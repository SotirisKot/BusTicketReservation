package gr.aueb.softeng.project1801.DomainModelTests;

import org.junit.Assert;
import org.junit.Test;

import gr.aueb.softeng.project1801.BusState;
import gr.aueb.softeng.project1801.Driver;
import gr.aueb.softeng.project1801.DriverState;

import static org.junit.Assert.assertTrue;


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

    @Test
    public void getDriverName() {
        Driver driver = new Driver();
        driver.setDriverName("Toni");
        assertTrue(driver.getDriverName().equals("Toni"));
    }

    @Test
    public void setDriverName() {
        Driver driver = new Driver();
        driver.setDriverName("Toni");
        assertTrue(driver.getDriverName().equals("Toni"));
    }

    @Test
    public void getDriverID() {
        Driver driver = new Driver();
        driver.setDriverID("666");
        assertTrue(driver.getDriverID().equals("666"));
    }

    @Test
    public void setDriverID() {
        Driver driver = new Driver();
        driver.setDriverID("666");
        assertTrue(driver.getDriverID().equals("666"));
    }

    @Test
    public void getState() {
        Driver driver = new Driver();
        driver.setState(DriverState.AVAILABLE);
        assertTrue(driver.getState() == DriverState.AVAILABLE);
    }

    @Test
    public void setState() {
        Driver driver = new Driver();
        driver.setState(DriverState.AVAILABLE);
        assertTrue(driver.getState() == DriverState.AVAILABLE);
    }

    @Test
    public void equals() {
        String driverName = "Toni";
        String driverID = "666";
        Driver driver1 = new Driver();
        Driver driver2 = new Driver();
        driver1.setDriverName(driverName);
        driver1.setDriverID(driverID);
        driver2.setDriverName(driverName);
        driver2.setDriverID(driverID);
        assertTrue(driver1.equals(driver2));

    }



}