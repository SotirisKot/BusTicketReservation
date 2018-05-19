package gr.aueb.softeng.project1801.viewTests.EmployeeTests.PrintTicketOverviewTests;

import gr.aueb.softeng.project1801.view.Employee.PrintTicketOverView.PrintTicketView;

public class PrintTicketViewStub implements PrintTicketView {

    private String destination, departurePoint, departureDate, passengerID, estimatedArrivalTime,
            firstName, lastName, departureTime, price, type, seats, message, value, title,printMessage;

    /**
     * This method sets a specific destination.
     * @param destination , a String object that contains the destination
     */
    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * This method sets a specific departure point.
     * @param departurePoint , a String object that contains the departure point
     */
    @Override
    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    /**
     * This method sets a specific departure date.
     * @param departureDate , a String object that contains the departure date
     */
    @Override
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * This method sets a seat.
     * @param seats , a specific seat
     */
    @Override
    public void setSeat(String seats) {
        this.seats = seats;
    }

    /**
     * This method sets a specific departure time.
     * @param time , a String object that contains the departure time
     */
    @Override
    public void setDepartureTime(String time) {
        this.departureTime = departureTime;
    }

    /**
     * This method sets a specific price on a ticket.
     * @param price , a String object that contains the price of the ticket
     */
    @Override
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * This method sets a types.
     * @param types , a specific type
     */
    @Override
    public void setType(String types) {
        this.type = types;
    }

    /**
     * This method sets a passenger's firstName.
     * @param name , a passenger's firstName
     */
    @Override
    public void setPassengerFirstname(String name) {
        firstName = name;
    }

    /**
     * This method sets a passenger's lastName.
     * @param name , a passenger's lastName
     */
    @Override
    public void setPassengerLastname(String name) {
        lastName = name;
    }

    /**
     * This method sets a specific passenger ID.
     * @param id , a String object that contains the passenger ID
     */
    @Override
    public void setPassengerID(String id) {
        passengerID = id;
    }

    /**
     * Constructor
     */
    public PrintTicketViewStub() {
        printMessage = destination = departurePoint = departureDate = passengerID = estimatedArrivalTime
                = firstName = lastName = departureTime = price = type = seats = message = value = title = "";
    }

    /**
     * This method returns a passenger's FirstName.
     * @return a String object that has the passenger's FirstName
     */
    @Override
    public String getPassengerFirstname() {
        return firstName;
    }

    /**
     * This method returns a passenger's LastName.
     * @return a String object that has the passenger's LastName
     */
    @Override
    public String getPassengerLastname() {
        return lastName;
    }

    /**
     * This method returns a passenger's ID.
     * @return a String object that has the passenger's ID
     */
    @Override
    public String getPassengerID() {
        return passengerID;
    }

    /**
     * This method terminates the process
     */
    @Override
    public void kill() {
        showToast("Cannot find Ticket");
    }

    /**
     * This method sets a specific estimated arrival time.
     * @param arrivalTime , a String object that contains the estimated arrival time
     */
    @Override
    public void setEstimatedArrivalTime(String arrivalTime) {
        estimatedArrivalTime = arrivalTime;
    }

    /**
     * This method pops up a toast.
     * @param value , the message we want to print in the toast
     */
    @Override
    public void showToast(String value) {
        this.value = value;
    }

    /**
     * This method shows alert messages
     * @param message , the alert message we want to print
     */
    @Override
    public void showAlertMessage(String message) {
        this.message = message;
    }

    /**
     * This method helps us to print a passenger's ticket.
     * @param printMessage , the message we want to print
     */
    @Override
    public void printTicket(String printMessage) {
        this.printMessage = printMessage;
    }

    /**
     * This method sets name to a specific Activity.
     * @param title , the name_value we want to set in a specific Activity
     */
    @Override
    public void setActivityName(String title) {
        this.title = title;
    }

    /**
     * This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    public String getDestination() {
        return destination;
    }

    /**
     * This method returns a departure point.
     * @return a String object that has the departure point
     */
    public String getDeparturePoint() {
        return departurePoint;
    }

    /**
     * This method returns a departure date.
     * @return a String object that has the departure date
     */
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * This method returns an estimated arrival time.
     * @return a String object that has the estimated arrival time
     */
    public String getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    /**
     * This method returns a passenger's FirstName.
     * @return a String object that has the passenger's FirstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method returns a passenger's LastName.
     * @return a String object that has the passenger's LastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method returns a departure time.
     * @return a String object that has the departure time
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * This method helps us to set a price to a ticket.
     * @return the price of the ticket
     */
    public String getPrice() {
        return price;
    }

    /**
     * This method returns a type of the card.
     * @return a String object that has the type of the card
     */
    public String getType() {
        return type;
    }

    /**
     * This method returns a set of SeatRow objects.
     * @return a list that has the SeatRow objects
     */
    public String getSeats() {
        return seats;
    }
    /** This method returns the value.
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * This method sets a value
     * @param value , the message "value" we want to print
     */
    public void setValue(String value) {
        this.value = value;
    }

    /** This method returns the message.
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method sets a message
     * @param message , the message we want to print
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * This method returns a title
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method sets a title
     * @param title , the title we want to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrintMessage() {
        return printMessage;
    }
}
