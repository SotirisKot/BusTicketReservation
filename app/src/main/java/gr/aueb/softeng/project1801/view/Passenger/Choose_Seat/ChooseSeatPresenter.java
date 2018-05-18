package gr.aueb.softeng.project1801.view.Passenger.Choose_Seat;
import java.util.ArrayList;
import java.util.List;
import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.SysUtils.SeatRow;

public class ChooseSeatPresenter {

    private ChooseSeatView view;
    private Route selectedRoute;
    private List<SeatRow> seatsSelected = new ArrayList<>();
    private int temp;

    /**
     * This method initializes the Presenter in order to be able a user to choose a seat.
     * @param view , an instance of view
     * @param selectedRoute , an instance of Route
     */
    public ChooseSeatPresenter(ChooseSeatView view, Route selectedRoute){

        this.view = view;
        this.selectedRoute = selectedRoute;

        view.setActivityName("You must select: " + view.getSeats() + " seats");
        temp = Integer.parseInt(view.getSeats());
        onloadData();
    }

    /**
     * This method helps us to understand if a seat is already taken by another user on not.
     * @param seat , an instance of seatRow
     */
    public void onClickSeat(SeatRow seat){

        if(seat.getText().equals("T")){

            view.showToast("Seat already taken");

        }else if(seat.isChecked()){
            seat.uncheck();
            seatsSelected.remove(seat);
            temp++;
        }else{
            if( temp != 0){
                seat.check();
                seatsSelected.add(seat);
                temp--;
            }else{
                view.showAlertMessage("You cannot select more seats.Proceed to checkout?");
            }
        }
    }

    /**
     * This method returns a list of seats after their creation.
     * @return a list of seats
     */
    private List<SeatRow> createData(){
        List<SeatRow> data = new ArrayList<>();

        for(int i=0; i<selectedRoute.getRouteBus().getBusSeats(); i++){
            if(selectedRoute.getSavedSeats().contains(String.valueOf(i))){
                data.add(new SeatRow("T",i));
            }else{
                data.add(new SeatRow(String.valueOf(i),i));
            }

        }
        return data;
    }

    /**
     * This method helps to load the data(a List).
     */
    public void onloadData(){
        view.loadData(createData());
    }

    /** This method shows alert messages
     * @param message , the alert message we want to print
     */
    public void onShowAlertMessage(String message){
        view.showAlertMessage(message);
    }

    /**
     * This method pops up a toast with a message.
     * @param message , the message that is being displayed in the toast
     */
    public void onShowtoast(String message){
        view.showToast(message);
    }

    /**
     * This method method helps to redirect the user to another activity after a click event.
     */
    public void onClickProceed(){
        view.clickProceed(view.getDestination(),view.getDeparturePoint(),view.getDepartureDate(),view.getDepartureTime());
    }

    /** This method returns a list of seat rows.
     * @return a list of seat rows
     */
    public List<SeatRow> getSeatsSelected(){
        return seatsSelected;
    }

}
