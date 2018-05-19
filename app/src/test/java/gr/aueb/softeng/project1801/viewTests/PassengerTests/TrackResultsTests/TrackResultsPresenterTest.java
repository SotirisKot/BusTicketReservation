package gr.aueb.softeng.project1801.viewTests.PassengerTests.TrackResultsTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;
import gr.aueb.softeng.project1801.view.Passenger.TrackResults.TrackResultsPresenter;

public class TrackResultsPresenterTest {

    private Initializer dataHelper;
    private TrackResultsViewStub viewStub;
    private TrackResultsPresenter presenter;

    @Before
    public void setUp(){
        dataHelper = new DataInitializer();
        dataHelper.prepareData();
        viewStub = new TrackResultsViewStub();
        viewStub.setDepartureDate("2018/04/23");
        viewStub.setDeparturePoint("Ναυπλιο");
        viewStub.setDestination("Αθηνα");
        viewStub.setDepartureTime("9:00AM");

        presenter = new TrackResultsPresenter(viewStub,dataHelper.getRouteData());

    }

    /**
     * This method pops up a toast.
     */
    @Test
    public void onShowToast() {
        Assert.assertEquals("", viewStub.getValue());
        presenter.onShowToast("hello");
        Assert.assertEquals("hello", viewStub.getValue());
    }

    @Test
    public void OnGetDestination() {
        viewStub.setDestination("Αθηνα");
        Assert.assertEquals("Αθηνα", viewStub.getDestination());
    }

    @Test
    public void OnGetDeparture() {
        viewStub.setDeparturePoint("Ναυπλιο");
        Assert.assertEquals("Ναυπλιο", viewStub.getDeparturePoint());
    }

    @Test
    public void OnGetDepartureDate() {
        viewStub.setDepartureDate("2018/04/23");
        Assert.assertEquals("2018/04/23", viewStub.getDepartureDate());
    }

    @Test
    public void OnGetDepartureTime() {
        viewStub.setDepartureDate("9:00AM");
        Assert.assertEquals("9:00AM", viewStub.getDepartureTime());
    }

    @Test
    public void Kill() {
        viewStub.setDepartureDate("2018/04/1");
        viewStub.setDeparturePoint("Ναυπλιο");
        viewStub.setDestination("Αθηνα");
        viewStub.setDepartureTime("9:00AM");

        presenter = new TrackResultsPresenter(viewStub,dataHelper.getRouteData());

        Assert.assertEquals("Route does not exist",viewStub.getMessage());
    }

    @Test
    public void onShowAlert() {
        Assert.assertEquals("", viewStub.getMessage());
        presenter.onShowAlert("hello");
        Assert.assertEquals("hello", viewStub.getMessage());
    }
}
