package gr.aueb.softeng.project1801.dataImpl;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.Driver;
import gr.aueb.softeng.project1801.data_interfaces.DriverData;

public class DriverImpl implements DriverData{

    protected static List<Driver> entities = new ArrayList<Driver>();

    public void delete(Driver driver){
        entities.remove(driver);
    }

    public void save(Driver driver){
        if(!entities.contains(driver)){
            entities.add(driver);
        }
    }

    public Driver find(String driverID){
        for(Driver driver: entities){
            if(driver.getDriverID().equals(driverID)){
                return driver;
            }
        }
        return null;
    }

    public List<Driver> findAll(){
        return new ArrayList<>(entities);
    }
}
