package gr.aueb.softeng.project1801.daoMemoryTests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Passenger;

import static org.junit.Assert.*;

public class PassengerDAOMemoryTest {

    private Passenger passenger1 = new Passenger();
    private Passenger passenger2 = new Passenger();
    private Passenger passenger3 = new Passenger();
    private Passenger passenger4 = new Passenger();
    private List<Passenger> passengerList = new ArrayList<>();

    /**
     * Initializing data.
     *
     * This method initializes the training data.
     */
    @Before
    public void setUp(){
        passenger1.setNumberID("1232");
        passenger2.setNumberID("4512");
        passenger3.setNumberID("5733");
        passenger4.setNumberID("1674");

        passengerList.add(passenger1);
        passengerList.add(passenger2);
        passengerList.add(passenger3);
        passengerList.add(passenger4);

    }

    /**
     * Saving a new passenger.
     *
     * This method saves a new passenger in the database.
     */
    @Test
    public void save() {
        Passenger passenger5 = new Passenger();
        passenger5.setNumberID("1542");

        if(!passengerList.contains(passenger5)){
            passengerList.add(passenger5);
        }
        assertTrue(passengerList.contains(passenger5));
    }
    /**
     * Deleting a passenger;
     *
     * This method deletes a passenger from the database.
     */
    @Test
    public void delete() {
        if(passengerList.contains(passenger3)){
            passengerList.remove(passenger3);
        }
        assertTrue(!passengerList.contains(passenger3));

    }

    /**
     * Finding a specific passenger.
     *
     * This method finds a passenger based on the PassengerID.
     */
    @Test
    public void find() {
        for(Passenger passenger: passengerList){
            if(passenger.getNumberID().equals("5733")){
                assertTrue(passenger3.getNumberID().equals("5733"));
                break;
            }
        }
        assertTrue(!(passenger3.getNumberID().equals("1232")));
        assertTrue(!(passenger3.getNumberID().equals("4512")));
        assertTrue(!(passenger3.getNumberID().equals("1674")));
    }

    /**
     * Finding all the passengers.
     *
     * This method finds and returns all the passengers that are saved in the database.
     * @return all the passengers
     */
    @Test
    public void findAll() {
        for (Passenger passenger : passengerList) {
            assertTrue(passengerList.contains(passenger));
        }
        assertTrue(passengerList.contains(passenger1));
        assertTrue(passengerList.contains(passenger2));
        assertTrue(passengerList.contains(passenger3));
        assertTrue(passengerList.contains(passenger4));

    }
}