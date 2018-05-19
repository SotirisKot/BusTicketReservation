package gr.aueb.softeng.project1801.viewTests.OwnerTests.ManageRoutesTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;
import gr.aueb.softeng.project1801.view.Owner.ManageRoutes.ManageRoutesPresenter;

public class ManageRoutesPresenterTest {

    private Initializer dataHelper;
    private ManageRoutesPresenter presenter;
    private ManageRoutesViewStub viewStub;
    private String date1,date2,date3,date4;

    /**
     * Initializing the necessary objects.
     *
     * This method creates a Initializer,ManageRoutesPresenter,ManageRoutesViewStub object and sets values to it.
     */
    @Before
    public void setUp() throws Exception {
        dataHelper = new DataInitializer();
        dataHelper.prepareData();
        viewStub = new ManageRoutesViewStub();
        presenter = new ManageRoutesPresenter(viewStub, dataHelper.getScheduleData(), dataHelper.getBusData(), dataHelper.getDriverData());
        date1 = "2018/06/29";
        date2 = "2000/3/29";
        date3 = "2018/34/2";
        date4 = "2018/4/234";
    }

    /**
     * This method adds a route.
     * Checks if the date and all the other objects we must have in order to create a route and then decides whether it can add the new route or not.
     */
    @Test
    public void addRouteWhenAllInfoValid() {
        viewStub.setDepartureDate("2018/06/30");
        viewStub.setDeparturePoint("Ναυπλιο");
        viewStub.setDestination("Αθηνα");
        viewStub.setDepartureTime("9:00AM");
        viewStub.setBusID("T260");
        viewStub.setDriverID("RK1997");
        viewStub.setEstimatedArrivalTime("11:00PM");
        Assert.assertFalse(viewStub.isNewAdded());
        presenter.addRoute();
        Assert.assertEquals("Route created..will be added to the schedule!!",viewStub.getshowSuccessMessage());
        Assert.assertTrue(viewStub.isNewAdded());
    }

    /**
     * This method adds a route.
     * Checks if the date and all the other objects we must have in order to create a route and then decides whether it can add the new route or not.
     */
    @Test
    public void addRouteWhenDateNotValid(){
        viewStub.setDepartureDate("2018/06/234");
        viewStub.setDeparturePoint("Ναυπλιο");
        viewStub.setDestination("Αθηνα");
        viewStub.setDepartureTime("9:00AM");
        viewStub.setBusID("T260");
        viewStub.setDriverID("RK1997");
        viewStub.setEstimatedArrivalTime("11:00PM");
        Assert.assertFalse(viewStub.isNewAdded());
        presenter.addRoute();
        Assert.assertEquals("Invalid Date...Try again!!",viewStub.getAlertMessage());
        Assert.assertTrue(!viewStub.isNewAdded());
    }

    /**
     * This method adds a route.
     * Checks if the date and all the other objects we must have in order to create a route and then decides whether it can add the new route or not.
     */
    @Test
    public void addRouteWhenScheduleEntryAlreadyExists(){
        viewStub.setDepartureDate("2018/04/23");
        viewStub.setDeparturePoint("Ναυπλιο");
        viewStub.setDestination("Αθηνα");
        viewStub.setDepartureTime("9:00AM");
        viewStub.setBusID("T260");
        viewStub.setDriverID("RK1997");
        viewStub.setEstimatedArrivalTime("11:00PM");
        Assert.assertFalse(viewStub.isNewAdded());
        presenter.addRoute();
        Assert.assertEquals("Schedule Entry slot is taken..." + "\n" +
                " TRY: 2018/04/30 at 9:00AM",viewStub.getAlertMessage());
        Assert.assertTrue(!viewStub.isNewAdded());
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


}