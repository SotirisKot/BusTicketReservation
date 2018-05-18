package gr.aueb.softeng.project1801.viewTests.PassengerTests.Buy_TicketTests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.view.Passenger.Buy_Ticket.BuyTicketsView;

public class BuyTicketsViewStub implements BuyTicketsView {

    private String message, destination,departurePoint, departureDate, numberOfSeats, value, seats;
    private List<String> destinationsList, departurePointList, numberOfSeatsList;

    /**
     * This method pops up a toast.
     * @param message , the message we want to print in the toast
     */
    @Override
    public void ShowToast(String message) {
        this.message = message;
    }

    /**
     * This method sets name to a specific Activity.
     * @param value , the name_value we want to set in a specific Activity
     */
    @Override
    public void setActivityName(String value) {
        this.value = value;
    }

    /**
     * This method sets a list of destinations.
     * @param destinations , a set of destinations we want to have
     */
    @Override
    public void setDestinationsList(List<String> destinations) {
        this.destinationsList = destinations;

    }

    /**
     * This method sets a list of departures.
     * @param departures , a set of departures we want to have
     */
    @Override
    public void setDeparturePointsList(List<String> departures) {
        this.departurePointList = departures;
    }

    /**
     * This method sets a list of number of seats.
     * @param num_seats , a set of number of seats
     */
    @Override
    public void setNumberOfSeats(List<String> num_seats) {
        this.numberOfSeatsList = num_seats;

    }

    /**
     * Constructor
     */
    public BuyTicketsViewStub(){
        message = destination = departurePoint = departureDate = numberOfSeats = value = seats = "";
        destinationsList = new ArrayList<>();
        departurePointList = new ArrayList<>();
        numberOfSeatsList = new ArrayList<>();
        destinationsList.add("");
        departurePointList.add("");
        numberOfSeatsList.add("");

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
    public String getDeparturepoint() {
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
    public String getNumberOfSeats() {
        return numberOfSeats;
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
     * This method search a route based on the details given.
     * @param destination ,the destination
     * @param departurePoint ,the departure point
     * @param departureDate , the departure date
     * @param seats , the seat
     */
    @Override
    public void searchRoute(String destination, String departurePoint, String departureDate, String seats) {
        this.destination = destination;
        this.departurePoint = departurePoint;
        this.departureDate = departureDate;
        this.seats = seats;
    }
}
