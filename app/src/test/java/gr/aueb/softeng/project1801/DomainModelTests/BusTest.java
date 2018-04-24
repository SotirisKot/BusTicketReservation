package gr.aueb.softeng.project1801.DomainModelTests;

import org.junit.Assert;
import org.junit.Test;
import gr.aueb.softeng.project1801.Bus;
import gr.aueb.softeng.project1801.BusState;


public class BusTest {

    @Test
    public void fromAvailableToNot(){
        Bus bus = new Bus();
        Assert.assertEquals(BusState.AVAILABLE,bus.getState());
        bus.not_available();
        Assert.assertEquals(BusState.NOT_AVAILABLE,bus.getState());
    }

    @Test
    public void fromNotAvailableToAvailable(){
        Bus bus = new Bus();
        bus.not_available();
        Assert.assertEquals(BusState.NOT_AVAILABLE,bus.getState());
        bus.available();
        Assert.assertEquals(BusState.AVAILABLE,bus.getState());
    }

}