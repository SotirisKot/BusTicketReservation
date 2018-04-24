package gr.aueb.softeng.project1801.DomainModelTests;


import org.junit.*;
import java.util.*;
import gr.aueb.softeng.project1801.Bus;
import gr.aueb.softeng.project1801.Driver;
import gr.aueb.softeng.project1801.Passenger;
import gr.aueb.softeng.project1801.Route;
import gr.aueb.softeng.project1801.Ticket;


public class TicketTest {

    Passenger passenger;
    Route route;
    Bus bus;
    Driver driver;


    @Before
    public void setUp(){

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2018);
        calendar.set(Calendar.MONTH,4);
        calendar.set(Calendar.DAY_OF_MONTH,24);


        bus = new Bus("Type1", "Mercendes", "AR1314",50);
        driver = new Driver("Anastasios Lepipas", "AL1997");

        passenger = new Passenger("Sotiris","Kotitsas","SK9");
        route = new Route("Athens","8:00PM","Nafplio", calendar,
                "10:00PM",bus,driver);
    }

    @After
    public void tearDown(){ }


    @Test
    public void TestTicketExistsIfAdded(){
        Ticket ticket = new Ticket();
        ticket.setDestinationTicket(route.getDestination());
        ticket.setDeparturePointTicket(route.getDeparturePoint());
        ticket.setDepartureTimeTicket(route.getDepartureTime());
        ticket.setEstimatedArrivalTimeTicket(route.getEstimatedArrivalTime());
        ticket.setDepartureDateTicket(route.getDepartureDate());
        ticket.setPassenger(passenger);
        ticket.setPassengerName(passenger.getFirstName() + passenger.getLastName());
        ticket.setPassengerID(passenger.getNumberID());
        ticket.setPrice(9);
        ticket.setPassengerSeat(22);
        ticket.setRoute(route);
        Assert.assertTrue(route.friendRoutes().size() == 1);
        Assert.assertTrue(ticket.TicketExists(ticket));
    }

    @Test
    public void TestTicketExistsWhenSameTicket(){
        Ticket ticket = new Ticket();
        ticket.setDestinationTicket(route.getDestination());
        ticket.setDeparturePointTicket(route.getDeparturePoint());
        ticket.setDepartureTimeTicket(route.getDepartureTime());
        ticket.setEstimatedArrivalTimeTicket(route.getEstimatedArrivalTime());
        ticket.setDepartureDateTicket(route.getDepartureDate());
        ticket.setPassenger(passenger);
        ticket.setPassengerName(passenger.getFirstName() + passenger.getLastName());
        ticket.setPassengerID(passenger.getNumberID());
        ticket.setPrice(9);
        ticket.setPassengerSeat(22);
        ticket.setRoute(route);

        Assert.assertTrue(route.friendRoutes().size() == 1);
        Ticket Newticket = new Ticket();
        Newticket.setDestinationTicket(route.getDestination());
        Newticket.setDeparturePointTicket(route.getDeparturePoint());
        Newticket.setDepartureTimeTicket(route.getDepartureTime());
        Newticket.setEstimatedArrivalTimeTicket(route.getEstimatedArrivalTime());
        Newticket.setDepartureDateTicket(route.getDepartureDate());
        Newticket.setPassenger(passenger);
        Newticket.setPassengerName(passenger.getFirstName() + passenger.getLastName());
        Newticket.setPassengerID(passenger.getNumberID());
        Newticket.setPrice(9);
        Newticket.setPassengerSeat(22);
        Newticket.setRoute(route);

        Assert.assertTrue(Newticket.TicketExists(Newticket));
    }

    @Test
    public void TestTicketExistsWhenNotSame(){
        Ticket ticket = new Ticket();
        ticket.setDestinationTicket(route.getDestination());
        ticket.setDeparturePointTicket(route.getDeparturePoint());
        ticket.setDepartureTimeTicket(route.getDepartureTime());
        ticket.setEstimatedArrivalTimeTicket(route.getEstimatedArrivalTime());
        ticket.setDepartureDateTicket(route.getDepartureDate());
        ticket.setPassenger(passenger);
        ticket.setPassengerName(passenger.getFirstName() + passenger.getLastName());
        ticket.setPassengerID(passenger.getNumberID());
        ticket.setPrice(9);
        ticket.setPassengerSeat(22);
        ticket.setRoute(route);

        Assert.assertTrue(route.friendRoutes().size() == 1);
        Ticket Newticket = new Ticket();
        Newticket.setDestinationTicket(route.getDestination());
        Newticket.setDeparturePointTicket(route.getDeparturePoint());
        Newticket.setDepartureTimeTicket(route.getDepartureTime());
        Newticket.setEstimatedArrivalTimeTicket(route.getEstimatedArrivalTime());
        Newticket.setDepartureDateTicket(route.getDepartureDate());
        Newticket.setPassenger(passenger);
        Newticket.setPassengerName(passenger.getFirstName() + passenger.getLastName());
        Newticket.setPassengerID(passenger.getNumberID());
        Newticket.setPrice(9);//not the same as before
        Newticket.setPassengerSeat(23);//not the same as before
        Newticket.setRoute(route);

        Assert.assertTrue(route.friendRoutes().size() == 2);
        Assert.assertTrue(Newticket.TicketExists(Newticket));
    }

    @Test
    public void TestBuyTicketWhenSeatsAreNotAvailable(){
        Ticket ticket = new Ticket();
        route.setAvailableSeats(0);
        Assert.assertTrue(!ticket.buyTicket(ticket,passenger,route));
    }

    @Test
    public void TestBuyTicketWhenTicketIsNotAvailable(){
        Ticket ticket = new Ticket();
        ticket.setDestinationTicket(route.getDestination());
        ticket.setDeparturePointTicket(route.getDeparturePoint());
        ticket.setDepartureTimeTicket(route.getDepartureTime());
        ticket.setEstimatedArrivalTimeTicket(route.getEstimatedArrivalTime());
        ticket.setDepartureDateTicket(route.getDepartureDate());
        ticket.setPassenger(passenger);
        ticket.setPassengerName(passenger.getFirstName() + passenger.getLastName());
        ticket.setPassengerID(passenger.getNumberID());
        ticket.setPrice(9);
        ticket.setPassengerSeat(22);
        ticket.setRoute(route);
        Assert.assertTrue(route.friendRoutes().size() == 1);

        Assert.assertTrue(!ticket.buyTicket(ticket,passenger,route));
    }

    @Test
    public void TestBuyTicketWhenAvailable(){
        Ticket ticket = new Ticket();
        ticket.setRoute(route);
        ticket.setDestinationTicket(route.getDestination());
        ticket.setDeparturePointTicket(route.getDeparturePoint());
        ticket.setDepartureTimeTicket(route.getDepartureTime());
        ticket.setEstimatedArrivalTimeTicket(route.getEstimatedArrivalTime());
        ticket.setDepartureDateTicket(route.getDepartureDate());
        ticket.setPrice(9);
        ticket.setPassengerSeat(22);

        Assert.assertTrue(ticket.buyTicket(ticket,passenger,route));

        Assert.assertEquals(passenger.getFirstName() + passenger.getLastName(),ticket.getPassengerName());
        Assert.assertEquals(passenger.getNumberID(),ticket.getPassengerID());
    }
}