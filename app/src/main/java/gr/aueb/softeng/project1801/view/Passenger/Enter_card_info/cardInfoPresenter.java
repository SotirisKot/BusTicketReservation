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
                calendar,presentedRoute.getEstimatedArrivalTime(),Double.parseDouble(view.getPrice()),presentedPassenger,view.getSeats(),view.getType(),presentedRoute);

        presentedCard = new Card();
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

    private boolean validateOnlyDigits(String code){
        for(int i = 0; i < code.length(); i++)
            if(!Character.isDigit(code.charAt(i)))
                return false;
        return true;
    }

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

    public void onShowToast(String message){
        view.showToast(message);
    }

    public String OngetCardHolderName(){
        return view.getCardHolderName();
    }

    public String OngetCardCode(){
        return view.getCardId();
    }

    public String OngetCV(){
        return view.getCVcode();
    }

    public String OngetExpDate(){
        return view.getExpirationDate();
    }
}
