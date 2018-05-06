package gr.aueb.softeng.project1801.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Bus;
import gr.aueb.softeng.project1801.dao.BusDAO;

public class BusDAOMemory implements BusDAO {

    protected static List<Bus> entities = new ArrayList<Bus>();

    /**
     * This method deletes a bus from the database.
     * @param bus ,the bus
     */
    public void delete(Bus bus){
        entities.remove(bus);
    }

    /**
     * This method saves a bus in the database.
     * @param bus ,the bus
     */
    public void save(Bus bus){
        if(!entities.contains(bus)){
            entities.add(bus);
        }
    }

    /**
     * This method finds and return all the buses that are saved in the database.
     * @return all the buses
     */
    public List<Bus> findAll(){
        return new ArrayList<>(entities);
    }

    /**
     * This method finds a bus based on the BusID.
     * @param busID ,the bus's ID
     * @return the bus that is found or null
     */
    public Bus find(String busID){
        for(Bus bus: entities){
            if(bus.getBusID().equals(busID)){
                return bus;
            }
        }
        return null;
    }
}
