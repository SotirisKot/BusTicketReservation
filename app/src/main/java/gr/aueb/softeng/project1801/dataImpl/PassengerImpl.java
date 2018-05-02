package gr.aueb.softeng.project1801.dataImpl;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.Passenger;
import gr.aueb.softeng.project1801.data_interfaces.PassengerData;

public class PassengerImpl implements PassengerData{

    protected static List<Passenger> entities = new ArrayList<Passenger>();

    public void save(Passenger passenger){
        if(!entities.contains(passenger)){
            entities.add(passenger);
        }
    }

    public void delete(Passenger passenger){
        entities.remove(passenger);
    }


    public Passenger find(String NumberID) {
        for(Passenger passenger: entities){
            if(passenger.getNumberID().equals(NumberID)){
                return passenger;
            }
        }
        return null;
    }

    public List<Passenger> findAll() {
        return new ArrayList<>(entities);
    }

}
