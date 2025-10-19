package cor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookingRequest {
    private String passengerName;
    private String flightNumber;
    private boolean seatAvailable;
    private boolean paymentValid;

}
