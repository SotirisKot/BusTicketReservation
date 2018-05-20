package gr.aueb.softeng.project1801.viewTests.PassengerTests.Enter_card_infoTests;

import gr.aueb.softeng.project1801.view.Passenger.Enter_card_info.cardInfoView;

public class cardInfoViewStub implements cardInfoView {

    private String destination, departurePoint, departureDate, departureTime, firstName, lastName, cardHolderName, passengerID, cardID, CVcode, expirationDate, price, seats, type, message, title;

    /**
     * This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    @Override
    public String getDestination() {
        return destination;
    }

    /**
     * This method returns a departure point.
     * @return a String object that has the departure point
     */
    @Override
    public String getDeparturePoint() {
        return departurePoint;
    }

    /**
     * This method returns a departure date.
     * @return a String object that has the departure date
     */
    @Override
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * This method returns a departure time.
     * @return a String object that has the departure time
     */
    @Override
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * This method returns a FirstName.
     * @return a String object that has the FirstName
     */
    @Override
    public String getFirstname() {
        return firstName;
    }

    /**
     * This method returns a LastName.
     * @return a String object that has the LastName
     */
    @Override
    public String getLastname() {
        return lastName;
    }

    /**
     * This method returns a passengerID.
     * @return a String object that has the passengerID
     */
    @Override
    public String getPassengerID() {
        return passengerID;
    }

    /**
     * This method returns a cardHolderName.
     * @return a String object that has the cardHolderName
     */
    @Override
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * This method returns a cardID.
     * @return a String object that has the cardID
     */
    @Override
    public String getCardId() {
        return cardID;
    }

    /**
     * This method returns a CVcode.
     * @return a String object that has the CVcode
     */
    @Override
    public String getCVcode() {
        return CVcode;
    }

    /**
     * This method returns an expirationDate.
     * @return a String object that has the expirationDate
     */
    @Override
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * This method returns a price.
     * @return a String object that has the price
     */
    @Override
    public String getPrice() {
        return price;
    }

    /**
     * This method returns the number of seats.
     * @return a String object that has the number of seats
     */
    @Override
    public String getSeats() {
        return seats;
    }

    /**
     * This method returns a type of the card.
     * @return a String object that has the type of the card
     */
    @Override
    public String getType() {
        return type;
    }

    public cardInfoViewStub(){
        destination = departurePoint = departureDate = departureTime = firstName = lastName = cardHolderName = passengerID = cardID = CVcode = expirationDate = price = seats = type = message = title = "";
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
     *  This method pops up a toast.
     * @param message , the message we want to print in the toast
     */
    @Override
    public void showToast(String message) {
        this.message = message;
    }

    /** This method sets name to a specific Activity.
     * @param title , the title we want to set in a specific Activity
     */
    @Override
    public void setActivityName(String title) {
        this.title = title;
    }

    /**
     *  This method pops up a toast.
     * @param message , the message we want to show in the toast
     */
    @Override
    public void clickCheckout(String message) {
        this.message = message;
    }

    /**
     * This methods returns the firstName of the passenger.
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This methods returns the lastName of the passenger.
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This methods returns a message.
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * This methods returns a title.
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method sets a specific destination.
     * @param destination , a String object that contains the destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * This method sets a specific departure point.
     * @param departurePoint , a String object that contains the departure point
     */
    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    /**
     * This method sets a specific departure date.
     * @param departureDate , a String object that contains the departure date
     */
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * This method sets a specific departure time.
     * @param departureTime , a String object that contains the departure time
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * This methods helps us to set the fistName of a passenger.
     * @param firstName , the firstName of the passenger
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This methods helps us to set the lastName of a passenger.
     * @param lastName , the lastName of the passenger
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This methods helps us to set the cardHolderName of a passenger.
     * @param cardHolderName , the cardHolderName of the passenger
     */
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    /**
     * This methods helps us to set the passengerID.
     * @param passengerID , the passengerID
     */
    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    /**
     * This methods helps us to set the cardID.
     * @param cardID , the cardID
     */
    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    /**
     * This methods helps us to set the CVcode.
     * @param CVcode , the CVcode
     */
    public void setCVcode(String CVcode) {
        this.CVcode = CVcode;
    }

    /**
     * This methods helps us to set the expirationDate.
     * @param expirationDate , the expirationDate
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * This methods helps us to set the price of a ticket.
     * @param price , the price of the ticket
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * This method sets the seats.
     * @param seats , the seats we want to set
     */
    public void setSeats(String seats) {
        this.seats = seats;
    }

    /**
     * This method sets the type.
     * @param type , the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method helps us to set a message that we want to print.
     * @param message , the message we want to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * This method helps us to set a title that we want to print.
     * @param title , the title we want to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
