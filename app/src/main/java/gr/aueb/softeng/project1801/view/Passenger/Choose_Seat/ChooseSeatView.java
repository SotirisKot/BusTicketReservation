package gr.aueb.softeng.project1801.view.Passenger.Choose_Seat;

import java.util.List;

import gr.aueb.softeng.project1801.SysUtils.SeatRow;

public interface ChooseSeatView {

    void setActivityName(String title);

    String getDestination();

    String getDeparturePoint();

    String getDepartureDate();

    String getSeats();

    String getDepartureTime();

    void showToast(String value);

    void showAlertMessage(String message);

    void loadData(List<SeatRow> data);
}
