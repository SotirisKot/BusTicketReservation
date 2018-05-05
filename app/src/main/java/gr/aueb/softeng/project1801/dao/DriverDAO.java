package gr.aueb.softeng.project1801.dao;

import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Driver;

public interface DriverDAO {

    /**
     * This method finds a driver based on the DriverID.
     * @param DriverID ,the driver's ID
     * @return the driver
     */
    Driver find(String DriverID);

    /**
     * This method saves a driver in the database.
     * @param driver ,the driver
     */
    void save(Driver driver);

    /**
     * This method deletes a driver from the database.
     * @param driver ,the driver
     */
    void delete(Driver driver);

    /**
     * This method finds and returns all the drivers that are saved in the database.
     * @return all the drivers
     */
    List<Driver> findAll();
}
