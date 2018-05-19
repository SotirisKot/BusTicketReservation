package gr.aueb.softeng.project1801.viewTests.PassengerTests.TrackRouteTests;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.view.Passenger.Track_Route.TrackRouteView;

public class TrackRouteViewStub implements TrackRouteView {

    private String destination, departurePoint, departureDate, departureTime, message, value;
    private List<String> destinations, departures, times;


    /**
     * This method pops up a toast.
     *
     * @param message , the message we want to print in the toast
     */
    @Override
    public void ShowToast(String message) {
        this.message = message;
    }

    /**
     * This method sets name to a specific Activity.
     *
     * @param value , the name_value we want to set in a specific Activity
     */
    @Override
    public void setActivityName(String value) {
        this.value = value;
    }

    /**
     * This method sets a list of destinations.
     *
     * @param destinations , a set of destinations we want to have
     */
    @Override
    public void setDestinationsList(List<String> destinations) {
        this.destinations = destinations;
    }

    /**
     * This method sets a list of departures.
     *
     * @param departures , a set of departures we want to have
     */
    @Override
    public void setDeparturePointsList(List<String> departures) {
        this.departures = departures;
    }

    /**
     * This method sets a list of times we want to departure our buses.
     *
     * @param times , a set of times that the buses can start their routs
     */
    @Override
    public void setDepartureTimesList(List<String> times) {
        this.times = times;
    }

    /**
     * This method returns a destination.
     *
     * @return a String object that has the name of the destination we asked
     */
    @Override
    public String getDestination() {
        return destination;
    }

    /**
     * This method returns a departure point.
     *
     * @return a String object that has the departure point
     */
    @Override
    public String getDeparturepoint() {
        return departurePoint;
    }

    /**
     * This method returns a departure date.
     *
     * @return a String object that has the departure date
     */
    @Override
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * This method returns a departure time.
     *
     * @return a String object that has the departure time
     */
    @Override
    public String getDepartureTime() {
        return departureTime;
    }

    public TrackRouteViewStub () {
        destination = departurePoint = departureDate = departureTime = message = value;
        destinations = new ArrayList<>();
        departures = new ArrayList<>();
        times = new ArrayList<>();
        destinations.add("");
        departures.add("");
        times.add("");
    }

    /**
     * This method shows alert messages
     *
     * @param message , the alert message we want to print
     */
    @Override
    public void showAlertMessage(String message) {
        this.message = message;
    }

    /**
     * This method method redirects the user to another activity after a click event.
     *
     * @param destination    , the destination of the route
     * @param departurePoint , the departure point of the route
     * @param departureDate  , the departure date of the route
     * @param departureTime  , the departure time of the route
     */
    @Override
    public void trackRoute(String destination, String departurePoint, String departureDate, String departureTime) {
        this.destination = destination;
        this.departurePoint = departurePoint;
        this.departureDate = departureDate;
        this.departurePoint = departureTime;
    }

    /** This method returns the message.
     * @return the message
     */
    public String getMessage() {
        return message;
    }


    /**
     * This method sets a message
     *
     * @param message , the message we want to print
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
