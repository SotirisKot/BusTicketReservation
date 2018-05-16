package gr.aueb.softeng.project1801.view.Passenger.Track_Route;

import java.util.List;

public interface TrackRouteView {

    void ShowToast(String message);

    void setActivityName(String value);

    void setDestinationsList(List<String> destinations);

    void setDeparturePointsList(List<String> departures);

    void setDepartureTimesList(List<String> num_seats);

    String getDestination();

    String getDeparturepoint();

    String getDepartureDate();

    String getDepartureTime();

    void showAlertMessage(String message);

    void trackRoute(String destination,String departurePoint,String departureDate,String departureTime);
}
