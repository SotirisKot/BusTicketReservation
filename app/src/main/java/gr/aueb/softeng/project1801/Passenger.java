package gr.aueb.softeng.project1801;

import java.util.*;

public class Passenger {

    private String FirstName;
    private String LastName;
    private String NumberID;
    private Set<Ticket> PassengerTicket = new HashSet<>();//Stores all passenger's tickets.
    private Set<Card> PassengerCard = new HashSet<>();//Stores all passenger's card.

    //Constructor
    public Passenger(String FirstName,String LastName,String NumberID){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.NumberID = NumberID;
    }

    //Returns the firstname of the passenger
    public String getFirstName() {
        return FirstName;
    }

    //Returns the lastname of the passenger
    public String getLastName() {
        return LastName;
    }

    //Returns the numberID of the passenger
    public String getNumberID() {
        return NumberID;
    }


    //Setters
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setNumberID(String numberID) {
        NumberID = numberID;
    }


    //Returns a copy of the original set-> PassengerTicket
    public Set<Ticket> getAllTickets() {
        return new HashSet<>(PassengerTicket);
    }


    //Returns a copy of the original set-> PassengerCard
    public Set<Card> getAllCards() {
        return new HashSet<>(PassengerCard);
    }


    //Adds a ticket in the set if it is not null
    public void addTicket(Ticket ticket){

        if(ticket != null){
            PassengerTicket.add(ticket);
        }
    }


    //Adds a card in the set if it is not null
    public void addCard(Card card){

        if(card != null){
            PassengerCard.add(card);
        }
    }


    //Removes a ticket from the set if it exists
    public void removeTicket(Ticket ticket){

        if(ticket != null){
            PassengerTicket.remove(ticket);
        }
    }

    //Removes a card from the set if it exists
    public void removeCard(Card card){

        if(card != null){
            PassengerCard.remove(card);
        }
    }


    //Overrides equals
    @Override
    public boolean equals(Object other){

        if(other == null){
            return false;
        }

        if(this == other){
            return true;
        }

        if(!(other instanceof Passenger)){
            return false;
        }

        Passenger thePassenger = (Passenger) other;
        if(!(FirstName == null ? thePassenger.FirstName == null
                : FirstName.equals(thePassenger.FirstName))){
            return false;
        }

        if(!(LastName == null ? thePassenger.LastName == null
                : LastName.equals(thePassenger.LastName))){
            return false;
        }

        if(!(NumberID == null ? thePassenger.NumberID == null
                : NumberID.equals(thePassenger.NumberID))){

        }
        if(!(FirstName == null ? thePassenger.getFirstName() == null
                : FirstName.equals(thePassenger.getFirstName()))){
            return false;
        }

        if(!(LastName == null ? thePassenger.getLastName() == null
                : LastName.equals(thePassenger.getLastName()))){
            return false;
        }

        if(!(NumberID == null ? thePassenger.getNumberID() == null
                : NumberID.equals(thePassenger.getNumberID()))){

            return false;
        }

        return true;
    }

    //When equals is overrided always override hashCode
    @Override
    public int hashCode(){
        if(FirstName == null && LastName == null & NumberID == null){
            return 0;
        }

        int result = 0;
        result = FirstName == null ? result : 13 * result + FirstName.hashCode();
        result = LastName == null ? result : 13 * result + LastName.hashCode();
        result = NumberID == null ? result : 13 * result + NumberID.hashCode();

        return result;
    }
}
