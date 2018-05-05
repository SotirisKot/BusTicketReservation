package gr.aueb.softeng.project1801.memorydao;

import gr.aueb.softeng.project1801.DomainModel.Bus;
import gr.aueb.softeng.project1801.DomainModel.Card;
import gr.aueb.softeng.project1801.DomainModel.Driver;
import gr.aueb.softeng.project1801.DomainModel.Passenger;
import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.DomainModel.Schedule;
import gr.aueb.softeng.project1801.dao.BusDAO;
import gr.aueb.softeng.project1801.dao.CardDAO;
import gr.aueb.softeng.project1801.dao.DriverDAO;
import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.dao.PassengerDAO;
import gr.aueb.softeng.project1801.dao.RouteDAO;
import gr.aueb.softeng.project1801.dao.ScheduleDAO;

public class DataInitializer extends Initializer{

    /**
     * This method deletes all the saved data.
     */
    protected void eraseData(){

        for(Bus bus : getBusData().findAll()){
            getBusData().delete(bus);
        }

        for(Card card : getCardData().findAll()){
            getCardData().delete(card);
        }

        for(Driver driver : getDriverData().findAll()){
            getDriverData().delete(driver);
        }

        for (Passenger passenger : getPassengerData().findAll()){
            getPassengerData().delete(passenger);
        }

        for(Route route : getRouteData().findAll()){
            getRouteData().delete(route);
        }

        for(Schedule schedule : getScheduleData().findAll()){
            getScheduleData().delete(schedule);
        }
    }

    /**
     * This method returns the bus data.
     * @return the bus data
     */
    @Override
    public BusDAO getBusData() {
        return new BusDAOMemory();
    }

    /**
     * This method returns the card data.
     * @return the card data
     */
    @Override
    public CardDAO getCardData() {
        return new CardDAOMemory();
    }

    /**
     * This method returns the driver data.
     * @return the driver data
     */
    @Override
    public DriverDAO getDriverData() {
        return new DriverDAOMemory();
    }

    /**
     * This method returns the passenger data.
     * @return the passenger data
     */
    @Override
    public PassengerDAO getPassengerData() {
        return new PassengerDAOMemory();
    }

    /**
     * This method returns the route data.
     * @return the route data
     */
    @Override
    public RouteDAO getRouteData() {
        return new RouteDAOMemory();
    }

    /**
     * This method returns the schedule data.
     * @return the schedule data
     */
    @Override
    public ScheduleDAO getScheduleData() {
        return new ScheduleDAOMemory();
    }
}
