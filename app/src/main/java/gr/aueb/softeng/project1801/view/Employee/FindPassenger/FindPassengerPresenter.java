package gr.aueb.softeng.project1801.view.Employee.FindPassenger;

public class FindPassengerPresenter {

    private FindPassengerView view;


    public FindPassengerPresenter(FindPassengerView view){

        this.view = view;

        view.setActivityName("Find Passenger's ticket");

    }

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

    public void onShowToast(String message){
        view.showToast(message);
    }

    public void onShowAlertMessage(String message){
        view.showAlertMessage(message);
    }

    public String onGetPassengerFirstname(){
        return view.getFirstname();
    }

    public String onGetPassengerLastname(){
        return view.getLastname();
    }

    public String onGetPassengerID(){
        return view.getPassengerID();
    }


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
