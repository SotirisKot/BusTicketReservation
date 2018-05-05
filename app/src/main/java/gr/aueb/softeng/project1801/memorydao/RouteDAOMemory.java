package gr.aueb.softeng.project1801.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.Route;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.RouteDAO;

public class RouteDAOMemory implements RouteDAO {

    protected static List<Route> entities = new ArrayList<Route>();

    /**
     * This method saves a route in the database.
     * @param route ,the route
     */
    public void save(Route route){
        if(!entities.contains(route)){
            entities.add(route);
        }
    }

    /**
     * This method deletes a route from the database.
     * @param route ,the route
     */
    public void delete(Route route){
        entities.remove(route);
    }

    /**
     * This method finds a route based on the details given.
     * @param destination ,the destination
     * @param departureTime ,the departure time
     * @param departurePoint ,the departure point
     * @param departureDate , the departure date
     * @return the route that is found or null
     */
    public Route find(String destination, String departureTime, String departurePoint, SystemCalendar departureDate){
        for(Route route: entities){
            if(route.getDestination().equals(destination) && route.getDepartureTime().equals(departureTime) &&
                    route.getDeparturePoint().equals(departurePoint) && route.getDepartureDate().equals(departureDate)){
                return route;
            }
        }
        return null;
    }

    /**
     * This method finds and returns all the routes that are saved in the database.
     * @return all the routes
     */
    public List<Route> findAll(){
        return new ArrayList<>(entities);
    }

}
