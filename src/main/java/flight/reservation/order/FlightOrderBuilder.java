package flight.reservation.order;

import flight.reservation.Customer;
import flight.reservation.Passenger;
import flight.reservation.flight.ScheduledFlight;

import java.util.ArrayList;
import java.util.List;

public class FlightOrderBuilder implements  OrderBuilder{

    FlightOrder flightOrder;

    public void reset(){
        flightOrder = new FlightOrder();
    }
    @Override
    public FlightOrderBuilder addPrice(double price) {
        flightOrder.setPrice(price);
        return this;
    }

    @Override
    public FlightOrderBuilder addCustomer(Customer customer) {
        flightOrder.setCustomer(customer);
        return this;
    }

    @Override
    public FlightOrderBuilder addPassenger(Passenger passenger) {
        List<Passenger> passengers = flightOrder.getPassengers();
        if ( passengers == null){
            passengers = new ArrayList<Passenger>();
        }
        passengers.add(passenger);
        flightOrder.setPassengers(passengers);
        return this;
    }

    @Override
    public FlightOrderBuilder addPassengers(List<Passenger> passengers) {
        List<Passenger> p = flightOrder.getPassengers();
        if ( p == null){
            p = new ArrayList<Passenger>();
        }
        p.addAll(passengers);

        flightOrder.setPassengers(p);
        return this;
    }

    @Override
    public FlightOrderBuilder addScheduledFlights(List<ScheduledFlight> scheduledFlightList) {
        List<ScheduledFlight> sf = flightOrder.getScheduledFlights();
        if (sf == null ){
            sf = new ArrayList<ScheduledFlight>();
        }
        sf.addAll(scheduledFlightList);
        flightOrder.setFlights(sf);

        return this;
    }

    public FlightOrder build(){
       return this.flightOrder;
    }

}
