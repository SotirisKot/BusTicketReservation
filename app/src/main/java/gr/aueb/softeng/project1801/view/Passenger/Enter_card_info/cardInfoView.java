package gr.aueb.softeng.project1801.view.Passenger.Enter_card_info;

public interface cardInfoView {

    String getDestination();

    String getDeparturePoint();

    String getDepartureDate();

    String getDepartureTime();

    String getFirstname();

    String getLastname();

    String getPassengerID();

    String getCardHolderName();

    String getCardId();

    String getCVcode();

    String getExpirationDate();

    String getPrice();

    String getSeats();

    String getType();

    void showAlertMessage(String message);

    void showToast(String message);

    void setActivityName(String title);

    void clickCheckout(String message);


}
