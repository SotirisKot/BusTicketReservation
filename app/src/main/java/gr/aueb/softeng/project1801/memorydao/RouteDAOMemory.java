package gr.aueb.softeng.project1801.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.Route;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.RouteDAO;

public class RouteDAOMemory implements RouteDAO {

    protected static List<Route> entities = new ArrayList<Route>();

    public void save(Route route){
        if(!entities.contains(route)){
            entities.add(route);
        }
    }

    public void delete(Route route){
        entities.remove(route);
    }

    public Route find(String destination, String departureTime, String departurePoint, SystemCalendar departureDate){
        for(Route route: entities){
            if(route.getDestination().equals(destination) && route.getDepartureTime().equals(departureTime) &&
                    route.getDeparturePoint().equals(departurePoint) && route.getDepartureDate().equals(departureDate)){
                return route;
            }
        }
        return null;
    }

    public List<Route> findAll(){
        return new ArrayList<>(entities);
    }

}
