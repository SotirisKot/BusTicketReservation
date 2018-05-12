package gr.aueb.softeng.project1801.view.Passenger.Choose_Seat;
import java.util.ArrayList;
import java.util.List;
import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.SysUtils.SeatRow;

public class ChooseSeatPresenter {

    private ChooseSeatView view;
    private Route selectedRoute;
    private int temp;
    private List<SeatRow> seatsSelected = new ArrayList<>();

    public ChooseSeatPresenter(ChooseSeatView view, Route selectedRoute){

        this.view = view;
        this.selectedRoute = selectedRoute;
        this.temp = selectedRoute.getAvailableSeats();

        view.setActivityName("You must select: " + view.getSeats() + " seats");
        onloadData();
    }

    public void onClickSeat(Route route,SeatRow seat){

        int availableSeats = route.getAvailableSeats();

        if(seat.isChecked()){
            seat.uncheck();
            seatsSelected.remove(seat);
            route.setAvailableSeats(availableSeats + 1);
        }else{
            if(availableSeats > (temp - Integer.parseInt(view.getSeats()))){
                seat.check();
                seatsSelected.add(seat);
                route.setAvailableSeats(availableSeats - 1);
            }else{
                view.showAlertMessage("You cannot select more seats.Proceed to checkout?");
            }

        }
    }

    private List<SeatRow> createData(){
        List<SeatRow> data = new ArrayList<>();

        for(int i=0; i<selectedRoute.getRouteBus().getBusSeats(); i++){
            data.add(new SeatRow(String.valueOf(i),i));
        }
        return data;
    }

    public void onloadData(){
        view.loadData(createData());
    }

    public void onShowAlertMessage(String message){
        view.showAlertMessage(message);
    }

    public void onShowtoast(String message){
        view.showToast(message);
    }

    public void onClickProceed(){
        view.clickProceed(view.getDestination(),view.getDeparturePoint(),view.getDepartureDate(),view.getDepartureTime());
    }

    public List<SeatRow> getSeatsSelected(){
        return seatsSelected;
    }

}
