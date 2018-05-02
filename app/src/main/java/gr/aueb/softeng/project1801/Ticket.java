package gr.aueb.softeng.project1801;


import gr.aueb.softeng.project1801.SysCalendar.SystemCalendar;

public class Ticket {

    private String DestinationTicket;
    private String DeparturePointTicket;
    private String DepartureTimeTicket;
    private SystemCalendar DepartureDateTicket;
    private String EstimatedArrivalTimeTicket;
    private double Price;
    private Passenger passenger;
    private String PassengerName;
    private String PassengerID;
    private int PassengerSeat;
    private String Type;
    private Route route;

    /**
     *
     * Default constructor,which constructs a Ticket object.
     */
    public Ticket() { }

    /**
     *
     * Constructor.
     * @param DestinationTicket (required) Destination Ticket of the ticket.
     * @param DeparturePointTicket (required) Departure Point Ticket of the ticket.
     * @param DepartureTimeTicket (required) Departure Time Ticket of the ticket.
     * @param DepartureDateTicket (required) Departure Date Ticket of the ticket.
     * @param EstimatedArrivalTimeTicket (required) Estimated Arrival Time Ticket of the ticket.
     * @param Price (required) price of the ticket.
     * @param passenger (required) passenger of the ticket.
     * @param PassengerSeat (required) passenger Seat of the ticket.
     * @param Type (required) type of the ticket.
     * @param route (required) route of the ticket.
     */
    public Ticket(String DestinationTicket,String DeparturePointTicket,String DepartureTimeTicket,
                  SystemCalendar DepartureDateTicket,String EstimatedArrivalTimeTicket,double Price,
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

    /** @return DestinationTicket passed to the constructor.  */
    public String getDestinationTicket() {
        return DestinationTicket;
    }

    /** @return DeparturePointTicket passed to the constructor.  */
    public String getDeparturePointTicket() {
        return DeparturePointTicket;
    }

    /** @return DepartureTimeTicket passed to the constructor.  */
    public String getDepartureTimeTicket() {
        return DepartureTimeTicket;
    }

    /** @return DepartureDateTicket passed to the constructor.  */
    public SystemCalendar getDepartureDateTicket() {
        return DepartureDateTicket;
    }

    /** @return EstimatedArrivalTimeTicket passed to the constructor.  */
    public String getEstimatedArrivalTimeTicket() {
        return EstimatedArrivalTimeTicket;
    }

    /** @return Price passed to the constructor.  */
    public double getPrice() {
        return Price;
    }

    /** @return passenger passed to the constructor.  */
    public Passenger getPassenger() {
        return passenger;
    }

    /** @return PassengerName passed to the constructor.  */
    public String getPassengerName() {
        return PassengerName;
    }

    /** @return PassengerID passed to the constructor.  */
    public String getPassengerID() {
        return PassengerID;
    }

    /** @return PassengerSeat passed to the constructor.  */
    public int getPassengerSeat() {
        return PassengerSeat;
    }

    /** @return Type passed to the constructor.  */
    public String getType() {
        return Type;
    }

    /** @return route passed to the constructor.  */
    public Route getRoute() {
        return route;
    }


    //Setters

    /**
     *
     * @param destinationTicket destination Ticket to set
     */
    public void setDestinationTicket(String destinationTicket) {
        DestinationTicket = destinationTicket;
    }

    /**
     *
     * @param departurePointTicket departure Point Ticket to set
     */
    public void setDeparturePointTicket(String departurePointTicket) {
        DeparturePointTicket = departurePointTicket;
    }

    /**
     *
     * @param departureTimeTicket departure Time Ticket to set
     */
    public void setDepartureTimeTicket(String departureTimeTicket) {
        DepartureTimeTicket = departureTimeTicket;
    }

    /**
     *
     * @param departureDateTicket departure Date Ticket to set
     */
    public void setDepartureDateTicket(SystemCalendar departureDateTicket) {
        DepartureDateTicket = departureDateTicket;
    }

    /**
     *
     * @param estimatedArrivalTimeTicket estimated Arrival Time Ticket to set
     */
    public void setEstimatedArrivalTimeTicket(String estimatedArrivalTimeTicket) {
        EstimatedArrivalTimeTicket = estimatedArrivalTimeTicket;
    }

    /**
     *
     * @param price price to set
     */
    public void setPrice(double price) {
        this.Price = price;
    }

    /**
     *
     * @param passenger passenger to set
     */
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    /**
     *
     * @param passengerSeat passenger Seat to set
     */
    public void setPassengerSeat(int passengerSeat) {
        this.PassengerSeat = passengerSeat;
    }

    /**
     *
     * @param passengerName passenger Name to set
     */
    public void setPassengerName(String passengerName) {
        this.PassengerName = passengerName;
    }

    /**
     *
     * @param type type to set
     */
    public void setType(String type) {
        this.Type = type;
    }

    /**
     *
     * @param passengerID passenger ID to set
     */
    public void setPassengerID(String passengerID) {
        this.PassengerID = passengerID;
    }

    /**
     *
     * @param route route to set
     */
    public void setRoute(Route route) {
        if(this.route != null){
            this.route.friendRoutes().remove(this);
            this.route.setAvailableSeats(this.route.getAvailableSeats() + 1);
        }

        this.route = route;
        if(this.route != null){
            this.route.friendRoutes().add(this);
            this.route.setAvailableSeats(this.route.getAvailableSeats() - 1);
        }
    }


    /**
     * //Checking availability.
     *
     * This method checks if the ticket is available in the route.
     * @param ticket must be an object.
     */
    public boolean TicketExists(Ticket ticket){
        return route.FindTicket(ticket);
    }


    /**
     * //Compliting purchase availability.
     *
     * This method completes the purchase of a ticket if it is available.
     * @param ticket must be an object.
     * @param passenger must be an object.
     * @param route must be an object.
     */
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

    /**
     * Comparing two objects.
     *
     * This method checks if two object are the same.
     * @param other must be an object.
     */
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

    /**
     * Getting the hashCode of an object.
     *
     * This method checks if two object has the same hasCode.
     * If the method equals returned "true" the hasCode of the two objects must be the same.
     * If the method equals returned "false" the hasCode of the two objects must not be the same.
     */
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
