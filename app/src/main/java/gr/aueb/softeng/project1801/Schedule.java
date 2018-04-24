package gr.aueb.softeng.project1801;

import java.text.ParseException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by George Chatzopoulos on 04/22/2018.
 */

public class Schedule {

    private Set<String> Destinations = new HashSet<>();
    private Set<String> DeparturePoints = new HashSet<>();
    private Set<Calendar> DepartureTimes = new HashSet<>();
    private Set<Calendar> DepartureDates = new HashSet<>();
    private Calendar date;
    private Calendar time;
    private Calendar selectedDate;
    private String Destination;
    private String Departure;
    private Set<Route> routes = new HashSet<>();
    private Set<ScheduleEntry> ScheduleEntry = new HashSet<>();

    public Schedule(){ }

    public Schedule(Set<String> destinations, Set<String> departurePoints, Set<Calendar> departureTimes,
                    Set<Calendar> departureDates, String destination, String departure) {
        Destinations = destinations;
        DeparturePoints = departurePoints;
        DepartureTimes = departureTimes;
        DepartureDates = departureDates;
        Destination = destination;
        Departure = departure;
    }

    public void addNewRoute(Route route){

        if(route != null){
            routes.add(route);
        }
    }

    public void deleteRoute(Route route){

        if(route != null){
            routes.remove(route);
        }
    }

    public Calendar chooseDate(Calendar date){
        return selectedDate = date;
    }

    public void addScheduleEntry(ScheduleEntry entry) throws ParseException {
        if (entry != null) {
            Calendar Date = entry.findNextRoute(date, time);
            if (Date == null) {
                System.out.println("No available date");
            } else {
                System.out.println("The Date is: " + Date);
                entry.setDepartureTime(Date);
                ScheduleEntry.add(entry);
            }
        }
    }

    public void removeScheduleEntry(ScheduleEntry entry){
        if(entry != null){
            ScheduleEntry.remove(entry);
        }
    }



    Set<Route> getRoutes(){
        return new HashSet<>(routes);
    }

    Set<ScheduleEntry> getScheduleEntry(){
        return new HashSet<>(ScheduleEntry);
    }

    public Set<String> getDestinations() {
        return new HashSet<>(Destinations);
    }

    public void setDestinations(Set<String> destinations) {
        Destinations = destinations;
    }

    public Set<String> getDeparturePoints() {
        return new HashSet<>(DeparturePoints);
    }

    public void setDeparturePoints(Set<String> departurePoints) {
        DeparturePoints = departurePoints;
    }

    public Set<Calendar> getDepartureTimes() {
        return new HashSet<>(DepartureTimes);
    }

    public void setDepartureTimes(Set<Calendar> departureTimes) {
        DepartureTimes = departureTimes;
    }

    public Set<Calendar> getDepartureDates() {
        return new HashSet<>(DepartureDates);
    }

    public void setDepartureDates(Set<Calendar> departureDates) {
        DepartureDates = departureDates;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
        Departure = departure;
    }


    public Route createRoute(String Destination,String DeparturePoint,Calendar DepartureTime
        ,Calendar DepartureDate,Calendar EstimatedArrivalTime,Bus RouteBus,Driver Driver){

        //Will check if all the chosen information about the route is valid
        if(!Destinations.contains(Destination)){
            System.out.println("Not a valid Destination!!!");
            return null;
        }
        if(!DeparturePoints.contains(DeparturePoint)){
            System.out.println("Not a valid departure point!!!");
            return null;
        }
        if(!DepartureTimes.contains(DepartureTime)){
            System.out.println("Not a valid departure time!!!");
            return null;
        }
        if(!DepartureDates.contains(DepartureDate)){
            System.out.println("Not a valid departure date!!!");
            return null;
        }
        Route route = new Route();
        if(RouteBus.getState() == BusState.AVAILABLE){
            System.out.println("Bus is available");
            route.setRouteBus(RouteBus);
            RouteBus.setState(BusState.NOT_AVAILABLE);
        }else{
            System.out.println("Bus not available");
            return null;
        }
        if(Driver.getState() == DriverState.AVAILABLE){
            System.out.println("Driver is available");
            route.setDriver(Driver);
            Driver.setState(DriverState.NOT_AVAILABLE);
        }else {
            return null;
        }
        System.out.println("All the information is valid...will create route");
        route.setEstimatedArrivalTime(EstimatedArrivalTime);
        addNewRoute(route);

        return route;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule1 = (Schedule) o;

        if (Destinations != null ? !Destinations.equals(schedule1.Destinations) : schedule1.Destinations != null)
            return false;
        if (DeparturePoints != null ? !DeparturePoints.equals(schedule1.DeparturePoints) : schedule1.DeparturePoints != null)
            return false;
        if (DepartureTimes != null ? !DepartureTimes.equals(schedule1.DepartureTimes) : schedule1.DepartureTimes != null)
            return false;
        if (DepartureDates != null ? !DepartureDates.equals(schedule1.DepartureDates) : schedule1.DepartureDates != null)
            return false;
        if (Destination != null ? !Destination.equals(schedule1.Destination) : schedule1.Destination != null)
            return false;
        if (Departure != null ? !Departure.equals(schedule1.Departure) : schedule1.Departure != null)
            return false;
        if (routes != null ? !routes.equals(schedule1.routes) : schedule1.routes != null)
            return false;
        return ScheduleEntry != null ? ScheduleEntry.equals(schedule1.ScheduleEntry) : schedule1.ScheduleEntry == null;
    }

    @Override
    public int hashCode() {
        int result = Destinations != null ? Destinations.hashCode() : 0;
        result = 13 * result + (DeparturePoints != null ? DeparturePoints.hashCode() : 0);
        result = 13 * result + (DepartureTimes != null ? DepartureTimes.hashCode() : 0);
        result = 13 * result + (DepartureDates != null ? DepartureDates.hashCode() : 0);
        result = 13 * result + (Destination != null ? Destination.hashCode() : 0);
        result = 13 * result + (Departure != null ? Departure.hashCode() : 0);
        result = 13 * result + (routes != null ? routes.hashCode() : 0);
        result = 13 * result + (ScheduleEntry != null ? ScheduleEntry.hashCode() : 0);
        return result;
    }
}
