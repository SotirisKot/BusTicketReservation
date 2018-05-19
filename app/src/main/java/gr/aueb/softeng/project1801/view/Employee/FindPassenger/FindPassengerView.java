package gr.aueb.softeng.project1801.view.Employee.FindPassenger;

public interface FindPassengerView {

    /**
     * This method returns a passenger's FirstName.
     * @return a String object that has the passenger's FirstName
     */
    String getFirstname();

    /**
     * This method returns a passenger's LastName.
     * @return a String object that has the passenger's LastName
     */
    String getLastname();

    /**
     * This method sets a specific passenger ID.
     */
    String getPassengerID();

    /**
     * This method shows alert messages
     * @param message , the alert message we want to print
     */
    void showAlertMessage(String message);

    /**
     *  This method pops up a toast.
     * @param message , the message we want to print in the toast
     */
    void showToast(String message);

    /**
     * This method sets name to a specific Activity.
     * @param title , the name_value we want to set in a specific Activity
     */
    void setActivityName(String title);

    /**
     * This methods helps us to find a specific passenger.
     * @param firstname , the fistName of the passenger
     * @param lastname , the lastName of the passenger
     * @param id , the passegner's ID number
     */
    void findPassenger(String firstname,String lastname,String id);
}
