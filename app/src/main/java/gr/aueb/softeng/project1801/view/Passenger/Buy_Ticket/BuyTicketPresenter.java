package gr.aueb.softeng.project1801.view.Passenger.Buy_Ticket;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.DomainModel.Schedule;
import gr.aueb.softeng.project1801.SysUtils.DataRow;
import gr.aueb.softeng.project1801.dao.RouteDAO;
import gr.aueb.softeng.project1801.dao.ScheduleDAO;

public class BuyTicketPresenter {

    private BuyTicketsView view;
    private ScheduleDAO schedule;

    public BuyTicketPresenter(BuyTicketsView view,ScheduleDAO schedule){
        this.view = view;
        this.schedule = schedule;

        Schedule sc = schedule.findAll().get(0);

        List<String> destinations = new ArrayList<>(sc.getDestinations());
        List<String> departurePoints = new ArrayList<>(sc.getDeparturePoints());

        view.setActivityName("Search for a Route!");
        view.setDestinationsList(destinations);
        view.setDeparturePointsList(departurePoints);
    }

    void onShowToast(String value)
    {
        view.ShowToast(value);
    }

    void onSearchRoute(String destination,String departurePoint,String departureDate,String seats){
        view.searchRoute(destination,departurePoint,departureDate,seats);
    }
}
