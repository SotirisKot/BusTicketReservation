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

    private String DayOfWeek;
    private Calendar DepartureTime;
    private Schedule sc;

    public ScheduleEntry(String DayOfWeek,Calendar DepartureTime){
        this.DayOfWeek = DayOfWeek;
        this.DepartureTime = DepartureTime;
    }

    public String getDayOfWeek() {
        return DayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        DayOfWeek = dayOfWeek;
    }

    public Calendar getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(Calendar departureTime) {
        DepartureTime = departureTime;
    }

    public Calendar findNextRoute(Calendar date, Calendar time) throws ParseException {
        String input_date = Format(date);
        boolean hasDate = false;
        HashMap<String,Calendar> dates = new HashMap<String,Calendar>();
        sc.getRoutes();
        Calendar finalDate = null;
        finalDate.set(0,0,0);

        for(Route i : sc.getRoutes()){
            if((i.getDepartureDate().equals(date) && i.getDepartureTime().equals(time) && input_date.equals(Format(i.getDepartureDate())))){
                System.out.println("I already have a route that date");
                hasDate = false;
            }else{
                System.out.println("Empty day");
                hasDate = true;
                finalDate = i.getDepartureDate();
                break;
            }
            if(hasDate == false && input_date.equals(Format(i.getDepartureDate()))){
                if(i.getDepartureTime().equals(time)){
                    continue;
                }else{
                    finalDate = i.getDepartureDate();
                    hasDate = true;
                    break;
                }
            }

        }

        return finalDate;
    }

    public String Format(Calendar date) throws ParseException {
        String input_date=date.toString();
        SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
        Date dt1=format1.parse(input_date);
        DateFormat format2=new SimpleDateFormat("EEEE");
        String finalDay=format2.format(dt1);

        return finalDay;
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
