package gr.aueb.softeng.project1801.viewTests.PassengerTests.Search_RouteTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;
import gr.aueb.softeng.project1801.view.Passenger.Search_Route.SearchRoutePresenter;

public class SearchRoutePresenterTest {

    private Initializer dataHelper;
    private SearchRouteViewStub viewStub;
    private SearchRoutePresenter presenter;


    /**
     * Initializing the necessary objects.
     *
     * This method creates a Initializer,SearchRoutePresenter,SearchRouteViewStub object and sets values to it.
     */
    @Before
    public void setUp(){
        dataHelper = new DataInitializer();
        dataHelper.prepareData();
        viewStub = new SearchRouteViewStub();

    }

    /**
     * This method tries to load the data.
     * The data are invalid.
     */
    @Test
    public void onLoadDataWithInvalidData() {
        viewStub.setDestination("Αμερικη");
        viewStub.setDepartureDate("2018/04/23");
        viewStub.setDeparturePoint("Ναυπλιο");
        viewStub.setSeats("3");

        presenter = new SearchRoutePresenter(viewStub,dataHelper.getScheduleData());

        Assert.assertEquals("No results based on your request!!",viewStub.getValue());
    }

    /**
     * This method tries to load the data.
     * The data are valid.
     */
    @Test
    public void onLoadDataWithValidData() {
        viewStub.setDepartureDate("2018/04/23");
        viewStub.setDeparturePoint("Ναυπλιο");
        viewStub.setDestination("Αθηνα");
        viewStub.setSeats("3");

        presenter = new SearchRoutePresenter(viewStub,dataHelper.getScheduleData());

        Assert.assertEquals(1,viewStub.getData().size());
    }

    /**
     * This method helps us to test the ClickItem method.
     */
    @Test
    public void onClickItem() {
        viewStub.setDepartureDate("2018/04/23");
        viewStub.setDeparturePoint("Ναυπλιο");
        viewStub.setDestination("Αθηνα");
        viewStub.setDepartureTime("9:00AM");
        viewStub.setSeats("3");
        presenter = new SearchRoutePresenter(viewStub,dataHelper.getScheduleData());
        presenter.onclickItem("Are you sure this is the route you want?",
                viewStub.getDestination(),viewStub.getDeparturePoint(),viewStub.getDepartureDate(),
                viewStub.getDepartureTime(),viewStub.getSeats());

        Assert.assertEquals("Are you sure this is the route you want?",viewStub.getMessage());
    }

    /**
     * This method helps us to test how many times the ClickItem method was called.
     */
    @Test
    public void onclickItemTimes() {
        viewStub.setDepartureDate("2018/04/23");
        viewStub.setDeparturePoint("Ναυπλιο");
        viewStub.setDestination("Αθηνα");
        viewStub.setSeats("3");
        presenter = new SearchRoutePresenter(viewStub,dataHelper.getScheduleData());
        presenter.onFinalClick("Argos","Athens","30/06/2018","15:00","3");
        presenter.onFinalClick("Argos","Nafplio","30/06/2018","15:00","3");
        presenter.onFinalClick("Argos","Bolos","30/06/2018","15:00","3");
        presenter.onFinalClick("Argos","Ioannina","30/06/2018","15:00","3");
        Assert.assertEquals(4,viewStub.getTimesClickedItem("Argos"));

    }
}
