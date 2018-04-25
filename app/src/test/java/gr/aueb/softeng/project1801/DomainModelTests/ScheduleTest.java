package gr.aueb.softeng.project1801.DomainModelTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import gr.aueb.softeng.project1801.Bus;
import gr.aueb.softeng.project1801.BusState;
import gr.aueb.softeng.project1801.Driver;
import gr.aueb.softeng.project1801.DriverState;
import gr.aueb.softeng.project1801.Route;
import gr.aueb.softeng.project1801.Schedule;
import gr.aueb.softeng.project1801.ScheduleEntry;
import gr.aueb.softeng.project1801.SystemCalendar;


//
/**
 * Created by George Chatzopoulos on 04/24/2018.
 */

public class ScheduleTest {

     Set<String> Destinations = new HashSet<>();
     Set<String> DeparturePoints = new HashSet<>();
     Set<String> DepartureTimes = new HashSet<>();
     Set<SystemCalendar> DepartureDates = new HashSet<>();
     Calendar date;
     Calendar time;
     Calendar selectedDate;
     String Destination;
     String Departure;
     Set<Route> routes = new HashSet<>();
     Set<ScheduleEntry> ScheduleEntry = new HashSet<>();
     Bus bus;
     Driver driver;
     SystemCalendar calendar1,calendar2,calendar3,calendar4;
     Route route1,route2,route3,route4,route5;

     @Before
    public void setUp(){

         Destinations.add("Athens");
         Destinations.add("Patra");
         Destinations.add("Nauplio");
         Destinations.add("Argos");

         DeparturePoints.add("Athens");
         DeparturePoints.add("Patra");
         DeparturePoints.add("Nauplio");
         DeparturePoints.add("Argos");

         DepartureTimes.add("9:00AM");
         DepartureTimes.add("11:00AM");
         DepartureTimes.add("14:00PM");
         DepartureTimes.add("21:00PM");

         calendar1 = new SystemCalendar(2018,4,23);
         calendar2 = new SystemCalendar(2018,4,12);
         calendar3 = new SystemCalendar(2018,4,30);
         calendar4 = new SystemCalendar(2018,5,1);

         DepartureDates.add(calendar1);
         DepartureDates.add(calendar2);
         DepartureDates.add(calendar3);
         DepartureDates.add(calendar4);

         Destination = "Patra";
         Departure = "Athens";

         bus = new Bus("Type1", "Mercendes", "AR1314",50);
         driver = new Driver("Anastasios Lepipas", "AL1997");


         route1 = new Route("Athens","9:00AM","Nafplio", calendar1,
                 "10:00PM",bus,driver);
         route2 = new Route("Patra","9:00AM","Athens",calendar2,
                 "11:00PM",bus,driver);
         route3 = new Route("Argos","9:00AM","Nauplio",calendar3,
                 "15:00PM",bus,driver);
         route4 = new Route("Athens","21:00PM","Argos",calendar4,
                 "22:30PM",bus,driver);


     }

    @After
    public void tearDown(){ }

    @Test
    public void TestAddNewRoute(){
        Schedule sc = new Schedule();
        sc.setDestinations(Destinations);
        sc.setDepartureDates(DepartureDates);
        sc.setDepartureTimes(DepartureTimes);
        sc.setDeparturePoints(DeparturePoints);
        sc.addNewRoute(route1);
        Assert.assertTrue(route1!=null);
        sc.addNewRoute(route2);
        Assert.assertTrue(route2!=null);
        sc.addNewRoute(route3);
        Assert.assertTrue(route3!=null);
        sc.addNewRoute(route4);
        Assert.assertTrue(route4!=null);
    }

    @Test
    public void TestAddNewRouteWithNullRoute(){
        Schedule sc = new Schedule();
        sc.setDestinations(Destinations);
        sc.setDepartureDates(DepartureDates);
        sc.setDepartureTimes(DepartureTimes);
        sc.setDeparturePoints(DeparturePoints);
        sc.addNewRoute(route5);
        Assert.assertTrue(route5==null);
    }

