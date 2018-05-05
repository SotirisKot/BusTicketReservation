package gr.aueb.softeng.project1801.dao;

import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Bus;

public interface BusDAO {

    /**
     * This method finds a bus based on the BusID.
     * @param BusID ,the bus's ID
     * @return the bus
     */
    Bus find(String BusID);

    /**
     * This method saves a bus in the database.
     * @param bus ,the bus
     */
    void save(Bus bus);


    /**
     * This method deletes a bus from the database.
     * @param bus ,the bus
     */
    void delete(Bus bus);

    /**
     * This method finds and returns all the buses that are saved in the database.
     * @return all the buses
     */
    List<Bus> findAll();

}
