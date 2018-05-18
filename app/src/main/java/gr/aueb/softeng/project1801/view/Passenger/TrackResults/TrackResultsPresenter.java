package gr.aueb.softeng.project1801.view.Passenger.TrackResults;


import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.RouteDAO;

public class TrackResultsPresenter {

    private TrackResultsView view;
    private RouteDAO routeDAO;

    /**
     * This method initializes the Presenter in order to be able a user to choose a seat.
     * @param view, an instance of view
     * @param routeDAO, an instance of RouteDAO
     */
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

    /**
     * This method pops up a toast with a message.
     * @param value, the message that is being displayed in the toast
     */
    void onShowToast(String value)
    {
        view.showToast(value);
    }

    /**
     * This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    public String onGetDestination(){
        return view.getDestination();
    }

    /**
     * This method returns a departure place.
     * @return a String object that has the departure place
     */
    public String onGetDeparture(){
        return view.getDeparturePoint();
    }

    /**
     * This method returns a departure date.
     * @return a String object that has the departure date
     */
    public String onGetDepartureDate(){
        return view.getDepartureDate();
    }

    /**
     * This method returns a departure time.
     * @return a String object that has the departure time
     */
    public String onGetDepartureTime(){ return view.getDepartureTime(); }

    /**
     * This method shows alert messages
     * @param message, the alert message we want to print
     */
    public void onShowAlert(String message){
        view.showAlertMessage(message);
    }
}
