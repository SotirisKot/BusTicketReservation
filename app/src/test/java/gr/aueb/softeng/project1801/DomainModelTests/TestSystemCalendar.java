package gr.aueb.softeng.project1801.DomainModelTests;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;

/**
 * Created by George Chatzopoulos on 04/25/2018.
 */

public class TestSystemCalendar {


    /**
     * Checking specific date.
     *
     * @param date must be an object
     * This method checks if the values of a SystemCalendar object matches to a specific date,month,year.
     */
    private void assert1stApril2018(SystemCalendar date) {
        Assert.assertEquals(2018, date.getYear() );
        Assert.assertEquals(4,date.getMonth());
        Assert.assertEquals(1, date.getDayOfMonth());
    }

    /**
     * Creating SystemCalendar object.
     *
     * This method creates a SystemCalendar object, sets values to it and tries to check it's realiability.
     */
    @Test
    public void creation() {
        SystemCalendar april_1_2018 = new SystemCalendar(2018, 4 , 1);
        assert1stApril2018(april_1_2018);
    }

    /**
     * Creating SystemCalendar object from a Calendar object.
     *
     * This method creates a Calendar,SystemCalendar object, sets values to the first object and then tries to set values to the second object(getting information from the first one) and finally tries to check it's realiability.
     */
    @Test
    public void creationFormCalendar() {
        Calendar date = Calendar.getInstance();
        date.set(2018,Calendar.APRIL,1);
        SystemCalendar april_1_2018 = new SystemCalendar(date);
        assert1stApril2018(april_1_2018);
    }

    /**
     * Checking SystemCalendar object reliability.
     *
     * This method creates a SystemCalendar object, sets values to it and tries to check it's values with a specific date,month,year.
     */
    @Test
    public void preserveDateInvirant() {
        SystemCalendar date = new SystemCalendar(2018, 4, 1);
        assert1stApril2018(date);
    }

    /**
     * Adding days.
     *
     * This method creates two SystemCalendar objects, sets values to them and tries to add a day to the second object.Finally tries to check their equality.
     */
    @Test
    public void addDays() {
        SystemCalendar date = new SystemCalendar(2018, 3, 31);
        SystemCalendar april_1_2018 = date.addDays(1);
        assert1stApril2018(april_1_2018);
        Assert.assertFalse(date.equals(april_1_2018));
    }

    /**
     * Comparing SystemCalendar objects.
     *
     * This method creates some SystemCalendar objects, sets values to them and tries to compare each other.
     */
    @Test
    public void beforeAndAfter() {
        SystemCalendar date = new SystemCalendar(2018, 4, 1);

        Assert.assertTrue(date.before(new SystemCalendar(2018, 4, 2)));
        Assert.assertTrue(date.compareTo(new SystemCalendar(2018, 4, 2)) < 0);

        Assert.assertTrue(date.after(new SystemCalendar(2018, 3, 31)));
        Assert.assertTrue(date.compareTo(new SystemCalendar(2018, 3, 31)) > 0);

        Assert.assertFalse(date.after(new SystemCalendar(2018, 4, 1)));
        Assert.assertFalse(date.before(new SystemCalendar(2018, 4, 1)));
        Assert.assertEquals(0, date.compareTo(new SystemCalendar(2018, 4, 1)));
    }

    /**
     * Getting JavaCalendar.
     *
     * This method creates a SystemCalendar,Calendar object, sets values to them and tries to check their values.
     */
    @Test
    public void getJavaCalendar() {
        SystemCalendar date = new SystemCalendar(2018, 4, 1);
        Calendar javaDate = date.getJavaCalendar();

        Assert.assertEquals(2018, javaDate.get(Calendar.YEAR));
        Assert.assertEquals(Calendar.APRIL, javaDate.get(Calendar.MONTH));
        Assert.assertEquals(1, javaDate.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(0, javaDate.get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(0, javaDate.get(Calendar.MINUTE));
        Assert.assertEquals(0, javaDate.get(Calendar.SECOND));
        Assert.assertEquals(0, javaDate.get(Calendar.MILLISECOND));
    }

    /**
     * Testing duration.
     *
     * This method creates two SystemCalendar objects, sets values to them and tries to check their durations.
     */
    @Test
    public void duration() {
        SystemCalendar march_31_2018 = new SystemCalendar(2018, 3, 31);
        SystemCalendar april_1_2018 = new SystemCalendar(2018, 4, 1);

        Assert.assertEquals(0, march_31_2018.durationInDays(new SystemCalendar(2018, 3, 31)));
        Assert.assertEquals(1, march_31_2018.durationInDays(april_1_2018));
        Assert.assertEquals(-1, april_1_2018.durationInDays(march_31_2018));
    }

}
