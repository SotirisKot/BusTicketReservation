package gr.aueb.softeng.project1801.DomainModelTests;

import org.junit.Test;

import gr.aueb.softeng.project1801.Card;
import gr.aueb.softeng.project1801.Passenger;

import static org.junit.Assert.*;

public class PassengerTest {

    @Test
    public void getFirstName() {
        Passenger passenger = new Passenger();
        passenger.setFirstName("Toni");
        assertTrue(passenger.getFirstName().equals("Toni"));
    }

    @Test
    public void getLastName() {
        Passenger passenger = new Passenger();
        passenger.setFirstName("Montana");
        assertTrue(passenger.getLastName().equals("Montana"));
    }

    @Test
    public void getNumberID() {
        Passenger passenger = new Passenger();
        passenger.setNumberID("666");
        assertTrue(passenger.getFirstName().equals("666"));
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
        assertTrue(passenger.getLastName().equals("Montana"));
    }

    @Test
    public void setNumberID() {
        Passenger passenger = new Passenger();
        passenger.setNumberID("666");
        assertTrue(passenger.getFirstName().equals("666"));
    }

    @Test
    public void getAllCards() {
    }

    @Test
    public void addCard() {
        Passenger passenger = new Passenger();
        Card card = new Card();
        passenger.addCard(card);
        assertTrue(passenger.getAllCards().size() == 1);
        assertTrue(passenger.getAllCards().contains(card));
    }

    @Test
    public void removeCard() {
        Passenger passenger = new Passenger();
        Card card = new Card();
        passenger.addCard(card);
        passenger.removeCard(card);
        assertTrue(passenger.getAllCards().size() == 0);
        assertTrue(!(passenger.getAllCards().contains(card)));

    }

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
        assertTrue(passenger1.equals(passenger2) == true);
    }


}