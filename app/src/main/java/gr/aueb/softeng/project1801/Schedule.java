package gr.aueb.softeng.project1801;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by George Chatzopoulos on 04/22/2018.
 */

public class Schedule {

    private String Destinations;
    private String DeparturePoints;
    private Calendar DepartureTimes;
    private Calendar DepartureDates;
    private String Destination;
    private String Departure;
    ScheduleEntry entry;
    Set<Route> schedule;
    Set<ScheduleEntry> ScheduleEntry;


    public Schedule(String destinations, String departurePoints, Calendar departureTimes, Calendar departureDates, String destination, String departure) {
        Destinations = destinations;
        DeparturePoints = departurePoints;
        DepartureTimes = departureTimes;
        DepartureDates = departureDates;
        Destination = destination;
        Departure = departure;
    }

    public void addNewRoute(String Destination, String DeparturePoint){

        entry.findNextRoute(getSchedule());

    }

    public void deleteRoute(String Destination, String DeparturePoint){

        for(Route i : schedule){
            if(schedule.equals(Destination)){
                schedule.remove(i);
            }
        }


    }

    Set<Route> getSchedule(){
        return schedule;
    }

    Set<ScheduleEntry> getScheduleEntry(){
        return ScheduleEntry;
    }

    public String getDestinations() {
        return Destinations;
    }

    public void setDestinations(String destinations) {
        Destinations = destinations;
    }

    public String getDeparturePoints() {
        return DeparturePoints;
    }

    public void setDeparturePoints(String departurePoints) {
        DeparturePoints = departurePoints;
    }

    public Calendar getDepartureTimes() {
        return DepartureTimes;
    }

    public void setDepartureTimes(Calendar departureTimes) {
        DepartureTimes = departureTimes;
    }

    public Calendar getDepartureDates() {
        return DepartureDates;
    }

    public void setDepartureDates(Calendar departureDates) {
        DepartureDates = departureDates;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
        Departure = departure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule1 = (Schedule) o;

        if (Destinations != null ? !Destinations.equals(schedule1.Destinations) : schedule1.Destinations != null)
            return false;
        if (DeparturePoints != null ? !DeparturePoints.equals(schedule1.DeparturePoints) : schedule1.DeparturePoints != null)
            return false;
        if (DepartureTimes != null ? !DepartureTimes.equals(schedule1.DepartureTimes) : schedule1.DepartureTimes != null)
            return false;
        if (DepartureDates != null ? !DepartureDates.equals(schedule1.DepartureDates) : schedule1.DepartureDates != null)
            return false;
        if (Destination != null ? !Destination.equals(schedule1.Destination) : schedule1.Destination != null)
            return false;
        if (Departure != null ? !Departure.equals(schedule1.Departure) : schedule1.Departure != null)
            return false;
        if (entry != null ? !entry.equals(schedule1.entry) : schedule1.entry != null) return false;
        if (schedule != null ? !schedule.equals(schedule1.schedule) : schedule1.schedule != null)
            return false;
        return ScheduleEntry != null ? ScheduleEntry.equals(schedule1.ScheduleEntry) : schedule1.ScheduleEntry == null;
    }

    @Override
    public int hashCode() {
        int result = Destinations != null ? Destinations.hashCode() : 0;
        result = 31 * result + (DeparturePoints != null ? DeparturePoints.hashCode() : 0);
        result = 31 * result + (DepartureTimes != null ? DepartureTimes.hashCode() : 0);
        result = 31 * result + (DepartureDates != null ? DepartureDates.hashCode() : 0);
        result = 31 * result + (Destination != null ? Destination.hashCode() : 0);
        result = 31 * result + (Departure != null ? Departure.hashCode() : 0);
        result = 31 * result + (entry != null ? entry.hashCode() : 0);
        result = 31 * result + (schedule != null ? schedule.hashCode() : 0);
        result = 31 * result + (ScheduleEntry != null ? ScheduleEntry.hashCode() : 0);
        return result;
    }
}
