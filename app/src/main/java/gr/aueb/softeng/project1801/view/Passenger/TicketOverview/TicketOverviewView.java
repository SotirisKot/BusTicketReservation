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

    void clickContinue(String destination,String departurePoint,String departureDate,
                       String departureTime,String firstname,String lastname,String id,String price,String seats,String type);

    void showToast(String value);

    String getSeat();

    void showAlertMessage(String message);
}
