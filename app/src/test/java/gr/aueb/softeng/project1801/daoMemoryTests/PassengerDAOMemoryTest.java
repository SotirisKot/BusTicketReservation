package gr.aueb.softeng.project1801.daoMemoryTests;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.DomainModel.Passenger;
import gr.aueb.softeng.project1801.dao.PassengerDAO;
import gr.aueb.softeng.project1801.memorydao.PassengerDAOMemory;

import static org.junit.Assert.*;

public class PassengerDAOMemoryTest {

    private Passenger passenger1 = new Passenger();
    private Passenger passenger2 = new Passenger();
    private Passenger passenger3 = new Passenger();
    private Passenger passenger4 = new Passenger();
    private PassengerDAO passengerDAO;

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

        passengerDAO = new PassengerDAOMemory();

        passengerDAO.save(passenger1);
        passengerDAO.save(passenger2);
        passengerDAO.save(passenger3);
        passengerDAO.save(passenger4);

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
        passengerDAO.save(passenger5);
        assertTrue(passengerDAO.findAll().contains(passenger5));

    }
    /**
     * Deleting a passenger;
     *
     * This method deletes a passenger from the database.
     */
    @Test
    public void delete() {
        Passenger passenger5 = new Passenger();
        passenger5.setNumberID("1542");
        passengerDAO.save(passenger5);
        passengerDAO.delete(passenger5);
        assertTrue(!passengerDAO.findAll().contains(passenger5));

    }

    /**
     * Finding a specific passenger.
     *
     * This method finds a passenger based on the PassengerID.
     */
    @Test
    public void find() {
        Passenger passenger5 = new Passenger();
        passenger5.setNumberID("1542");
        passengerDAO.save(passenger5);
        assertTrue(passengerDAO.find("1542").equals(passenger5));

    }

    /**
     * Finding all the passengers.
     *
     * This method finds and returns all the passengers that are saved in the database.
     * @return all the passengers
     */
    @Test
    public void findAll() {
        assertTrue(passengerDAO.findAll().contains(passenger1));
        assertTrue(passengerDAO.findAll().contains(passenger2));
        assertTrue(passengerDAO.findAll().contains(passenger3));
        assertTrue(passengerDAO.findAll().contains(passenger4));
        assertTrue(passengerDAO.findAll().size() == 4);

    }
}