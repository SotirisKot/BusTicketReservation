package gr.aueb.softeng.project1801;

import java.util.*;

public class Passenger {

    private String FirstName;
    private String LastName;
    private String NumberID;
    private Set<Card> PassengerCard = new HashSet<>();//Stores all passenger's card.

    /**
     *
     * Constructor.
     * @param FirstName (required) First Name of the passenger.
     * @param LastName (required) Last Name of the passenger.
     * @param NumberID (required) Number ID of the passenger.
     */
    public Passenger(String FirstName,String LastName,String NumberID){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.NumberID = NumberID;
    }

    /**
     *
     * Default constructor,which construct a Passenger object.
     */
    public Passenger() {}

    /** @return FirstName passed to the constructor.  */
    public String getFirstName() {
        return FirstName;
    }

    /** @return LastName passed to the constructor.  */
    public String getLastName() {
        return LastName;
    }

    /** @return NumberID passed to the constructor.  */
    public String getNumberID() {
        return NumberID;
    }


    //Setters

    /**
     *
     * @param firstName first name to set
     */
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    /**
     *
     * @param lastName last name to set
     */
    public void setLastName(String lastName) {
        LastName = lastName;
    }

    /**
     *
     * @param numberID number ID to set
     */
    public void setNumberID(String numberID) {
        NumberID = numberID;
    }


    //Returns a copy of the original set-> PassengerCard
    public Set<Card> getAllCards() {
        return new HashSet<>(PassengerCard);
    }


    /**
     * Adding a card in the set.
     *
     * This method checks if an object is null or not.
     * If the object is not null,then we add the object into the set.
     * If the object is null,then we do not add the object into the set.
     */
    public void addCard(Card card){

        if(card != null){
            PassengerCard.add(card);
        }
    }

    /**
     * Removing a card in the set.
     *
     * This method checks if an object is null or not.
     * If the object is not null,then we remove the object into the set.
     */
    //Removes a card from the set if it exists
    public void removeCard(Card card){

        if(card != null){
            PassengerCard.remove(card);
        }
    }



    /**
     * Comparing two objects.
     *
     * This method checks if two object are the same.
     * @param other must be an object.
     */
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

            return false;
        }

        return true;
    }

    /**
     * Getting the hashCode of an object.
     *
     * This method checks if two object has the same hasCode.
     * If the method equals returned "true" the hasCode of the two objects must be the same.
     * If the method equals returned "false" the hasCode of the two objects must not be the same.
     */
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
