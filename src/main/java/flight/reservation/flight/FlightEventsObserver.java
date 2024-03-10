package flight.reservation.flight;

public interface FlightEventsObserver {

    void notifyFlightEvent( FlightEvents e , FlightEventInfo info);
}
