package gr.aueb.softeng.project1801.DomainModelTests;

import org.junit.*;
import gr.aueb.softeng.project1801.Bus;
import gr.aueb.softeng.project1801.Driver;
import gr.aueb.softeng.project1801.Passenger;
import gr.aueb.softeng.project1801.R;
import gr.aueb.softeng.project1801.Route;
import gr.aueb.softeng.project1801.SysCalendar.SystemCalendar;
import gr.aueb.softeng.project1801.Ticket;

import static junit.framework.Assert.assertTrue;

public class RouteTest {

    Bus bus;
    Driver driver;
    Passenger passenger;
    Ticket ticket;
    SystemCalendar calendar;

    @Before
    public void setUp(){
        bus = new Bus("Type1", "Mercendes", "AR1314",50);
        driver = new Driver("Anastasios Lepipas", "AL1997");
        passenger = new Passenger("Sotiris","Kotitsas","SK9");
        calendar = new SystemCalendar(2018,4,14);

        ticket = new Ticket();
        ticket.setDestinationTicket("Athens");
        ticket.setDeparturePointTicket("Nafplio");
        ticket.setDepartureTimeTicket("8:00PM");
        ticket.setDepartureDateTicket(calendar);
        ticket.setPassenger(passenger);
        ticket.setPassengerName(passenger.getFirstName()+passenger.getLastName());
        ticket.setPassengerID(passenger.getNumberID());
        ticket.setPassengerSeat(9);
        ticket.setPrice(7.5);
        ticket.setEstimatedArrivalTimeTicket("10:00PM");
    }

    @After
    public void tearDown(){ }

    @Test
    public void TestAddTicketWhenTicketNotNull(){
        Route route = new Route();
        route.setRouteBus(bus);
        route.setAvailableSeats(bus.getBusSeats());
        route.addTicket(ticket);

        Assert.assertTrue(route.getTickets().size() == 1);
        Assert.assertTrue(route.getTickets().contains(ticket));
        Assert.assertEquals(bus.getBusSeats()-1,route.getAvailableSeats());
    }

    @Test
    public void TestAddTicketWhenTicketNull(){
        Route route = new Route();
        route.addTicket(null);

        Assert.assertTrue(route.getTickets().size() == 0);
        Assert.assertTrue(route.getTickets().isEmpty());

    }

    @Test
    public void TestRemoveTicketWhenTicketNotNull(){
        Route route = new Route();
        route.setRouteBus(bus);
        route.setAvailableSeats(bus.getBusSeats());
        route.addTicket(ticket);

        Assert.assertTrue(route.getTickets().size() == 1);
        Assert.assertTrue(route.getTickets().contains(ticket));

        route.removeTicket(ticket);
        Assert.assertTrue(route.getTickets().size() == 0);
        Assert.assertTrue(route.getTickets().isEmpty());
        Assert.assertEquals(bus.getBusSeats(),route.getAvailableSeats());

    }

    @Test
    public void FindTicketWhenTicketExists(){
        Route route = new Route();
        route.addTicket(ticket);

        Assert.assertTrue(route.getTickets().size() == 1);
        Assert.assertTrue(route.FindTicket(ticket));
    }

    @Test
    public void FindTicketWhenNotExists(){
        Route route = new Route();
        route.addTicket(ticket);

        ticket.setPassengerSeat(25);
        Assert.assertTrue(route.getTickets().size() == 1);
        Assert.assertTrue(!route.FindTicket(ticket));
    }

    @Test
    public void getDestination() {
        Route route = new Route();
        route.setDestination("Serres");
        assertTrue(route.getDestination().equals("Serres"));
    }

    @Test
    public void setDestination() {
        Route route = new Route();
        route.setDestination("Serres");
        assertTrue(route.getDestination().equals("Serres"));
    }

    @Test
    public void getDepartureTime() {
        Route route = new Route();
        route.setDepartureTime("12:00");
        assertTrue(route.getDepartureTime().equals("12:00"));
    }

    @Test
    public void setDepartureTime() {
        Route route = new Route();
        route.setDepartureTime("12:00");
        assertTrue(route.getDepartureTime().equals("12:00"));
    }

    @Test
    public void getDeparturePoint() {
        Route route = new Route();
        route.setDeparturePoint("Pefki");
        assertTrue(route.getDeparturePoint().equals("Pefki"));
    }

    @Test
    public void setDeparturePoint() {
        Route route = new Route();
        route.setDeparturePoint("Pefki");
        assertTrue(route.getDeparturePoint().equals("Pefki"));
    }

    @Test
    public void getDepartureDate() {
        Route route = new Route();
        SystemCalendar systemCalendar = new SystemCalendar(2018,05,03);
        route.setDepartureDate(systemCalendar);
        SystemCalendar temp_systemCalendar = new SystemCalendar(2018,05,03);
        assertTrue(route.getDepartureDate().compareTo(temp_systemCalendar) == 0);
    }

    @Test
    public void setDepartureDate() {
        Route route = new Route();
        SystemCalendar systemCalendar = new SystemCalendar(2018,05,03);
        route.setDepartureDate(systemCalendar);
        SystemCalendar temp_systemCalendar = new SystemCalendar(2018,05,03);
        assertTrue(route.getDepartureDate().compareTo(temp_systemCalendar) == 0);
    }

    @Test
    public void getEstimatedArrivalTime() {
        Route route = new Route();
        route.setEstimatedArrivalTime("20:00");
        assertTrue(route.getEstimatedArrivalTime().equals("20:00"));
    }

