package gr.aueb.softeng.project1801.DomainModelTests;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.DomainModel.ScheduleEntry;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;

public class TestScheduleEntry {

    private SystemCalendar calendar;
    private String DepartureTime;
    private int DayOfWeek;

    /**
     * Initializing a SystemCalendar object.
     *
     * This method creates a SystemCalendar object and sets values to it.
     */
    @Before
    public void SetUp(){
        calendar = new SystemCalendar(2018,4,25);
        DepartureTime = "9:00AM";
        DayOfWeek = calendar.getDayOfMonth();
    }

    /**
     * Creating ScheduleEntry.
     *
     * This method creates a ScheduleEntry object and sets values to it.
     */
    @Test
    public void createScheduleEntry(){
        ScheduleEntry entry = new ScheduleEntry();
        entry.setCalendar(calendar);
        entry.setDepartureTime(DepartureTime);
    }

    /**
     * Creating from ScheduleEntry.
     *
     * This method creates a ScheduleEntry object and sets values to it.
     */
    @Test
    public void createFormSceduleEntry(){
        ScheduleEntry entry = new ScheduleEntry("9;00AM", new SystemCalendar(2018,4,25));
    }

    /** Returns DayOfweek passed to the constructor.  */
    @Test
    public void getterDayOfWeek(){
        ScheduleEntry entry = new ScheduleEntry();
        entry.setCalendar(calendar);
        entry.setDepartureTime(DepartureTime);
        Assert.assertEquals(25,entry.getDayOfWeek());
    }

    /** Returns DepartureTime passed to the constructor.  */
    @Test
    public void getterDepartureTime(){
        ScheduleEntry entry = new ScheduleEntry();
        entry.setCalendar(calendar);
        entry.setDepartureTime(DepartureTime);
        Assert.assertEquals("9:00AM",entry.getDepartureTime());
    }

    /** Returns calendar passed to the constructor.  */
    @Test
    public void getterCalendar(){
        ScheduleEntry entry = new ScheduleEntry();
        entry.setCalendar(calendar);
        entry.setDepartureTime(DepartureTime);
        Assert.assertEquals(2018,calendar.getYear());
        Assert.assertEquals(4,calendar.getMonth());
        Assert.assertEquals(25,calendar.getDayOfMonth());
    }

}
