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
     *
     * This method method redirects the user to another activity after a click event.
     * @param departurePoint, the departure point of the route
     * @param destination, the destination of the route
     * @param departureDate, the departure date of the route
     * @param departureTime, the departure time of the route
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
     * @param data, the list that is going to be loaded
     */
    @Override
    public void loadData(List<DataRow> data) {
        this.data = data;
    }

    /**
     * This method pops up a toast.
     * @param value, the message we want to print in the toast
     */
    @Override
    public void showToast(String value) {
        this.value = value;
    }

    /** This method returns a text of a toast.
     * @return a String object that has the text of a toast
     */
    public String getToast(){
        return value;
    }

    /** This method returns a list of data.
     * @return a list that has inside the data we wants
     */
    public List<DataRow> getData() {
        return data;
    }

    /** This method returns the number of times an item was clicked.
     * @return the number of times an item was clicked
     */
    public int getTimesClickedItem(String destination)
    {
        return clicksCount.containsKey(destination) ? clicksCount.get(destination) : 0;
    }

}
