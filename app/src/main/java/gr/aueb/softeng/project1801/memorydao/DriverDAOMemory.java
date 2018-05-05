package gr.aueb.softeng.project1801.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Driver;
import gr.aueb.softeng.project1801.dao.DriverDAO;

public class DriverDAOMemory implements DriverDAO {

    protected static List<Driver> entities = new ArrayList<Driver>();

    /**
     * This method deletes a driver from the database.
     * @param driver ,the driver
     */
    public void delete(Driver driver){
        entities.remove(driver);
    }

    /**
     * This method saves a driver in the database.
     * @param driver ,the driver
     */
    public void save(Driver driver){
        if(!entities.contains(driver)){
            entities.add(driver);
        }
    }

    /**
     * This method finds a driver based on the DriverID.
     * @param driverID ,the driver's ID
     * @return the driver that is found or null
     */
    public Driver find(String driverID){
        for(Driver driver: entities){
            if(driver.getDriverID().equals(driverID)){
                return driver;
            }
        }
        return null;
    }

    /**
     * This method finds and returns all the drivers that are saved in the database.
     * @return all the drivers
     */
    public List<Driver> findAll(){
        return new ArrayList<>(entities);
    }
}
