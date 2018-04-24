package gr.aueb.softeng.project1801;


import java.util.*;

import javax.xml.transform.Source;

public class Ticket {

    private String DestinationTicket;
    private String DeparturePointTicket;
    private String DepartureTimeTicket;
    private Calendar DepartureDateTicket;
    private String EstimatedArrivalTimeTicket;
    private double Price;
    private Passenger passenger;
    private String PassengerName;
    private String PassengerID;
    private int PassengerSeat;
    private String Type;
    private Route route;

    //Default Constructor
    public Ticket() { }

    //Constructor
    public Ticket(String DestinationTicket,String DeparturePointTicket,String DepartureTimeTicket,
                  Calendar DepartureDateTicket,String EstimatedArrivalTimeTicket,double Price,
                  Passenger passenger,int PassengerSeat,String Type,Route route){

        this.DestinationTicket = DestinationTicket;
        this.DeparturePointTicket = DeparturePointTicket;
        this.DepartureTimeTicket = DepartureTimeTicket;
        this.DepartureDateTicket = DepartureDateTicket;
        this.EstimatedArrivalTimeTicket = EstimatedArrivalTimeTicket;
        this.Price = Price;
        this.passenger = passenger;
        this.PassengerSeat = PassengerSeat;
        this.Type = Type;
        this.route = route;
    }

    //Getters

    public String getDestinationTicket() {
        return DestinationTicket;
    }

    public String getDeparturePointTicket() {
        return DeparturePointTicket;
    }

    public String getDepartureTimeTicket() {
        return DepartureTimeTicket;
    }

    public Calendar getDepartureDateTicket() {
        return DepartureDateTicket;
    }

    public String getEstimatedArrivalTimeTicket() {
        return EstimatedArrivalTimeTicket;
    }

