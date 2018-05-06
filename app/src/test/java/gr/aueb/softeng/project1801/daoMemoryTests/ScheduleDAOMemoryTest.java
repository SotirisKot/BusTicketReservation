package gr.aueb.softeng.project1801.daoMemoryTests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Schedule;

import static org.junit.Assert.*;

public class ScheduleDAOMemoryTest {

    private Schedule schedule1 = new Schedule();
    private Schedule schedule2 = new Schedule();
    private Schedule schedule3 = new Schedule();
    private Schedule schedule4 = new Schedule();
    private List<Schedule> scheduleList = new ArrayList<>();


    /**
     * Initializing data.
     *
     * This method initializes the training data.
     */
    @Before
    public void setUp(){
        schedule1.setDestination("Nauplio");
        schedule1.setDeparture("Athens");

        schedule2.setDestination("Naxos");
        schedule2.setDeparture("Athens");

        schedule3.setDestination("Serres");
        schedule3.setDeparture("Athens");

        schedule4.setDestination("Oropos");
        schedule4.setDeparture("Athens");

        scheduleList.add(schedule1);
        scheduleList.add(schedule2);
        scheduleList.add(schedule3);
        scheduleList.add(schedule4);

    }

    /**
     * Saving a new schedule.
     *
     * This method saves a new schedule in the database.
     */
    @Test
    public void save() {
        Schedule schedule5 = new Schedule();
        schedule5.setDestination("Olimpos");
        schedule5.setDeparture("Athens");

        if(!scheduleList.contains(schedule5)){
            scheduleList.add(schedule5);
        }
        assertTrue(scheduleList.contains(schedule5));
    }

    /**
     * Deleting a schedule;
     *
     * This method deletes a schedule from the database.
     */
    @Test
    public void delete() {
        if(scheduleList.contains(schedule3)){
            scheduleList.remove(schedule3);
        }
        assertTrue(!scheduleList.contains(schedule3));

    }

    /**
     * Finding a specific schedule.
     *
     * This method finds a schedule based on the Schedule destination.
     */
    @Test
    public void find() {
        for(Schedule schedule: scheduleList){
            if(schedule.getDestination().equals("Serres")){
                assertTrue(schedule3.getDestination().equals("Serres"));
                break;
            }
        }
        assertTrue(!(schedule3.getDestination().equals("Nauplio")));
        assertTrue(!(schedule3.getDestination().equals("Naxos")));
        assertTrue(!(schedule3.getDestination().equals("Oropos")));
    }

    /**
     * Finding all the schedules.
     *
     * This method finds and returns all the schedules that are saved in the database.
     * @return all the schedules
     */
    @Test
    public void findAll() {
        for (Schedule schedule : scheduleList) {
            assertTrue(scheduleList.contains(schedule));
        }
        assertTrue(scheduleList.contains(schedule1));
        assertTrue(scheduleList.contains(schedule2));
        assertTrue(scheduleList.contains(schedule3));
        assertTrue(scheduleList.contains(schedule4));

    }
}