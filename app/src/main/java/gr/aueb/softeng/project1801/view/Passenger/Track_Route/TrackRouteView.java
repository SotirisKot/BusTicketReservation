package gr.aueb.softeng.project1801.view.Passenger.Track_Route;

import java.util.List;

public interface TrackRouteView {

    /**
     *  This method pops up a toast.
     * @param message , the message we want to print in the toast
     */
    void ShowToast(String message);

    /**
     * This method sets name to a specific Activity.
     * @param value , the name_value we want to set in a specific Activity
     */
    void setActivityName(String value);

    /**
     * This method sets a list of destinations.
     * @param destinations , a set of destinations we want to have
     */
    void setDestinationsList(List<String> destinations);

    /**
     * This method sets a list of departures.
     * @param departures , a set of departures we want to have
     */
    void setDeparturePointsList(List<String> departures);

    /**
     * This method sets a list of times we want to departure our buses.
     * @param times , a set of times that the buses can start their routs
     */
    void setDepartureTimesList(List<String> times);

    /**
     * This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    String getDestination();

    /**
     * This method returns a departure point.
     * @return a String object that has the departure point
     */
    String getDeparturepoint();

    /**
     * This method returns a departure date.
     * @return a String object that has the departure date
     */
    String getDepartureDate();

    /**
     * This method returns a departure time.
     * @return a String object that has the departure time
     */
    String getDepartureTime();

    /**
     * This method shows alert messages
     * @param message , the alert message we want to print
     */
    void showAlertMessage(String message);

    /**
     *
     * This method method redirects the user to another activity after a click event.
     * @param destination , the destination of the route
     * @param departurePoint , the departure point of the route
     * @param departureDate , the departure date of the route
     * @param departureTime , the departure time of the route
     */
    void trackRoute(String destination,String departurePoint,String departureDate,String departureTime);
}
