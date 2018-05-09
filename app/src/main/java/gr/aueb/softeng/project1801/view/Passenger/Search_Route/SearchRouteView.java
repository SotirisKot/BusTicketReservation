package gr.aueb.softeng.project1801.view.Passenger.Search_Route;

import java.util.List;

import gr.aueb.softeng.project1801.SysUtils.DataRow;

public interface SearchRouteView {

    void clickItem(String destination,String departurePoint,String departureDate,String departureTime,String seats);

    void loadData(List<DataRow> data);

    void showToast(String value);

    void showAlertMessage(String message,String destination,String departurePoint,String departureDate,String departureTime,String seats);

    String getDestination();

    String getDeparturePoint();

    String getDepartureDate();

    String getSeats();

    void setActivityName(String value);
}
