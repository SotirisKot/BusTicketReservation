package gr.aueb.softeng.project1801.view.Passenger.Buy_Ticket;

import java.util.ArrayList;
import java.util.List;
import gr.aueb.softeng.project1801.DomainModel.Schedule;
import gr.aueb.softeng.project1801.dao.ScheduleDAO;

public class BuyTicketPresenter {

    private BuyTicketsView view;
    private ScheduleDAO schedule;

    /**
     * This method initializes the Presenter in order to be able a user to buy a ticket.
     * @param view, an instance of view
     * @param schedule, an instance of scheduleDAO
     */
    public BuyTicketPresenter(BuyTicketsView view,ScheduleDAO schedule){
        this.view = view;
        this.schedule = schedule;

        Schedule sc = schedule.findAll().get(0);

        List<String> destinations = new ArrayList<>(sc.getDestinations());
        List<String> departurePoints = new ArrayList<>(sc.getDeparturePoints());

        List<String> seats = new ArrayList<>();
        seats.add(String.valueOf(1));
        seats.add(String.valueOf(2));
        seats.add(String.valueOf(3));
        seats.add(String.valueOf(4));

        view.setActivityName("Search for a Route!");
        view.setDestinationsList(destinations);
        view.setDeparturePointsList(departurePoints);
        view.setNumberOfSeats(seats);
    }

    /**
     *  This method validates a day.
     * @param date, a specific date
     * @return "true" if the date is valid or else "false"
     */
    private boolean validateDate(String date){
        String[] parts = date.replaceAll("\\s+"," ").split("/");
        try {
            if(Integer.parseInt(parts[0]) >= 2018 && Integer.parseInt(parts[1]) > 0 && Integer.parseInt(parts[1]) <=12
                    && Integer.parseInt(parts[2]) > 0 && Integer.parseInt(parts[2]) <= 31){
                return true;
            }
            return false;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * This method pops up a toast with a message.
     * @param value, the message that is being displayed in the toast
     */
    void onShowToast(String value)
    {
        view.ShowToast(value);
    }

    /**
     * This method search a route based on the details given.
     * @param destination ,the destination
     * @param departurePoint ,the departure point
     * @param departureDate , the departure date
     * @param seats ,the seat
     */
    void onSearchRoute(String destination,String departurePoint,String departureDate,String seats){
        if(!validateDate(departureDate)){
            view.showAlertMessage("Invalid Date...Try again!!");
        }else {
            view.searchRoute(destination,departurePoint,departureDate,seats);
        }
    }

    /**
     *  This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    public String onGetDestination(){
        return view.getDestination();
    }

    /**
     *  This method returns a departure place.
     * @return a String object that has the departure place
     */
    public String onGetDeparture(){
        return view.getDeparturepoint();
    }

    /**
     *  This method returns a departure date.
     * @return a String object that has the departure date
     */
    public String onGetDepartureDate(){
        return view.getDepartureDate();
    }

    /**
     *  This method returns a number of seats.
     * @return a String object that has the number of sears
     */
    public String onGetSeats(){
        return view.getNumberOfSeats();
    }
}
