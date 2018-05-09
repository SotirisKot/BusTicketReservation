package gr.aueb.softeng.project1801.view.Passenger.Choose_Seat;

import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.RouteDAO;

public class ChooseSeatPresenter {

    private ChooseSeatView view;
    private RouteDAO selectedRoute;

    public ChooseSeatPresenter(ChooseSeatView view, RouteDAO selectedRoute){

        this.view = view;
        this.selectedRoute = selectedRoute;

        view.setActivityName("You must select: " + view.getSeats() + " seats");

    }

    public void onClickSeat(String destination,String departurePoint,String departureDate,String departureTime,int seat){

        String[] parts = departureDate.split("/");
        SystemCalendar calendar = new SystemCalendar(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));

        Route route = selectedRoute.find(destination,departureTime,departurePoint,calendar);

        int availableSeats = route.getAvailableSeats();

        if(availableSeats > (availableSeats - Integer.parseInt(view.getSeats()))){
            view.setSeat(seat);
            route.setAvailableSeats(availableSeats - 1);
        }else{
            view.showAlertMessage("You cannot select more seats");
        }


    }

    public void onShowAlertMessage(String message){
        view.showAlertMessage(message);
    }

    public void onShowtoast(String message){
        view.showToast(message);
    }
}
