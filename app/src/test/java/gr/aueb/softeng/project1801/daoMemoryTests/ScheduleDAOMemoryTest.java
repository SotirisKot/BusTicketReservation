package gr.aueb.softeng.project1801.daoMemoryTests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gr.aueb.softeng.project1801.DomainModel.Schedule;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.ScheduleDAO;
import gr.aueb.softeng.project1801.memorydao.ScheduleDAOMemory;

import static org.junit.Assert.*;

public class ScheduleDAOMemoryTest {

    private Schedule schedule1 = new Schedule();
    private Schedule schedule2 = new Schedule();
    private Schedule schedule3 = new Schedule();
    private Schedule schedule4 = new Schedule();
    private ScheduleDAO scheduleDAO;
    //private List<Schedule> scheduleList = new ArrayList<>();


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

        scheduleDAO = new ScheduleDAOMemory();
        scheduleDAO.save(schedule1);
        scheduleDAO.save(schedule2);
        scheduleDAO.save(schedule3);
        scheduleDAO.save(schedule4);

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
        scheduleDAO.save(schedule5);
        assertTrue(scheduleDAO.findAll().contains(schedule5));


/*        if(!scheduleList.contains(schedule5)){
            scheduleList.add(schedule5);
        }
        assertTrue(scheduleList.contains(schedule5));*/
    }

    /**
     * Deleting a schedule;
     *
     * This method deletes a schedule from the database.
     */
    @Test
    public void delete() {
        Schedule schedule5 = new Schedule();
        schedule5.setDestination("Olimpos");
        schedule5.setDeparture("Athens");
        scheduleDAO.save(schedule5);
        scheduleDAO.delete(schedule5);
        assertTrue(!scheduleDAO.findAll().contains(schedule5));

      /*  if(scheduleList.contains(schedule3)){
            scheduleList.remove(schedule3);
        }
        assertTrue(!scheduleList.contains(schedule3));*/

    }

    /**
     * Finding a specific schedule.
     *
     * This method finds a schedule based on the Schedule destination.
     */
    @Test
    public void find() {
        Set<String> Destinations = new HashSet<>();
        Set<String> DeparturePoints = new HashSet<>();
        Set<String> DepartureTimes = new HashSet<>();
        Set<SystemCalendar> DepartureDates = new HashSet<>();

        Destinations.add("Athens");
    /*    Destinations.add("Patra");
        Destinations.add("Nauplio");
        Destinations.add("Argos");*/

        DeparturePoints.add("Athens");
/*        DeparturePoints.add("Patra");
        DeparturePoints.add("Nauplio");
        DeparturePoints.add("Argos");*/

        DepartureTimes.add("9:00AM");
     /*   DepartureTimes.add("11:00AM");
        DepartureTimes.add("14:00PM");
        DepartureTimes.add("21:00PM");*/

        SystemCalendar calendar1,calendar2,calendar3,calendar4;

        calendar1 = new SystemCalendar(2018,6,23);
  /*      calendar2 = new SystemCalendar(2018,4,12);
        calendar3 = new SystemCalendar(2018,4,30);
        calendar4 = new SystemCalendar(2018,5,1);*/

        DepartureDates.add(calendar1);
     /*   DepartureDates.add(calendar2);
        DepartureDates.add(calendar3);
        DepartureDates.add(calendar4);*/
        Schedule schedule5 = new Schedule();

        schedule5.setDestination("Olimpos");
       // schedule5.setDeparturePoints("Athens");
        schedule5.setDeparture("Athens");
        schedule5.setDeparturePoints(DeparturePoints);
        schedule5.setDepartureTimes(DepartureTimes);
        schedule5.setDepartureDates(DepartureDates);
        schedule5.setDestinations(Destinations);
        scheduleDAO.save(schedule5);
        assertTrue(scheduleDAO.find(Destinations,DeparturePoints,DepartureTimes,DepartureDates,"Olimpos","Athens").equals(schedule5));

        /*   for(Schedule schedule: scheduleList){
            if(schedule.getDestination().equals("Serres")){
                assertTrue(schedule3.getDestination().equals("Serres"));
                break;
            }
        }
        assertTrue(!(schedule3.getDestination().equals("Nauplio")));
        assertTrue(!(schedule3.getDestination().equals("Naxos")));
        assertTrue(!(schedule3.getDestination().equals("Oropos")));*/
    }

    /**
     * Finding all the schedules.
     *
     * This method finds and returns all the schedules that are saved in the database.
     * @return all the schedules
     */
    @Test
    public void findAll() {
        assertTrue(scheduleDAO.findAll().contains(schedule1));
        assertTrue(scheduleDAO.findAll().contains(schedule2));
        assertTrue(scheduleDAO.findAll().contains(schedule3));
        assertTrue(scheduleDAO.findAll().contains(schedule4));
        assertTrue(scheduleDAO.findAll().size() == 4);


/*        for (Schedule schedule : scheduleList) {
            assertTrue(scheduleList.contains(schedule));
        }
        assertTrue(scheduleList.contains(schedule1));
        assertTrue(scheduleList.contains(schedule2));
        assertTrue(scheduleList.contains(schedule3));
        assertTrue(scheduleList.contains(schedule4));*/

    }
}