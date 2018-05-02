package gr.aueb.softeng.project1801;

import gr.aueb.softeng.project1801.SysCalendar.SystemCalendar;


public class ScheduleEntry {

    private int DayOfWeek;
    private String DepartureTime;
    private SystemCalendar calendar;

    /**
     *
     * Default constructor,which constructs a ScheduleEntry object.
     */
    public ScheduleEntry() { }

    /**
     *
     * Constructor.
     * @param DepartureTime (required) Departure Time of the Schedule.
     * @param calendar (required) calendar of the Schedule.
     */
    public ScheduleEntry(String DepartureTime,SystemCalendar calendar){
        this.DayOfWeek = calendar.getDayOfMonth();
        this.DepartureTime = DepartureTime;
        this.calendar = calendar;
    }

    /** @return DayOfweek passed to the constructor.  */
    public int getDayOfWeek() {
        return DayOfWeek;
    }

    /**
     *
     * @param dayOfWeek day of Week to set
     */
    public void setDayOfWeek(int dayOfWeek) {
        DayOfWeek = dayOfWeek;
    }

    /** @return DepartureTime passed to the constructor.  */
    public String getDepartureTime() {
        return DepartureTime;
    }

    /**
     *
     * @param departureTime departure Time to set
     */
    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }

    /** @return calendar passed to the constructor.  */
    public SystemCalendar getCalendar(){
        return calendar;
    }

    /**
     *
     * @param calendar calendar to set
     */
    public void setCalendar(SystemCalendar calendar) {
        this.calendar = calendar;
        this.DayOfWeek = calendar.getDayOfMonth();
    }

    /**
     * Comparing two objects.
     *
     * This method checks if two object are the same.
     * @param o must be an object.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScheduleEntry that = (ScheduleEntry) o;

        if (DayOfWeek != 0 ? DayOfWeek != (that.DayOfWeek) : that.DayOfWeek != 0)
            return false;
        return DepartureTime != null ? DepartureTime.equals(that.DepartureTime) : that.DepartureTime == null;
    }

    /**
     * Getting the hashCode of an object.
     *
     * This method checks if two object has the same hasCode.
     * If the method equals returned "true" the hasCode of the two objects must be the same.
     * If the method equals returned "false" the hasCode of the two objects must not be the same.
     */
    @Override
    public int hashCode() {
        int result = DayOfWeek;
        result = 13 * result + (DepartureTime != null ? DepartureTime.hashCode() : 0);
        return result;
    }
}
