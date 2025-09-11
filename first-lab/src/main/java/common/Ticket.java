package common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {
    private String id;
    private Route route;
    private double price;
    private Currency currency;
}
