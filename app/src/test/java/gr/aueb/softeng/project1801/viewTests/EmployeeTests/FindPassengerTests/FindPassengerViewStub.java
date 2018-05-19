package gr.aueb.softeng.project1801.viewTests.EmployeeTests.FindPassengerTests;

import gr.aueb.softeng.project1801.view.Employee.FindPassenger.FindPassengerView;

public class FindPassengerViewStub implements FindPassengerView {

    private String message, title, passengerID, firstName, lastName,value;

    /**
     * This method returns a passenger's FirstName.
     * @return a String object that has the passenger's FirstName
     */
    @Override
    public String getFirstname() {
        return firstName;
    }

    /**
     * This method returns a passenger's LastName.
     * @return a String object that has the passenger's LastName
     */
    @Override
    public String getLastname() {
        return lastName;
    }

    /**
     * This method return a passenger's ID.
     * @return a String object that has the passenger's ID
     */
    @Override
    public String getPassengerID() {
        return passengerID;
    }

    /** This method returns the message.
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /** This method returns the title.
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method shows alert messages
     * @param message , the alert message we want to print
     */
    @Override
    public void showAlertMessage(String message) {
        this.message = message;
    }

    /**
     * This method pops up a toast.
     * @param value , the message we want to print in the toast
     */
    @Override
    public void showToast(String value) {
        this.value = value;
    }

    /**
     * Constructor
     */
    public FindPassengerViewStub() {
        message = title = passengerID = firstName = lastName = value = "";
    }

    /**
     * This method sets name to a specific Activity.
     * @param title , the name_value we want to set in a specific Activity
     */
    @Override
    public void setActivityName(String title) {
        this.title = title;
    }

    /**
     * This methods helps us to find a specific passenger.
     * @param firstname , the fistName of the passenger
     * @param lastname  , the lastName of the passenger
     * @param id        , the passegner's ID number
     */
    @Override
    public void findPassenger(String firstname, String lastname, String id) {
        firstName = firstname;
        lastName = lastname;
        passengerID = id;
    }

    /**
     * This method sets a message
     * @param message , the message we want to print
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * This method sets a title
     * @param title , the title we want to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method sets a specific passenger ID.
     * @param passengerID , a String object that contains the passenger ID
     */
    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    /**
     * This methods helps us to set the fistName of a passenger.
     * @param firstName , the firstName of the passenger
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This methods helps us to set the lastName of a passenger.
     * @param lastName , the lastName of the passenger
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getValue() {
        return value;
    }
}
