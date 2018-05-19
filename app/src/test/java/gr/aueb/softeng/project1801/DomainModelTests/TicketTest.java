package gr.aueb.softeng.project1801.DomainModelTests;


import org.junit.*;

import gr.aueb.softeng.project1801.DomainModel.Bus;
import gr.aueb.softeng.project1801.DomainModel.Driver;
import gr.aueb.softeng.project1801.DomainModel.Passenger;
import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.DomainModel.Ticket;

import static org.junit.Assert.assertTrue;


public class TicketTest {

    Passenger passenger;
    Route route;
    Bus bus;
    Driver driver;
    SystemCalendar calendar;

    /**
     * Initializing a Route,Bus,Driver,Passesnger,SystemCalendar object.
     *
     * This method creates a Route,Bus,Driver,Passesnger,SystemCalendar object and sets values to it.
     */
    @Before
    public void setUp(){
        calendar = new SystemCalendar(2018,4,14);

        bus = new Bus("Type1", "Mercendes", "AR1314",50);
        driver = new Driver("Anastasios Lepipas", "AL1997");

        passenger = new Passenger("Sotiris","Kotitsas","SK9");
        route = new Route("Athens","8:00PM","Nafplio", calendar,
                "10:00PM",bus,driver);
    }

    @After
    public void tearDown(){ }


