package flight.reservation.flight;

import java.util.HashMap;
import java.util.List;

public class FlightEventsManager {

    HashMap<FlightEvents, List<FlightEventsObserver> >  eventsObservers;


    public FlightEventsManager() {
        this.eventsObservers = new HashMap<>();
    }


    public void notifyEvent(FlightEvents event,FlightEventInfo info){
        if ( eventsObservers.containsKey(event) ){
            List<FlightEventsObserver> observers = eventsObservers.get(event);
            for (FlightEventsObserver observer: observers){
                observer.notifyFlightEvent(event,info);
            }
        }

    }
    public void registerEvent(FlightEvents e , FlightEventsObserver observer){
        if( eventsObservers.containsKey(e) ){
            List<FlightEventsObserver> observerList = eventsObservers.get(e);
            observerList.add(observer);
        }
    }
}
