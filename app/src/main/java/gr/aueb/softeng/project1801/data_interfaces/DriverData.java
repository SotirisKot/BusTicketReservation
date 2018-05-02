package gr.aueb.softeng.project1801.data_interfaces;

import java.util.List;

import gr.aueb.softeng.project1801.Driver;

public interface DriverData {

    //finds the driver based on the driver id
    Driver find(String DriverID);

    //saves a driver in the database
    void save(Driver driver);

    //deletes a driver from the database
    void delete(Driver driver);

    //returns all the drivers in the database
    List<Driver> findAll();
}
