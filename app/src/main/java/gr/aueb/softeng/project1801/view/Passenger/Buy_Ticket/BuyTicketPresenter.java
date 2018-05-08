package gr.aueb.softeng.project1801.view.Passenger.Buy_Ticket;

import java.util.ArrayList;
import java.util.List;
import gr.aueb.softeng.project1801.DomainModel.Schedule;
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

    void onShowToast(String value)
    {
        view.ShowToast(value);
    }

    void onSearchRoute(String destination,String departurePoint,String departureDate,String seats){
        if(!validateDate(departureDate)){
            view.showAlertMessage("Invalid Date...Try again!!");
        }else {
            view.searchRoute(destination,departurePoint,departureDate,seats);
        }
    }
}
