package gr.aueb.softeng.project1801.viewTests.PassengerTests.TicketOverviewTests;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.SysUtils.SeatRow;
import gr.aueb.softeng.project1801.view.Passenger.TicketOverview.TicketOverviewView;

public class TicketOverviewViewStubs implements TicketOverviewView {

    private String destination, departurePoint, departureDate, passengerID, estimatedArrivalTime, firstName, lastName, departureTime, price, type, seats, message, value, title;
    private List<SeatRow> seatsList;
    private List<String> types;

    /**
     * This method sets name to a specific Activity.
     *
     * @param title , the name_value we want to set in a specific Activity
     */
    @Override
    public void setActivityName(String title) {
        this.title = title;
    }

    /**
     * This method returns a destination.
     *
     * @return a String object that has the name of the destination we asked
     */
    @Override
    public String getDestination() {
        return destination;
    }

    /**
     * This method returns a departure point.
     *
     * @return a String object that has the departure point
     */
    @Override
    public String getDeparturePoint() {
        return departurePoint;
    }

    /**
     * This method returns a departure date.
     *
     * @return a String object that has the departure date
     */
    @Override
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * This method returns a set of SeatRow objects.
     *
     * @return a list that has the SeatRow objects
     */
    @Override
    public List<SeatRow> getSeats() {
        return seatsList;
    }

    /**
     * This method returns a departure time.
     *
     * @return a String object that has the departure time
     */
    @Override
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * This method returns a type of the card.
     *
     * @return a String object that has the type of the card
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * This method sets a specific destination.
     *
     * @param destination , a String object that contains the destination
     */
    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * This method sets a specific departure point.
     *
     * @param departurePoint , a String object that contains the departure point
     */
    @Override
    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    /**
     * This method sets a specific departure date.
     *
     * @param departureDate , a String object that contains the departure date
     */
    @Override
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * This method sets a set of seats.
     *
     * @param seats , a list that contains the set of seats
     */
    @Override
    public void setSeats(List<SeatRow> seats) {
        this.seatsList = seats;
    }

    /**
     * This method sets a specific departure time.
     *
     * @param time , a String object that contains the departure time
     */
    @Override
    public void setDepartureTime(String time) {
        departureTime = time;
    }

    /**
     * This method sets a specific passenger ID.
     *
     * @param id , a String object that contains the passenger ID
     */
    @Override
    public void setPassengerId(String id) {
        passengerID = id;
    }

    /**
     * This method sets a specific price on a ticket.
     *
     * @param price , a String object that contains the price of the ticket
     */
    @Override
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * This method sets a set of ticket types.
     *
     * @param types , a list that contains the set of ticket types
     */
    @Override
    public void setTypes(List<String> types) {
        this.types = types;
    }

    /**
     * Constructor
     */
    public TicketOverviewViewStubs() {
        destination = departurePoint = departureDate = passengerID = estimatedArrivalTime = firstName = lastName = departureTime = price = type = seats = message = value = title = "";
        seatsList = new ArrayList<>();
        types = new ArrayList<>();
        types.add("");
    }

    /**
     * This method returns a passenger's FirstName.
     *
     * @return a String object that has the passenger's FirstName
     */
    @Override
    public String getPassengerFirstname() {
        return firstName;
    }

    /**
     * This method returns a passenger's LastName.
     *
     * @return a String object that has the passenger's LastName
     */
    @Override
    public String getPassengerLastname() {
        return lastName;
    }

    /**
     * This method sets a specific estimated arrival time.
     *
     * @param arrivalTime , a String object that contains the estimated arrival time
     */
    @Override
    public void setEstimatedArrivalTime(String arrivalTime) {
        estimatedArrivalTime = arrivalTime;
    }

    /**
     * This method method redirects the user to another activity after a click event.
     *
     * @param destination    , the destination of the route
     * @param departurePoint , the departure point of the route
     * @param departureDate  , the departure date of the route
     * @param departureTime  , the departure time of the route
     * @param firstname      , the first name of the passenger
     * @param lastname       , the last name of the passenger
     * @param id             , the passenger id
     * @param price          , the price of the ticket
     * @param seats          , the seat of the ticket
     * @param type           , the type of the ticket
     */
    @Override
    public void clickContinue(String destination, String departurePoint, String departureDate, String departureTime, String firstname, String lastname, String id, String price, String seats, String type) {
        this.destination = destination;
        this.departurePoint = departurePoint;
        this.departureDate = departureDate;
        this.departurePoint = departureTime;
        firstName = firstname;
        lastName = lastname;
        passengerID = id;
        this.price = price;
        this.seats = seats;
        this.type = type;
    }

    /**
     * This method pops up a toast.
     *
     * @param value , the message we want to print in the toast
     */
    @Override
    public void showToast(String value) {
        this.value = value;
    }

    /**
     * This method returns the number of seats.
     *
     * @return a String object that has the number of seats
     */
    @Override
    public String getSeat() {
        return seats;
    }

    /**
     * This method shows alert messages
     *
     * @param message , the alert message we want to print
     */
    @Override
    public void showAlertMessage(String message) {
        this.message = message;
    }
}
