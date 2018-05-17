package gr.aueb.softeng.project1801.DomainModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;

/**
 * Created by George Chatzopoulos on 04/22/2018.
 */

public class Route {

    private String Destination;
    private String DepartureTime;
    private String DeparturePoint;
    private SystemCalendar DepartureDate;
    private String EstimatedArrivalTime;
    private Bus RouteBus;
    private gr.aueb.softeng.project1801.DomainModel.Driver Driver;
    private int AvailableSeats;
    private Set<Ticket> tickets = new HashSet<>();
    private Set<String> savedSeats = new HashSet<>();

    /**
     *
     * Default constructor,which constructs a Route object.
     */
    public Route() { }

    /**
     *
     * Constructor.
     * @param destination (required) Destination of the route.
     * @param departureTime (required) Departure Ticket of the route.
     * @param departurePoint (required) Departure Point of the route.
     * @param departureDate (required) Departure Date of the route.
     * @param estimatedArrivalTime (required) Estimated Arrival Time of the route.
     * @param routeBus (required) route Bus of the route.
     * @param driver (required) driver of the route.
     */
    public Route(String destination, String departureTime, String departurePoint, SystemCalendar departureDate
            ,String estimatedArrivalTime, Bus routeBus, Driver driver) {
        Destination = destination;
        DepartureTime = departureTime;
        DeparturePoint = departurePoint;
        DepartureDate = departureDate;
        EstimatedArrivalTime = estimatedArrivalTime;
        RouteBus = routeBus;
        Driver = driver;
        AvailableSeats = routeBus.getBusSeats();
        RouteBus.not_available();
        Driver.not_available();
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

    /** @return DepartureTime passed to the constructor.  */
    public String getDepartureTime() {
        return DepartureTime;
    }

    /**
     *
     * @param departureTime departure Time to set
     */
    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }

    /** @return DeparturePoint passed to the constructor.  */
    public String getDeparturePoint() {
        return DeparturePoint;
    }

    /**
     *
     * @param departurePoint departure Point to set
     */
    public void setDeparturePoint(String departurePoint) {
        DeparturePoint = departurePoint;
    }

    /** @return DepartureDate passed to the constructor.  */
    public SystemCalendar getDepartureDate() {
        return DepartureDate;
    }

    /**
     *
     * @param departureDate departure Date to set
     */
    public void setDepartureDate(SystemCalendar departureDate) {
        DepartureDate = departureDate;
    }

    /** @return EstimatedArrivalTime passed to the constructor.  */
    public String getEstimatedArrivalTime() {
        return EstimatedArrivalTime;
    }

    /**
     *
     * @param estimatedArrivalTime estimated Arrival Time to set
     */
    public void setEstimatedArrivalTime(String estimatedArrivalTime) {
        EstimatedArrivalTime = estimatedArrivalTime;
    }

    /** @return RouteBus passed to the constructor.  */
    public Bus getRouteBus() {
        return RouteBus;
    }

    /**
     *
     * @param routeBus route Bus to set
     */
    public void setRouteBus(Bus routeBus) {
        RouteBus = routeBus;
    }

    /** @return Driver passed to the constructor.  */
    public Driver getDriver() {
        return Driver;
    }

    /**
     *
     * @param driver driver to set
     */
    public void setDriver(Driver driver) {
        Driver = driver;
    }

    /** @return AvailableSeats passed to the constructor.  */
    public int getAvailableSeats() {
        return AvailableSeats;
    }

    /**
     *
     * @param availableSeats available Seats to set
     */
    public void setAvailableSeats(int availableSeats) {
        AvailableSeats = availableSeats;
    }

    /**
     * Returning a set.
     *
     * This method returns a copy of the original set-> tickets.
     * The set that is being returned contains Ticket objects.
     */
    public Set<Ticket> getTickets(){
        return new HashSet<>(tickets);
    }

    /**
     * Adding a ticket in the set.
     *
     * This method checks if an object is null or not.
     * @param ticket must be an object.
     * If the object is not null,then we add the object into the set.
     * If the object is null,then we do not add the object into the set.
     */
    public void addTicket(Ticket ticket){
        if(ticket != null){
            ticket.setRoute(this);
        }
    }

    /**
     * Removing a card from the set.
     *
     * This method checks if an object is null or not.
     * @param ticket must be an object.
     * If the object is not null,then we remove the object from the set.
     */
    public void removeTicket(Ticket ticket){
        if(ticket != null){
            ticket.setRoute(null);
        }
    }

    public void saveSeat(String seat){
        if(!seat.equals("")){
            savedSeats.add(seat);
        }
    }

    public void removeSeat(String seat){
        if(!seat.equals("")){
            savedSeats.remove(seat);
        }
    }

    public Set<String> getSavedSeats() {
        return savedSeats;
    }

    /**
     * Returning a set.
     *
     * This method returns the original set-> tickets.
     * The set that is being returned contains Ticket objects.
     */
    public Set<Ticket> friendRoutes(){
        return tickets;
    }

    /**
     * Finding a ticket.
     *
     * This method tries to find a ticket inside of the set-> tickets.
     * @param ticket must be an object.
     * The set contains Ticket objects.
     * @return "true" if the ticket exists in the set or else "false"
     */
    public boolean FindTicket(Ticket ticket){
        return tickets.contains(ticket);
    }


    /**
     * Printing data.
     *
     *
     * This method prints the statistics of the routes.
     */
    public String printData(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        StringBuilder string = new StringBuilder();
        string.append(this.Destination);
        string.append("\n");
        string.append(this.DeparturePoint);
        string.append("\n");
        string.append(this.DepartureTime);
        string.append("\n");
        string.append(dateFormat.format(this.DepartureDate.getJavaCalendar().getTime()));
        string.append("\n");
        string.append(this.EstimatedArrivalTime);
        string.append("\n");
        string.append(this.RouteBus.getBusType());
        string.append("\n");
        string.append(this.Driver.getDriverID());
        string.append("\n");
        string.append(this.AvailableSeats);
        string.append("...");
        double statistic = ((double)this.AvailableSeats/this.getRouteBus().getBusSeats())*100;
        string.append(statistic);

        return string.toString();
    }


    public Ticket findTicket(String firstname,String lastname,String id){
        String passengerName = firstname+" "+lastname;
        String ticketName;
        String passid;
        for(Ticket ticket : tickets){
            ticketName = ticket.getPassengerName();
            passid = ticket.getPassengerID();
            if(ticketName != null && passid != null){
                if(ticketName.equals(passengerName) && passid.equals(id)){
                    return ticket;
                }
            }
        }
        return null;
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

        Route route = (Route) o;

        if (Destination != null ? !Destination.equals(route.Destination) : route.Destination != null)
            return false;
        if (DepartureTime != null ? !DepartureTime.equals(route.DepartureTime) : route.DepartureTime != null)
            return false;
        if (DeparturePoint != null ? !DeparturePoint.equals(route.DeparturePoint) : route.DeparturePoint != null)
            return false;
        if (DepartureDate != null ? !DepartureDate.equals(route.DepartureDate) : route.DepartureDate != null)
            return false;

        return true;
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
        int result = Destination != null ? Destination.hashCode() : 0;
        result = 13 * result + (DepartureTime != null ? DepartureTime.hashCode() : 0);
        result = 13 * result + (DeparturePoint != null ? DeparturePoint.hashCode() : 0);
        result = 13 * result + (DepartureDate != null ? DepartureDate.hashCode() : 0);
        return result;
    }
}
