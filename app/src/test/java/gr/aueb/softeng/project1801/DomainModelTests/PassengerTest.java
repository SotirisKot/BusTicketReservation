package gr.aueb.softeng.project1801.DomainModelTests;

import org.junit.Test;

import gr.aueb.softeng.project1801.Card;
import gr.aueb.softeng.project1801.Passenger;

import static org.junit.Assert.*;

public class PassengerTest {

    /** Returns FirstName passed to the constructor.  */
    @Test
    public void getFirstName() {
        Passenger passenger = new Passenger();
        passenger.setFirstName("Toni");
        assertTrue(passenger.getFirstName().equals("Toni"));
    }

    /** Returns LastName passed to the constructor.  */
    @Test
    public void getLastName() {
        Passenger passenger = new Passenger();
        passenger.setLastName("Montana");
        assertTrue(passenger.getLastName().equals("Montana"));
    }

    /** Returns NumberID passed to the constructor.  */
    @Test
    public void getNumberID() {
        Passenger passenger = new Passenger();
        passenger.setNumberID("666");
        assertTrue(passenger.getNumberID().equals("666"));
    }

    @Test
    public void setFirstName() {
        Passenger passenger = new Passenger();
        passenger.setFirstName("Toni");
        assertTrue(passenger.getFirstName().equals("Toni"));
    }

    @Test
    public void setLastName() {
        Passenger passenger = new Passenger();
        passenger.setFirstName("Montana");
        assertTrue(passenger.getFirstName().equals("Montana"));
    }

    @Test
    public void setNumberID() {
        Passenger passenger = new Passenger();
        passenger.setNumberID("666");
        assertTrue(passenger.getNumberID().equals("666"));
    }

    /**
     * Returning a set.
     *
     * This method creates Card objects,inserts them into a set and finally checks if these objects were inserted correctly.
     * The set that is being returned contains Card objects.
     */
    @Test
    public void getAllCards() {
        Passenger passenger = new Passenger();
        Card card1 = new Card();
        card1.setCardHolderName("Sotiris Kotitsas");
        Card card2 = new Card();
        card2.setCardHolderName("Giorgos Chatzopoulos");
        Card card3 = new Card();
        card3.setCardHolderName("Tasos Lepiaps");
        passenger.addCard(card1);
        passenger.addCard(card2);
        passenger.removeCard(card2);
        passenger.addCard(card3);
        assertTrue(passenger.getAllCards().size() == 2);
        assertTrue(passenger.getAllCards().contains(card1));
        assertTrue(!(passenger.getAllCards().contains(card2)));
        assertTrue(passenger.getAllCards().contains(card3));
    }

    /**
     * Adding a card in the set.
     *
     * This method creates and checks if an object is null or not.
     * If the object is not null,then it adds the object into the set and it also checks that the set includes it after the insertion.
     * If the object is null,then we do not add the object into the set.
     */
    @Test
    public void addCard() {
        Passenger passenger = new Passenger();
        Card card = new Card();
        passenger.addCard(card);
        assertTrue(passenger.getAllCards().size() == 1);
        assertTrue(passenger.getAllCards().contains(card));
    }

    /**
     * Removing a card from the set.
     *
     * This method creates and checks if an object is null or not and it also checks that the set doesn't include it any more after the deletion.
     * If the object is not null,then we remove the object from the set.
     */
    @Test
    public void removeCard() {
        Passenger passenger = new Passenger();
        Card card = new Card();
        passenger.addCard(card);
        passenger.removeCard(card);
        assertTrue(passenger.getAllCards().size() == 0);
        assertTrue(!(passenger.getAllCards().contains(card)));

    }

    /**
     * Comparing two objects.
     *
     * This method creates and checks if two object are the same.
     */
    @Test
    public void equals() {
        String firstname = "Toni";
        String lastname = "Montana";
        String numberID = "666";
        Passenger passenger1 = new Passenger();
        Passenger passenger2 = new Passenger();
        passenger1.setFirstName(firstname);
        passenger1.setLastName(lastname);
        passenger1.setNumberID(numberID);
        passenger2.setFirstName(firstname);
        passenger2.setLastName(lastname);
        passenger2.setNumberID(numberID);
        assertTrue(passenger1.equals(passenger2));
    }


}