package gr.aueb.softeng.project1801;


import java.util.*;

public class Ticket {

    private String DestinationTicket;
    private String DeparturePointTicket;
    private Calendar DepartureTimeTicket;
    private Calendar DepartureDateTicket;
    private Calendar EstimatedArrivalTimeTicket;
    private double Price;
    private String PassengerName;
    private String PassengerID;
    private int PassengerSeat;
    private String Type;
    private Route route;

    //Default Constructor
    public Ticket() { }

    //Constructor
    public Ticket(String DestinationTicket,String DeparturePointTicket,Calendar DepartureTimeTicket,
                  Calendar DepartureDateTicket,Calendar EstimatedArrivalTimeTicket,double Price,
                  String PassengerName,String PassengerID,int PassengerSeat,String Type,Route route){

        this.DestinationTicket = DestinationTicket;
        this.DeparturePointTicket = DeparturePointTicket;
        this.DepartureTimeTicket = DepartureTimeTicket;
        this.DepartureDateTicket = DepartureDateTicket;
        this.EstimatedArrivalTimeTicket = EstimatedArrivalTimeTicket;
        this.Price = Price;
        this.PassengerName = PassengerName;
        this.PassengerID = PassengerID;
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

    public Calendar getDepartureTimeTicket() {
        return DepartureTimeTicket;
    }

    public Calendar getDepartureDateTicket() {
        return DepartureDateTicket;
    }

    public Calendar getEstimatedArrivalTimeTicket() {
        return EstimatedArrivalTimeTicket;
    }

    public double getPrice() {
        return Price;
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

    public void setDepartureTimeTicket(Calendar departureTimeTicket) {
        DepartureTimeTicket = departureTimeTicket;
    }

    public void setDepartureDateTicket(Calendar departureDateTicket) {
        DepartureDateTicket = departureDateTicket;
    }

    public void setEstimatedArrivalTimeTicket(Calendar estimatedArrivalTimeTicket) {
        EstimatedArrivalTimeTicket = estimatedArrivalTimeTicket;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setPassengerName(String passengerName) {
        PassengerName = passengerName;
    }

    public void setPassengerID(String passengerID) {
        PassengerID = passengerID;
    }

    public void setPassengerSeat(int passengerSeat) {
        PassengerSeat = passengerSeat;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setRoute(Route route) {
        if(this.route != null){
            this.route.friendRoutes().remove(this);
        }

        this.route = route;
        if(this.route != null){
            this.route.friendRoutes().add(this);
        }
    }


    //Checks if the ticket is available in the route
    public boolean TicketExists(Ticket ticket){
        return route.FindTicket(ticket);
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

        if(!(PassengerName == null ? theTicket.PassengerName == null
                : PassengerName.equals(theTicket.PassengerName))){
            return false;
        }

        if(!(PassengerID == null ? theTicket.PassengerID == null
                : PassengerID.equals(theTicket.PassengerID))){
            return false;
        }

        if(!(PassengerSeat == 0 ? theTicket.PassengerSeat == 0
                : PassengerSeat == theTicket.PassengerSeat)){
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
                Price == 0 && PassengerName == null && PassengerID == null & PassengerSeat == 0
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
        result = PassengerName == null ? result : 13 * result + PassengerName.hashCode();
        result = PassengerID == null ? result : 13 * result + PassengerID.hashCode();
        result = PassengerSeat == 0 ? result : 13 * result + PassengerSeat;
        result = Type == null ? result : 13 * result + Type.hashCode();

        return result;
    }
}
