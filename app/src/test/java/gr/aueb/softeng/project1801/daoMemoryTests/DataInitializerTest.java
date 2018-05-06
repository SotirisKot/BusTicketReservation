package gr.aueb.softeng.project1801.daoMemoryTests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Bus;
import gr.aueb.softeng.project1801.DomainModel.Card;
import gr.aueb.softeng.project1801.DomainModel.Driver;
import gr.aueb.softeng.project1801.DomainModel.Passenger;
import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.DomainModel.Schedule;
import gr.aueb.softeng.project1801.dao.BusDAO;
import gr.aueb.softeng.project1801.memorydao.BusDAOMemory;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;

import static org.junit.Assert.*;

public class DataInitializerTest {

    private Bus bus;
    private List<Bus> busList;
    private Card card;
    private Driver driver;
    private Passenger passenger;
    private Route route;
    private Schedule schedule;
    private DataInitializer dataInitializer;
    private BusDAO busDAO;

    @Before
    public void setUp(){

        bus = new Bus();
        busList = new ArrayList<>();
        busList.add(bus);

        card = new Card();
        driver = new Driver();
        passenger = new Passenger();
        route = new Route();
        schedule = new Schedule();
        dataInitializer = new DataInitializer();
    }

    @Test
    public void eraseData() {

        assertTrue(busList.contains(bus));

        dataInitializer.getBusData().delete(bus);
        dataInitializer.getCardData().delete(card);
        dataInitializer.getDriverData().delete(driver);
        dataInitializer.getPassengerData().delete(passenger);
        dataInitializer.getRouteData().delete(route);
        dataInitializer.getScheduleData().delete(schedule);

        assertTrue(busList.contains(bus));

        //  assertTrue(bus == null);


    }

}