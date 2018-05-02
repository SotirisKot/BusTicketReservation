package gr.aueb.softeng.project1801.data_interfaces;

import java.util.HashSet;
import java.util.Set;

import gr.aueb.softeng.project1801.Bus;
import gr.aueb.softeng.project1801.Card;
import gr.aueb.softeng.project1801.Driver;
import gr.aueb.softeng.project1801.Passenger;
import gr.aueb.softeng.project1801.Route;
import gr.aueb.softeng.project1801.Schedule;
import gr.aueb.softeng.project1801.ScheduleEntry;
import gr.aueb.softeng.project1801.SysCalendar.SystemCalendar;

public abstract class Initializer {

    protected abstract void eraseData();

    public void prepareData(){

        //erase the data first
        eraseData();

        PassengerData passengerData = getPassengerData();

        passengerData.save(new Passenger("Sot","Kot","SK123"));

        CardData cardData = getCardData();

        SystemCalendar calendar = new SystemCalendar(2020,4,14);
        cardData.save(new Card("Sot Kot","1213343553",calendar,540));

        passengerData.find("SK123").addCard(cardData.find("Sot Kot"));

        BusData busData = getBusData();

        busData.save(new Bus("Type1", "Mercedes", "AR1314",50));
        busData.save(new Bus("Type2","Scania","SC1496",40));
        busData.save(new Bus("Type1","Honda","H1269",33));
        busData.save(new Bus("Type3","Scania","SC1269",48));
        busData.save(new Bus("Type2","Ford","F1269",50));
        busData.save(new Bus("Type4","Mercedes","M269",40));

        DriverData driverData = getDriverData();

        driverData.save(new Driver("Anastasios Lepipas", "AL1997"));
        driverData.save(new Driver("George Chatzo","GC1997"));
        driverData.save(new Driver("Sotiris Kotitsas","SK1997"));
        driverData.save(new Driver("Giannis Bouzios","GB1997"));
        driverData.save(new Driver("Sotiris Vasileiou","SV1997"));
        driverData.save(new Driver("Petros Dimitrakopoulos","PD1997"));

        RouteData routeData = getRouteData();

        SystemCalendar calendar1 = new SystemCalendar(2018,4,23);
        SystemCalendar calendar2 = new SystemCalendar(2018,4,12);
        SystemCalendar calendar3 = new SystemCalendar(2018,4,30);
        SystemCalendar calendar4 = new SystemCalendar(2018,5,1);
        SystemCalendar calendar5 = new SystemCalendar(2018,5,3);
        SystemCalendar calendar6 = new SystemCalendar(2018,5,1);

        routeData.save(new Route("Αθηνα","9:00AM","Ναυπλιο", calendar1,
                "11:00PM",busData.find("AR1314"),driverData.find("AL1997")));
        routeData.save(new Route("Πατρα","9:00AM","Αθηνα",calendar2,
                "11:30PM",busData.find("SC1496"),driverData.find("GC1997")));
        routeData.save(new Route("Θεσσαλονικη","2:15PM","Αθηνα",calendar3,
                "8:15PM",busData.find("H1269"), driverData.find("SK1997")));
        routeData.save(new Route("Χαλκιδα","10:30AM","Αθηνα",calendar4,
                "11:30AM",busData.find("SC1269"),driverData.find("GB1997")));
        routeData.save(new Route("Βολος","12:30AM","Αργος",calendar5,
                "5:00PM",busData.find("F1269"),driverData.find("SV1997")));
        routeData.save(new Route("Λαρισα","11:30AM","Θεσσαλονικη",calendar6,
                "2:00PM",busData.find("M269"),driverData.find("PD1997")));

        ScheduleData scheduleData = getScheduleData();

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

        DeparturePoints.add("Αθηνα");
        DeparturePoints.add("Θεσσαλονικη");
        DeparturePoints.add("Ναυπλιο");
        DeparturePoints.add("Αργος");

        DepartureTimes.add("9:00AM");
        DepartureTimes.add("2:15PM");
        DepartureTimes.add("10:30AM");
        DepartureTimes.add("12:30AM");
        DepartureTimes.add("11:30AM");

        Schedule schedule = new Schedule();
        schedule.setDestinations(Destinations);
        schedule.setDeparturePoints(DeparturePoints);
        schedule.setDepartureTimes(DepartureTimes);
        schedule.setDepartureDates(DepartureDates);

        schedule.getRoutes().add(routeData.find("Αθηνα","9:00AM","Ναυπλιο", calendar1));
        schedule.getRoutes().add(routeData.find("Πατρα","9:00AM","Αθηνα",calendar2));
        schedule.getRoutes().add(routeData.find("Θεσσαλονικη","2:15PM","Αθηνα",calendar3));
        schedule.getRoutes().add(routeData.find("Χαλκιδα","10:30AM","Αθηνα",calendar4));
        schedule.getRoutes().add(routeData.find("Βολος","12:30AM","Αργος",calendar5));
        schedule.getRoutes().add(routeData.find("Λαρισα","11:30AM","Θεσσαλονικη",calendar6));

        for(Route route: schedule.getRoutes()){
            ScheduleEntry entry = new ScheduleEntry(route.getDepartureTime(),route.getDepartureDate());
            schedule.getScheduleEntry().add(entry);
        }

        scheduleData.save(schedule);

    }

    public abstract BusData getBusData();

    public abstract CardData getCardData();

    public abstract PassengerData getPassengerData();

    public abstract DriverData getDriverData();

    public abstract RouteData getRouteData();

    public abstract ScheduleData getScheduleData();
}
