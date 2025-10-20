
package memento;

import java.util.Stack;

public class BookingHistory {
    private final Stack<BookingMemento> history = new Stack<>();

    public void save(Booking booking) {
        history.push(booking.save());
    }

    public void undo(Booking booking) {
        if (!history.isEmpty()) {
            booking.restore(history.pop());
        } else {
            System.out.println("Немає попереднього стану для відновлення!");
        }
    }
}
