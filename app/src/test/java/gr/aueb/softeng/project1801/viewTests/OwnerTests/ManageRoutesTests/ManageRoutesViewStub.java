package gr.aueb.softeng.project1801.viewTests.OwnerTests.ManageRoutesTests;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.view.Owner.ManageRoutes.ManageRoutesView;


public class ManageRoutesViewStub implements ManageRoutesView{

    private String departureDate, estimatedArrivalTime, destination, departurePoint, departureTime, busID, driverID, title, message;
    private List<String> destinationsList, departuresList, bus_idsList, driver_idsList, departureTimeList;
    private boolean addedNew;

    /**
     * This method returns a departure date.
     * @return a String object that has the departure date
     */
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * This method returns an estimated arrival time of the bus.
     * @return a String object that has the estimated arrival time of the bus.
     */
    public String getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    /**
     * This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    public String getDestination() {
        return destination;
    }

    /**
     * This method returns a departure point.
     * @return a String object that has the departure point
     */
    public String getDeparturepoint() {
        return departurePoint;
    }

    /**
     * This method returns a departure time.
     * @return a String object that has the departure time
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * This method returns a BusID.
     * @return a String object that has the BusID number
     */
    public String getBusID() {
        return busID;
    }

    /**
     * This method returns a DriverID.
     * @return a String object that has the DriverID number
     */
    public String getDriverID() {
        return driverID;
    }

    /**
     * Constructor
     */
    public ManageRoutesViewStub() {
        departureDate = estimatedArrivalTime = destination = departurePoint = departureTime = busID = driverID = title = message = "";
        destinationsList = new ArrayList<>();
        departuresList =  new ArrayList<>();
        bus_idsList = new ArrayList<>();
        driver_idsList = new ArrayList<>();
        departureTimeList = new ArrayList<>();
        addedNew = false;
    }

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
     * @param title , the name_value we want to set in a specific Activity
     */
    public void setActivityName(String title) {
        this.title = title;
    }

    /**
     * This method sets a list of destinations.
     * @param destinations , a set of destinations we want to have
     */
    @Override
    public void setDestinationsList(List<String> destinations) {
        destinationsList = destinations;

    }

    /**
     * This method sets a list of departures.
     * @param departures , a set of departures we want to have
     */
    @Override
    public void setDeparturePointsList(List<String> departures) {
        departuresList = departures;
    }

    /**
     * This method sets a list of BusIDs.
     * @param bus_ids , a set of BusIDs we want to have
     */
    @Override
    public void setBusIDsList(List<String> bus_ids) {
        bus_idsList = bus_ids;
    }

    /**
     * This method sets a list of DriverIDs.
     * @param driver_ids , a set of DriverIDs we want to have
     */
    @Override
    public void setDriverIDsList(List<String> driver_ids) {
        driver_idsList = driver_ids;
    }

    /**
     * This method sets a list of times we want to departure our buses.
     * @param times , a set of times that the buses can start their routs
     */
    @Override
    public void setDepartureTimesList(List<String> times) {
        departureTimeList = times;
    }

    /**
     * This method sets a departure date.
     * @param date , the date we want the route to be added
     */
    public void setDepartureDate(String date) { departureDate = date; }


    /**
     * This method shows alert messages
     * @param message , the alert message we want to print
     */
    public void showAlertMessage(String message) {
        this.message = message;
    }


    /**
     * This method shows success messages.
     * @param message , the success message we want to print
     */
    public void showSuccessMessage(String message) {
        this.addedNew = true;
        this.message = message;
    }

    /**
     * This method sets a success message.
     */
    public String getshowSuccessMessage() {return this.message; }

    /**
     * This returns the boolean is addedNew.
     *  @return a boolean that represents if the route was added.
     * */
    public boolean isNewAdded(){
        return addedNew;
    }

    /**
     * This method sets a destination.
     * @param destination , the destination of the route
     */
    public void setDestination(String destination){
        this.destination = destination;
    }

    /**
     * This method sets a departure point.
     * @param departurePoint , the departure point of the route
     */
    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    /**
     * This method sets a driver id.
     * @param driverID , the driver id of the route
     */
    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    /**
     * This method sets a departure time.
     * @param departureTime , the departure time of the route
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * This method sets an arrival time.
     * @param arrivalTime , the arrival time of the route
     */
    public void setEstimatedArrivalTime(String arrivalTime){
        this.estimatedArrivalTime = arrivalTime;
    }

    /**
     * This method sets a bus id.
     * @param busID , the bus id of the route
     */
    public void setBusID(String busID) {
        this.busID = busID;
    }

    /**
     * This method returns the alert message.
     * @return  message..an alert message
     */
    public String getAlertMessage(){
        return message;
    }
}