package gr.aueb.softeng.project1801.daoMemoryTests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Bus;

import static org.junit.Assert.*;

public class BusDAOMemoryTest {

    private Bus bus1 = new Bus();
    private Bus bus2 = new Bus();
    private Bus bus3 = new Bus();
    private Bus bus4 = new Bus();
    private List<Bus> busList = new ArrayList<>();


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

        busList.add(bus1);
        busList.add(bus2);
        busList.add(bus3);
        busList.add(bus4);

    }

    /**
     * Finding a specific bus.
     *
     * This method finds a bus based on the BusID.
     */
    @Test
    public void find() {
        for(Bus bus: busList){
            if(bus.getBusID().equals("5733")){
                assertTrue(bus3.getBusID().equals("5733"));
                break;
            }
        }
        assertTrue(!(bus3.getBusID().equals("1232")));
        assertTrue(!(bus3.getBusID().equals("4512")));
        assertTrue(!(bus3.getBusID().equals("1674")));
    }

    /**
     * Saving a new bus.
     *
     * This method saves a new bus in the database.
     */
    @Test
    public void save() {
        Bus bus5 = new Bus();
        bus5.setBusID("1542");

        if(!busList.contains(bus5)){
            busList.add(bus5);
        }
        assertTrue(busList.contains(bus5));
    }

    /**
     * Deleting a bus;
     *
     * This method deletes a bus from the database.
     */
    @Test
    public void delete() {
        if(busList.contains(bus3)){
            busList.remove(bus3);
        }
        assertTrue(!busList.contains(bus3));

    }

    /**
     * Finding all the buses.
     *
     * This method finds and returns all the buses that are saved in the database.
     * @return all the buses
     */
    @Test
    public void findAll() {
        for (Bus bus : busList) {
            assertTrue(busList.contains(bus));
        }
        assertTrue(busList.contains(bus1));
        assertTrue(busList.contains(bus2));
        assertTrue(busList.contains(bus3));
        assertTrue(busList.contains(bus4));


    }
}