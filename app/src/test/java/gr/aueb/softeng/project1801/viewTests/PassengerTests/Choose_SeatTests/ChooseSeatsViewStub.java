package gr.aueb.softeng.project1801.viewTests.PassengerTests.Choose_SeatTests;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.SysUtils.SeatRow;
import gr.aueb.softeng.project1801.view.Passenger.Choose_Seat.ChooseSeatView;

public class ChooseSeatsViewStub implements ChooseSeatView {

    private String title, value, message,seats , destination, departurePoint, departureDate, departureTime;
    private List<SeatRow> data;

    /**
     * This method sets name to a specific Activity.
     * @param title , the name_value we want to set in a specific Activity
     */
    @Override
    public void setActivityName(String title) {
        this.title = title;
    }

    /**
     * This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    @Override
    public String getDestination() {
        return destination;
    }

    /**
     * This method returns a departure point.
     * @return a String object that has the departure point
     */
    @Override
    public String getDeparturePoint() {
        return departurePoint;
    }

    /**
     * This method returns a departure date.
     * @return a String object that has the departure date
     */
    @Override
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * This method returns the number of seats.
     * @return a String object that has the number of seats
     */
    @Override
    public String getSeats() {
        return seats;
    }

    /**
     * This method returns a departure time.
     * @return a String object that has the departure time
     */
    @Override
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * Constructor
     */
    public ChooseSeatsViewStub(){
        title = value = message = destination = departurePoint = departureDate = departureTime = "";
        data = new ArrayList<>();
    }

    /**
     * This method pops up a toast.
     * @param value , the message we want to print in the toast
     */
    @Override
    public void showToast(String value) {
        this.value = value;
    }

    /**
     * This method shows alert messages
     * @param message , the alert message we want to print
     */
    @Override
    public void showAlertMessage(String message) {
        this.message = message;
    }

    /**
     * This method loads the data(a List).
     */
    @Override
    public void loadData(List<SeatRow> data) {
        this.data = data;
    }

    /**
     *
     * This method method redirects the user to another activity after a click event.
     * @param destination , the destination of the route
     * @param departurePoint , the departure point of the route
     * @param departureDate , the departure date of the route
     * @param departureTime , the departure time of the route
     */
    @Override
    public void clickProceed(String destination, String departurePoint, String departureDate, String departureTime) {
        this.destination = destination;
        this.departurePoint = departurePoint;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
    }
}
