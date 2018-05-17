package gr.aueb.softeng.project1801.view.Employee.PrintTicketOverView;

public interface PrintTicketView {

    void setDestination(String destination);

    void setDeparturePoint(String departurePoint);

    void setDepartureDate(String departureDate);

    void setSeat(String seats);

    void setDepartureTime(String time);

    void setPrice(String price);

    void setType(String types);

    void setPassengerFirstname(String name);

    void setPassengerLastname(String name);

    void setPassengerID(String id);

    String getPassengerFirstname();

    String getPassengerLastname();

    String getPassengerID();

    void setEstimatedArrivalTime(String arrivalTime);

    void showToast(String value);

    void showAlertMessage(String message);

    void printTicket(String message);

    void setActivityName(String title);

    void kill();
}
