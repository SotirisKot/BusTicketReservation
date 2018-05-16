package gr.aueb.softeng.project1801.view.Passenger.TrackResults;

public interface TrackResultsView {

    String getDestination();

    String getDeparturePoint();

    String getDepartureDate();

    String getDepartureTime();

    void showToast(String value);

    void showAlertMessage(String message);

    void kill();
}