    /**
     * Findind an existing ticket.
     *
     * This method creates a Ticket object, sets values to it and tries to find the (previous added)ticket.
     */
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
        ticket.setPassengerSeat("22");
        ticket.setRoute(route);
        Assert.assertTrue(route.friendRoutes().size() == 1);
        Assert.assertTrue(ticket.TicketExists(ticket));
    }

    /**
     * DoubleChecking the existence of a ticket.
     *
     * This method creates a Ticket object, sets values to it and tries to create another Ticket object with same values and finally checks it's existance.
     */
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
        ticket.setPassengerSeat("22");
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
        Newticket.setPassengerSeat("22");
        Newticket.setRoute(route);

        Assert.assertTrue(Newticket.TicketExists(Newticket));
    }


    /**
     * Checking the existence of a ticket.
     *
     * This method creates two Ticket objects, sets values to them and tries to check the existance of them.
     */
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
        ticket.setPassengerSeat("22");
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
        Newticket.setPassengerSeat("23");//not the same as before
        Newticket.setRoute(route);

        Assert.assertTrue(route.friendRoutes().size() == 2);
        Assert.assertTrue(Newticket.TicketExists(Newticket));
    }

    /**
     * Trying to buy an unavailable seat.
     *
     * This method creates a Ticket object, sets values to it and makes it unavailable and tries to buy a (unavailable)seat.
     */
    @Test
    public void TestBuyTicketWhenSeatsAreNotAvailable(){
        Ticket ticket = new Ticket();
        route.setAvailableSeats(0);
        Assert.assertTrue(!ticket.buyTicket(ticket,passenger,route));
    }

    /**
     * Trying to buy an unavailable ticket.
     *
     * This method creates a Ticket object, sets values to it and makes it unavailable and tries to buy the (previous unavailable)ticket.
     */
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
        ticket.setPassengerSeat("22");
        ticket.setRoute(route);
        Assert.assertTrue(route.friendRoutes().size() == 1);

        Assert.assertTrue(!ticket.buyTicket(ticket,passenger,route));
    }

    /**
     * Buying an available ticket.
     *
     * This method creates a Ticket object, sets values to it and tries to buy the (previous available)ticket.
     */
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
        ticket.setPassengerSeat("22");
        ticket.setPassengerName(passenger.getFirstName()+passenger.getLastName());
        ticket.setPassengerID(passenger.getNumberID());

        Assert.assertTrue(ticket.buyTicket(ticket,passenger,route));

        Assert.assertEquals(passenger.getFirstName() +" "+ passenger.getLastName(),ticket.getPassengerName());
        Assert.assertEquals(passenger.getNumberID(),ticket.getPassengerID());
    }

    /** Returns DestinationTicket passed to the constructor.  */
    @Test
    public void getDestinationTicket() {
        Ticket ticket = new Ticket();
        ticket.setDestinationTicket("Serres");
        assertTrue(ticket.getDestinationTicket().equals("Serres"));
    }

    /** Returns DeparturePointTicket passed to the constructor.  */
    @Test
    public void getDeparturePointTicket() {
        Ticket ticket = new Ticket();
        ticket.setDeparturePointTicket("Pefki");
        assertTrue(ticket.getDeparturePointTicket().equals("Pefki"));
    }

    /** Returns DepartureTimeTicket passed to the constructor.  */
    @Test
    public void getDepartureTimeTicket() {
        Ticket ticket = new Ticket();
        ticket.setDepartureTimeTicket("12:00");
        assertTrue(ticket.getDepartureTimeTicket().equals("12:00"));
    }

    /** Return DepartureDateTicket passed to the constructor.  */
    @Test
    public void getDepartureDateTicket() {
        Ticket ticket = new Ticket();
        SystemCalendar systemCalendar = new SystemCalendar(2018,05,03);
        ticket.setDepartureDateTicket(systemCalendar);
        SystemCalendar temp_systemCalendar = new SystemCalendar(2018,05,03);
        assertTrue(ticket.getDepartureDateTicket().compareTo(temp_systemCalendar) == 0);
    }

    /** Returns EstimatedArrivalTimeTicket passed to the constructor.  */
    @Test
    public void getEstimatedArrivalTimeTicket() {
        Ticket ticket = new Ticket();
        ticket.setEstimatedArrivalTimeTicket("20:00");
        assertTrue(ticket.getEstimatedArrivalTimeTicket().equals("20:00"));
    }

    /** Returns Price passed to the constructor.  */
    @Test
    public void getPrice() {
        Ticket ticket = new Ticket();
        ticket.setPrice(50.0);
        assertTrue(ticket.getPrice() == 50.0);
    }

    /** Returns passenger passed to the constructor.  */
    @Test
    public void getPassenger() {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        Passenger passenger1 = new Passenger();
        passenger1.setNumberID("U2175");
        ticket1.setPassenger(passenger1);
        Passenger passenger2 = new Passenger();
        passenger2.setNumberID("U2175");
        ticket2.setPassenger(passenger2);
        assertTrue(ticket1.getPassenger().equals(ticket2.getPassenger()));
    }

    /** Returns PassengerName passed to the constructor.  */
    @Test
    public void getPassengerName() {
        Ticket ticket = new Ticket();
        ticket.setPassengerName("Toni");
        assertTrue(ticket.getPassengerName().equals("Toni"));
    }

    /** Returns PassengerID passed to the constructor.  */
    @Test
    public void getPassengerID() {
        Ticket ticket = new Ticket();
        ticket.setPassengerID("U5866");
        assertTrue(ticket.getPassengerID().equals("U5866"));
    }

    /** Returns PassengerSeat passed to the constructor.  */
    @Test
    public void getPassengerSeat() {
        Ticket ticket = new Ticket();
        ticket.setPassengerSeat("21");
        assertTrue(ticket.getPassengerSeat() == "21");
    }

    /** Returns Type passed to the constructor.  */
    @Test
    public void getType() {
        Ticket ticket = new Ticket();
        ticket.setType("Aplo");
        assertTrue(ticket.getType().equals("Aplo"));
    }

    /** Returns route passed to the constructor.  */
    @Test
    public void getRoute() {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        Route route1 = new Route();
        route1.setDepartureTime("12:00");
        route1.setDestination("Serres");
        ticket1.setRoute(route1);
        Route route2 = new Route();
        route2.setDepartureTime("12:00");
        route2.setDestination("Serres");
        ticket2.setRoute(route2);
        assertTrue(ticket1.getRoute().equals(ticket2.getRoute()));
    }

    @Test
    public void setDestinationTicket() {
        Ticket ticket = new Ticket();
        ticket.setDestinationTicket("Serres");
        assertTrue(ticket.getDestinationTicket().equals("Serres"));
    }

    @Test
    public void setDeparturePointTicket() {
        Ticket ticket = new Ticket();
        ticket.setDeparturePointTicket("Pefki");
        assertTrue(ticket.getDeparturePointTicket().equals("Pefki"));
    }

    @Test
    public void setDepartureTimeTicket() {
        Ticket ticket = new Ticket();
        ticket.setDepartureTimeTicket("12:00");
        assertTrue(ticket.getDepartureTimeTicket().equals("12:00"));
    }

    @Test
    public void setDepartureDateTicket() {
        Ticket ticket = new Ticket();
        SystemCalendar systemCalendar = new SystemCalendar(2018,05,03);
        ticket.setDepartureDateTicket(systemCalendar);
        SystemCalendar temp_systemCalendar = new SystemCalendar(2018,05,03);
        assertTrue(ticket.getDepartureDateTicket().compareTo(temp_systemCalendar) == 0);
    }

    @Test
    public void setEstimatedArrivalTimeTicket() {
        Ticket ticket = new Ticket();
        ticket.setEstimatedArrivalTimeTicket("20:00");
        assertTrue(ticket.getEstimatedArrivalTimeTicket().equals("20:00"));
    }

    @Test
    public void setPrice() {
        Ticket ticket = new Ticket();
        ticket.setPrice(50.0);
        assertTrue(ticket.getPrice() == 50.0);
    }

    @Test
    public void setPassenger() {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        Passenger passenger1 = new Passenger();
        passenger1.setNumberID("U2175");
        ticket1.setPassenger(passenger1);
        Passenger passenger2 = new Passenger();
        passenger2.setNumberID("U2175");
        ticket2.setPassenger(passenger2);
        assertTrue(ticket1.getPassenger().equals(ticket2.getPassenger()));
    }

    @Test
    public void setPassengerSeat() {
        Ticket ticket = new Ticket();
        ticket.setPassengerSeat("21");
        assertTrue(ticket.getPassengerSeat() == "21");
    }

    @Test
    public void setPassengerName() {
        Ticket ticket = new Ticket();
        ticket.setPassengerName("Toni");
        assertTrue(ticket.getPassengerName().equals("Toni"));
    }

    @Test
    public void setType() {
        Ticket ticket = new Ticket();
        ticket.setType("Aplo");
        assertTrue(ticket.getType().equals("Aplo"));
    }

    @Test
    public void setPassengerID() {
        Ticket ticket = new Ticket();
        ticket.setPassengerID("U5866");
        assertTrue(ticket.getPassengerID().equals("U5866"));
    }

    @Test
    public void setRoute() {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        Route route1 = new Route();
        route1.setDepartureTime("12:00");
        route1.setDestination("Serres");
        ticket1.setRoute(route1);
        Route route2 = new Route();
        route2.setDepartureTime("12:00");
        route2.setDestination("Serres");
        ticket2.setRoute(route2);
        assertTrue(ticket1.getRoute().equals(ticket2.getRoute()));
    }


    /**
     * Comparing two objects.
     *
     * This method creates and checks if two object are the same.
     */
    @Test
    public void equals() {

        String destinationTicket = "Argos";
        String departurePointTicket = "Zografou";
        String departureTimeTicket = "11:00";
        SystemCalendar departureDateTicket = new SystemCalendar(2018,05,03);;
        String estimatedArrivalTimeTicket = "14:00:";
        double price = 19.0;
        Passenger passenger = new Passenger();
        passenger.setNumberID("U2168");
        String passengerName = "Sotiris";
        String passengerID = passenger.getNumberID();
        String passengerSeat = "21";
        String type = "Aplos";
        Route route = new Route();
        route.setDepartureTime("11.00");

        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        ticket1.setDestinationTicket(destinationTicket);
        ticket1.setDeparturePointTicket(departurePointTicket);
        ticket1.setDepartureTimeTicket(departureTimeTicket);
        ticket1.setDepartureDateTicket(departureDateTicket);
        ticket1.setEstimatedArrivalTimeTicket(estimatedArrivalTimeTicket);
        ticket1.setPrice(price);
        ticket1.setPassenger(passenger);
        ticket1.setPassengerName(passengerName);
        ticket1.setPassengerName(passengerName);
        ticket1.setPassengerSeat(passengerSeat);
        ticket1.setType(type);
        ticket1.setRoute(route);
        ticket2.setDestinationTicket(destinationTicket);
        ticket2.setDeparturePointTicket(departurePointTicket);
        ticket2.setDepartureTimeTicket(departureTimeTicket);
        ticket2.setDepartureDateTicket(departureDateTicket);
        ticket2.setEstimatedArrivalTimeTicket(estimatedArrivalTimeTicket);
        ticket2.setPrice(price);
        ticket2.setPassenger(passenger);
        ticket2.setPassengerName(passengerName);
        ticket2.setPassengerName(passengerName);
        ticket2.setPassengerSeat(passengerSeat);
        ticket2.setType(type);
        ticket2.setRoute(route);
        assertTrue(ticket1.equals(ticket2));
    }
}