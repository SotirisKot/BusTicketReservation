package gr.aueb.softeng.project1801.viewTests.PassengerTests.TrackResultsTests;

import gr.aueb.softeng.project1801.view.Passenger.TrackResults.TrackResultsView;
import gr.aueb.softeng.project1801.viewTests.PassengerTests.TrackRouteTests.TrackRouteViewStub;

public class TrackResultsViewStub implements TrackResultsView {


    private String destination, departurePoint, departureDate, departureTime, value, message;

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
    public String getDeparturePoint() {
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

    /**
     * Constructor
     */
    public TrackResultsViewStub() {
        destination = departurePoint = departureDate = departureTime = value = message = "";
    }

    /**
     * This method sets a specific destination.
     *
     * @param destination , a String object that contains the destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * This method sets a specific departure point.
     *
     * @param departurePoint , a String object that contains the departure point
     */
    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    /**
     * This method sets a specific departure date.
     *
     * @param departureDate , a String object that contains the departure date
     */
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * This method sets a specific departure time.
     *
     * @param departureTime , a String object that contains the departure time
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * This method pops up a toast.
     *
     * @param value , the message we want to print in the toast
     */
    @Override
    public void showToast(String value) {
        this.value = value;
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

    /** This method returns the value.
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * This method sets a value
     *
     * @param value , the message "value" we want to print
     */
    public void setValue(String value) {
        this.value = value;
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
