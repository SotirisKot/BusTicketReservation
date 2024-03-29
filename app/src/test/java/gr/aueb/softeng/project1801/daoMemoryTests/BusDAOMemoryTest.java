package gr.aueb.softeng.project1801.daoMemoryTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.DomainModel.Bus;
import gr.aueb.softeng.project1801.dao.BusDAO;
import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.memorydao.BusDAOMemory;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;

import static org.junit.Assert.*;

public class BusDAOMemoryTest {

    private Bus bus1 = new Bus();
    private Bus bus2 = new Bus();
    private Bus bus3 = new Bus();
    private Bus bus4 = new Bus();
    private BusDAO busDAO;
    private Initializer dataHelper = new DataInitializer();

    /**
     * Initializing data.
     *
     * This method initializes the training data.
     */
    @Before
    public void setUp(){
        bus1.setBusID("1232");
        bus2.setBusID("4512");
        bus3.setBusID("5733");
        bus4.setBusID("1674");
        dataHelper.prepareData();
        busDAO = dataHelper.getBusData();
        busDAO.save(bus1);
        busDAO.save(bus2);
        busDAO.save(bus3);
        busDAO.save(bus4);

    }

    @After
    public void tearDown(){
    }

    /**
     * Finding a specific bus.
     *
     * This method finds a bus based on the BusID.
     */
    @Test
    public void findBus() {
        Bus bus5 = new Bus();
        bus5.setBusID("1542");
        busDAO.save(bus5);

        assertTrue(busDAO.find("1542").equals(bus5));

    }

    /**
     * Saving a new bus.
     *
     * This method saves a new bus in the database.
     */
    @Test
    public void saveBus() {
        Bus bus5 = new Bus();
        bus5.setBusID("1542");
        busDAO.save(bus5);
        assertTrue(busDAO.findAll().contains(bus5));
    }

    /**
     * Deleting a bus;
     *
     * This method deletes a bus from the database.
     */
    @Test
    public void deleteBus() {
        Bus bus5 = new Bus();
        bus5.setBusID("1542");
        busDAO.save(bus5);
        busDAO.delete(bus5);

        assertTrue(!busDAO.findAll().contains(bus5));

    }

    /**
     * Finding all the buses.
     * This method finds and returns all the buses that are saved in the database.
     */
    @Test
    public void findAllBuses() {
        assertTrue(busDAO.findAll().contains(bus1));
        assertTrue(busDAO.findAll().contains(bus2));
        assertTrue(busDAO.findAll().contains(bus3));
        assertTrue(busDAO.findAll().contains(bus4));
        assertTrue(busDAO.findAll().size() == 14);

    }
}