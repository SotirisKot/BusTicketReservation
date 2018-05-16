package gr.aueb.softeng.project1801.view.Passenger.Track_Route;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Schedule;
import gr.aueb.softeng.project1801.dao.ScheduleDAO;

public class TrackRoutePresenter {

    private TrackRouteView view;
    private ScheduleDAO schedule;

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

    private boolean validateDate(String date){
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

    void onShowToast(String value)
    {
        view.ShowToast(value);
    }

    void onTrackRoute(String destination,String departurePoint,String departureDate,String time){
        if(!validateDate(departureDate)){
            view.showAlertMessage("Invalid Date...Try again!!");
        }else {
            view.trackRoute(destination,departurePoint,departureDate,time);
        }
    }

    public String onGetDestination(){
        return view.getDestination();
    }

    public String onGetDeparture(){
        return view.getDeparturepoint();
    }

    public String onGetDepartureDate(){
        return view.getDepartureDate();
    }

    public String onGetDepartureTime(){
        return view.getDepartureTime();
    }

    public void onShowAlertMessage(String message){
        view.showAlertMessage(message);
    }
}
