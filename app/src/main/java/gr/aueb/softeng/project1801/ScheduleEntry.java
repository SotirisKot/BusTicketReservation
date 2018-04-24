package gr.aueb.softeng.project1801;

import android.support.annotation.NonNull;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by George Chatzopoulos on 04/22/2018.
 */

public class ScheduleEntry implements Comparable<ScheduleEntry>{

    private Calendar DayOfWeek;
    private Calendar DepartureTime;


    public ScheduleEntry(Calendar DayOfWeek,Calendar DepartureTime){
        this.DayOfWeek = DayOfWeek;
        this.DepartureTime = DepartureTime;
    }

    public Calendar getDayOfWeek() {
        return DayOfWeek;
    }

    public void setDayOfWeek(Calendar dayOfWeek) {
        DayOfWeek = dayOfWeek;
    }

    public Calendar getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(Calendar departureTime) {
        DepartureTime = departureTime;
    }

    public void findNextRoute(Set<Route> schedule) {
        if(!schedule.isEmpty()){

        }else{
            System.out.println("Empty Schedule!");
        }
    }

    @Override
    public int compareTo(ScheduleEntry other) {
        if(this.getDayOfWeek().before(other.getDayOfWeek())
                && this.getDepartureTime().before(other.getDepartureTime())){
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScheduleEntry that = (ScheduleEntry) o;

        if (DayOfWeek != null ? !DayOfWeek.equals(that.DayOfWeek) : that.DayOfWeek != null)
            return false;
        return DepartureTime != null ? DepartureTime.equals(that.DepartureTime) : that.DepartureTime == null;
    }

    @Override
    public int hashCode() {
        int result = DayOfWeek != null ? DayOfWeek.hashCode() : 0;
        result = 13 * result + (DepartureTime != null ? DepartureTime.hashCode() : 0);
        return result;
    }
}
