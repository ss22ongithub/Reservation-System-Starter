package flight.reservation;

import flight.reservation.flight.FlightEventInfo;
import flight.reservation.flight.FlightEvents;
import flight.reservation.flight.FlightEventsObserver;
import flight.reservation.flight.ScheduledFlight;

public class Passenger  implements FlightEventsObserver {

    private final String name;

    public Passenger(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    @Override
    public void notifyFlightEvent(FlightEvents e, FlightEventInfo info) {
        System.out.println("Received "+e);
        System.out.println("Event Info"+info);
    }
}