    @Test
    public void TestDeleteRoute(){
        Schedule sc = new Schedule();
        sc.setDestinations(Destinations);
        sc.setDepartureDates(DepartureDates);
        sc.setDepartureTimes(DepartureTimes);
        sc.setDeparturePoints(DeparturePoints);
        sc.addNewRoute(route1);
        Assert.assertTrue(route1!=null);
        sc.addNewRoute(route2);
        Assert.assertTrue(route2!=null);
        sc.addNewRoute(route3);
        Assert.assertTrue(route3!=null);
        sc.addNewRoute(route4);
        Assert.assertTrue(route4!=null);
        sc.deleteRoute(route1);
        Assert.assertTrue(route1!=null);
        sc.deleteRoute(route2);
        Assert.assertTrue(route2!=null);
        sc.deleteRoute(route3);
        Assert.assertTrue(route3!=null);
        sc.deleteRoute(route4);
        Assert.assertTrue(route4!=null);
    }

    @Test
    public void TestDeleteNullRoute(){
        Schedule sc = new Schedule();
        sc.setDestinations(Destinations);
        sc.setDepartureDates(DepartureDates);
        sc.setDepartureTimes(DepartureTimes);
        sc.setDeparturePoints(DeparturePoints);
        sc.addNewRoute(route5);
        sc.deleteRoute(route5);
        Assert.assertTrue(route5==null);
    }

    @Test
    public void TestCreateRouteWithValidInfo(){
        Schedule sc = new Schedule();
        sc.setDestinations(Destinations);
        sc.setDeparturePoints(DeparturePoints);
        sc.setDepartureTimes(DepartureTimes);
        sc.setDepartureDates(DepartureDates);

        Assert.assertTrue(sc.getDestinations().contains("Athens"));
        Assert.assertTrue(sc.getDeparturePoints().contains("Patra"));
        Assert.assertTrue(sc.getDepartureTimes().contains("9:00AM"));
        Assert.assertTrue(sc.getDepartureDates().contains(calendar1));


        bus.available();
        driver.available();

        Route route = sc.createRoute("Athens","Patra","9:00AM",calendar1
                ,"11:30AM",bus,driver);

        Assert.assertTrue(route!=null);

    }

    @Test
    public void TestCreateRouteWithWrongDestination(){
        Schedule sc = new Schedule();
        sc.setDestinations(Destinations);
        sc.setDeparturePoints(DeparturePoints);
        sc.setDepartureTimes(DepartureTimes);
        sc.setDepartureDates(DepartureDates);


        Assert.assertTrue(!(sc.getDestinations().contains("Athe")));
        Assert.assertTrue(sc.getDeparturePoints().contains("Patra"));
        Assert.assertTrue(sc.getDepartureTimes().contains("9:00AM"));
        Assert.assertTrue(sc.getDepartureDates().contains(calendar1));

        bus.available();
        driver.available();

        Route route = sc.createRoute("Athe","Patra","9:00AM",calendar1
                ,"11:30AM",bus,driver);

        Assert.assertTrue(route == null);
    }

    @Test
    public void TestCreateRouteWithWrongDeparturePoint(){
        Schedule sc = new Schedule();
        sc.setDestinations(Destinations);
        sc.setDeparturePoints(DeparturePoints);
        sc.setDepartureTimes(DepartureTimes);
        sc.setDepartureDates(DepartureDates);


        Assert.assertTrue(sc.getDestinations().contains("Athens"));
        Assert.assertTrue(!(sc.getDeparturePoints().contains("Petra")));
        Assert.assertTrue(sc.getDepartureTimes().contains("9:00AM"));
        Assert.assertTrue(sc.getDepartureDates().contains(calendar1));

        bus.available();
        driver.available();

        Route route = sc.createRoute("Athens","Petra","9:00AM",calendar1
                ,"11:30PM",bus,driver);

        Assert.assertTrue(route == null);

    }


    @Test
    public void TestCreateRouteWithWrongDepartureTime(){
        Schedule sc = new Schedule();
        sc.setDestinations(Destinations);
        sc.setDeparturePoints(DeparturePoints);
        sc.setDepartureTimes(DepartureTimes);
        sc.setDepartureDates(DepartureDates);



        Assert.assertTrue(sc.getDestinations().contains("Athens"));
        Assert.assertTrue(sc.getDeparturePoints().contains("Patra"));
        Assert.assertTrue(!(sc.getDepartureTimes().contains("20:00PM")));
        Assert.assertTrue(sc.getDepartureDates().contains(calendar1));

        bus.available();
        driver.available();


        Route route = sc.createRoute("Athens","Patra","20:00PM",calendar1
                ,"11:30PM",bus,driver);

        Assert.assertTrue(route == null);

    }

