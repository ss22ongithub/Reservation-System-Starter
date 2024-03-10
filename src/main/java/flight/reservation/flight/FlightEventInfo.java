package flight.reservation.flight;


import java.sql.Timestamp;
import java.util.Date;

public class FlightEventInfo {
    private String info;
    Timestamp timestamp;

    public FlightEventInfo(String info, Timestamp timestamp) {
        this.info = info;
        this.timestamp = timestamp;
    }
}
