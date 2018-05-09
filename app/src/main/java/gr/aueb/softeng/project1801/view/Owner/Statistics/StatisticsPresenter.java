package gr.aueb.softeng.project1801.view.Owner.Statistics;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.SysUtils.DataRow;
import gr.aueb.softeng.project1801.dao.RouteDAO;


public class StatisticsPresenter {

    private StatisticsView view;
    private RouteDAO routeDAO;

    /**
     * This method returns a list of route after their creation.
     * @param routes, a list of routes
     * @return a list of routes
     */
    private List<DataRow> createData(List<Route> routes){
        List<DataRow> data = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        for(Route route : routes){
            data.add(new DataRow(route.getDeparturePoint()+"  -",route.getDestination(),
                    dateFormat.format(route.getDepartureDate().getJavaCalendar().getTime()),route.getDepartureTime()));

        }

        return data;
    }

    /**
     * This method initializes the Presenter in order to be able to show statistics of the routes in later time.
     * @param view, an instance of view
     * @param schedule, an instance of routeDao
     */
    public StatisticsPresenter(StatisticsView view,RouteDAO schedule){
        this.view = view;
        this.routeDAO = schedule;
        onloadData();
    }

    /**
     * This method loads a list with the routes
     */
    public void onloadData(){
        view.loadData(createData(routeDAO.findAll()));
    }

    /**
     * This method pops up a toast with a message.
     * @param value, the message that is being displayed in the toast
     */
    public void onShowToast(String value)
    {
        view.showToast(value);
    }

    /**
     * This method method redirects the user to another activity after a click event.
     * @param destination, the destination of the route
     * @param departurePoint, the departure point of the route
     * @param departureDate, the departure date of the route
     * @param departureTime, the departure time of the route
     */
    public void onclickItem(String destination,String departurePoint,String departureDate,String departureTime){
        view.clickItem(destination,departurePoint,departureDate,departureTime);
    }

}
