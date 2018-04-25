package gr.aueb.softeng.project1801;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by George Chatzopoulos on 04/22/2018.
 */

public class ScheduleEntry {

    private int DayOfWeek;
    private String DepartureTime;
    private SystemCalendar calendar;

    public ScheduleEntry() { }

    public ScheduleEntry(String DepartureTime,SystemCalendar calendar){
        this.DayOfWeek = calendar.getDayOfMonth();
        this.DepartureTime = DepartureTime;
        this.calendar = calendar;
    }

    public int getDayOfWeek() {
        return DayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        DayOfWeek = dayOfWeek;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }

    public SystemCalendar getCalendar(){
        return calendar;
    }

    public void setCalendar(SystemCalendar calendar) {
        this.calendar = calendar;
        this.DayOfWeek = calendar.getDayOfMonth();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScheduleEntry that = (ScheduleEntry) o;

        if (DayOfWeek != 0 ? DayOfWeek != (that.DayOfWeek) : that.DayOfWeek != 0)
            return false;
        return DepartureTime != null ? DepartureTime.equals(that.DepartureTime) : that.DepartureTime == null;
    }

    @Override
    public int hashCode() {
        int result = DayOfWeek;
        result = 13 * result + (DepartureTime != null ? DepartureTime.hashCode() : 0);
        return result;
    }
}
