package gr.aueb.softeng.project1801.view.Passenger.Choose_Seat;

import java.util.List;

import gr.aueb.softeng.project1801.SysUtils.SeatRow;

public interface ChooseSeatView {

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

    /** This method returns the number of seats.
     * @return a String object that has the number of seats
     */
    String getSeats();

    /** This method returns a departure time.
     * @return a String object that has the departure time
     */
    String getDepartureTime();

    /**
     *  This method pops up a toast.
     * @param value, the message we want to print in the toast
     */
    void showToast(String value);

    /** This method shows alert messages
     * @param message, the alert message we want to print
     */
    void showAlertMessage(String message);

    /**
     * This method loads the data(a List).
     */
    void loadData(List<SeatRow> data);

    /**
     *
     * This method method redirects the user to another activity after a click event.
     * @param destination, the destination of the route
     * @param departurePoint, the departure point of the route
     * @param departureDate, the departure date of the route
     * @param departureTime, the departure time of the route
     */
    void clickProceed(String destination,String departurePoint,String departureDate,String departureTime);
}
