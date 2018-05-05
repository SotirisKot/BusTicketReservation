package gr.aueb.softeng.project1801.dao;

import java.util.List;

import gr.aueb.softeng.project1801.Passenger;

public interface PassengerDAO {

    /**
     * This method finds a passenger based on the NumberID.
     * @param NumberID ,the passenger's number ID
     * @return the passenger
     */
    Passenger find(String NumberID);

    /**
     * This method saves a passenger in the database.
     * @param passenger ,the passenger
     */
    void save(Passenger passenger);

    /**
     * This method deletes a passenger from the database.
     * @param passenger ,the passenger
     */
    void delete(Passenger passenger);

    /**
     * This method finds and return all the passengers that are saved in the database.
     * @return all the passengers
     */
    List<Passenger> findAll();
}
