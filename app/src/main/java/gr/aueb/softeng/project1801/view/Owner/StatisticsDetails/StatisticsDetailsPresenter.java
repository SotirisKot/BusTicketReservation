package gr.aueb.softeng.project1801.view.Owner.StatisticsDetails;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import gr.aueb.softeng.project1801.Route;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.RouteDAO;

public class StatisticsDetailsPresenter {

    private StatisticsDetailsView view;
    private RouteDAO routes;
    private Route presentedRoute;

    public StatisticsDetailsPresenter(StatisticsDetailsView view,RouteDAO routes){
        this.view = view;
        this.routes = routes;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String date = view.getDepartureDate();
        String[] parts = date.split("/");
        SystemCalendar calendar = new SystemCalendar(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));

        System.out.println(view.getDestination());
        System.out.println(view.getDepartureTime());
        System.out.println(view.getDeparturePoint());


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

    public void onShowToast(String value)
    {
        view.showToast(value);
    }
}
