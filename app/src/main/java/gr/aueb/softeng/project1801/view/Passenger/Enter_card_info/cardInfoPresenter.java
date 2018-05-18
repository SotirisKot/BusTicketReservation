package gr.aueb.softeng.project1801.view.Passenger.Enter_card_info;


import gr.aueb.softeng.project1801.DomainModel.Card;
import gr.aueb.softeng.project1801.DomainModel.Passenger;
import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.DomainModel.Ticket;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.CardDAO;
import gr.aueb.softeng.project1801.dao.PassengerDAO;
import gr.aueb.softeng.project1801.dao.RouteDAO;
import gr.aueb.softeng.project1801.memorydao.RouteDAOMemory;

public class cardInfoPresenter {

    private cardInfoView view;
    private Ticket presentedTicket;
    private Passenger presentedPassenger;
    private Card presentedCard;
    private PassengerDAO passengerDAO;
    private CardDAO cardDAO;
    private Route presentedRoute;

    /**
     * This method initializes the Presenter in order to be able a user to give card details.
     * @param view, an instance of view
     * @param passengerDAO, an instance of PassengerDAO
     * @param cardDAO, an instance of CardDAO
     */
    public cardInfoPresenter(cardInfoView view,PassengerDAO passengerDAO,CardDAO cardDAO){

        this.view = view;
        this.passengerDAO = passengerDAO;
        this.cardDAO = cardDAO;

        RouteDAO routeDAO = new RouteDAOMemory();
        String date = view.getDepartureDate();
        String[] parts = date.split("/");
        SystemCalendar calendar = new SystemCalendar(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));

        presentedRoute = routeDAO.find(view.getDestination(),view.getDepartureTime(),view.getDeparturePoint(),calendar);

        view.setActivityName("Enter card credentials");

        presentedPassenger = new Passenger();
        presentedPassenger.setFirstName(view.getFirstname());
        presentedPassenger.setLastName(view.getLastname());
        presentedPassenger.setNumberID(view.getPassengerID());

        presentedTicket = new Ticket(presentedRoute.getDestination(),presentedRoute.getDeparturePoint(),presentedRoute.getDepartureTime(),
                presentedRoute.getDepartureDate(),presentedRoute.getEstimatedArrivalTime(),Double.parseDouble(view.getPrice()),presentedPassenger,view.getSeats(),view.getType(),presentedRoute);

        presentedCard = new Card();
    }


    /**
     *  This method validates letters.
     * @param name, a specific name
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
     * This method validates a day.
     * @param date, a specific date
     * @return "true" if the date is valid or else "false"
     */
    private boolean validateDate(String date){
        String[] parts = date.replaceAll("\\s+"," ").split("/");
        try {
            if(Integer.parseInt(parts[0]) >= 2018 && Integer.parseInt(parts[1]) > 0 && Integer.parseInt(parts[1]) <=12
                    && Integer.parseInt(parts[2]) > 0 && Integer.parseInt(parts[2]) <= 31){
                return true;
            }
            return false;
        } catch (Exception e){
            return false;
        }
    }

    /**
     *  This method validates digits.
     * @param code, a specific code
     * @return "true" if the code is valid or else "false"
     */
    private boolean validateOnlyDigits(String code){
        for(int i = 0; i < code.length(); i++)
            if(!Character.isDigit(code.charAt(i)))
                return false;
        return true;
    }

    /**
     * This method method helps to redirect the user to another activity after a click event.
     * @param name, a specific card holder name of the card
     * @param code, a specific code of the card
     * @param cv, a specific cv code of a card
     * @param expirationDate, a specific expiration date of the card
     */
    public void onClickContinue(String name,String code,String cv,String expirationDate){
        if(!validateOnlyLetters(name)){
            view.showAlertMessage("Name filed must not be empty and must be only letters.");
            return;
        }

        if(!validateOnlyDigits(code)){
            view.showAlertMessage("Invalid format for code.Only digits!");
            return;
        }

        if(!validateOnlyDigits(cv)){
            view.showAlertMessage("Invalid format for cv.Only digits.");
            return;
        }

        if(!validateDate(expirationDate)){
            view.showAlertMessage("Invalid date.");
            return;
        }

        if(presentedTicket.buyTicket(presentedTicket,presentedPassenger,presentedRoute)){
            presentedCard.setCardHolderName(view.getCardHolderName());
            presentedCard.setCardID(view.getCardId());
            presentedCard.setCVcode(Integer.parseInt(view.getCVcode()));
            String date = view.getExpirationDate();
            String[] parts = date.split("/");
            SystemCalendar calendar = new SystemCalendar(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
            presentedCard.setExpirationDate(calendar);
            cardDAO.save(presentedCard);
            passengerDAO.save(presentedPassenger);
            passengerDAO.find(presentedPassenger.getNumberID()).addCard(presentedCard);

            String seats = view.getSeats();
            String[] parts1 = seats.split(",");
            for(int i=0; i<parts1.length; i++){
                presentedRoute.setAvailableSeats(presentedRoute.getAvailableSeats() - 1);
                presentedRoute.saveSeat(parts1[i]);
                System.out.println(parts1[i]);
            }
            view.clickCheckout("Purchase completed!");
        }else{
            view.showAlertMessage("Purchase failed.Check all your info again");
        }
    }

    /**
     * This method pops up a toast with a message.
     * @param message, the message that is being displayed in the toast
     */
    public void onShowToast(String message){
        view.showToast(message);
    }

    /** This method returns a cardHolderName.
     * @return a String object that has the cardHolderName
     */
    public String OngetCardHolderName(){
        return view.getCardHolderName();
    }

    /**
     * This method returns a cardID.
     * @return a String object that has the cardID
     */
    public String OngetCardCode(){
        return view.getCardId();
    }

    /**
     * This method returns a CVcode.
     * @return a String object that has the CVcode
     */
    public String OngetCV(){
        return view.getCVcode();
    }

    /**
     * This method returns an expirationDate.
     * @return a String object that has the expirationDate
     */
    public String OngetExpDate(){
        return view.getExpirationDate();
    }
}
