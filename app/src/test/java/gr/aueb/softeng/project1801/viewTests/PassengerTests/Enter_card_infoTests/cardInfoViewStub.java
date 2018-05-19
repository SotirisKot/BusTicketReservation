package gr.aueb.softeng.project1801.viewTests.PassengerTests.Enter_card_infoTests;

import gr.aueb.softeng.project1801.view.Passenger.Enter_card_info.cardInfoView;

public class cardInfoViewStub implements cardInfoView {

    private String destination, departurePoint, departureDate, departureTime, firstName, lastName, cardHolderName, passengerID, cardID, CVcode, expirationDate, price, seats, type, message, title;

    /** This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    @Override
    public String getDestination() {
        return destination;
    }

    /** This method returns a departure point.
     * @return a String object that has the departure point
     */
    @Override
    public String getDeparturePoint() {
        return departurePoint;
    }

    /** This method returns a departure date.
     * @return a String object that has the departure date
     */
    @Override
    public String getDepartureDate() {
        return departureDate;
    }

    /** This method returns a departure time.
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

    /** This method returns the number of seats.
     * @return a String object that has the number of seats
     */
    @Override
    public String getSeats() {
        return seats;
    }

    /** This method returns a type of the card.
     * @return a String object that has the type of the card
     */
    @Override
    public String getType() {
        return type;
    }

    public cardInfoViewStub(){
        destination = departurePoint = departureDate = departureTime = firstName = lastName = cardHolderName = passengerID = cardID = CVcode = expirationDate = price = seats = type = message = title = "";
    }

    /** This method shows alert messages
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public void setCVcode(String CVcode) {
        this.CVcode = CVcode;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
