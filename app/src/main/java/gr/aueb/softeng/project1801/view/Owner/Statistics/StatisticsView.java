package gr.aueb.softeng.project1801.view.Owner.Statistics;

import java.util.List;

import gr.aueb.softeng.project1801.SysUtils.DataRow;

public interface StatisticsView {

    /**
     *
     * This method method redirects the user to another activity after a click event.
     * @param destination , the destination of the route
     * @param departurePoint , the departure point of the route
     * @param departureDate , the departure date of the route
     * @param departureTime , the departure time of the route
     */
    void clickItem(String destination,String departurePoint,String departureDate,String departureTime);

    /**
     * This method loads the data(a List).
     * @param data , the list that is going to be loaded
     */
    void loadData(List<DataRow> data);

    /**
     * This method pops up a toast.
     * @param value , the message we want to print in the toast
     */
    void showToast(String value);
}
