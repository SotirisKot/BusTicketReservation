package gr.aueb.softeng.project1801.view.Owner.StatisticsDetails;

public interface StatisticsDetailsView {

    /** This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    String getDestination();

    /** This method returns a departure point.
     * @return a String object that has the departure point
     */
    String getDeparturePoint();

    /** This method returns a departure date.
     * @return a String object that has the departure date
     */
    String getDepartureDate();

    /** This method returns a departure time.
     * @return a String object that has the departure time
     */
    String getDepartureTime();

    /**
     * This method sets a destination to a route.
     * @param destination , the destination of the route
     */
    void setDestination(String destination);

    /**
     * This method sets a departure point to a route.
     * @param departurePoint , the departure point of the route
     */
    void setDeparturePoint(String departurePoint);

    /**
     * This method sets a departure time to a route.
     * @param departureTime , the departure time of the route
     */
    void setDepartureTime(String departureTime);

    /**
     * This method sets a departure date to a route.
     * @param departureDate , the departure date of the route
     */
    void setDepartureDate(String departureDate);

    /**
     * This method sets an estimated arrival time to a route.
     * @param estimatedArrivalTime , the estimated arival time of the route
     */
    void setEstimatedArrivalTime(String estimatedArrivalTime);

    /**
     * This method sets the bus type that is going to be used in a route.
     * @param busType , the bus type being used in the route
     */
    void setBusType(String busType);

    /**
     * This method sets the driver's ID.
     * @param driver , the driver's ID
     */
    void setDriverID(String driver);

    /**
     * This method sets the number of available seats of a bus.
     * @param availableSeats , the number of available seats of a bus
     */
    void setAvailableSeats(int availableSeats);

    /**
     * This method sets the statistics of a route.
     * @param statistic , the statistics of a route
     */
    void setStatistic(double statistic);

    /** This method pops up a toast.
     * @param value , the message we want to print in the toast
     */
    void showToast(String value);

    /** This method sets name to a specific Activity.
     * @param value , the name_value we want to set in a specific Activity
     */
    void setActivityName(String value);

    /** This method prints a warning message before deletion.
     * @param warning , the warning message for deletion
     */
    void ClickDeleteButton(String warning);

    /**
     * This method prints a deletion message.
     * @param message , the deletion message
     */
    void delete(String message);
}
