package gr.aueb.softeng.project1801.view.Employee.PrintTicketOverView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.DomainModel.Schedule;
import gr.aueb.softeng.project1801.DomainModel.Ticket;
import gr.aueb.softeng.project1801.dao.ScheduleDAO;

public class PrintTicketPresenter {

    private PrintTicketView view;
    private ScheduleDAO scheduleDAO;

    public PrintTicketPresenter(PrintTicketView view,ScheduleDAO scheduleDAO){
        this.view = view;
        this.scheduleDAO = scheduleDAO;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        view.setActivityName("Passenger's Ticket");

        Ticket ticket = findTicketForPassenger();
        if(ticket == null){
            view.showAlertMessage("Can not find Ticket");
            view.kill();
        }else{
            view.setDeparturePoint(ticket.getDeparturePointTicket());
            view.setDepartureTime(ticket.getDepartureTimeTicket());
            view.setDestination(ticket.getDestinationTicket());
            view.setEstimatedArrivalTime(ticket.getEstimatedArrivalTimeTicket());
            view.setPassengerFirstname(view.getPassengerFirstname());
            view.setPassengerLastname(view.getPassengerLastname());
            view.setPassengerID(ticket.getPassengerID());
            view.setSeat(ticket.getPassengerSeat());
            view.setType(ticket.getType());
            view.setDepartureDate(dateFormat.format(ticket.getDepartureDateTicket().getJavaCalendar().getTime()));
            view.setPrice(String.valueOf(ticket.getPrice()));
        }

    }


    private Ticket findTicketForPassenger(){
        Ticket presentedTicket = new Ticket();
        Schedule sc = scheduleDAO.findAll().get(0);
        boolean found = true;
        for(Route route : sc.getRoutes()){
            presentedTicket = route.findTicket(view.getPassengerFirstname(),view.getPassengerLastname(),view.getPassengerID());
            if(presentedTicket == null){
                found = false;
            }else{
                found = true;
                break;
            }
        }
        if(found){
            return presentedTicket;
        }else{
            return null;
        }
    }

    public void onShowToast(String message){
        view.showToast(message);
    }

    public void onShowAlertMessage(String message){
        view.showAlertMessage(message);
    }
}