    @Test
    public void TestCreateRouteWithWrongDepartureDate(){
        Schedule sc = new Schedule();
        sc.setDestinations(Destinations);
        sc.setDeparturePoints(DeparturePoints);
        sc.setDepartureTimes(DepartureTimes);
        sc.setDepartureDates(DepartureDates);
        SystemCalendar calendar = new SystemCalendar(2018,4,29);

        Assert.assertTrue(sc.getDestinations().contains("Athens"));
        Assert.assertTrue(sc.getDeparturePoints().contains("Patra"));
        Assert.assertTrue(sc.getDepartureTimes().contains("9:00AM"));
        Assert.assertTrue(!(sc.getDepartureDates().contains(calendar)));

        bus.available();
        driver.available();

        Route route = sc.createRoute("Athens","Patra","9:00AM",calendar
                ,"11:30PM",bus,driver);
        Assert.assertTrue(route == null);

    }

    @Test
    public void TestCreateRouteWithInavailableBus(){
        Schedule sc = new Schedule();
        sc.setDestinations(Destinations);
        sc.setDeparturePoints(DeparturePoints);
        sc.setDepartureTimes(DepartureTimes);
        sc.setDepartureDates(DepartureDates);
        bus.not_available();

        Assert.assertTrue(sc.getDestinations().contains("Athens"));
        Assert.assertTrue(sc.getDeparturePoints().contains("Patra"));
        Assert.assertTrue(sc.getDepartureTimes().contains("9:00AM"));
        Assert.assertTrue(sc.getDepartureDates().contains(calendar1));
        Assert.assertTrue(bus.getState() != BusState.AVAILABLE);

        Route route = sc.createRoute("Athens","Patra","9:00AM",calendar1
                ,"11:30PM",bus,driver);

        Assert.assertTrue(route == null);

    }

    @Test
    public void TestCreateRouteWithInavailableDriver(){
        Schedule sc = new Schedule();
        sc.setDestinations(Destinations);
        sc.setDeparturePoints(DeparturePoints);
        sc.setDepartureTimes(DepartureTimes);
        sc.setDepartureDates(DepartureDates);
        driver.not_available();

        Assert.assertTrue(sc.getDestinations().contains("Athens"));
        Assert.assertTrue(sc.getDeparturePoints().contains("Patra"));
        Assert.assertTrue(sc.getDepartureTimes().contains("9:00AM"));
        Assert.assertTrue(sc.getDepartureDates().contains(calendar1));
        Assert.assertTrue(bus.getState() == BusState.AVAILABLE);
        Assert.assertTrue(driver.getState() != DriverState.AVAILABLE);

        Route route = sc.createRoute("Athens","Patra","9:00AM",calendar1
                ,"11:30PM",bus,driver);

        Assert.assertTrue(route == null);

    }

    @Test
    public void TestFindNextAvailableDateWhenSlotTaken() {
        Schedule sc = new Schedule();
        sc.setDepartureDates(DepartureDates);
        sc.setDeparturePoints(DeparturePoints);
        sc.setDestinations(Destinations);
        sc.setDestination(Destination);
        sc.setDepartureTimes(DepartureTimes);
        sc.addNewRoute(route1);
        sc.addNewRoute(route2);
        sc.addNewRoute(route3);
        sc.addNewRoute(route4);

        SystemCalendar calendar = new SystemCalendar(2018,4,23);
        ScheduleEntry entry = new ScheduleEntry("9:00AM",calendar);

        ScheduleEntry AvailableEntry = sc.findNextAvailableDate(entry);

        Assert.assertTrue(AvailableEntry != null);
        Assert.assertEquals(7,AvailableEntry.getDayOfWeek());

    }

    @Test
    public void TestFindNextAvailableDateWhenSlotAvailable() {
        Schedule sc = new Schedule();
        sc.setDepartureDates(DepartureDates);
        sc.setDeparturePoints(DeparturePoints);
        sc.setDestinations(Destinations);
        sc.setDestination(Destination);
        sc.setDepartureTimes(DepartureTimes);
        sc.addNewRoute(route1);
        sc.addNewRoute(route2);
        sc.addNewRoute(route3);
        sc.addNewRoute(route4);

        SystemCalendar calendar = new SystemCalendar(2018,4,2);
        ScheduleEntry entry = new ScheduleEntry("9:00AM",calendar);

        ScheduleEntry AvailableEntry = sc.findNextAvailableDate(entry);

        Assert.assertTrue(AvailableEntry != null);
        Assert.assertEquals(2,AvailableEntry.getDayOfWeek());
    }


}
