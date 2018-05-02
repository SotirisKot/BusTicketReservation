package gr.aueb.softeng.project1801.data_interfaces;

import java.util.List;

import gr.aueb.softeng.project1801.Passenger;

public interface PassengerData {

    //returns a passenger based on the number id
    Passenger find(String NumberID);

    //saves a passenger
    void save(Passenger passenger);

    //deletes a passenger
    void delete(Passenger passenger);

    //returns all the passengers
    List<Passenger> findAll();
}
