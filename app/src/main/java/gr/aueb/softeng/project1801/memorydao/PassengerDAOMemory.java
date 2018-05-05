package gr.aueb.softeng.project1801.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Passenger;
import gr.aueb.softeng.project1801.dao.PassengerDAO;

public class PassengerDAOMemory implements PassengerDAO {

    protected static List<Passenger> entities = new ArrayList<Passenger>();

    /**
     * This method saves a passenger in the database.
     * @param passenger ,the passenger
     */
    public void save(Passenger passenger){
        if(!entities.contains(passenger)){
            entities.add(passenger);
        }
    }

    /**
     * This method deletes a passenger from the database.
     * @param passenger ,the passenger
     */
    public void delete(Passenger passenger){
        entities.remove(passenger);
    }


    /**
     * This method finds a passenger based on the NumberID.
     * @param NumberID ,the passenger's number ID
     * @return the passenger that is found or null
     */
    public Passenger find(String NumberID) {
        for(Passenger passenger: entities){
            if(passenger.getNumberID().equals(NumberID)){
                return passenger;
            }
        }
        return null;
    }

    /**
     * This method finds and returns all the passengers that are saved in the database.
     * @return all the passengers
     */
    public List<Passenger> findAll() {
        return new ArrayList<>(entities);
    }

}
