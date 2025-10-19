package command;

import cor.BookingRequest;
import java.util.ArrayList;
import java.util.List;

public class BookingInvoker {
    private final List<BookingCommand> commands = new ArrayList<>();

    public void addCommand(BookingCommand command) {
        commands.add(command);
    }

    public void executeAll(BookingRequest request) {
        for (BookingCommand command : commands) {
            command.execute(request);
        }
    }
}
