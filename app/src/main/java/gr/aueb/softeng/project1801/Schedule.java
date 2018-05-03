package gr.aueb.softeng.project1801;


import java.util.HashSet;
import java.util.Set;

import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;


public class Schedule {

    private Set<String> Destinations = new HashSet<>();
    private Set<String> DeparturePoints = new HashSet<>();
    private Set<String> DepartureTimes = new HashSet<>();
    private Set<SystemCalendar> DepartureDates = new HashSet<>();
    private String Destination;
    private String Departure;
    private Set<Route> routes = new HashSet<>();
    private Set<ScheduleEntry> ScheduleEntry = new HashSet<>();

    /**
     *
     * Default constructor,which constructs a Schedule object.
     */
    public Schedule(){ }

    /**
     *
     * Constructor.
     * @param destinations (required) set of destinations of the schedule.
     * @param departurePoints (required) set of departure Points of the schedule.
     * @param departureTimes (required) set of departure Times of the schedule.
     * @param departureDates (required) set of departure Dates of the schedule.
     * @param destination (required) departureDates of the schedule.
     * @param departure (required) departure of the schedule.
     */
    public Schedule(Set<String> destinations, Set<String> departurePoints, Set<String> departureTimes,
                    Set<SystemCalendar> departureDates, String destination, String departure) {
        Destinations = destinations;
        DeparturePoints = departurePoints;
        DepartureTimes = departureTimes;
        DepartureDates = departureDates;
        Destination = destination;
        Departure = departure;
    }

    /**
     * Adding a route into a set.
     *
     * This method checks if a Route object is null or not and decides whether to insert it or not into the set.
     * @param route must be an object.

     * If the object is not null,then we add the object into the set -> routes.
     * If the object is null,then we do not add the object into the set.
     */
    public void addNewRoute(Route route){

        if(route != null){
            routes.add(route);
            System.out.println("New route added!");
        }else{
            System.out.println("Empty route");
        }

    }

    /**
     * Deleting a card from the set.
     *
     * This method checks if an object is null or not and decides whether to delete it or not from the set.
     * @param route must be an object.
     * If the object is not null,then we delete the object from the set.
     */
    public void deleteRoute(Route route){

        if(route != null){
            routes.remove(route);
            System.out.println("Route removed!");
        }else{
            System.out.println("Empty route");
        }
    }

    /**
     * Adding a schedule entry into a set.
     *
     * This method checks if a ScheduleEntry object is null or not and decides whether to insert it or not into the set.
     * @param entry must be an object.
     * If the object is not null,then we add the object into the set -> ScheduleEntry.
     * If the object is null,then we do not add the object into the set.
     */
    public void addScheduleEntry(ScheduleEntry entry) {
        if (entry != null) {
            ScheduleEntry.add(entry);
            DepartureDates.add(entry.getCalendar());
            DepartureTimes.add(entry.getDepartureTime());
        }
    }

    /**
     * Deleting a card from the set.
     *
     * This method checks if an object is null or not and decides whether to delete it or not from the set..
     * @param entry must be an object.
     * If the object is not null,then we delete the object from the set.
     */
    public void removeScheduleEntry(ScheduleEntry entry){
        if(entry != null){
            ScheduleEntry.remove(entry);
        }
    }


    /** @return set of Routes for the schedule.  */
    public Set<Route> getRoutes(){
        return new HashSet<>(routes);
    }

    /** @return set of ScheduleEntry.  */
    public Set<ScheduleEntry> getScheduleEntry(){
        return new HashSet<>(ScheduleEntry);
    }

    /** @return set of Destinations passed to the constructor.  */
    public Set<String> getDestinations() {
        return new HashSet<>(Destinations);
    }

    /**
     *
     * @param destinations destinations to set
     */
    public void setDestinations(Set<String> destinations) {
        Destinations = destinations;
    }

    /** @return set of DeparturePoints passed to the constructor.  */
    public Set<String> getDeparturePoints() {
        return new HashSet<>(DeparturePoints);
    }

    /**
     *
     * @param departurePoints departure Points to set
     */
    public void setDeparturePoints(Set<String> departurePoints) {
        DeparturePoints = departurePoints;
    }

