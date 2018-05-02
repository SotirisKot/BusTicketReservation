package gr.aueb.softeng.project1801.data_interfaces;

import java.util.List;

import gr.aueb.softeng.project1801.Schedule;

public interface ScheduleData {

    //saves a schedule
    void save(Schedule schedule);

    //deletes a schedule
    void delete(Schedule schedule);

    //returns all the schedules
    List<Schedule> findAll();

    //finds a schedule.
    Schedule find(Schedule schedule);
}
