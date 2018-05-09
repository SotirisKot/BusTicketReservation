package gr.aueb.softeng.project1801.view.Owner.ManageRoutes;

import java.util.List;

public interface ManageRoutesView {

    /**
     *  This method pops up a toast.
     * @param message, the message we want to print in the toast
     */
    void ShowToast(String message);

    /** This method sets name to a specific Activity.
     * @param value, the name_value we want to set in a specific Activity
     */
    void setActivityName(String value);

    /** This method sets a list of destinations.
     * @param destinations, a set of destinations we want to have
     */
    void setDestinationsList(List<String> destinations);

    /** This method sets a list of departures.
     * @param departures, a set of departures we want to have
     */
    void setDeparturePointsList(List<String> departures);

    /** This method sets a list of BusIDs.
     * @param bus_ids, a set of BusIDs we want to have
     */
    void setBusIDsList(List<String> bus_ids);

    /** This method sets a list of DriverIDs.
     * @param driver_ids, a set of DriverIDs we want to have
     */
    void setDriverIDsList(List<String> driver_ids);

    /** This method sets a list of times we want to departure our buses.
     * @param times, a set of times that the buses can start their routs
     */
    void setDepartureTimesList(List<String> times);

    /** This method shows alert messages
     * @param message, the alert message we want to print
     */
    void showAlertMessage(String message);

    /** This method shows success messages.
     * @param message, the success message we want to print
     * */
    void showSuccessMessage(String message);

    /** This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    String getDestination();

    /** This method returns a departure point.
     * @return a String object that has the departure point
     */
    String getDeparturepoint();

    /** This method returns a departure time.
     * @return a String object that has the departure time
     */
    String getDepartureTime();

    /** This method returns a departure date.
     * @return a String object that has the departure date
     */
    String getDepartureDate();

    /** This method returns an estimated arrival time of the bus.
     * @return a String object that has the estimated arrival time of the bus.
     */
    String getEstimatedArrivalTime();

    /** This method returns a BusID.
     * @return a String object that has the BusID number
     */
    String getBusID();

    /** This method returns a DriverID.
     * @return a String object that has the DriverID number
     */
    String getDriverID();

}
