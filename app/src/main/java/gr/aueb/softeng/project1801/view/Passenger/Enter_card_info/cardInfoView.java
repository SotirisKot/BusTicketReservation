package gr.aueb.softeng.project1801.view.Passenger.Enter_card_info;

public interface cardInfoView {

    /** This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    String getDestination();

    /** This method returns a departure point.
     * @return a String object that has the departure point
     */
    String getDeparturePoint();

    /** This method returns a departure date.
     * @return a String object that has the departure date
     */
    String getDepartureDate();

    /** This method returns a departure time.
     * @return a String object that has the departure time
     */
    String getDepartureTime();

    /**
     * This method returns a FirstName.
     * @return a String object that has the FirstName
     */
    String getFirstname();

    /**
     * This method returns a LastName.
     * @return a String object that has the LastName
     */
    String getLastname();

    /**
     * This method returns a passengerID.
     * @return a String object that has the passengerID
     */
    String getPassengerID();

    /**
     * This method returns a cardHolderName.
     * @return a String object that has the cardHolderName
     */
    String getCardHolderName();

    /**
     * This method returns a cardID.
     * @return a String object that has the cardID
     */
    String getCardId();

    /**
     * This method returns a CVcode.
     * @return a String object that has the CVcode
     */
    String getCVcode();

    /**
     * This method returns an expirationDate.
     * @return a String object that has the expirationDate
     */
    String getExpirationDate();

    /**
     * This method returns a price.
     * @return a String object that has the price
     */
    String getPrice();

    /** This method returns the number of seats.
     * @return a String object that has the number of seats
     */
    String getSeats();

    /** This method returns a type of the card.
     * @return a String object that has the type of the card
     */
    String getType();

    /** This method shows alert messages
     * @param message , the alert message we want to print
     */
    void showAlertMessage(String message);

    /**
     *  This method pops up a toast.
     * @param message , the message we want to print in the toast
     */
    void showToast(String message);

    /** This method sets name to a specific Activity.
     * @param title , the title we want to set in a specific Activity
     */
    void setActivityName(String title);

    /**
     *  This method pops up a toast.
     * @param message , the message we want to show in the toast
     */
    void clickCheckout(String message);


}
