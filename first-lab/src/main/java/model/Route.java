package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class Route {
    private String id;
    private City fromCity;
    private City toCity;
    private LocalTime startTime;
    private LocalTime endTime;

}
