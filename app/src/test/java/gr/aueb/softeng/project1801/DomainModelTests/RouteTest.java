package gr.aueb.softeng.project1801.DomainModelTests;

import org.junit.*;
import gr.aueb.softeng.project1801.Bus;
import gr.aueb.softeng.project1801.Driver;
import gr.aueb.softeng.project1801.Passenger;
import gr.aueb.softeng.project1801.Route;
import gr.aueb.softeng.project1801.SystemCalendar;
import gr.aueb.softeng.project1801.Ticket;

import static org.junit.Assert.*;

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


}