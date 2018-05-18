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
    private String date;

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
        date = "2018/06/29";
    }

    /**
     * This method adds a route.
     * Checks if the date and all the other objects we must have in order to create a route and then decides whether it can add the new route or not.
     */
    @Test
    public void addRoute() {
        Assert.assertFalse(viewStub.isNewAdded());
        presenter.addRoute();
  //      Assert.assertTrue(presenter != null);
        ///!!!!
    }

    /**
     * This method validates a day.
     */
    @Test
    public void validateDate(){
        Assert.assertTrue(presenter.validateDate(date));
    }


}