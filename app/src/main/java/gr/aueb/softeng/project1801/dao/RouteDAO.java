package gr.aueb.softeng.project1801.dao;

import java.util.List;

import gr.aueb.softeng.project1801.Route;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;

public interface RouteDAO {

    /**
     * This method finds a route based on the details given.
     * @param destination ,the destination
     * @param departureTime ,the departure time
     * @param departurePoint ,the departure point
     * @param departureDate , the departure date
     * @return the route
     */
    Route find(String destination, String departureTime, String departurePoint, SystemCalendar departureDate);

    /**
     * This method saves a route in the database.
     * @param route ,the route
     */
    void save(Route route);

    /**
     * This method deletes a route from the database.
     * @param route ,the route
     */
    void delete(Route route);

    /**
     * This method finds and return all the routes that are saved in the database.
     * @return all the routes
     */
    List<Route> findAll();
}
