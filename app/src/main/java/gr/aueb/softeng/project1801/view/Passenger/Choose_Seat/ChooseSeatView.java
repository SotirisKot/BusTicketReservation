package gr.aueb.softeng.project1801.view.Passenger.Choose_Seat;

public interface ChooseSeatView {

    void setActivityName(String title);

    void setSeat(int seat);

    int getSelectedSeat();

    String getDestination();

    String getDeparturePoint();

    String getDepartureDate();

    String getSeats();

    void showToast(String value);

    void showAlertMessage(String message);
}
