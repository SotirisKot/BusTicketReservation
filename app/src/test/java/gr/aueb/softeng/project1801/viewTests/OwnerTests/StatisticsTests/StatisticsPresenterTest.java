package gr.aueb.softeng.project1801.viewTests.OwnerTests.StatisticsTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;
import gr.aueb.softeng.project1801.view.Owner.Statistics.StatisticsPresenter;


public class StatisticsPresenterTest {

    private Initializer dataHelper;
    private StatisticsPresenter presenter;
    private StatisticsViewSub viewStub;

    /**
     * Initializing the necessary objects.
     *
     * This method creates a Initializer,StatisticsPresenter,StatisticsViewSub object and sets values to it.
     */
    @Before
    public void setUp() throws Exception {
        dataHelper = new DataInitializer();
        dataHelper.prepareData();
        viewStub = new StatisticsViewSub();
        presenter = new StatisticsPresenter(viewStub, dataHelper.getRouteData());
    }


    /**
     * This method loads the data(a List).
     */
    @Test
    public void onloadData() {
        presenter.onloadData();
        Assert.assertEquals(6,viewStub.getData().size());
    }

    /**
     * This method pops up a toast.
     */
    @Test
    public void onShowToast() {
        Assert.assertEquals("", viewStub.getToast());
        presenter.onShowToast("hello");
        Assert.assertEquals("hello", viewStub.getToast());
    }

    /**
     * This method helps us to understand what the user selected.
     */
    @Test
    public void onclickItem() {
        presenter.onclickItem("Argos","Athens","30/06/2018","15:00");
        presenter.onclickItem("Naxos","Athens","30/06/2018","15:00");
        presenter.onclickItem("Argos","Ioannina","30/06/2018","10:00");
        presenter.onclickItem("Argos","Nauplio","30/06/2018","18:00");

        Assert.assertEquals(3,viewStub.getTimesClickedItem("Argos"));

    }
}