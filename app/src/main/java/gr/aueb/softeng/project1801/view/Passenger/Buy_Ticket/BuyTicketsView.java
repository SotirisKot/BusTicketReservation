package gr.aueb.softeng.project1801.view.Passenger.Buy_Ticket;

import java.util.List;

import gr.aueb.softeng.project1801.SysUtils.DataRow;

public interface BuyTicketsView {

    void ShowToast(String message);

    void setActivityName(String value);

    void setDestinationsList(List<String> destinations);

    void setDeparturePointsList(List<String> departures);

    String getDestination();

    String getDeparturepoint();

    String getDepartureDate();

    String getNumberOfSeats();

    void showAlertMessage(String message);

    void searchRoute(String destination,String departurePoint,String departureDate,String seats);
}
