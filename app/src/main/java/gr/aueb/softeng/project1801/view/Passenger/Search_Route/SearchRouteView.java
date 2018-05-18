package gr.aueb.softeng.project1801.view.Passenger.Search_Route;

import java.util.List;

import gr.aueb.softeng.project1801.SysUtils.DataRow;

public interface SearchRouteView {

    /**
     *
     * This method method redirects the user to another activity after a click event.
     * @param destination , the destination of the route
     * @param departurePoint , the departure point of the route
     * @param departureDate , the departure date of the route
     * @param departureTime , the departure time of the route
     * @param seats , a specific seaet in the bus
     */
    void clickItem(String destination,String departurePoint,String departureDate,String departureTime,String seats);

    /**
     * This method loads the data(a List).
     * @param data , the data that we want to load
     */
    void loadData(List<DataRow> data);

    /**
     *  This method pops up a toast.
     * @param value , the message we want to print in the toast
     */
    void showToast(String value);

    /** This method shows alert messages
     * @param message , the alert message we want to print
     */
    void showAlertMessage(String message,String destination,String departurePoint,String departureDate,String departureTime,String seats);

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

    /** This method sets name to a specific Activity.
     * @param value , the name_value we want to set in a specific Activity
     */
    void setActivityName(String value);
}
