package gr.aueb.softeng.project1801.dao;

import java.util.HashSet;
import java.util.Set;

import gr.aueb.softeng.project1801.DomainModel.Bus;
import gr.aueb.softeng.project1801.DomainModel.Card;
import gr.aueb.softeng.project1801.DomainModel.Driver;
import gr.aueb.softeng.project1801.DomainModel.Passenger;
import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.DomainModel.Schedule;
import gr.aueb.softeng.project1801.DomainModel.ScheduleEntry;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;

/**
 * This class undertakes to initialize the data in the database.
 * Provides data for the examples and control tests.
 */
public abstract class Initializer {

    /**
     * This method deletes all the saved data.
     */
    protected abstract void eraseData();

    /**
     * This method inserts the training data.
     */
    public void prepareData(){

        //erase the data first
        eraseData();

        PassengerDAO passengerDAO = getPassengerData();

        passengerDAO.save(new Passenger("Sot","Kot","SK123"));

        CardDAO cardDAO = getCardData();

        SystemCalendar calendar = new SystemCalendar(2020,4,14);
        cardDAO.save(new Card("Sot Kot","1213343553",calendar,540));

        passengerDAO.find("SK123").addCard(cardDAO.find("Sot Kot"));

        BusDAO busDAO = getBusData();

        busDAO.save(new Bus("Type1", "Mercedes", "AR1314",50));
        busDAO.save(new Bus("Type2","Scania","SC1496",40));
        busDAO.save(new Bus("Type1","Honda","H1269",33));
        busDAO.save(new Bus("Type3","Scania","SC1269",48));
        busDAO.save(new Bus("Type2","Ford","F1269",50));
        busDAO.save(new Bus("Type4","Mercedes","M269",40));
        busDAO.save(new Bus("Type3","Mercedes","M270",40));


        DriverDAO driverData = getDriverData();

        driverData.save(new Driver("Anastasios Lepipas", "AL1997"));
        driverData.save(new Driver("George Chatzo","GC1997"));
        driverData.save(new Driver("Sotiris Kotitsas","SK1997"));
        driverData.save(new Driver("Giannis Bouzios","GB1997"));
        driverData.save(new Driver("Sotiris Vasileiou","SV1997"));
        driverData.save(new Driver("Petros Dimitrakopoulos","PD1997"));
        driverData.save(new Driver("Sot Kot","SP1997"));

        RouteDAO routeDAO = getRouteData();

        SystemCalendar calendar1 = new SystemCalendar(2018,4,23);
        SystemCalendar calendar2 = new SystemCalendar(2018,4,12);
        SystemCalendar calendar3 = new SystemCalendar(2018,4,30);
        SystemCalendar calendar4 = new SystemCalendar(2018,5,1);
        SystemCalendar calendar5 = new SystemCalendar(2018,5,3);
        SystemCalendar calendar6 = new SystemCalendar(2018,5,1);

        routeDAO.save(new Route("Αθηνα","9:00AM","Ναυπλιο", calendar1,
                "11:00PM", busDAO.find("AR1314"),driverData.find("AL1997")));
        routeDAO.save(new Route("Πατρα","9:00AM","Αθηνα",calendar2,
                "11:30PM", busDAO.find("SC1496"),driverData.find("GC1997")));
        routeDAO.save(new Route("Θεσσαλονικη","2:15PM","Αθηνα",calendar3,
                "8:15PM", busDAO.find("H1269"), driverData.find("SK1997")));
        routeDAO.save(new Route("Χαλκιδα","10:30AM","Αθηνα",calendar4,
                "11:30AM", busDAO.find("SC1269"),driverData.find("GB1997")));
        routeDAO.save(new Route("Βολος","12:30AM","Αργος",calendar5,
                "5:00PM", busDAO.find("F1269"),driverData.find("SV1997")));
        routeDAO.save(new Route("Λαρισα","11:30AM","Θεσσαλονικη",calendar6,
                "2:00PM", busDAO.find("M269"),driverData.find("PD1997")));

        ScheduleDAO scheduleDAO = getScheduleData();

        Set<String> Destinations = new HashSet<>();
        Set<String> DeparturePoints = new HashSet<>();
        Set<String> DepartureTimes = new HashSet<>();
        Set<SystemCalendar> DepartureDates = new HashSet<>();

        Destinations.add("Αθηνα");
        Destinations.add("Πατρα");
        Destinations.add("Θεσσαλονικη");
        Destinations.add("Χαλκιδα");
        Destinations.add("Βολος");
        Destinations.add("Λαρισα");
        Destinations.add("Ασπροπυργος");
        Destinations.add("Ελευσινα");
        Destinations.add("Ισθμος");
        Destinations.add("Μεγαρα");
        Destinations.add("Αδαμι");
        Destinations.add("Αγιοι Αποστολοι");
        Destinations.add("Αγναντα");
        Destinations.add("Αρχαια Επιδαυρος");
        Destinations.add("Αρχαια Τιρινθα");
        Destinations.add("Αργος");
        Destinations.add("Δαλαμαναρα");
        Destinations.add("Δριοπι");
        Destinations.add("Φουρνη");
        Destinations.add("Γαλατας");
        Destinations.add("Καλλονη");
        Destinations.add("Κρανιδι");
        Destinations.add("Λιγουριο");
        Destinations.add("Πορτοχελι");
        Destinations.add("Τριζινα");

        DeparturePoints.add("Αθηνα");
        DeparturePoints.add("Θεσσαλονικη");
        DeparturePoints.add("Ναυπλιο");
        DeparturePoints.add("Αργος");
        DeparturePoints.add("Γαλατας");
        DeparturePoints.add("Ισθμος");
        DeparturePoints.add("Κρανιδι");
        DeparturePoints.add("Μεθανα");
        DeparturePoints.add("Τριπολη");
        DeparturePoints.add("Βιτινα");
        DeparturePoints.add("Χαλεπα");
        DeparturePoints.add("Κιβερι");
        DeparturePoints.add("Νεα Κιος");
        DeparturePoints.add("Πατρα");
        DeparturePoints.add("Λιγουριο");
        DeparturePoints.add("Καργια");
        DeparturePoints.add("Χουνη");
        DeparturePoints.add("Δρεπανο");
        DeparturePoints.add("Τολο");
        DeparturePoints.add("Καλαματα");

        DepartureTimes.add("7:00PM");
        DepartureTimes.add("8:00PM");
        DepartureTimes.add("9:00PM");
        DepartureTimes.add("10:00PM");
        DepartureTimes.add("11:00PM");
        DepartureTimes.add("12:00PM");
        DepartureTimes.add("1:00AM");
        DepartureTimes.add("2:00AM");
        DepartureTimes.add("3:00AM");
        DepartureTimes.add("4:00AM");
        DepartureTimes.add("5:00AM");
        DepartureTimes.add("6:00AM");
        DepartureTimes.add("7:00AM");
        DepartureTimes.add("8:00AM");
        DepartureTimes.add("9:00AM");
        DepartureTimes.add("10:00AM");
        DepartureTimes.add("11:00AM");
        DepartureTimes.add("12:00AM");

        Schedule schedule = new Schedule();
        schedule.setDestinations(Destinations);
        schedule.setDeparturePoints(DeparturePoints);
        schedule.setDepartureTimes(DepartureTimes);
        schedule.setDepartureDates(DepartureDates);

        schedule.addNewRoute(routeDAO.find("Αθηνα","9:00AM","Ναυπλιο", calendar1));
        schedule.addNewRoute(routeDAO.find("Πατρα","9:00AM","Αθηνα",calendar2));
        schedule.addNewRoute(routeDAO.find("Θεσσαλονικη","2:15PM","Αθηνα",calendar3));
        schedule.addNewRoute(routeDAO.find("Χαλκιδα","10:30AM","Αθηνα",calendar4));
        schedule.addNewRoute(routeDAO.find("Βολος","12:30AM","Αργος",calendar5));
        schedule.addNewRoute(routeDAO.find("Λαρισα","11:30AM","Θεσσαλονικη",calendar6));

        for(Route route: schedule.getRoutes()){
            ScheduleEntry entry = new ScheduleEntry(route.getDepartureTime(),route.getDepartureDate());
            schedule.addScheduleEntry(entry);
        }

        scheduleDAO.save(schedule);

    }

    /**
     * This method returns the bus data.
     * @return the bus data
     */
    public abstract BusDAO getBusData();

    /**
     * This method returns the card data.
     * @return the card data
     */
    public abstract CardDAO getCardData();

    /**
     * This method returns the passenger data.
     * @return the passenger data
     */
    public abstract PassengerDAO getPassengerData();

    /**
     * This method returns the driver data.
     * @return the driver data
     */
    public abstract DriverDAO getDriverData();

    /**
     * This method returns the route data.
     * @return the route data
     */
    public abstract RouteDAO getRouteData();

    /**
     * This method returns the schedule data.
     * @return the schedule data
     */
    public abstract ScheduleDAO getScheduleData();
}