    @Test
    public void setEstimatedArrivalTime() {
        Route route = new Route();
        route.setEstimatedArrivalTime("20:00");
        assertTrue(route.getEstimatedArrivalTime().equals("20:00"));
    }

    @Test
    public void getRouteBus() {
        Route route = new Route();
        Bus bus = new Bus();
        String busType = "Diorofo";
        String modelType = "Astiko";
        String busID = "666";
        int busSeats = 100;
        bus.setBusType(busType);
        bus.setModelType(modelType);
        bus.setBusID(busID);
        bus.setBusSeats(busSeats);
        route.setRouteBus(bus);
        Bus temp_bus = new Bus();
        temp_bus.setBusType(busType);
        temp_bus.setModelType(modelType);
        temp_bus.setBusID(busID);
        temp_bus.setBusSeats(busSeats);
        assertTrue(route.getRouteBus().equals(temp_bus));
    }

    @Test
    public void setRouteBus() {
        Route route = new Route();
        Bus bus = new Bus();
        String busType = "Diorofo";
        String modelType = "Astiko";
        String busID = "666";
        int busSeats = 100;
        bus.setBusType(busType);
        bus.setModelType(modelType);
        bus.setBusID(busID);
        bus.setBusSeats(busSeats);
        route.setRouteBus(bus);
        Bus temp_bus = new Bus();
        temp_bus.setBusType(busType);
        temp_bus.setModelType(modelType);
        temp_bus.setBusID(busID);
        temp_bus.setBusSeats(busSeats);
        assertTrue(route.getRouteBus().equals(temp_bus));
    }

    @Test
    public void getDriver() {
        Route route = new Route();
        Driver driver = new Driver();
        String driverName = "Toni";
        String driverID = "666";
        driver.setDriverName(driverName);
        driver.setDriverID(driverID);
        route.setDriver(driver);
        Driver temp_driver = new Driver();
        temp_driver.setDriverName(driverName);
        temp_driver.setDriverID(driverID);
        assertTrue(route.getDriver().equals(temp_driver));
    }

    @Test
    public void setDriver() {
        Route route = new Route();
        Driver driver = new Driver();
        String driverName = "Toni";
        String driverID = "666";
        driver.setDriverName(driverName);
        driver.setDriverID(driverID);
        route.setDriver(driver);
        Driver temp_driver = new Driver();
        temp_driver.setDriverName(driverName);
        temp_driver.setDriverID(driverID);
        assertTrue(route.getDriver().equals(temp_driver));
    }

    @Test
    public void getAvailableSeats() {
        Route route = new Route();
        route.setAvailableSeats(100);
        assertTrue(route.getAvailableSeats() == 100);
    }

    @Test
    public void setAvailableSeats() {
        Route route = new Route();
        route.setAvailableSeats(100);
        assertTrue(route.getAvailableSeats() == 100);
    }

    @Test
    public void getTickets() {
        Route route = new Route();
        Ticket ticket1 = new Ticket();
        ticket1.setDestinationTicket("Argos");
        Ticket ticket2 = new Ticket();
        ticket2.setDestinationTicket("Na3os");
        Ticket ticket3 = new Ticket();
        ticket3.setDestinationTicket("Serres");
        route.addTicket(ticket1);
        route.addTicket(ticket2);
        route.removeTicket(ticket2);
        route.addTicket(ticket3);
        assertTrue(route.getTickets().size() == 2);
        assertTrue(route.getTickets().contains(ticket1));
        assertTrue(!(route.getTickets().contains(ticket2)));
        assertTrue(route.getTickets().contains(ticket3));
    }

    @Test
    public void addTicket() {
        Route route = new Route();
        Ticket ticket = new Ticket();
        route.addTicket(ticket);
        assertTrue(route.getTickets().size() == 1);
        assertTrue(route.getTickets().contains(ticket));

    }

    @Test
    public void removeTicket() {
        Route route = new Route();
        Ticket ticket = new Ticket();
        route.addTicket(ticket);
        route.removeTicket(ticket);
        assertTrue(route.getTickets().size() == 0);
        assertTrue(!(route.getTickets().contains(ticket)));
    }

    @Test
    public void equals() {

        String destination = "Serres";
        String departureTime = "12:00";
        String departurePoint = "Pefki";
        SystemCalendar departureDate = new SystemCalendar(2018,05,03);
        String estimatedArrivalTime = " 20:00";
        Bus routeBus = new Bus();
        routeBus.setBusType("Diorofo");
        Driver driver = new Driver();
        driver.setDriverID("D2109");
        int availableSeats = 100;
        Route route1 = new Route();
        Route route2 = new Route();
        route1.setDestination(destination);
        route1.setDepartureTime(departureTime);
        route1.setDepartureDate(departureDate);
        route1.setEstimatedArrivalTime(estimatedArrivalTime);
        route1.setRouteBus(routeBus);
        route1.setDriver(driver);
        route1.setAvailableSeats(availableSeats);
        route2.setDestination(destination);
        route2.setDepartureTime(departureTime);
        route2.setDepartureDate(departureDate);
        route2.setEstimatedArrivalTime(estimatedArrivalTime);
        route2.setRouteBus(routeBus);
        route2.setDriver(driver);
        route2.setAvailableSeats(availableSeats);
        assertTrue(route1.equals(route2));
    }

}