package gr.aueb.softeng.project1801.view.Passenger.TrackResults;

public interface TrackResultsView {

    /**
     * This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    String getDestination();

    /**
     * This method returns a departure point.
     * @return a String object that has the departure point
     */
    String getDeparturePoint();

    /**
     * This method returns a departure date.
     * @return a String object that has the departure date
     */
    String getDepartureDate();

    /**
     * This method returns a departure time.
     * @return a String object that has the departure time
     */
    String getDepartureTime();

    /**
     * This method pops up a toast.
     * @param value, the message we want to print in the toast
     */
    void showToast(String value);

    /**
     * This method shows alert messages
     * @param message, the alert message we want to print
     */
    void showAlertMessage(String message);

    /**
     * This method terminates the process
     */
    void kill();
}
