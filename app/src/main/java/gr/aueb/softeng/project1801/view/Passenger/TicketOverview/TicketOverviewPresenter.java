package gr.aueb.softeng.project1801.view.Passenger.TicketOverview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.SysUtils.SeatRow;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.RouteDAO;
import gr.aueb.softeng.project1801.memorydao.RouteDAOMemory;

public class TicketOverviewPresenter {

    private TicketOverviewView view;
    private int passengerNum1,passengerNum2,passengerNum;
    private String passengerID,price,typeTicket;
    private List<SeatRow> seats;
    private Random random;

    /**
     * This method initializes the Presenter in order to be able to show the ticket overview.
     * @param view , an instance of view
     */
    public TicketOverviewPresenter(TicketOverviewView view){
        this.view = view;

        random = new Random();
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
        passengerNum1 = random.nextInt();
        passengerNum2 = random.nextInt();
        passengerNum = passengerNum1 + passengerNum2;
        passengerID = initials1+initials2+String.valueOf(passengerNum);
        System.out.println(passengerID);
        view.setPassengerId(passengerID);

        seats = view.getSeats();
        view.setSeats(seats);

        List<String> types = new ArrayList<>();
        types.add("Student 50% off : 7.5€");
        types.add("Full ticket : 14€");

        view.setTypes(types);
    }

    /**
     * This method validates letters.
     * @param name , a specific name
     * @return "true" if the letter is valid or else "false"
     */
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

    /**
     * This method sets a specific price on a ticket.
     * @param type , a String object that contains the price of the ticket
     */
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

    /**
     *
     * This method method redirects the user to another activity after a click event if the user's data are correct.
     * @param firstname , the first name of the passenger
     * @param lastname , the last name of the passenger
     */
    public void onClickContinue(String firstname,String lastname){
        if(validateOnlyLetters(firstname) && validateOnlyLetters(lastname)){

            view.clickContinue(view.getDestination(),view.getDeparturePoint(),view.getDepartureDate()
            ,view.getDepartureTime(),view.getPassengerFirstname(),view.getPassengerLastname(),passengerID,price,view.getSeat(),typeTicket);

        }else{

            view.showAlertMessage("Invalid firstname or lastname.Must not be empty and only letters.");

        }
    }

    /**
     * This method returns a passenger's FirstName.
     * @return a String object that has the passenger's FirstName
     */
    public String OngetPassengerFirstname(){
        return view.getPassengerFirstname();
    }

    /**
     * This method returns a passenger's LastName.
     * @return a String object that has the passenger's LastName
     */
    public String OngetPassengerLastname(){
        return view.getPassengerLastname();
    }
}
