package gr.aueb.softeng.project1801.viewTests.PassengerTests.Buy_TicketTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;
import gr.aueb.softeng.project1801.view.Passenger.Buy_Ticket.BuyTicketPresenter;

public class BuyTicketPresenterTest {

    private Initializer dataHelper;
    private BuyTicketPresenter presenter;
    private BuyTicketsViewStub viewStub;
    private String date1,date2,date3,date4;

    /**
     * Initializing the necessary objects.
     *
     * This method creates a Initializer,BuyTicketPresenter,BuyTicketsViewStub object and sets values to it.
     */
    @Before
    public void setUp() throws Exception{
        dataHelper = new DataInitializer();
        dataHelper.prepareData();
        viewStub = new BuyTicketsViewStub();
        presenter = new BuyTicketPresenter(viewStub, dataHelper.getScheduleData());
        date1 = "2018/06/29";
        date2 = "2000/3/29";
        date3 = "2018/34/2";
        date4 = "2018/4/234";
    }

    /**
     * This method validates a day.
     */
    @Test
    public void validateDate(){
        Assert.assertTrue(presenter.validateDate(date1));
        Assert.assertTrue(!presenter.validateDate(date2));
        Assert.assertTrue(!presenter.validateDate(date3));
        Assert.assertTrue(!presenter.validateDate(date4));
    }

    /**
     * This method calls another activity to search for the specified route.
     */
    @Test
    public void onSearchRouteWithInvalidDate(){
        presenter.onSearchRoute(viewStub.getDestination(),viewStub.getDeparturepoint(),viewStub.getDepartureDate()
        ,viewStub.getNumberOfSeats());
        Assert.assertEquals(viewStub.getMessage(),"Invalid Date...Try again!!");
    }

    /**
     * This method calls another activity to search for the specified route.
     */
    @Test
    public void onSearchRouteWithValidDate(){
        presenter.onSearchRoute(viewStub.getDestination(),viewStub.getDeparturepoint(),date1
                ,viewStub.getNumberOfSeats());

        Assert.assertEquals("",viewStub.getDestination());
        Assert.assertEquals("",viewStub.getDeparturepoint());
        Assert.assertEquals("2018/06/29",viewStub.getDepartureDate());
        Assert.assertEquals("",viewStub.getNumberOfSeats());
    }

}
