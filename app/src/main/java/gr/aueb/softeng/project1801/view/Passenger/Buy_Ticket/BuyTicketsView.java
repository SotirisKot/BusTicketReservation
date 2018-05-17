package gr.aueb.softeng.project1801.view.Passenger.Buy_Ticket;

import java.util.List;

import gr.aueb.softeng.project1801.SysUtils.DataRow;

public interface BuyTicketsView {

    /**
     *  This method pops up a toast.
     * @param message, the message we want to print in the toast
     */
    void ShowToast(String message);

    /** This method sets name to a specific Activity.
     * @param value, the name_value we want to set in a specific Activity
     */
    void setActivityName(String value);

    /** This method sets a list of destinations.
     * @param destinations, a set of destinations we want to have
     */
    void setDestinationsList(List<String> destinations);

    /** This method sets a list of departures.
     * @param departures, a set of departures we want to have
     */
    void setDeparturePointsList(List<String> departures);

    /** This method sets a list of number of seats.
     * @param num_seats, a set of number of seats
     */
    void setNumberOfSeats(List<String> num_seats);

    /** This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    String getDestination();

    /** This method returns a departure point.
     * @return a String object that has the departure point
     */
    String getDeparturepoint();

    /** This method returns a departure date.
     * @return a String object that has the departure date
     */
    String getDepartureDate();

    /** This method returns the number of seats.
     * @return a String object that has the number of seats
     */
    String getNumberOfSeats();

    /** This method shows alert messages
     * @param message, the alert message we want to print
     */
    void showAlertMessage(String message);

    /**
     * This method search a route based on the details given.
     * @param destination ,the destination
     * @param departurePoint ,the departure point
     * @param departureDate , the departure date
     * @param seats ,the seat
     */
    void searchRoute(String destination,String departurePoint,String departureDate,String seats);
}
