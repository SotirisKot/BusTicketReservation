package gr.aueb.softeng.project1801.viewTests.PassengerTests.TrackRouteTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;
import gr.aueb.softeng.project1801.view.Passenger.Track_Route.TrackRoutePresenter;

public class TrackRoutePresenterTest {

    private Initializer dataHelper;
    private TrackRoutePresenter presenter;
    private TrackRouteViewStub viewStub;
    private String date1,date2,date3,date4;

    @Before
    public void setUp(){
        dataHelper = new DataInitializer();
        dataHelper.prepareData();
        viewStub = new TrackRouteViewStub();
        viewStub.setDepartureDate("2018/04/23");
        viewStub.setDeparturePoint("Ναυπλιο");
        viewStub.setDestination("Αθηνα");
        viewStub.setDepartureTime("9:00AM");
        presenter = new TrackRoutePresenter(viewStub,dataHelper.getScheduleData());
        date1 = "2018/06/29";
        date2 = "2000/3/29";
        date3 = "2018/34/2";
        date4 = "2018/4/234";
    }

    @Test
    public void testValidateDate(){
        Assert.assertTrue(presenter.validateDate(date1));
        Assert.assertTrue(!presenter.validateDate(date2));
        Assert.assertTrue(!presenter.validateDate(date3));
        Assert.assertTrue(!presenter.validateDate(date4));
    }

    @Test
    public void testOnTrackRouteWhenDateNotValid(){
        presenter.onTrackRoute(viewStub.getDestination(),viewStub.getDeparturepoint(),date3,viewStub.getDepartureTime());
        Assert.assertEquals("Invalid Date...Try again!!",viewStub.getMessage());
    }

    @Test
    public void testOnTrackRouteWhenDataValid(){
        presenter.onTrackRoute(viewStub.getDestination(),viewStub.getDeparturepoint(),date3,viewStub.getDepartureTime());
        Assert.assertEquals("2018/04/23",viewStub.getDepartureDate());
        Assert.assertEquals("Ναυπλιο",viewStub.getDeparturepoint());
        Assert.assertEquals("Αθηνα",viewStub.getDestination());
        Assert.assertEquals("9:00AM",viewStub.getDepartureTime());
    }
}