    public double getPrice() {
        return Price;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public String getPassengerName() {
        return PassengerName;
    }

    public String getPassengerID() {
        return PassengerID;
    }

    public int getPassengerSeat() {
        return PassengerSeat;
    }

    public String getType() {
        return Type;
    }

    public Route getRoute() {
        return route;
    }


    //Setters

    public void setDestinationTicket(String destinationTicket) {
        DestinationTicket = destinationTicket;
    }

    public void setDeparturePointTicket(String departurePointTicket) {
        DeparturePointTicket = departurePointTicket;
    }

    public void setDepartureTimeTicket(String departureTimeTicket) {
        DepartureTimeTicket = departureTimeTicket;
    }

    public void setDepartureDateTicket(Calendar departureDateTicket) {
        DepartureDateTicket = departureDateTicket;
    }

    public void setEstimatedArrivalTimeTicket(String estimatedArrivalTimeTicket) {
        EstimatedArrivalTimeTicket = estimatedArrivalTimeTicket;
    }

    public void setPrice(double price) {
        this.Price = price;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setPassengerSeat(int passengerSeat) {
        this.PassengerSeat = passengerSeat;
    }

    public void setPassengerName(String passengerName) {
        this.PassengerName = passengerName;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public void setPassengerID(String passengerID) {
        this.PassengerID = passengerID;
    }

    public void setRoute(Route route) {
        if(this.route != null){
            this.route.friendRoutes().remove(this);
            route.setAvailableSeats(route.getAvailableSeats() + 1);
        }

        this.route = route;
        if(this.route != null){
            this.route.friendRoutes().add(this);
            route.setAvailableSeats(route.getAvailableSeats() - 1);
        }
    }


    //Checks if the ticket is available in the route
    public boolean TicketExists(Ticket ticket){
        return route.FindTicket(ticket);
    }


    //Completes the purchase of a ticket if it is available
    public boolean buyTicket(Ticket ticket, Passenger passenger, Route route){
        if(route.getAvailableSeats() != 0){
            if(!TicketExists(ticket)){
                System.out.println("Ticket is available!!!");
                setPassenger(passenger);
                PassengerName = passenger.getFirstName() + passenger.getLastName();
                PassengerID = passenger.getNumberID();

                //here it will ask for card information TODO

                route.addTicket(ticket);
                return true;
            }else{
                System.out.println("Ticket is not available!!!");
                return false;
            }
        }else{
            System.out.println("There are no available seats in this route!!!");
            return false;
        }
    }

    //Overrides equals
    @Override
    public boolean equals(Object other){

        if(other == null){
            return false;
        }

        if(this == other){
            return true;
        }

        if(!(other instanceof Ticket)){
            return false;
        }

        Ticket theTicket = (Ticket) other;
        if(!(DestinationTicket == null ? theTicket.DestinationTicket == null
                : DestinationTicket.equals(theTicket.DestinationTicket))){
            return false;
        }

        if(!(DeparturePointTicket == null ? theTicket.DeparturePointTicket == null
                : DeparturePointTicket.equals(theTicket.DeparturePointTicket))){
            return false;
        }

        if(!(DepartureTimeTicket == null ? theTicket.DepartureTimeTicket == null
                : DepartureTimeTicket.equals(theTicket.DepartureTimeTicket))){

        }
        if(!(DepartureDateTicket == null ? theTicket.DepartureDateTicket == null
                : DepartureDateTicket.equals(theTicket.DepartureDateTicket))){
            return false;
        }

        if(!(EstimatedArrivalTimeTicket == null ? theTicket.EstimatedArrivalTimeTicket == null
                : EstimatedArrivalTimeTicket.equals(theTicket.EstimatedArrivalTimeTicket))){
            return false;
        }

        if(!(Price == 0.0 ? theTicket.Price == 0.0
                : Price == theTicket.Price)){
            return false;
        }

        if(!(passenger == null ? theTicket.passenger == null
                : passenger.equals(theTicket.passenger))){
            return false;
        }

        if(!(PassengerSeat == 0 ? theTicket.PassengerSeat == 0
                : PassengerSeat == theTicket.PassengerSeat)){
            return false;
        }

        if(!(PassengerName == null ? theTicket.PassengerName == null
                : PassengerName.equals(theTicket.PassengerName))){
            return false;
        }

        if(!(PassengerID == null ? theTicket.PassengerID == null
                : PassengerID.equals(theTicket.PassengerID))){
            return false;
        }

        if(!(Type == null ? theTicket.Type == null
                : Type.equals(theTicket.Type))){
            return false;
        }

        if(!(route == null ? theTicket.route == null
                : route.equals(theTicket.route))){
            return false;
        }

        return true;
    }

    //When equals is overrided always override hashCode
    @Override
    public int hashCode(){
        if(DestinationTicket == null && DeparturePointTicket == null & DepartureTimeTicket == null
                && DepartureDateTicket == null && EstimatedArrivalTimeTicket == null &&
                Price == 0 && passenger == null && PassengerSeat == 0
                && Type == null && route == null){

            return 0;
        }

        int result = 0;
        result = DestinationTicket == null ? result : 13 * result + DestinationTicket.hashCode();
        result = DeparturePointTicket == null ? result : 13 * result + DeparturePointTicket.hashCode();
        result = DepartureTimeTicket == null ? result : 13 * result + DepartureTimeTicket.hashCode();
        result = DepartureDateTicket == null ? result : 13 * result + DepartureDateTicket.hashCode();
        result = EstimatedArrivalTimeTicket == null ? result : 13 * result + EstimatedArrivalTimeTicket.hashCode();
        result = Price == 0 ? result : 13 * result + (int) Price;
        result = passenger == null ? result : 13 * result + passenger.hashCode();
        result = PassengerName == null ? result : 13 * result + PassengerName.hashCode();
        result = PassengerID == null ? result : 13 * result + PassengerID.hashCode();
        result = PassengerSeat == 0 ? result : 13 * result + PassengerSeat;
        result = Type == null ? result : 13 * result + Type.hashCode();

        return result;
    }
}
