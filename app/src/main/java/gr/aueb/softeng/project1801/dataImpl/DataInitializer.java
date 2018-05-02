package gr.aueb.softeng.project1801.dataImpl;

import gr.aueb.softeng.project1801.Bus;
import gr.aueb.softeng.project1801.Card;
import gr.aueb.softeng.project1801.Driver;
import gr.aueb.softeng.project1801.Passenger;
import gr.aueb.softeng.project1801.Route;
import gr.aueb.softeng.project1801.Schedule;
import gr.aueb.softeng.project1801.data_interfaces.BusData;
import gr.aueb.softeng.project1801.data_interfaces.CardData;
import gr.aueb.softeng.project1801.data_interfaces.DriverData;
import gr.aueb.softeng.project1801.data_interfaces.Initializer;
import gr.aueb.softeng.project1801.data_interfaces.PassengerData;
import gr.aueb.softeng.project1801.data_interfaces.RouteData;
import gr.aueb.softeng.project1801.data_interfaces.ScheduleData;

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
    public BusData getBusData() {
        return new BusImpl();
    }

    @Override
    public CardData getCardData() {
        return new CardImpl();
    }

    @Override
    public DriverData getDriverData() {
        return new DriverImpl();
    }

    @Override
    public PassengerData getPassengerData() {
        return new PassengerImpl();
    }

    @Override
    public RouteData getRouteData() {
        return new RouteImpl();
    }

    @Override
    public ScheduleData getScheduleData() {
        return new ScheduleImpl();
    }
}
