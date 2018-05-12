package gr.aueb.softeng.project1801.view.Passenger.TicketOverview;

import java.util.ArrayList;
import java.util.List;
import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.DomainModel.Ticket;
import gr.aueb.softeng.project1801.SysUtils.SeatRow;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.RouteDAO;
import gr.aueb.softeng.project1801.memorydao.RouteDAOMemory;

public class TicketOverviewPresenter {

    private TicketOverviewView view;
    private Ticket presentedTicket;
    private int passengerNum;
    private List<SeatRow> seats;

    public TicketOverviewPresenter(TicketOverviewView view){
        this.view = view;

        RouteDAO routeDAO = new RouteDAOMemory();
        String date = view.getDepartureDate();
        String[] parts = date.split("/");
        SystemCalendar calendar = new SystemCalendar(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));

        Route route = routeDAO.find(view.getDestination(),view.getDepartureTime(),view.getDeparturePoint(),calendar);

        view.setActivityName("Ticket OverView");

        view.setDestination(route.getDestination());
        view.setDeparturePoint(route.getDeparturePoint());
        view.setDepartureTime(route.getDepartureTime());
        view.setEstimatedArrivalTime(route.getEstimatedArrivalTime());
        view.setDepartureDate(view.getDepartureDate());
        String initials1 = String.valueOf(route.getDeparturePoint().charAt(0));
        String initials2 = String.valueOf(route.getDestination().charAt(0));
        String initials = initials1+initials2+String.valueOf(passengerNum);
        passengerNum++;
        view.setPassengerId(initials);

        seats = view.getSeats();
        view.setSeats(seats);

        List<String> types = new ArrayList<>();
        types.add("Student 50% off : 7.5€");
        types.add("Full ticket : 14€");

        view.setTypes(types);
    }

    public void onSetPrice(String type){
        if(type.equals("Student 50% off : 7.5€")){
            view.setPrice("7.5");
        }else{
            view.setPrice("14");
        }
    }
}
