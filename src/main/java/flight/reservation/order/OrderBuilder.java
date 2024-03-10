package flight.reservation.order;

import flight.reservation.Customer;
import flight.reservation.Passenger;
import flight.reservation.flight.Flight;
import flight.reservation.flight.ScheduledFlight;

import java.util.List;

public interface OrderBuilder {
    public FlightOrderBuilder addPrice(double price);
    public FlightOrderBuilder addCustomer(Customer customer);
    public FlightOrderBuilder addPassenger(Passenger passenger);
    public FlightOrderBuilder addPassengers(List<Passenger> passengers);
    public FlightOrderBuilder addScheduledFlights(List<ScheduledFlight> scheduledFlightList);

    public FlightOrder build();
}
