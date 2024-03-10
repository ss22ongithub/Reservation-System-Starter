package flight.reservation;

import flight.reservation.flight.ScheduledFlight;
import flight.reservation.order.FlightOrder;
import flight.reservation.order.FlightOrderBuilder;
import flight.reservation.order.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {

    private String email;
    private String name;
    private List<Order> orders;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public FlightOrder createOrder(List<Passenger> passengerNames, List<ScheduledFlight> flights, double price) {

        if (!isOrderValid(passengerNames, flights)) {
            throw new IllegalStateException("Order is not valid");
        }

        FlightOrderBuilder orderBuilder = new FlightOrderBuilder();
        orderBuilder.reset();

        return (orderBuilder.addCustomer(this)
                    .addPrice(price)
                    .addPassengers(passengerNames)
                    .addScheduledFlights(flights)
                    .build());

    }

    private boolean isOrderValid(List<Passenger> passengerNames, List<ScheduledFlight> flights) {
        boolean valid = true;
        valid = valid && !FlightOrder.getNoFlyList().contains(this.getName());
        valid = valid && passengerNames.stream().noneMatch(passenger -> FlightOrder.getNoFlyList().contains(passenger));
        valid = valid && flights.stream().allMatch(scheduledFlight -> {
            try {
                return scheduledFlight.getAvailableCapacity() >= passengerNames.size();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return false;
            }
        });
        return valid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
