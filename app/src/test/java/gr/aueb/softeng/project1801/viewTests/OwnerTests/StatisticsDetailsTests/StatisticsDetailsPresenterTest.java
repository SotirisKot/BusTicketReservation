package gr.aueb.softeng.project1801.viewTests.OwnerTests.StatisticsDetailsTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.SysUtils.SeatRow;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;
import gr.aueb.softeng.project1801.view.Owner.StatisticsDetails.StatisticsDetailsPresenter;

public class StatisticsDetailsPresenterTest {

    private Initializer dataHelper;
    private StatisticsDetailsPresenter presenter;
    private StatisticsDetailsViewSub viewSub;

    @Before
    public void setUp() throws Exception {
        dataHelper = new DataInitializer();
        dataHelper.prepareData();
        viewSub = new StatisticsDetailsViewSub();
        viewSub.setDepartureDate("2018/04/23");
        viewSub.setDeparturePoint("Ναυπλιο");
        viewSub.setDestination("Αθηνα");
        viewSub.setDepartureTime("9:00AM");
        presenter = new StatisticsDetailsPresenter(viewSub, dataHelper.getRouteData());
    }

    @Test
    public void onShowToast() {
        Assert.assertEquals("Route: Ναυπλιο-Αθηνα", viewSub.getToast());
        presenter.onShowToast("hello");
        Assert.assertEquals("hello", viewSub.getToast());
    }

    @Test
    public void onClickDeleteButton() {
        presenter.onClickDeleteButton();
        Assert.assertEquals(viewSub.getDeleteMessage(), "");
    }

    @Test
    public void onDelete() {
        presenter.onDelete();
        Assert.assertEquals(viewSub.getDeleteMessage(), "Route successfully deleted!!");
    }
}