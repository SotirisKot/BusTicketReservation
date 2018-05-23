package gr.aueb.softeng.project1801.viewTests.PassengerTests.Search_RouteTests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gr.aueb.softeng.project1801.SysUtils.DataRow;
import gr.aueb.softeng.project1801.view.Passenger.Search_Route.SearchRouteView;

public class SearchRouteViewStub implements SearchRouteView {

    private String destination, departurePoint, departureDate, departureTime, seats, value, message;
    private List<DataRow> data;
    private Map<String, Integer> clicksCount;

    /**
     *
     * This method method redirects the user to another activity after a click event.
     *
     * @param destination the departure point of the route
     *
     * @param departurePoint the destination of the route
     *
     * @param departureDate the departure date of the route
     *
     * @param departureTime the departure time of the route
     *
     * @param seats the selected seats
     *
     */
    @Override
    public void clickItem(String destination, String departurePoint, String departureDate, String departureTime,String seats) {
        clicksCount.put(destination,(clicksCount.containsKey(destination) ? clicksCount.get(destination) : 0)+1);
        this.destination = destination;
        this.departurePoint = departurePoint;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.seats = seats;
    }

    /**
     * This method loads the data(a List).
     *
     * @param data , the data that we want to load
     */
    @Override
    public void loadData(List<DataRow> data) {
        this.data = data;
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
     * Constructor
     */
    public SearchRouteViewStub() {
        destination = departurePoint = departureDate = departureTime = seats = value = message = "";
        data = new ArrayList<>();
        clicksCount = new HashMap<>();
    }

    /**
     * This method shows alert messages
     *
     * @param message        , the alert message we want to print
     * @param destination    , the destination of the route
     * @param departurePoint , the departure point of the route
     * @param departureDate  , the departure date of the route
     * @param departureTime  , the departure time of the route
     * @param seats          , a specific seat in the bus
     */
    @Override
    public void showAlertMessage(String message, String destination, String departurePoint, String departureDate, String departureTime, String seats) {
        this.message = message;
        this.destination = destination;
        this.departurePoint = departurePoint;
        this.departureDate = departureDate;
        this.departurePoint = departureTime;
        this.seats = seats;
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
     * This method returns the number of seats.
     *
     * @return a String object that has the number of seats
     */
    @Override
    public String getSeats() {
        return seats;
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
     * This method sets a seat.
     *
     * @param seats , a seat
     */
    public void setSeats(String seats) {
        this.seats = seats;
    }

    public List<DataRow> getData() {
        return data;
    }

    public void setData(List<DataRow> data) {
        this.data = data;
    }

    /** This method returns the number of times an item was clicked.
     * @return the number of times an item was clicked
     */
    public int getTimesClickedItem(String destination){
        return clicksCount.containsKey(destination) ? clicksCount.get(destination) : 0;
    }

    public String getDepartureTime() {
        return departureTime;
    }
}
