package flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlightTypeFactory {
    private static final Map<String, FlightType> pool = new HashMap<>();

    public static FlightType getFlightType(String airline, String aircraftModel, String logo) {
        String key = airline + "-" + aircraftModel;
        if (!pool.containsKey(key)) {
            pool.put(key, new FlightType(airline, aircraftModel, logo));
        }
        return pool.get(key);
    }

    public static int getPoolSize() {
        return pool.size();
    }
}
