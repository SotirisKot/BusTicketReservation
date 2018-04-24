package gr.aueb.softeng.project1801.DomainModelTests;

import org.junit.Assert;
import org.junit.Test;
import gr.aueb.softeng.project1801.Driver;
import gr.aueb.softeng.project1801.DriverState;


public class DriverTest {

    @Test
    public void fromAvailableToNot(){
        Driver driver = new Driver();
        Assert.assertEquals(DriverState.AVAILABLE,driver.getState());
        driver.not_available();
        Assert.assertEquals(DriverState.NOT_AVAILABLE,driver.getState());
    }

    @Test
    public void fromNotAvailableToAvailable(){
        Driver driver = new Driver();
        driver.not_available();
        Assert.assertEquals(DriverState.NOT_AVAILABLE,driver.getState());
        driver.available();
        Assert.assertEquals(DriverState.AVAILABLE,driver.getState());
    }

}