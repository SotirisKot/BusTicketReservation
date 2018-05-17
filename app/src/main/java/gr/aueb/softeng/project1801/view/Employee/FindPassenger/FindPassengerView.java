package gr.aueb.softeng.project1801.view.Employee.FindPassenger;

public interface FindPassengerView {

    String getFirstname();

    String getLastname();

    String getPassengerID();

    void showAlertMessage(String message);

    void showToast(String message);

    void setActivityName(String title);

    void findPassenger(String firstname,String lastname,String id);
}
