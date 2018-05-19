package gr.aueb.softeng.project1801.view.Employee.FindPassenger;

public class FindPassengerPresenter {

    private FindPassengerView view;

    /**
     * This method initializes the Presenter in order to be able to find a passenger.
     * @param view , an instance of view
     */
    public FindPassengerPresenter(FindPassengerView view){

        this.view = view;

        view.setActivityName("Find Passenger's ticket");

    }

    /**
     * This method validates letters.
     * @param name , a specific name
     * @return "true" if the letter is valid or else "false"
     */
    private boolean validateOnlyLetters(String name){
        if(name .equals("")){
            return false;
        }else {
            for(int i=0; i< name.length(); i++){
                if(!Character.isLetter(name.charAt(i))){
                    return false;
                }
            }
        }
        return true;

    }

    /**
     * This method pops up a toast with a message.
     * @param message , the message that is being displayed in the toast
     */
    public void onShowToast(String message){
        view.showToast(message);
    }

    /** This method shows alert messages
     * @param message , the alert message we want to print
     */
    public void onShowAlertMessage(String message){
        view.showAlertMessage(message);
    }

    /**
     * This method returns a passenger's FirstName.
     * @return a String object that has the passenger's FirstName
     */
    public String onGetPassengerFirstname(){
        return view.getFirstname();
    }

    /**
     * This method returns a passenger's LastName.
     * @return a String object that has the passenger's LastName
     */
    public String onGetPassengerLastname(){
        return view.getLastname();
    }

    /**
     * This method returns a passenger's ID.
     * @return a String object that has the passenger's ID
     */
    public String onGetPassengerID(){
        return view.getPassengerID();
    }


    /**
     * This methods helps us to find a specific passenger.
     * @param firstname , the fistName of the passenger
     * @param lastname , the lastName of the passenger
     * @param id , the passegner's ID number
     */
    public void onFindPassenger(String firstname,String lastname,String id){

        if(!validateOnlyLetters(firstname)){
            view.showAlertMessage("Names must be only letters");
            return;
        }
        if(!validateOnlyLetters(lastname)){
            view.showAlertMessage("Names must be only letters");
            return;
        }

        view.findPassenger(firstname,lastname,id);
    }
}
