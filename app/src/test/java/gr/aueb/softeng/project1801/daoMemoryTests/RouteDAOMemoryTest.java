package gr.aueb.softeng.project1801.daoMemoryTests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Route;

import static org.junit.Assert.*;

public class RouteDAOMemoryTest {

    private Route route1 = new Route();
    private Route route2 = new Route();
    private Route route3 = new Route();
    private Route route4 = new Route();
    private List<Route> routeList = new ArrayList<>();


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

        routeList.add(route1);
        routeList.add(route2);
        routeList.add(route3);
        routeList.add(route4);

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

        if(!routeList.contains(route5)){
            routeList.add(route5);
        }
        assertTrue(routeList.contains(route5));
    }

    /**
     * Deleting a route;
     *
     * This method deletes a route from the database.
     */
    @Test
    public void delete() {
        if(routeList.contains(route3)){
            routeList.remove(route3);
        }
        assertTrue(!routeList.contains(route3));

    }

    /**
     * Finding a specific route.
     *
     * This method finds a route based on the Route destination.
     */
    @Test
    public void find() {
        for(Route route: routeList){
            if(route.getDestination().equals("Serres")){
                assertTrue(route3.getDestination().equals("Serres"));
                break;
            }
        }
        assertTrue(!(route3.getDestination().equals("Nauplio")));
        assertTrue(!(route3.getDestination().equals("Naxos")));
        assertTrue(!(route3.getDestination().equals("Oropos")));
    }

    /**
     * Finding all the routes.
     *
     * This method finds and returns all the routes that are saved in the database.
     * @return all the routes
     */
    @Test
    public void findAll() {
        for (Route route : routeList) {
            assertTrue(routeList.contains(route));
        }
        assertTrue(routeList.contains(route1));
        assertTrue(routeList.contains(route2));
        assertTrue(routeList.contains(route3));
        assertTrue(routeList.contains(route4));

    }
}