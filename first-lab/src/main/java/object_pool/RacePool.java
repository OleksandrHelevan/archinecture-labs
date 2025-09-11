package object_pool;

import common.Ticket;
import common.exception.NoAvailableTicketException;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RacePool {

    private final Map<String, Deque<Ticket>> ticketsByRoute = new HashMap<>();

    public synchronized void addTicket(Ticket ticket) {
        ticketsByRoute
                .computeIfAbsent(ticket.getRoute().getId(), k -> new ArrayDeque<>())
                .push(ticket);
        notifyAll();
    }

    public synchronized Ticket reserve(String routeId) throws NoAvailableTicketException {
        Deque<Ticket> deque = ticketsByRoute.get(routeId);
        long startTime = System.currentTimeMillis();
        long timeout = 10_000;
        while (deque == null || deque.isEmpty()) {
            long elapsed = System.currentTimeMillis() - startTime;
            long remaining = timeout - elapsed;
            if (remaining <= 0) {
                throw new NoAvailableTicketException("No available tickets for route " + routeId);
            }
            try {
                wait(remaining);
                deque = ticketsByRoute.get(routeId);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        return deque.pop();
    }

    public synchronized void release(Ticket ticket) {
        ticketsByRoute
                .computeIfAbsent(ticket.getRoute().getId(), k -> new ArrayDeque<>())
                .push(ticket);
        notifyAll();
    }

    public synchronized int availableCount(String routeId) {
        Deque<Ticket> deque = ticketsByRoute.get(routeId);
        return deque == null ? 0 : deque.size();
    }
}
