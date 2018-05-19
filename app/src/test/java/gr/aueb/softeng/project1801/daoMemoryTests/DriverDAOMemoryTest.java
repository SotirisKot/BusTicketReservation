package gr.aueb.softeng.project1801.daoMemoryTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.DomainModel.Driver;
import gr.aueb.softeng.project1801.dao.DriverDAO;
import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;
import gr.aueb.softeng.project1801.memorydao.DriverDAOMemory;

import static org.junit.Assert.*;

public class DriverDAOMemoryTest {

    private Driver driver1 = new Driver();
    private Driver driver2 = new Driver();
    private Driver driver3 = new Driver();
    private Driver driver4 = new Driver();
    private DriverDAO driverDAO;
    private Initializer dataHelper = new DataInitializer();

    /**
     * Initializing data.
     *
     * This method initializes the training data.
     */
    @Before
    public void setUp(){
        driver1.setDriverID("1232");
        driver2.setDriverID("4512");
        driver3.setDriverID("5733");
        driver4.setDriverID("1674");
        dataHelper.prepareData();
        driverDAO = dataHelper.getDriverData();
        driverDAO.save(driver1);
        driverDAO.save(driver2);
        driverDAO.save(driver3);
        driverDAO.save(driver4);

    }

    @After
    public void tearDown(){
    }

    /**
     * Deleting a driver;
     *
     * This method deletes a driver from the database.
     */
    @Test
    public void deleteDriver() {
        Driver driver5 = new Driver();
        driver5.setDriverID("1542");
        driverDAO.save(driver5);
        driverDAO.delete(driver5);

        assertTrue(!driverDAO.findAll().contains(driver5));

    }

    /**
     * Saving a new driver.
     *
     * This method saves a new driver in the database.
     */
    @Test
    public void saveDriver() {
        Driver driver5 = new Driver();
        driver5.setDriverID("1542");
        driverDAO.save(driver5);
        assertTrue(driverDAO.findAll().contains(driver5));

    }

    /**
     * Finding a specific driver.
     *
     * This method finds a driver based on the DriverID.
     */
    @Test
    public void findDriver() {
        Driver driver5 = new Driver();
        driver5.setDriverID("1542");
        driverDAO.save(driver5);
        assertTrue(driverDAO.find("1542").equals(driver5));

    }

    @Test
    public void findAllDrivers() {
        assertTrue(driverDAO.findAll().contains(driver1));
        assertTrue(driverDAO.findAll().contains(driver2));
        assertTrue(driverDAO.findAll().contains(driver3));
        assertTrue(driverDAO.findAll().contains(driver4));
        assertTrue(driverDAO.findAll().size() == 12);
    }
}