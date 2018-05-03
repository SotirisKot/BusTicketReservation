package gr.aueb.softeng.project1801.memorydao;

import gr.aueb.softeng.project1801.Bus;
import gr.aueb.softeng.project1801.Card;
import gr.aueb.softeng.project1801.Driver;
import gr.aueb.softeng.project1801.Passenger;
import gr.aueb.softeng.project1801.Route;
import gr.aueb.softeng.project1801.Schedule;
import gr.aueb.softeng.project1801.dao.BusDAO;
import gr.aueb.softeng.project1801.dao.CardDAO;
import gr.aueb.softeng.project1801.dao.DriverDAO;
import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.dao.PassengerDAO;
import gr.aueb.softeng.project1801.dao.RouteDAO;
import gr.aueb.softeng.project1801.dao.ScheduleDAO;

public class DataInitializer extends Initializer{

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

    @Override
    public BusDAO getBusData() {
        return new BusDAOMemory();
    }

    @Override
    public CardDAO getCardData() {
        return new CardDAOMemory();
    }

    @Override
    public DriverDAO getDriverData() {
        return new DriverDAOMemory();
    }

    @Override
    public PassengerDAO getPassengerData() {
        return new PassengerDAOMemory();
    }

    @Override
    public RouteDAO getRouteData() {
        return new RouteDAOMemory();
    }

    @Override
    public ScheduleDAO getScheduleData() {
        return new ScheduleDAOMemory();
    }
}