    /** @return set of DepartureTimes passed to the constructor.  */
    public Set<String> getDepartureTimes() {
        return new HashSet<>(DepartureTimes);
    }

    /**
     *
     * @param departureTimes departure Times to set
     */
    public void setDepartureTimes(Set<String> departureTimes) {
        DepartureTimes = departureTimes;
    }

    /** @return set of DepartureDates passed to the constructor.  */
    public Set<SystemCalendar> getDepartureDates() {
        return DepartureDates;
    }

    /**
     *
     * @param departureDates departureDates to set
     */
    public void setDepartureDates(Set<SystemCalendar> departureDates) {
        DepartureDates = departureDates;
    }

    /**
     *
     * @param routes set of routes to set
     */
    public void setRoutes(Set<Route> routes) {
        this.routes = routes;
    }

    /** @return Destination passed to the constructor.  */
    public String getDestination() {
        return Destination;
    }

    /**
     *
     * @param destination destination to set
     */
    public void setDestination(String destination) {
        Destination = destination;
    }

    /** @return Departure passed to the constructor.  */
    public String getDeparture() {
        return Departure;
    }

    /**
     *
     * @param departure departure to set
     */
    public void setDeparture(String departure) {
        Departure = departure;
    }

    /**
     * Creating a new route.
     *
     * @param Destination must be a string.
     * @param DepartureTime must be a string.
     * @param DeparturePoint must be a string.
     * @param DepartureDate must be a string.
     * @param EstimatedArrivalTime must be a string.
     * @param RouteBus must be a Bus object.
     * @param Driver must be a Driver object.
     * This method creates a new route if there isn't any conflict with the information of the (new)route we want to add.
     * @return Route object(not empty) if we can add the new route in the schedule or else an empty one object"
     */
    public Route createRoute(String Destination,String DepartureTime,String DeparturePoint
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
        route.setDestination(Destination);
        route.setDeparturePoint(DeparturePoint);
        route.setDepartureTime(DepartureTime);
        route.setDepartureDate(DepartureDate);
        route.setEstimatedArrivalTime(EstimatedArrivalTime);
        route.setAvailableSeats(RouteBus.getBusSeats());
        if (findRoute(route)){
            System.out.println("Route already exists!!!");
            return null;
        }else{
            System.out.println("Route information valid...will create route!!");
            addNewRoute(route);

        }
        return route;
    }


    /**
     * Searching for Next Available Date.
     *
     * @param entry must be a ScheduleEntry object.
     * This method searches for the next available date to add a new route in schedule.
     * @return ScheduleEntry object(not empty) if there is a next available date to add a new route in the schedule or else an empty one object"
     */
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

    /**
     * Searching for route.
     *
     * @param route must be a Route object.
     * This method searches for a specific route into the set -> routes.
     * @return "true" if the route exists inside the set or else "false"
     */
    private boolean findRoute(Route route){
        return routes.contains(route);
    }

    /**
     * Printing data.
     *
     * @param route must be a Route object.
     * This method prints the statistics of a route.
     */
    public void printStatistics(Route route){
        //prints the statistics about this route based on how many seats are available.
        double statistic;
        if(findRoute(route)){
            statistic = ((double)route.getAvailableSeats()/route.getRouteBus().getBusSeats())*100;
            route.printData();
        }else {
            System.out.println("The route you requested does not exist...");
        }
    }

    /**
     * Printing data.
     *
     * @param calendar must be a SystemCalendar object.
     * This method prints the statistics of the schedules based on a date.
     */
    public void printStatisticsBasedOnDate(SystemCalendar calendar){

        for(Route route: routes){
            if(route.getDepartureDate().equals(calendar)){
                printStatistics(route);
                System.out.println();
            }
        }
    }

    /**
     * Comparing two objects.
     *
     * This method checks if two object are the same.
     * @param o must be an object.
     */
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

    /**
     * Getting the hashCode of an object.
     *
     * This method checks if two object has the same hasCode.
     * If the method equals returned "true" the hasCode of the two objects must be the same.
     * If the method equals returned "false" the hasCode of the two objects must not be the same.
     */
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
