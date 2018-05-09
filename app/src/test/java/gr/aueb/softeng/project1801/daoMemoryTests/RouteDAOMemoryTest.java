package gr.aueb.softeng.project1801.daoMemoryTests;

import org.junit.Before;
import org.junit.Test;


import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.RouteDAO;
import gr.aueb.softeng.project1801.memorydao.RouteDAOMemory;

import static org.junit.Assert.*;

public class RouteDAOMemoryTest {

    private Route route1 = new Route();
    private Route route2 = new Route();
    private Route route3 = new Route();
    private Route route4 = new Route();
    private RouteDAO routeDAO;


    /**
     * Initializing data.
     *
     * This method initializes the training data.
     */
    @Before
    public void setUp(){
        route1.setDestination("Nauplio");
        route1.setDepartureTime("12:00");

        route2.setDestination("Naxos");
        route2.setDepartureTime("10:00");

        route3.setDestination("Serres");
        route3.setDepartureTime("9:00");

        route4.setDestination("Oropos");
        route4.setDepartureTime("13:00");

        routeDAO = new RouteDAOMemory();
        routeDAO.save(route1);
        routeDAO.save(route2);
        routeDAO.save(route3);
        routeDAO.save(route4);

    }

    /**
     * Saving a new route.
     *
     * This method saves a new route in the database.
     */
    @Test
    public void save() {
        Route route5 = new Route();
        route5.setDestination("Olimpos");
        route5.setDepartureTime("10:00");
        routeDAO.save(route5);
        assertTrue(routeDAO.findAll().contains(route5));

    }

    /**
     * Deleting a route;
     *
     * This method deletes a route from the database.
     */
    @Test
    public void delete() {
        Route route5 = new Route();
        route5.setDestination("Olimpos");
        route5.setDepartureTime("10:00");
        routeDAO.save(route5);
        routeDAO.delete(route5);
        assertTrue(!routeDAO.findAll().contains(route5));

    }

    /**
     * Finding a specific route.
     *
     * This method finds a route based on the Route destination.
     */
    @Test
    public void find() {
        Route route5 = new Route();
        route5.setDestination("Olimpos");
        route5.setDepartureTime("10:00");
        route5.setDeparturePoint("Athens");
        SystemCalendar systemCalendar = new SystemCalendar(18,6,15);
        route5.setDepartureDate(systemCalendar);
        routeDAO.save(route5);
        assertTrue(routeDAO.find("Olimpos","10:00","Athens",systemCalendar).equals(route5));

    }

    /**
     * Finding all the routes.
     *
     * This method finds and returns all the routes that are saved in the database.
     * @return all the routes
     */
    @Test
    public void findAll() {
        assertTrue(routeDAO.findAll().contains(route1));
        assertTrue(routeDAO.findAll().contains(route2));
        assertTrue(routeDAO.findAll().contains(route3));
        assertTrue(routeDAO.findAll().contains(route4));
        assertTrue(routeDAO.findAll().size() == 4);

    }
}