package gr.aueb.softeng.project1801.view.Owner.StatisticsDetails;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import gr.aueb.softeng.project1801.DomainModel.BusState;
import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.DomainModel.Schedule;
import gr.aueb.softeng.project1801.DomainModel.ScheduleEntry;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.RouteDAO;
import gr.aueb.softeng.project1801.dao.ScheduleDAO;
import gr.aueb.softeng.project1801.memorydao.ScheduleDAOMemory;

public class StatisticsDetailsPresenter {

    private StatisticsDetailsView view;
    private RouteDAO routes;
    private Route presentedRoute;

    /**
     * This method initializes the Presenter in order to be able to show statistics details of the routes in later time.
     * @param view , an instance of view
     * @param routes , an instance of routeDao
     */
    public StatisticsDetailsPresenter(StatisticsDetailsView view,RouteDAO routes){
        this.view = view;
        this.routes = routes;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String date = view.getDepartureDate();
        String[] parts = date.split("/");
        SystemCalendar calendar = new SystemCalendar(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));

        presentedRoute = routes.find(view.getDestination(),view.getDepartureTime(),view.getDeparturePoint()
            ,calendar);

        view.setActivityName("Route: " + presentedRoute.getDeparturePoint() +"-"+ presentedRoute.getDestination());

        view.setDestination(presentedRoute.getDestination());
        view.setDeparturePoint(presentedRoute.getDeparturePoint());
        view.setDepartureDate(dateFormat.format(presentedRoute.getDepartureDate().getJavaCalendar().getTime()));
        view.setDepartureTime(presentedRoute.getDepartureTime());
        view.setAvailableSeats(presentedRoute.getAvailableSeats());
        view.setBusType(presentedRoute.getRouteBus().getBusType());
        view.setDriverID(presentedRoute.getDriver().getDriverID());
        view.setEstimatedArrivalTime(presentedRoute.getEstimatedArrivalTime());

        double statistic = ((double)presentedRoute.getAvailableSeats()/presentedRoute.getRouteBus().getBusSeats())*100;

        view.setStatistic(statistic);

    }

    /**
     * This method pops up a toast with a message.
     * @param value , the message that is being displayed in the toast
     */
    public void onShowToast(String value)
    {
        view.showToast(value);
    }

    /**
     * This method prints a warning dialog message before deletion in order to ensure the process that is going to be executed.
     */
    public void onClickDeleteButton(){
        view.ClickDeleteButton("Are you sure you want to delete this route?");
    }

    /**
     * This method deletes a specific route.
     */
    public void onDelete(){
        ScheduleDAO sc = new ScheduleDAOMemory();
        Schedule schedule = sc.findAll().get(0);
        presentedRoute.getRouteBus().available();
        presentedRoute.getDriver().available();

        for(ScheduleEntry entry : schedule.getScheduleEntry()){
            if(entry.getDayOfWeek() == presentedRoute.getDepartureDate().getDayOfMonth() && entry.getDepartureTime().equals(presentedRoute.getDepartureTime())
                    && entry.getCalendar().getMonth() == presentedRoute.getDepartureDate().getMonth()){
                schedule.removeScheduleEntry(entry);
            }
        }
        schedule.deleteRoute(presentedRoute);
        routes.delete(presentedRoute);
        presentedRoute = null;
        view.delete("Route successfully deleted!!");
    }
}
