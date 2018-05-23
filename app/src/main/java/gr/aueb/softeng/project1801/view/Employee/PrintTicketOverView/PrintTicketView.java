package gr.aueb.softeng.project1801.view.Employee.PrintTicketOverView;

public interface PrintTicketView {

    /**
     * This method sets a specific destination.
     * @param destination , a String object that contains the destination
     */
    void setDestination(String destination);

    /**
     * This method sets a specific departure point.
     * @param departurePoint , a String object that contains the departure point
     */
    void setDeparturePoint(String departurePoint);

    /**
     * This method sets a specific departure date.
     * @param departureDate , a String object that contains the departure date
     */
    void setDepartureDate(String departureDate);

    /**
     * This method sets a seat.
     * @param seats , a specific seat
     */
    void setSeat(String seats);

    /**
     * This method sets a specific departure time.
     * @param time , a String object that contains the departure time
     */
    void setDepartureTime(String time);

    /**
     * This method sets a specific price on a ticket.
     * @param price , a String object that contains the price of the ticket
     */
    void setPrice(String price);

    /**
     * This method sets a types.
     * @param types , a specific type
     */
    void setType(String types);

    /**
     * This method sets a passenger's firstName.
     * @param name , a passenger's firstName
     */
    void setPassengerFirstname(String name);

    /**
     * This method sets a passenger's lastName.
     * @param name , a passenger's lastName
     */
    void setPassengerLastname(String name);

    /**
     * This method sets a specific passenger ID.
     * @param id , a String object that contains the passenger ID
     */
    void setPassengerID(String id);

    /**
     * This method returns a passenger's FirstName.
     * @return a String object that has the passenger's FirstName
     */
    String getPassengerFirstname();

    /**
     * This method returns a passenger's LastName.
     * @return a String object that has the passenger's LastName
     */
    String getPassengerLastname();

    /**
     * This method returns a passenger's ID.
     * @return a String object that has the passenger's ID
     */
    String getPassengerID();

    /**
     * This method sets a specific estimated arrival time.
     * @param arrivalTime , a String object that contains the estimated arrival time
     */
    void setEstimatedArrivalTime(String arrivalTime);

    /**
     * This method pops up a toast.
     * @param value , the message we want to print in the toast
     */
    void showToast(String value);

    /**
     * This method shows alert messages
     * @param message , the alert message we want to print
     */
    void showAlertMessage(String message);

    /**
     * This method helps us to print a passenger's ticket.
     * @param message , the message we want to print
     */
    void printTicket(String message);

    /**
     * This method sets name to a specific Activity.
     * @param title , the name_value we want to set in a specific Activity
     */
    void setActivityName(String title);

    /**
     * This method terminates a process.
     */
    void kill();
}
