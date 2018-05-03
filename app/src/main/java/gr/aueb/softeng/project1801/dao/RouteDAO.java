package gr.aueb.softeng.project1801.dao;

import java.util.List;

import gr.aueb.softeng.project1801.Route;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;

public interface RouteDAO {

    //finds a route based on the details given
    Route find(String destination, String departureTime, String departurePoint, SystemCalendar departureDate);

    //saves a route
    void save(Route route);

    //deletes a route
    void delete(Route route);

    //returns all the routes
    List<Route> findAll();
}
