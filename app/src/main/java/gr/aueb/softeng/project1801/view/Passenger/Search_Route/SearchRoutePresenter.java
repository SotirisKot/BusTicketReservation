package gr.aueb.softeng.project1801.view.Passenger.Search_Route;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.DomainModel.Schedule;
import gr.aueb.softeng.project1801.SysUtils.DataRow;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.ScheduleDAO;

public class SearchRoutePresenter {

    private SearchRouteView view;
    private ScheduleDAO scheduleDAO;

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
     * This method initializes the Presenter in order to be able a user to choose a seat.
     * @param view, an instance of view
     * @param scheduleDAO, an instance of ScheduleDAO
     */
    public SearchRoutePresenter(SearchRouteView view,ScheduleDAO scheduleDAO){
        this.view = view;
        this.scheduleDAO = scheduleDAO;

        view.setActivityName("Routes based on your requests");

        onloadData();
    }

    /**
     * This method helps to load the data(a List).
     */
    public void onloadData(){
        Schedule schedule = scheduleDAO.findAll().get(0);
        String destination = view.getDestination();
        String departurePoint = view.getDeparturePoint();
        String departureDate = view.getDepartureDate();
        int seats = Integer.parseInt(view.getSeats());

        String[] parts = departureDate.split("/");
        SystemCalendar calendar = new SystemCalendar(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));

        List<Route> routes = new ArrayList<>();

        for(Route route : schedule.getRoutes()){
            if(destination.equals(route.getDestination()) && departurePoint.equals(route.getDeparturePoint())
                    && calendar.equals(route.getDepartureDate()) && route.getAvailableSeats() > seats){

                routes.add(route);
            }
        }
        if(routes.size() != 0){
            view.loadData(createData(routes));
        }else{
            view.showToast("No results based on your request!!");
        }

    }

    /**
     * This method helps us to finalize the execution of the user's choice.
     */
    public void onFinalClick(String destination,String departurePoint,String departureDate,String departureTime,String seats)
    {
        view.clickItem(destination,departurePoint,departureDate,departureTime,seats);
    }

    /**
     * This method helps us to understand what the user selected by showing a message.
     */
    public void onclickItem(String value,String destination,String departurePoint,String departureDate,String departureTime,String seats){

        view.showAlertMessage(value,destination,departurePoint,departureDate,departureTime,seats);

    }


}
