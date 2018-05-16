package gr.aueb.softeng.project1801.view.Passenger.TrackResults;


import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.RouteDAO;

public class TrackResultsPresenter {

    private TrackResultsView view;
    private RouteDAO routeDAO;

    public TrackResultsPresenter(TrackResultsView view,RouteDAO routeDAO){

        this.view = view;
        this.routeDAO = routeDAO;

        String destination = view.getDestination();
        String departurePoint = view.getDeparturePoint();
        String departureDate = view.getDepartureDate();
        String departureTime = view.getDepartureTime();

        String[] parts = departureDate.split("/");
        SystemCalendar calendar = new SystemCalendar(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));

        Route route = routeDAO.find(destination,departureTime,departurePoint,calendar);

        if(route == null){
            view.kill();
        }
    }

    void onShowToast(String value)
    {
        view.showToast(value);
    }

    public String onGetDestination(){
        return view.getDestination();
    }

    public String onGetDeparture(){
        return view.getDeparturePoint();
    }

    public String onGetDepartureDate(){
        return view.getDepartureDate();
    }

    public String onGetDepartureTime(){ return view.getDepartureTime(); }

    public void onShowAlert(String message){
        view.showAlertMessage(message);
    }
}
