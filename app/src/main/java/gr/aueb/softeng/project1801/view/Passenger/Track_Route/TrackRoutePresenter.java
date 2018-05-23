package gr.aueb.softeng.project1801.view.Passenger.Track_Route;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Schedule;
import gr.aueb.softeng.project1801.dao.ScheduleDAO;

public class TrackRoutePresenter {

    private TrackRouteView view;
    private ScheduleDAO schedule;

    /**
     * This method initializes the Presenter in order to be able a user to track a route.
     * @param view , an instance of view
     * @param schedule , an instance of ScheduleDAO
     */
    public TrackRoutePresenter(TrackRouteView view , ScheduleDAO schedule){
        this.view = view;
        this.schedule = schedule;

        Schedule sc = schedule.findAll().get(0);

        List<String> destinations = new ArrayList<>(sc.getDestinations());
        List<String> departurePoints = new ArrayList<>(sc.getDeparturePoints());
        List<String> departureTimes = new ArrayList<>(sc.getDepartureTimes());

        view.setActivityName("Track Route");
        view.setDestinationsList(destinations);
        view.setDeparturePointsList(departurePoints);
        view.setDepartureTimesList(departureTimes);
    }

    /**
     * This method validates a day.
     * @param date , a specific date
     * @return "true" if the date is valid or else "false"
     */
    public boolean validateDate(String date){
        String[] parts = date.replaceAll("\\s+"," ").split("/");
        try {
            if(Integer.parseInt(parts[0]) >= 2018 && Integer.parseInt(parts[1]) > 0 && Integer.parseInt(parts[1]) <=12
                    && Integer.parseInt(parts[2]) > 0 && Integer.parseInt(parts[2]) <= 31){
                return true;
            }
            return false;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * This method pops up a toast with a message.
     * @param value , the message that is being displayed in the toast
     */
    public void onShowToast(String value)
    {
        view.ShowToast(value);
    }

    /**
     *
     * This method method redirects the user to another activity after a click event.
     * @param destination , the destination of the route
     * @param departurePoint , the departure point of the route
     * @param departureDate , the departure date of the route
     * @param time , the time of the route
     */
    public void onTrackRoute(String destination,String departurePoint,String departureDate,String time){
        if(!validateDate(departureDate)){
            view.showAlertMessage("Invalid Date...Try again!!");
        }else {
            view.trackRoute(destination,departurePoint,departureDate,time);
        }
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
        return view.getDeparturepoint();
    }

    /**
     *  This method returns a departure date.
     * @return a String object that has the departure date
     */
    public String onGetDepartureDate(){
        return view.getDepartureDate();
    }

    /**
     *  This method returns a departure time.
     * @return a String object that has the departure time
     */
    public String onGetDepartureTime(){
        return view.getDepartureTime();
    }

    /** This method shows alert messages
     * @param message , the alert message we want to print
     */
    public void onShowAlertMessage(String message){
        view.showAlertMessage(message);
    }
}
