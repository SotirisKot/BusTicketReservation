package gr.aueb.softeng.project1801;

import java.util.*;

/**
 * Created by George Chatzopoulos on 04/22/2018.
 */

public class Route {

    private String Destination;
    private String DepartureTime;
    private String DeparturePoint;
    private String DepartureDate;
    private String EstimatedArrivalTime;
    private Bus RouteBus;
    private Driver Driver;
    private int AvailableSeats;
    private Set<Ticket> tickets = new HashSet<>();


    //Default constructor
    public Route() { }

    public Route(String destination, String departureTime, String departurePoint, String departureDate
            ,String estimatedArrivalTime, Bus routeBus, Driver driver) {
        Destination = destination;
        DepartureTime = departureTime;
        DeparturePoint = departurePoint;
        DepartureDate = departureDate;
        EstimatedArrivalTime = estimatedArrivalTime;
        RouteBus = routeBus;
        Driver = driver;
        AvailableSeats = routeBus.getBusSeats();
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }

    public String getDeparturePoint() {
        return DeparturePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        DeparturePoint = departurePoint;
    }

    public String getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(String departureDate) {
        DepartureDate = departureDate;
    }

    public String getEstimatedArrivalTime() {
        return EstimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(String estimatedArrivalTime) {
        EstimatedArrivalTime = estimatedArrivalTime;
    }

    public Bus getRouteBus() {
        return RouteBus;
    }

    public void setRouteBus(Bus routeBus) {
        RouteBus = routeBus;
    }

    public Driver getDriver() {
        return Driver;
    }

    public void setDriver(Driver driver) {
        Driver = driver;
    }

    public int getAvailableSeats() {
        return AvailableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        AvailableSeats = availableSeats;
    }

    public Set<Ticket> getTickets(){
        return new HashSet<>(tickets);
    }

    public void addTicket(Ticket ticket){
        if(ticket != null){
            ticket.setRoute(this);
        }
    }

    public void removeTicket(Ticket ticket){
        if(ticket != null){
            ticket.setRoute(null);
        }
    }

    public Set<Ticket> friendRoutes(){
        return tickets;
    }

    //Returns true if the ticket exists in the set
    public boolean FindTicket(Ticket ticket){
        return tickets.contains(ticket);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (AvailableSeats != route.AvailableSeats) return false;
        if (Destination != null ? !Destination.equals(route.Destination) : route.Destination != null)
            return false;
        if (DepartureTime != null ? !DepartureTime.equals(route.DepartureTime) : route.DepartureTime != null)
            return false;
        if (DeparturePoint != null ? !DeparturePoint.equals(route.DeparturePoint) : route.DeparturePoint != null)
            return false;
        if (DepartureDate != null ? !DepartureDate.equals(route.DepartureDate) : route.DepartureDate != null)
            return false;
        if (EstimatedArrivalTime != null ? !EstimatedArrivalTime.equals(route.EstimatedArrivalTime) : route.EstimatedArrivalTime != null)
            return false;
        if (RouteBus != null ? !RouteBus.equals(route.RouteBus) : route.RouteBus != null)
            return false;
        return Driver != null ? Driver.equals(route.Driver) : route.Driver == null;
    }

    @Override
    public int hashCode() {
        int result = Destination != null ? Destination.hashCode() : 0;
        result = 13 * result + (DepartureTime != null ? DepartureTime.hashCode() : 0);
        result = 13 * result + (DeparturePoint != null ? DeparturePoint.hashCode() : 0);
        result = 13 * result + (DepartureDate != null ? DepartureDate.hashCode() : 0);
        result = 13 * result + (EstimatedArrivalTime != null ? EstimatedArrivalTime.hashCode() : 0);
        result = 13 * result + (RouteBus != null ? RouteBus.hashCode() : 0);
        result = 13 * result + (Driver != null ? Driver.hashCode() : 0);
        result = 13 * result + AvailableSeats;
        return result;
    }
}
