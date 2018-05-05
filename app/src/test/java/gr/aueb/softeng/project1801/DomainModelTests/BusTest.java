package gr.aueb.softeng.project1801.DomainModelTests;

import org.junit.Assert;
import org.junit.Test;
import gr.aueb.softeng.project1801.DomainModel.Bus;
import gr.aueb.softeng.project1801.DomainModel.BusState;

import static org.junit.Assert.assertTrue;


public class BusTest {

    /**
     * Changing bus's state.
     *
     * This method changes the bus state from available to not available.
     */
    @Test
    public void fromAvailableToNot(){
        Bus bus = new Bus();
        Assert.assertEquals(BusState.AVAILABLE,bus.getState());
        bus.not_available();
        Assert.assertEquals(BusState.NOT_AVAILABLE,bus.getState());
    }

    /**
     * Changing bus's state.
     *
     * This method changes the bus state from not available to available.
     */
    @Test
    public void fromNotAvailableToAvailable(){
        Bus bus = new Bus();
        bus.not_available();
        Assert.assertEquals(BusState.NOT_AVAILABLE,bus.getState());
        bus.available();
        Assert.assertEquals(BusState.AVAILABLE,bus.getState());
    }

    /** Returns BusType passed to the constructor.  */
    @Test
    public void getBusType() {
        Bus bus = new Bus();
        bus.setBusType("Diorofo");
        assertTrue(bus.getBusType().equals("Diorofo"));
    }

    @Test
    public void setBusType() {
        Bus bus = new Bus();
        bus.setBusType("Diorofo");
        assertTrue(bus.getBusType().equals("Diorofo"));
    }

    /** Returns  ModelType passed to the constructor.  */
    @Test
    public void getModelType() {
        Bus bus = new Bus();
        bus.setModelType("Astiko");
        assertTrue(bus.getModelType().equals("Astiko"));
    }

    @Test
    public void setModelType() {
        Bus bus = new Bus();
        bus.setModelType("Astiko");
        assertTrue(bus.getModelType().equals("Astiko"));
    }

    /** Returns BusID passed to the constructor.  */
    @Test
    public void getBusID() {
        Bus bus = new Bus();
        bus.setBusID("666");
        assertTrue(bus.getBusID().equals("666"));
    }


    @Test
    public void setBusID() {
        Bus bus = new Bus();
        bus.setBusID("666");
        assertTrue(bus.getBusID().equals("666"));
    }

    /** Returns BusSeats passed to the constructor.  */
    @Test
    public void getBusSeats() {
        Bus bus = new Bus();
        bus.setBusSeats(100);
        assertTrue(bus.getBusSeats() == 100);
    }

    @Test
    public void setBusSeats() {
        Bus bus = new Bus();
        bus.setBusSeats(100);
        assertTrue(bus.getBusSeats() == 100);
    }

    /** Returns current State of the bus */
    @Test
    public void getState() {
        Bus bus = new Bus();
        bus.setState(BusState.AVAILABLE);
        assertTrue(bus.getState() == BusState.AVAILABLE);
    }

    @Test
    public void setState() {
        Bus bus = new Bus();
        bus.setState(BusState.AVAILABLE);
        assertTrue(bus.getState() == BusState.AVAILABLE);
    }

    /**
     * Comparing two objects.
     *
     * This method creates and checks if two object are the same.
     */
    @Test
    public void equals() {
        String busType = "Diorofo";
        String modelType = "Astiko";
        String busID = "666";
        int busSeats = 100;
        Bus bus1 = new Bus();
        Bus bus2 = new Bus();
        bus1.setBusType(busType);
        bus1.setModelType(modelType);
        bus1.setBusID(busID);
        bus1.setBusSeats(busSeats);
        bus2.setBusType(busType);
        bus2.setModelType(modelType);
        bus2.setBusID(busID);
        bus2.setBusSeats(busSeats);
        assertTrue(bus1.equals(bus2));
    }

}