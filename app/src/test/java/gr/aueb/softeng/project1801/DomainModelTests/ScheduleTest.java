package gr.aueb.softeng.project1801.DomainModelTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import gr.aueb.softeng.project1801.Bus;
import gr.aueb.softeng.project1801.BusState;
import gr.aueb.softeng.project1801.Driver;
import gr.aueb.softeng.project1801.DriverState;
import gr.aueb.softeng.project1801.Passenger;
import gr.aueb.softeng.project1801.Route;
import gr.aueb.softeng.project1801.Schedule;
import gr.aueb.softeng.project1801.ScheduleEntry;

/**
 * Created by George Chatzopoulos on 04/24/2018.
 */

public class ScheduleTest {

     Set<String> Destinations = new HashSet<>();
     Set<String> DeparturePoints = new HashSet<>();
     Set<String> DepartureTimes = new HashSet<>();
     Set<String> DepartureDates = new HashSet<>();
     Calendar date;
     Calendar time;
     Calendar selectedDate;
     String Destination;
     String Departure;
     Set<Route> routes = new HashSet<>();
     Set<ScheduleEntry> ScheduleEntry = new HashSet<>();
     Bus bus;
     Driver driver;
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

         DepartureDates.add("23-4-2018");
         DepartureDates.add("12-5-2018");
         DepartureDates.add("30-4-2018");
         DepartureDates.add("1-5-2018");

         Destination = "Patra";
         Departure = "Athens";

         bus = new Bus("Type1", "Mercendes", "AR1314",50);
         driver = new Driver("Anastasios Lepipas", "AL1997");

         route1 = new Route("Athens","8:00AM","Nafplio", "2018-4-24",
                 "10:00PM",bus,driver);
         route2 = new Route("Patra","9:00AM","Athens","12-5-2018",
                 "11:00PM",bus,driver);
         route3 = new Route("Argos","14:00PM","Nauplio","1-5-2018",
                 "15:00PM",bus,driver);
         route4 = new Route("Athens","21:00PM","Argos","30-4-2018",
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
        sc.createRoute("Nauplio","Patra","9:00PM","23-4-2018"
                ,"11:30PM",bus,driver);

        Assert.assertTrue(Destinations.contains("Nauplio"));
        Assert.assertTrue(DeparturePoints.contains("Patra"));
        Assert.assertTrue(DepartureTimes.contains("9:00AM")==true);
        Assert.assertTrue(DepartureDates.contains("23-4-2018")==true);
        Assert.assertTrue(bus.getState() == BusState.AVAILABLE);
        Assert.assertTrue(driver.getState() == DriverState.AVAILABLE);


    }









}
