package gr.aueb.softeng.project1801.daoMemoryTests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Driver;
import gr.aueb.softeng.project1801.dao.DriverDAO;
import gr.aueb.softeng.project1801.memorydao.DriverDAOMemory;

import static org.junit.Assert.*;

public class DriverDAOMemoryTest {

    private Driver driver1 = new Driver();
    private Driver driver2 = new Driver();
    private Driver driver3 = new Driver();
    private Driver driver4 = new Driver();
    private DriverDAO driverDAO;
 //   private List<Driver> driverList = new ArrayList<>();


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

        driverDAO = new DriverDAOMemory();
        driverDAO.save(driver1);
        driverDAO.save(driver2);
        driverDAO.save(driver3);
        driverDAO.save(driver4);

    }

    /**
     * Deleting a driver;
     *
     * This method deletes a driver from the database.
     */
    @Test
    public void delete() {
        Driver driver5 = new Driver();
        driver5.setDriverID("1542");
        driverDAO.save(driver5);
        driverDAO.delete(driver5);

        assertTrue(!driverDAO.findAll().contains(driver5));

      /*  if(driverList.contains(driver3)){
            driverList.remove(driver3);
        }
        assertTrue(!driverList.contains(driver3));*/

    }

    /**
     * Saving a new driver.
     *
     * This method saves a new driver in the database.
     */
    @Test
    public void save() {
        Driver driver5 = new Driver();
        driver5.setDriverID("1542");
        driverDAO.save(driver5);
        assertTrue(driverDAO.findAll().contains(driver5));


  /*      if(!driverList.contains(driver5)){
            driverList.add(driver5);
        }
        assertTrue(driverList.contains(driver5));*/
    }

    /**
     * Finding a specific driver.
     *
     * This method finds a driver based on the DriverID.
     */
    @Test
    public void find() {
        Driver driver5 = new Driver();
        driver5.setDriverID("1542");
        driverDAO.save(driver5);
        assertTrue(driverDAO.find("1542").equals(driver5));

/*        for(Driver driver: driverList){
            if(driver.getDriverID().equals("5733")){
                assertTrue(driver3.getDriverID().equals("5733"));
                break;
            }
        }
        assertTrue(!(driver3.getDriverID().equals("1232")));
        assertTrue(!(driver3.getDriverID().equals("4512")));
        assertTrue(!(driver3.getDriverID().equals("1674")));*/
    }

    @Test
    public void findAll() {
        assertTrue(driverDAO.findAll().contains(driver1));
        assertTrue(driverDAO.findAll().contains(driver2));
        assertTrue(driverDAO.findAll().contains(driver3));
        assertTrue(driverDAO.findAll().contains(driver4));
        assertTrue(driverDAO.findAll().size() == 4);
    }
}