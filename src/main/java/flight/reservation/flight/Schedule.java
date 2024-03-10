package flight.reservation.flight;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Schedule {

    private List<ScheduledFlight> scheduledFlights;
    private FlightEventsManager eventsManager;


    public Schedule(FlightEventsManager eventsManager) {
        scheduledFlights = new ArrayList<>();
        this.eventsManager = eventsManager;

    }

    public List<ScheduledFlight> getScheduledFlights() {
        return scheduledFlights;
    }

    public void scheduleFlight(Flight flight, Date date) {
        ScheduledFlight scheduledFlight = new ScheduledFlight(flight.getNumber(), flight.getDeparture(),
                flight.getArrival(), flight.getAircraft(), date);

        scheduledFlights.add(scheduledFlight);

        FlightEventInfo eventInfo = new FlightEventInfo(this.toString(),
                new Timestamp(System.currentTimeMillis()));

        eventsManager.notifyEvent(
                FlightEvents.FLIGHT_SCHEDULED,
                eventInfo );


    }

    public void removeFlight(Flight flight) {
        List<ScheduledFlight> tbr = new ArrayList<>();
        for (ScheduledFlight scheduledFlight : scheduledFlights) {
            if (scheduledFlight == flight ||
                    (flight.getArrival() == scheduledFlight.getArrival() &&
                            flight.getDeparture() == scheduledFlight.getDeparture() &&
                            flight.getNumber() == scheduledFlight.getNumber())) {
                tbr.add(scheduledFlight);
            }
        }
        scheduledFlights.removeAll(tbr);

        FlightEventInfo eventInfo = new FlightEventInfo(this.toString(),
                new Timestamp(System.currentTimeMillis()));

        eventsManager.notifyEvent(
                FlightEvents.FLIGHT_REMOVED,
                eventInfo );

    }

    public void removeScheduledFlight(ScheduledFlight flight) {
        scheduledFlights.remove(flight);
    }

    public ScheduledFlight searchScheduledFlight(int flightNumber) {
        return scheduledFlights.stream()
                .filter(f -> f.getNumber() == flightNumber)
                .findFirst()
                .orElse(null);
    }

    public void clear() {
        scheduledFlights.clear();
    }

}
