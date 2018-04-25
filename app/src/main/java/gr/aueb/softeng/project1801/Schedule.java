package gr.aueb.softeng.project1801;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by George Chatzopoulos on 04/22/2018.
 */

public class Schedule {

    private Set<String> Destinations = new HashSet<>();
    private Set<String> DeparturePoints = new HashSet<>();
    private Set<String> DepartureTimes = new HashSet<>();
    private Set<SystemCalendar> DepartureDates = new HashSet<>();
    private String date;
    private String time;
    private String selectedDate;
    private String Destination;
    private String Departure;
    private Set<Route> routes = new HashSet<>();
    private Set<ScheduleEntry> ScheduleEntry = new HashSet<>();

    public Schedule(){ }

    public Schedule(Set<String> destinations, Set<String> departurePoints, Set<String> departureTimes,
                    Set<SystemCalendar> departureDates, String destination, String departure) {
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
            System.out.println("New route added!");
        }else{
            System.out.println("Empty route");
        }

    }

    public void deleteRoute(Route route){

        if(route != null){
            routes.remove(route);
            System.out.println("Route removed!");
        }else{
            System.out.println("Empty route");
        }
    }


    public void addScheduleEntry(ScheduleEntry entry) {
        if (entry != null) {
            ScheduleEntry.add(entry);
        }
    }

    public void removeScheduleEntry(ScheduleEntry entry){
        if(entry != null){
            ScheduleEntry.remove(entry);
        }
    }



    public Set<Route> getRoutes(){
        return new HashSet<>(routes);
    }

    public Set<ScheduleEntry> getScheduleEntry(){
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

    public Set<String> getDepartureTimes() {
        return new HashSet<>(DepartureTimes);
    }

    public void setDepartureTimes(Set<String> departureTimes) {
        DepartureTimes = departureTimes;
    }

    public Set<SystemCalendar> getDepartureDates() {
        return new HashSet<>(DepartureDates);
    }

    public void setDepartureDates(Set<SystemCalendar> departureDates) {
        DepartureDates = departureDates;
    }

    public void setRoutes(Set<Route> routes) {
        this.routes = routes;
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

    public Route createRoute(String Destination,String DeparturePoint,String DepartureTime
        ,SystemCalendar DepartureDate,String EstimatedArrivalTime,Bus RouteBus,Driver Driver){

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
            RouteBus.not_available();
        }else{
            System.out.println("Bus not available");
            return null;
        }
        if(Driver.getState() == DriverState.AVAILABLE){
            System.out.println("Driver is available");
            route.setDriver(Driver);
            Driver.not_available();
        }else {
            System.out.println("Driver not available");
            return null;
        }
        System.out.println("All the information is valid...will create route");
        route.setEstimatedArrivalTime(EstimatedArrivalTime);
        addNewRoute(route);

        return route;
    }


    public ScheduleEntry findNextAvailableDate(ScheduleEntry entry) {
        String time = entry.getDepartureTime();
        ScheduleEntry AvailableEntry =  new ScheduleEntry();
        System.out.println("Asked for: " + entry.getDayOfWeek()+ "/" +entry.getCalendar().getMonth()
                + " and time: " + time);
        boolean FoundDate = false;
        while(!FoundDate){
            boolean found = true;

            for(Route route : getRoutes()){
                if(entry.getDayOfWeek() == route.getDepartureDate().getDayOfMonth() && time.equals(route.getDepartureTime())
                        && entry.getCalendar().getMonth() == route.getDepartureDate().getMonth()){

                    System.out.println("The slot is taken...searching for next available date");
                    entry.setCalendar(entry.getCalendar().addDays(7));
                    found = false;
                    break;
                }
            }

            if(found){
                FoundDate = true;
                SystemCalendar calendar = new SystemCalendar(entry.getCalendar().getYear()
                        ,entry.getCalendar().getMonth(),entry.getDayOfWeek());
                System.out.println("Found: " + entry.getDayOfWeek()+"/"+entry.getCalendar().getMonth()
                        + " and time: " + time);
                System.out.println();
                AvailableEntry.setDepartureTime(time);
                AvailableEntry.setCalendar(calendar);
                AvailableEntry.setDayOfWeek(calendar.getDayOfMonth());
                addScheduleEntry(AvailableEntry);
            }
        }
        return AvailableEntry;
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
