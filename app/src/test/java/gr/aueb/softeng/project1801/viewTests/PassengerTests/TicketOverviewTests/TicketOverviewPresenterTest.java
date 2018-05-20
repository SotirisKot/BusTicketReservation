package gr.aueb.softeng.project1801.viewTests.PassengerTests.TicketOverviewTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.SysUtils.SeatRow;
import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;
import gr.aueb.softeng.project1801.view.Passenger.TicketOverview.TicketOverviewPresenter;

public class TicketOverviewPresenterTest {

    private Initializer dataHelper;
    private TicketOverviewViewStub viewStub;
    private TicketOverviewPresenter presenter;
    private List<SeatRow> seats = new ArrayList<>();

    /**
     * Initializing the necessary objects.
     *
     * This method creates a Initializer,TicketOverviewPresenter,TicketOverviewViewStub object and sets values to it.
     */
    @Before
    public void setUp() {
        dataHelper = new DataInitializer();
        dataHelper.prepareData();
        viewStub = new TicketOverviewViewStub();
        viewStub.setDepartureDate("2018/04/23");
        viewStub.setDeparturePoint("Ναυπλιο");
        viewStub.setDestination("Αθηνα");
        viewStub.setDepartureTime("9:00AM");
        seats.add(new SeatRow("1",1));
        seats.add(new SeatRow("2",2));
        seats.add(new SeatRow("3",3));
        viewStub.setSeats(seats);
        presenter = new TicketOverviewPresenter(viewStub);

    }

    /**
     * This method helps us to validate the letters of a name.
     * The name contains invalid characters.
     */
    @Test
    public void ValidateLettersWithInvalidName() {
        viewStub.setPassengerFirstname("Sotiris123");
        Assert.assertTrue(!presenter.validateOnlyLetters(viewStub.getPassengerFirstname()));
    }

    /**
     * This method helps us to validate the letters of a name.
     * The name does not contain invalid characters.
     */
    @Test
    public void ValidateLettersWithValidName() {
        viewStub.setPassengerFirstname("sotiris");
        Assert.assertTrue(presenter.validateOnlyLetters(viewStub.getPassengerFirstname()));
    }

    /**
     * This method sets the price of a ticket to half.
     */
    @Test
    public void setPriceHalf() {
        viewStub.setType("Student 50% off : 7.5€");
        presenter.onSetPrice(viewStub.getType());
        Assert.assertEquals("7.5",viewStub.getPrice());
    }

    /**
     * This method sets the price of a ticket to full.
     */
    @Test
    public void setPriceFull() {
        viewStub.setType("Full ticket : 14€");
        presenter.onSetPrice(viewStub.getType());
        Assert.assertEquals("14",viewStub.getPrice());
    }

    /**
     * This method returns a passenger's FirstName.
     */
    @Test
    public void OnGetPassengerFirstname() {
        viewStub.setPassengerFirstname("Sotiris");
        Assert.assertEquals("Sotiris",presenter.OngetPassengerFirstname());
    }

    /**
     * This method returns a passenger's LastName.
     */
    @Test
    public void OnGetPassengerLastname() {
        viewStub.setPassengerLastname("Kotitsas");
        Assert.assertEquals("Kotitsas",presenter.OngetPassengerLastname());
    }

    /**
     * This method tries to test the method "clickContintue" with specific data.
     * The data are invalid.
     */
    @Test
    public void clickContinueWithInvalidData() {
        viewStub.setPassengerFirstname("Sotiris1");
        viewStub.setPassengerLastname("Kotitsas");

        presenter.onClickContinue(viewStub.getPassengerFirstname(),viewStub.getPassengerLastname());
        Assert.assertEquals("Invalid firstname or lastname.Must not be empty and only letters.",viewStub.getMessage());
    }

    /**
     * This method tries to test the method "clickContintue" with specific data.
     * The data are valid.
     */
    @Test
    public void clickContinuewithValidInfo() {
        viewStub.setPassengerFirstname("Sotiris");
        viewStub.setPassengerLastname("Kotitsas");
        viewStub.setType("Student 50% off : 7.5€");
        presenter.onSetPrice(viewStub.getType());

        presenter.onClickContinue(viewStub.getPassengerFirstname(),viewStub.getPassengerLastname());
        Assert.assertEquals("Sotiris",viewStub.getPassengerFirstname());
        Assert.assertEquals("Kotitsas",viewStub.getPassengerLastname());
        Assert.assertEquals("Αθηνα",viewStub.getDestination());
        Assert.assertEquals("Ναυπλιο",viewStub.getDeparturePoint());
        Assert.assertEquals("2018/04/23",viewStub.getDepartureDate());
        Assert.assertEquals("9:00AM",viewStub.getDepartureTime());
        Assert.assertEquals("Student 50% off : 7.5€",viewStub.getType());
        Assert.assertEquals("7.5",viewStub.getPrice());
        Assert.assertEquals("1,2,3,",viewStub.getSeat());
    }
}
