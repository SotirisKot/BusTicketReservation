package gr.aueb.softeng.project1801.dao;

import java.util.List;

import gr.aueb.softeng.project1801.Schedule;

public interface ScheduleDAO {

    /**
     * This method finds a schedule based on the scheduleID.
     * @param scheduleID ,the schedule
     * @return the schedule
     */
    Schedule find(Schedule scheduleID);

    /**
     * This method saves a schedule in the database.
     * @param schedule ,the schedule
     */
    void save(Schedule schedule);

    /**
     * This method deletes a schedule from the database.
     * @param schedule ,the schedule
     */
    void delete(Schedule schedule);

    /**
     * This method finds and return all the schedules that are saved in the database.
     * @return all the schedules
     */
    List<Schedule> findAll();


}
