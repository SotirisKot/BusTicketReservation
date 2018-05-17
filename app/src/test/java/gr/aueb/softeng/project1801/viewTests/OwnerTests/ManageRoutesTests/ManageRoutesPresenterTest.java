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

    @Before
    public void setUp() throws Exception {
        dataHelper = new DataInitializer();
        dataHelper.prepareData();
        viewStub = new ManageRoutesViewStub();
        presenter = new ManageRoutesPresenter(viewStub, dataHelper.getScheduleData(), dataHelper.getBusData(), dataHelper.getDriverData());
    }

    @Test
    public void addRoute() {
        Assert.assertFalse(viewStub.isNewAdded());
        presenter.addRoute();
        Assert.assertTrue(presenter != null);
    }
}