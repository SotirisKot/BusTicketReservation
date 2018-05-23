package gr.aueb.softeng.project1801.viewTests.OwnerTests.StatisticsDetailsTests;

import gr.aueb.softeng.project1801.view.Owner.StatisticsDetails.StatisticsDetailsView;

public class StatisticsDetailsViewStub implements StatisticsDetailsView {

    private String destination, departurePoint, departureDate, departureTime, estimatedArrivalTime, busType, driverID, message, value, warning,activity_name;
    private double statistics;
    private int availableSeats;

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
    public StatisticsDetailsViewStub(){
        activity_name = destination = departurePoint = departureDate = departureTime = estimatedArrivalTime = busType = driverID = message = value = warning = "";
        statistics = 0.0;
        availableSeats = 30;
    }

    /**
     * This method sets a destination to a route.
     * @param destination , the destination of the route
     */
    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * This method sets a departure point to a route.
     * @param departurePoint , the departure point of the route
     */
    @Override
    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    /**
     * This method sets a departure time to a route.
     * @param departureTime , the departure time of the route
     */
    @Override
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * This method sets a departure date to a route.
     * @param departureDate , the departure date of the route
     */
    @Override
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * This method sets an estimated arrival time to a route.
     * @param estimatedArrivalTime , the estimated arival time of the route
     */
    @Override
    public void setEstimatedArrivalTime(String estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    /**
     * This method sets the bus type that is going to be used in a route.
     * @param busType , the bus type being used in the route
     */
    @Override
    public void setBusType(String busType) {
        this.busType = busType;
    }

    /**
     * This method sets the driver's ID.
     * @param driver , the driver's ID
     */
    @Override
    public void setDriverID(String driver) {
        this.driverID = driver;
    }

    /**
     * This method sets the number of available seats of a bus.
     * @param availableSeats , the number of available seats of a bus
     */
    @Override
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    /**
     * This method sets the statistics of a route.
     * @param statistic , the statistics of a route
     */
    @Override
    public void setStatistic(double statistic) {
        this.statistics = statistic;
    }

    /**
     *  This method pops up a toast.
     * @param value , the message we want to print in the toast
     */
    @Override
    public void showToast(String value) {
        this.value = value;
    }

    /**
     * This method sets name to a specific Activity.
     * @param value , the name_value we want to set in a specific Activity
     */
    @Override
    public void setActivityName(String value) {
        this.activity_name = value;
    }

    /**
     * This method prints a warning message before deletion.
     * @param warning , the warning message for deletion
     */
    @Override
    public void ClickDeleteButton(String warning) {
        this.warning = warning;
    }

    /**
     * This method prints a deletion message.
     * @param message , the deletion message
     */
    @Override
    public void delete(String message) {
        this.message = message;
    }

    /**
     * This method returns a toast message.
     */
    public String getToast(){
        return value;
    }

    /**
     * This method returns a deletion message.
     */
    public String getDeleteMessage()
    {
        return message;
    }

    /**
     * This method returns the activity name.
     */
    public String getActivity_name(){ return activity_name; }
}
