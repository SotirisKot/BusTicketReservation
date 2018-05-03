package gr.aueb.softeng.project1801.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.Schedule;
import gr.aueb.softeng.project1801.dao.ScheduleDAO;

public class ScheduleDAOMemory implements ScheduleDAO {

    protected static List<Schedule> entities = new ArrayList<Schedule>();


    public void save(Schedule schedule){
        if(!entities.contains(schedule)){
            entities.add(schedule);
        }
    }

    public void delete(Schedule schedule){
        entities.remove(schedule);
    }

    public List<Schedule> findAll() {
        return new ArrayList<>(entities);
    }

    public Schedule find(Schedule schedule){
        for(Schedule schedule1 : entities){
            if(schedule1.equals(schedule)){
                return schedule;
            }
        }
        return null;
    }
}
