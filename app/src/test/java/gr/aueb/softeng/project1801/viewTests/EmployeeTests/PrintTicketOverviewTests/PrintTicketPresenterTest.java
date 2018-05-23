package gr.aueb.softeng.project1801.viewTests.EmployeeTests.PrintTicketOverviewTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.DomainModel.Bus;
import gr.aueb.softeng.project1801.DomainModel.Driver;
import gr.aueb.softeng.project1801.DomainModel.Passenger;
import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.DomainModel.Ticket;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.BusDAO;
import gr.aueb.softeng.project1801.dao.DriverDAO;
import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.dao.PassengerDAO;
import gr.aueb.softeng.project1801.dao.RouteDAO;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;
import gr.aueb.softeng.project1801.memorydao.RouteDAOMemory;
import gr.aueb.softeng.project1801.view.Employee.PrintTicketOverView.PrintTicketPresenter;

import static org.junit.Assert.*;

public class PrintTicketPresenterTest {

    private Initializer dataHelper;
    private PrintTicketPresenter presenter;
    private PrintTicketViewStub viewStub;
    private PassengerDAO passengerDAO;
    private RouteDAO routeDAO;

    /**
     * Initializing the necessary objects.
     *
     * This method creates a Initializer,PrintTicketPresenter,PrintTicketViewStub object and sets values to it.
     */
    @Before
    public void setUp(){
        dataHelper = new DataInitializer();
        dataHelper.prepareData();
        viewStub = new PrintTicketViewStub();
        viewStub.setPassengerFirstname("Sot");
        viewStub.setPassengerLastname("Kot");
        viewStub.setPassengerID("SK123");
        passengerDAO = dataHelper.getPassengerData();
        routeDAO = dataHelper.getRouteData();
        Route route = routeDAO.find("Αθηνα","9:00AM","Ναυπλιο",new SystemCalendar(2018,4,23));
        Passenger passenger = passengerDAO.find("SK123");
        Ticket ticket = new Ticket();
        ticket.setDestinationTicket(route.getDestination());
        ticket.setDeparturePointTicket(route.getDeparturePoint());
        ticket.setDepartureTimeTicket(route.getDepartureTime());
        ticket.setDepartureDateTicket(route.getDepartureDate());
        ticket.setPassenger(passenger);
        ticket.setPassengerName(passenger.getFirstName()+" "+passenger.getLastName());
        ticket.setPassengerID(passenger.getNumberID());
        ticket.setPassengerSeat("9");
        ticket.setPrice(7.5);
        ticket.setEstimatedArrivalTimeTicket("11:00PM");
        ticket.setRoute(route);
        route.addTicket(ticket);
        presenter = new PrintTicketPresenter(viewStub, dataHelper.getScheduleData());
    }

    /**
     * This method pops up a toast.
     */
    @Test
    public void onShowToastWhenTicketNotNull() {
        Assert.assertEquals("", viewStub.getValue());
        presenter.onShowToast("hello");
        Assert.assertEquals("hello", viewStub.getValue());
    }

    /**
     * This method pops up a toast.
     */
    @Test
    public void onShowToastWhenTicketNull() {
        PrintTicketViewStub viewStub1 = new PrintTicketViewStub();
        PrintTicketPresenter presenter1 = new PrintTicketPresenter(viewStub1,dataHelper.getScheduleData());
        Assert.assertEquals("Cannot find Ticket", viewStub1.getValue());
        presenter1.onShowToast("hello");
        Assert.assertEquals("hello", viewStub1.getValue());
    }

    /**
     * This method pops up an alert message.
     */
    @Test
    public void onShowAlertMessage() {
        Assert.assertEquals("", viewStub.getMessage());
        presenter.onShowAlertMessage("hello");
        Assert.assertEquals("hello", viewStub.getMessage());
    }

    /**
     * This method helps us to print a passenger's ticket.
     */
    @Test
    public void onPrintTicket() {
        presenter.onPrintTicket("Ticket printed");
        Assert.assertEquals("Ticket printed",viewStub.getPrintMessage());
    }

    /**
     * This method helps us to find a ticket to a passenger.
     * All the tickets have not been sold.
     */
    @Test
    public void findTicketForPassengerWhenTicketExists() {
        passengerDAO = dataHelper.getPassengerData();
        routeDAO = dataHelper.getRouteData();
        Route route = routeDAO.find("Αθηνα","9:00AM","Ναυπλιο",new SystemCalendar(2018,4,23));
        Passenger passenger = passengerDAO.find("SK123");
        Ticket ticket = new Ticket();
        ticket.setDestinationTicket(route.getDestination());
        ticket.setDeparturePointTicket(route.getDeparturePoint());
        ticket.setDepartureTimeTicket(route.getDepartureTime());
        ticket.setDepartureDateTicket(route.getDepartureDate());
        ticket.setPassenger(passenger);
        ticket.setPassengerName(passenger.getFirstName()+" "+passenger.getLastName());
        ticket.setPassengerID(passenger.getNumberID());
        ticket.setPassengerSeat("9");
        ticket.setPrice(7.5);
        ticket.setEstimatedArrivalTimeTicket("11:00PM");
        ticket.setRoute(route);
        route.addTicket(ticket);

        Ticket passengersTicket = presenter.findTicketForPassenger();
        Assert.assertTrue(passengersTicket!=null);
    }

    /**
     * This method helps us to try to find a ticket to a passenger.
     * All the tickets have been sold.
     */
    @Test
    public void findTicketForPassengerWhenTicketDoesNotExists() {
        passengerDAO = dataHelper.getPassengerData();
        routeDAO = dataHelper.getRouteData();
        Route route = routeDAO.find("Αθηνα","9:00AM","Ναυπλιο",new SystemCalendar(2018,4,23));
        Passenger passenger = passengerDAO.find("SK123");
        Ticket ticket = new Ticket();
        ticket.setDestinationTicket(route.getDestination());
        ticket.setDeparturePointTicket(route.getDeparturePoint());
        ticket.setDepartureTimeTicket(route.getDepartureTime());
        ticket.setDepartureDateTicket(route.getDepartureDate());
        ticket.setPassenger(passenger);
        ticket.setPassengerName(passenger.getFirstName()+" "+passenger.getLastName());
        ticket.setPassengerID(passenger.getNumberID());
        ticket.setPassengerSeat("9");
        ticket.setPrice(7.5);
        ticket.setEstimatedArrivalTimeTicket("11:00PM");
        ticket.setRoute(route);
        route.addTicket(ticket);
        viewStub.setPassengerID("12345");
        Ticket passengersTicket = presenter.findTicketForPassenger();
        Assert.assertTrue(passengersTicket==null);
    }
}