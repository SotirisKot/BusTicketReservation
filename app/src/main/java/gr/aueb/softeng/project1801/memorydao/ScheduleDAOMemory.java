package gr.aueb.softeng.project1801.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Schedule;
import gr.aueb.softeng.project1801.dao.ScheduleDAO;

public class ScheduleDAOMemory implements ScheduleDAO {

    protected static List<Schedule> entities = new ArrayList<Schedule>();


    /**
     * This method saves a schedule in the database.
     * @param schedule ,the schedule
     */
    public void save(Schedule schedule){
        if(!entities.contains(schedule)){
            entities.add(schedule);
        }
    }

    /**
     * This method deletes a schedule from the database.
     * @param schedule ,the schedule
     */
    public void delete(Schedule schedule){
        entities.remove(schedule);
    }


    /**
     * This method finds the schedule based on (the schedule) that we want to check.
     * @param schedule ,the schedule
     * @return the schedule that is found or null
     */
    public Schedule find(Schedule schedule){
        for(Schedule schedule1 : entities){
            if(schedule1.equals(schedule)){
                return schedule;
            }
        }
        return null;
    }

    /**
     * This method finds and returns all the schedules that are saved in the database.
     * @return all the schedules
     */
    public List<Schedule> findAll() {
        return new ArrayList<>(entities);
    }

}
