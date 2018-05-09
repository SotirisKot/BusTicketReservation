package gr.aueb.softeng.project1801.view.Passenger.Search_Route;

import android.support.design.widget.Snackbar;

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

    private List<DataRow> createData(List<Route> routes){
        List<DataRow> data = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        for(Route route : routes){
            data.add(new DataRow(route.getDeparturePoint()+"  -",route.getDestination(),
                    dateFormat.format(route.getDepartureDate().getJavaCalendar().getTime()),route.getDepartureTime()));

        }

        return data;
    }

    public SearchRoutePresenter(SearchRouteView view,ScheduleDAO scheduleDAO){
        this.view = view;
        this.scheduleDAO = scheduleDAO;

        view.setActivityName("Routes based on your requests");

        onloadData();
    }

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

    public void onFinalClick(String destination,String departurePoint,String departureDate,String departureTime)
    {
        view.clickItem(destination,departurePoint,departureDate,departureTime);
    }

    public void onclickItem(String value,String destination,String departurePoint,String departureDate,String departureTime){

        view.showAlertMessage(value,destination,departurePoint,departureDate,departureTime);

    }


}
