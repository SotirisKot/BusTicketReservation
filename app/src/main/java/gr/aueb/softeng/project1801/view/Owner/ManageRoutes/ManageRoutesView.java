package gr.aueb.softeng.project1801.view.Owner.ManageRoutes;

import java.util.List;

public interface ManageRoutesView {

    void ShowToast(String message);

    void setActivityName(String value);

    void setDestinationsList(List<String> destinations);

    void setDeparturePointsList(List<String> departures);

    void setBusIDsList(List<String> bus_ids);

    void setDriverIDsList(List<String> driver_ids);

    void setDepartureTimesList(List<String> times);

    void showAlertMessage(String message);

    void showSuccessMessage(String message);

    String getDestination();

    String getDeparturepoint();

    String getDepartureTime();

    String getDepartureDate();

    String getEstimatedArrivalTime();

    String getBusID();

    String getDriverID();

}
