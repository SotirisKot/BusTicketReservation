package gr.aueb.softeng.project1801.view.Passenger.TicketOverview;
import java.util.List;
import gr.aueb.softeng.project1801.SysUtils.SeatRow;

public interface TicketOverviewView {

    /** This method sets name to a specific Activity.
     * @param title, the name_value we want to set in a specific Activity
     */
    void setActivityName(String title);

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

    /** This method returns a set of SeatRow objects.
     * @return a list that has the SeatRow objects
     */
    List<SeatRow> getSeats();

    /** This method returns a departure time.
     * @return a String object that has the departure time
     */
    String getDepartureTime();

    /** This method returns a type of the card.
     * @return a String object that has the type of the card
     */
    String getType();

    /** This method sets a specific destination.
     * @param destination, a String object that contains the destination
     */
    void setDestination(String destination);

    /** This method sets a specific departure point.
     * @param departurePoint, a String object that contains the departure point
     */
    void setDeparturePoint(String departurePoint);

    /** This method sets a specific departure date.
     * @param departureDate, a String object that contains the departure date
     */
    void setDepartureDate(String departureDate);

    /** This method sets a set of seats.
     * @param seats, a list that contains the set of seats
     */
    void setSeats(List<SeatRow> seats);

    /** This method sets a specific departure time.
     * @param time, a String object that contains the departure time
     */
    void setDepartureTime(String time);

    /** This method sets a specific passenger ID.
     * @param id, a String object that contains the passenger ID
     */
    void setPassengerId(String id);

    /** This method sets a specific price on a ticket.
     * @param price, a String object that contains the price of the ticket
     */
    void setPrice(String price);

    /** This method sets a set of ticket types.
     * @param types, a list that contains the set of ticket types
     */
    void setTypes(List<String> types);

    /** This method returns a passenger's FirstName.
     * @return a String object that has the passenger's FirstName
     */
    String getPassengerFirstname();

    /** This method returns a passenger's LastName.
     * @return a String object that has the passenger's LastName
     */
    String getPassengerLastname();

    /** This method sets a specific estimated arrival time.
     * @param arrivalTime, a String object that contains the estimated arrival time
     */
    void setEstimatedArrivalTime(String arrivalTime);

    /**
     *
     * This method method redirects the user to another activity after a click event.
     * @param destination, the destination of the route
     * @param departurePoint, the departure point of the route
     * @param departureDate, the departure date of the route
     * @param departureTime, the departure time of the route
     * @param firstname, the first name of the passenger
     * @param lastname, the last name of the passenger
     * @param id, the passenger id
     * @param price, the price of the ticket
     * @param seats, the seat of the ticket
     * @param type, the type of the ticket
     */
    void clickContinue(String destination,String departurePoint,String departureDate,
                       String departureTime,String firstname,String lastname,String id,String price,String seats,String type);

    /**
     *  This method pops up a toast.
     * @param value, the message we want to print in the toast
     */
    void showToast(String value);

    /** This method returns the number of seats.
     * @return a String object that has the number of seats
     */
    String getSeat();

    /** This method shows alert messages
     * @param message, the alert message we want to print
     */
    void showAlertMessage(String message);
}
