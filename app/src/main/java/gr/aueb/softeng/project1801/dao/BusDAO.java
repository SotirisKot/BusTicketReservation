package gr.aueb.softeng.project1801.dao;

import java.util.List;

import gr.aueb.softeng.project1801.Bus;

public interface BusDAO {

    //finds the bus based on BusID
    Bus find(String BusID);

    //saves a bus in the database
    void save(Bus bus);

    //deletes a bus from the database
    void delete(Bus bus);

    //returns all the buses that are saved in the database
    List<Bus> findAll();

}
