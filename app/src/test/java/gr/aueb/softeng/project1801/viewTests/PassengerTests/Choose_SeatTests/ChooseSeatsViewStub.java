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

    /**
     * This method returns a value.
     * @return value , the name_value we want to get
     */
    public String getValue() {
        return value;
    }

    /**
     * This method returns a title.
     * @return title , the title we want to get
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method sets a destination.
     * @param destination , the destination we want to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * This method sets a departure point.
     * @param departurePoint , the departure point we want to set
     */
    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    /**
     * This method sets a departure date.
     * @param departureDate , the departure date we want to set
     */
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * This method sets a departureTime.
     * @param departureTime , the departureTime we want to set
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * This method returns a message.
     * @return  message , the message we want to get
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method sets the seats.
     * @param seats , the seats we want to set
     */
    public void setSeats(String seats) {
        this.seats = seats;
    }

    /**
     * This method sets the data.
     * @param data , the data we want to set
     */
    public void setData(List<SeatRow> data) {
        this.data = data;
    }

    /**
     * This method returns the data.
     * @return data , the data we want to get
     */
    public List<SeatRow> getData(){
        return data;
    }
}
