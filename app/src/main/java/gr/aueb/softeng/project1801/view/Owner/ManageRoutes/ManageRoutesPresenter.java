package gr.aueb.softeng.project1801.view.Owner.ManageRoutes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import gr.aueb.softeng.project1801.DomainModel.Bus;
import gr.aueb.softeng.project1801.DomainModel.BusState;
import gr.aueb.softeng.project1801.DomainModel.Driver;
import gr.aueb.softeng.project1801.DomainModel.DriverState;
import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.DomainModel.Schedule;
import gr.aueb.softeng.project1801.DomainModel.ScheduleEntry;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.BusDAO;
import gr.aueb.softeng.project1801.dao.DriverDAO;
import gr.aueb.softeng.project1801.dao.RouteDAO;
import gr.aueb.softeng.project1801.dao.ScheduleDAO;
import gr.aueb.softeng.project1801.memorydao.RouteDAOMemory;

public class ManageRoutesPresenter  {

    private ManageRoutesView view;
    private ScheduleDAO schedule;
    private BusDAO bus;
    private DriverDAO driver;


    public ManageRoutesPresenter(ManageRoutesView view,ScheduleDAO schedule,BusDAO bus,DriverDAO driver){

        this.view = view;
        this.schedule = schedule;
        this.bus = bus;
        this.driver = driver;


        List<String> bus_ids = new ArrayList<>();
        List<String> driver_ids = new ArrayList<>();


        Schedule sc1 = schedule.findAll().get(0);

        List<String> destinations = new ArrayList<>(sc1.getDestinations());
        List<String> departures = new ArrayList<>(sc1.getDeparturePoints());
        List<String> times = new ArrayList<>(sc1.getDepartureTimes());

        for(Bus bus1 : bus.findAll()){
            if(bus1.getState() == BusState.AVAILABLE){
                bus_ids.add(bus1.getBusID());
            }
        }

        for(Driver driver1 : driver.findAll()){
            if(driver1.getState() == DriverState.AVAILABLE){
                driver_ids.add(driver1.getDriverID());
            }
        }

        view.setActivityName("Creating Route:");
        view.setBusIDsList(bus_ids);
        view.setDeparturePointsList(departures);
        view.setDepartureTimesList(times);
        view.setDestinationsList(destinations);
        view.setDriverIDsList(driver_ids);
    }

    private boolean validateDate(String date){
        String[] parts = date.split("/");
        try {
            if(Integer.parseInt(parts[0]) >= 2018 && Integer.parseInt(parts[1]) > 0 && Integer.parseInt(parts[1]) <=12
                    && Integer.parseInt(parts[2]) > 0 && Integer.parseInt(parts[2]) <= 31){
                return true;
            }
            return false;
        } catch (Exception e){
            return false;
        }
    }

    public void addRoute(){
        RouteDAO routes = new RouteDAOMemory();
        String Destination = view.getDestination();
        String DepartureTime = view.getDepartureTime();
        String DeparturePoint = view.getDeparturepoint();
        String EstimatedArrivalTime = view.getEstimatedArrivalTime();
        Bus RouteBus = bus.find(view.getBusID());
        Driver Driver = driver.find(view.getDriverID());
        Schedule sc = schedule.findAll().get(0);
        String date = view.getDepartureDate();

        if(!validateDate(date)){

            view.showAlertMessage("Invalid Date...Try again!!");

        }else {
            String[] parts = date.split("/");
            SystemCalendar DepartureDate = new SystemCalendar(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
            ScheduleEntry entry = new ScheduleEntry(DepartureTime,DepartureDate);
            ScheduleEntry availableEntry = sc.findNextAvailableDate(entry);
            if(entry.equals(availableEntry)){
                Route route = sc.createRoute(Destination,DepartureTime,DeparturePoint,DepartureDate,EstimatedArrivalTime,RouteBus,Driver);
                if(route == null){
                    view.showAlertMessage("Route already exists!!!");
                }else{
                    view.showSuccessMessage("Route created..will be added to the schedule!!");
                    routes.save(route);

                }
            }else{
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String availableDate = dateFormat.format(availableEntry.getCalendar().getJavaCalendar().getTime());
                view.showAlertMessage("Schedule Entry slot is taken..."+ "\n "+
                        "TRY: "+ availableDate + " at "+ availableEntry.getDepartureTime());
            }
        }

    }
}
