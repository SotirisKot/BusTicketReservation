package gr.aueb.softeng.project1801.view.Passenger.TicketOverview;

import java.util.ArrayList;
import java.util.List;
import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.SysUtils.SeatRow;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.RouteDAO;
import gr.aueb.softeng.project1801.memorydao.RouteDAOMemory;

public class TicketOverviewPresenter {

    private TicketOverviewView view;
    private int passengerNum;
    private String passengerID,price,typeTicket;
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
        passengerID = initials1+initials2+String.valueOf(passengerNum);
        passengerNum++;
        view.setPassengerId(passengerID);

        seats = view.getSeats();
        view.setSeats(seats);

        List<String> types = new ArrayList<>();
        types.add("Student 50% off : 7.5€");
        types.add("Full ticket : 14€");

        view.setTypes(types);
    }

    private boolean validateOnlyLetters(String name){
        if(name .equals("")){
            return false;
        }else {
            for(int i=0; i< name.length(); i++){
                if(!Character.isLetter(name.charAt(i))){
                    return false;
                }
            }
        }
        return true;

    }


    public void onSetPrice(String type){
        if(type.equals("Student 50% off : 7.5€")){
            view.setPrice("7.5");
            price = "7.5";
            typeTicket = "Student 50% off : 7.5€";
        }else{
            view.setPrice("14");
            price = "14";
            typeTicket = "Full ticket : 14€";
        }
    }


    public void onClickContinue(String firstname,String lastname){
        if(validateOnlyLetters(firstname) && validateOnlyLetters(lastname)){

            view.clickContinue(view.getDestination(),view.getDeparturePoint(),view.getDepartureDate()
            ,view.getDepartureTime(),view.getPassengerFirstname(),view.getPassengerLastname(),passengerID,price,view.getSeat(),typeTicket);

        }else{

            view.showAlertMessage("Invalid firstname or lastname.Must not be empty and only letters.");

        }
    }

    public String OngetPassengerFirstname(){
        return view.getPassengerFirstname();
    }

    public String OngetPassengerLastname(){
        return view.getPassengerLastname();
    }
}
