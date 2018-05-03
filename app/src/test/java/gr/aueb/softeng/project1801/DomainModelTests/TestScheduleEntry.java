package gr.aueb.softeng.project1801.DomainModelTests;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.ScheduleEntry;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;

/**
 * Created by George Chatzopoulos on 04/25/2018.
 */

public class TestScheduleEntry {

    private SystemCalendar calendar;
    private String DepartureTime;
    private int DayOfWeek;

    @Before
    public void SetUp(){
        calendar = new SystemCalendar(2018,4,25);
        DepartureTime = "9:00AM";
        DayOfWeek = calendar.getDayOfMonth();
    }


    @Test
    public void createScheduleEntry(){
        ScheduleEntry entry = new ScheduleEntry();
        entry.setCalendar(calendar);
        entry.setDepartureTime(DepartureTime);
    }

    @Test
    public void createFormSceduleEntry(){
        ScheduleEntry entry = new ScheduleEntry("9;00AM", new SystemCalendar(2018,4,25));
    }

    @Test
    public void getterDayOfWeek(){
        ScheduleEntry entry = new ScheduleEntry();
        entry.setCalendar(calendar);
        entry.setDepartureTime(DepartureTime);
        Assert.assertEquals(25,entry.getDayOfWeek());
    }

    @Test
    public void getterDepartureTime(){
        ScheduleEntry entry = new ScheduleEntry();
        entry.setCalendar(calendar);
        entry.setDepartureTime(DepartureTime);
        Assert.assertEquals("9:00AM",entry.getDepartureTime());
    }

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
