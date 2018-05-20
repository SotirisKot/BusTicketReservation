package gr.aueb.softeng.project1801.viewTests.OwnerTests.StatisticsTests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gr.aueb.softeng.project1801.SysUtils.DataRow;
import gr.aueb.softeng.project1801.view.Owner.Statistics.StatisticsView;

public class StatisticsViewStub implements StatisticsView {


    private String destination, departurePoint, departureDate, departureTime, value;
    private List<DataRow> data;
    private Map<String, Integer> clicksCount;

    /**
     * This method method redirects the user to another activity after a click event.
     * @param departurePoint , the departure point of the route
     * @param destination , the destination of the route
     * @param departureDate , the departure date of the route
     * @param departureTime , the departure time of the route
     */
    @Override
    public void clickItem(String destination, String departurePoint, String departureDate, String departureTime) {
        clicksCount.put(destination,(clicksCount.containsKey(destination) ? clicksCount.get(destination) : 0)+1);
    }

    /**
     * Constructor
     */
    public StatisticsViewStub(){
        destination = departurePoint = departureDate = departureTime = value = "";
        data = new ArrayList<>();
        clicksCount = new HashMap<>();
    }

    /**
     * This method loads the data(a List).
     * @param data , the list that is going to be loaded
     */
    @Override
    public void loadData(List<DataRow> data) {
        this.data = data;
    }

    /**
     * This method pops up a toast.
     * @param value , the message we want to print in the toast
     */
    @Override
    public void showToast(String value) {
        this.value = value;
    }

    /**
     * This method returns a text of a toast.
     * @return a String object that has the text of a toast
     */
    public String getToast(){
        return value;
    }

    /**
     * This method returns a list of data.
     * @return a list that has inside the data we wants
     */
    public List<DataRow> getData() {
        return data;
    }

    /**
     * This method returns the number of times an item was clicked.
     * @return the number of times an item was clicked
     */
    public int getTimesClickedItem(String destination)
    {
        return clicksCount.containsKey(destination) ? clicksCount.get(destination) : 0;
    }

    /**
     * This method returns the departure point.
     * @return the departure point
     */
    public String getDeparturePoint() {
        return departurePoint;
    }

    /**
     * This method sets a specific departure point.
     * @param departurePoint , a String object that contains the departure point
     */
    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    /**
     * This method returns the destinations.
     * @return the destinations
     */
    public String getDestination() {
        return destination;
    }

    /**
     * This method sets a specific destination.
     * @param destination , a String object that contains the destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * This method returns the departure date.
     * @return the departure date
     */
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * This method sets a specific departure date.
     * @param departureDate , a String object that contains the departure date
     */
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * This method returns the departure time.
     * @return the departure time
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * This method sets a specific departure time.
     * @param departureTime , a String object that contains the departure time
     */
    public void setDepartureTime(String departureTime) {
        departureTime = departureTime;
    }

    /**
     * This method returns the value.
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * This method sets a value
     * @param value , the message "value" we want to print
     */
    public void setValue(String value) {
        this.value = value;
    }


}
