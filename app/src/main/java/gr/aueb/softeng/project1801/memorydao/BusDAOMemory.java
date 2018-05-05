package gr.aueb.softeng.project1801.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.Bus;
import gr.aueb.softeng.project1801.dao.BusDAO;

public class BusDAOMemory implements BusDAO {

    protected static List<Bus> entities = new ArrayList<Bus>();

    public void delete(Bus bus){
        entities.remove(bus);
    }

    public void save(Bus bus){
        if(!entities.contains(bus)){
            entities.add(bus);
        }

    }

    public List<Bus> findAll(){
        return new ArrayList<>(entities);
    }

    public Bus find(String busID){
        for(Bus bus: entities){
            if(bus.getBusID().equals(busID)){
                return bus;
            }
        }
        return null;
    }
}