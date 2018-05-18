package gr.aueb.softeng.project1801.viewTests.OwnerTests.StatisticsDetailsTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;
import gr.aueb.softeng.project1801.view.Owner.StatisticsDetails.StatisticsDetailsPresenter;

public class StatisticsDetailsPresenterTest {

    private Initializer dataHelper;
    private StatisticsDetailsPresenter presenter;
    private StatisticsDetailsViewStub viewStub;

    /**
     * Initializing the necessary objects.
     *
     * This method creates a Initializer,StatisticsDetailsPresenter,StatisticsDetailsViewStub object and sets values to it.
     */
    @Before
    public void setUp() throws Exception {
        dataHelper = new DataInitializer();
        dataHelper.prepareData();
        viewStub = new StatisticsDetailsViewStub();
        viewStub.setDepartureDate("2018/04/23");
        viewStub.setDeparturePoint("Ναυπλιο");
        viewStub.setDestination("Αθηνα");
        viewStub.setDepartureTime("9:00AM");
        presenter = new StatisticsDetailsPresenter(viewStub, dataHelper.getRouteData());
    }

    /**
     * This method pops up a toast.
     */
    @Test
    public void onShowToast() {
        Assert.assertEquals("Route: Ναυπλιο-Αθηνα", viewStub.getToast());
        presenter.onShowToast("hello");
        Assert.assertEquals("hello", viewStub.getToast());
    }

    /**
     * This method prints a warning dialog message before deletion in order to ensure the process that is going to be executed.
     */
    @Test
    public void onClickDeleteButton() {
        presenter.onClickDeleteButton();
        Assert.assertEquals(viewStub.getDeleteMessage(), "");
    }

    /**
     * This method deletes a specific route.
     */
    @Test
    public void onDelete() {
        presenter.onDelete();
        Assert.assertEquals(viewStub.getDeleteMessage(), "Route successfully deleted!!");
    }
}