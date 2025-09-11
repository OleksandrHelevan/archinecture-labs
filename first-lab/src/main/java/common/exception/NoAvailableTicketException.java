package common.exception;

public class NoAvailableTicketException extends RuntimeException {
    public NoAvailableTicketException(String message) {
        super(message);
    }
}
