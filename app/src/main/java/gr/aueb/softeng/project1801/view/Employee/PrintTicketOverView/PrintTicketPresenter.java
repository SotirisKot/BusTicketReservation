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

    /**
     * This method initializes the Presenter in order to be able a user to choose a seat.
     * @param view , an instance of view
     * @param scheduleDAO , an instance of ScheduleDAO
     */
    public PrintTicketPresenter(PrintTicketView view,ScheduleDAO scheduleDAO){
        this.view = view;
        this.scheduleDAO = scheduleDAO;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        view.setActivityName("Passenger's Ticket");

        Ticket ticket = findTicketForPassenger();
        if(ticket == null){
            System.out.println("geiaa");
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

    /**
     * This method helps is to find a ticket for any passenger.
     * @return a Ticket object if there is any available(ticket) or else null
     */
    public Ticket findTicketForPassenger(){
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

    /**
     * This method pops up a toast with a message.
     * @param message , the message that is being displayed in the toast
     */
    public void onShowToast(String message){
        view.showToast(message);
    }

    /** This method shows alert messages
     * @param message , the alert message we want to print
     */
    public void onShowAlertMessage(String message){
        view.showAlertMessage(message);
    }

    /**
     * This method helps us to print a passenger's ticket.
     *
     * @param message , the message we want to print
     *
     */
    public void onPrintTicket(String message){
        view.printTicket(message);
    }
}
