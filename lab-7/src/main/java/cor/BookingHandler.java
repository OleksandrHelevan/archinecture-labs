package cor;

public abstract class BookingHandler {
    private BookingHandler next;

    public BookingHandler setNext(BookingHandler next) {
        this.next = next;
        return next;
    }

    public void handle(BookingRequest request) {
        if (process(request) && next != null) {
            next.handle(request);
        }
    }

    protected abstract boolean process(BookingRequest request);
}
