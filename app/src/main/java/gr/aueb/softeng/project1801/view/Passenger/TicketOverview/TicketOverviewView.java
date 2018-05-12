package gr.aueb.softeng.project1801.view.Passenger.TicketOverview;
import java.util.List;
import gr.aueb.softeng.project1801.SysUtils.SeatRow;

public interface TicketOverviewView {

    void setActivityName(String title);

    String getDestination();

    String getDeparturePoint();

    String getDepartureDate();

    List<SeatRow> getSeats();

    String getDepartureTime();

    String getType();

    void setDestination(String destination);

    void setDeparturePoint(String departurePoint);

    void setDepartureDate(String departureDate);

    void setSeats(List<SeatRow> seats);

    void setDepartureTime(String time);

    void setPassengerId(String id);

    void setPrice(String price);

    void setTypes(List<String> types);

    String getPassengerFirstname();

    String getPassengerLastname();

    void setEstimatedArrivalTime(String arrivalTime);

    void clickContinue();

    void showToast(String value);

    void showAlertMessage(String message);
}
