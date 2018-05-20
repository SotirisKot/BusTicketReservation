package gr.aueb.softeng.project1801.viewTests.PassengerTests.Choose_SeatTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.SysUtils.SeatRow;
import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;
import gr.aueb.softeng.project1801.view.Passenger.Choose_Seat.ChooseSeatPresenter;

public class ChooseSeatPresenterTest {

    private Initializer dataHelper;
    private ChooseSeatsViewStub viewStub;
    private ChooseSeatPresenter presenter;
    private SeatRow seatRow;

    /**
     * Initializing the necessary objects.
     *
     * This method creates a Initializer,ChooseSeatPresenter,ChooseSeatsViewStub object and sets values to it.
     */
    @Before
    public void setUp(){
        dataHelper = new DataInitializer();
        dataHelper.prepareData();
        viewStub = new ChooseSeatsViewStub();
        viewStub.setDepartureDate("2018/04/23");
        viewStub.setDeparturePoint("Ναυπλιο");
        viewStub.setDestination("Αθηνα");
        viewStub.setDepartureTime("9:00AM");
        viewStub.setSeats("4");
        presenter = new ChooseSeatPresenter(viewStub,dataHelper.getRouteData());
    }


    /**
     * This method loads the data(a List).
     */
    @Test
    public void onloadData() {
        presenter.onloadData();
        Assert.assertEquals(30,viewStub.getData().size());
    }

    /**
     * This method checks the title that contains a num of seats.
     */
    @Test
    public void testActivityName(){
        Assert.assertEquals("You must select: 4 seats",viewStub.getTitle());
    }

    /**
     * This method checks the click seat method when the seat is already taken.
     */
    @Test
    public void testClickSeatWhenSeatAlreadyTaken(){
        seatRow = new SeatRow();
        seatRow.setText("T");
        presenter.onClickSeat(seatRow);
        Assert.assertEquals("Seat already taken",viewStub.getValue());
    }

    /**
     * This method checks the click seat method when the seat is checked.
     */
    @Test
    public void testClickSeatWhenSeatChecked(){
        seatRow = viewStub.getData().get(9);
        seatRow.check();
        Assert.assertTrue(seatRow.isChecked());
        presenter.onClickSeat(seatRow);
        Assert.assertTrue(!seatRow.isChecked());
    }

    /**
     * This method checks the click seat method when the seat is unchecked.
     */
    @Test
    public void testClickSeatWhenSeatunChecked(){
        seatRow = viewStub.getData().get(9);
        seatRow.uncheck();
        Assert.assertTrue(!seatRow.isChecked());
        presenter.onClickSeat(seatRow);
        Assert.assertTrue(seatRow.isChecked());
    }

    /**
     * This method checks the click seat method when the passenger cannot select more seats.
     */
    @Test
    public void testWhenCannotSelectMoreSeats(){
        seatRow = viewStub.getData().get(6);
        presenter.onClickSeat(seatRow);
        Assert.assertTrue(seatRow.isChecked());
        seatRow = viewStub.getData().get(9);
        presenter.onClickSeat(seatRow);
        Assert.assertTrue(seatRow.isChecked());
        seatRow = viewStub.getData().get(14);
        presenter.onClickSeat(seatRow);
        Assert.assertTrue(seatRow.isChecked());
        seatRow = viewStub.getData().get(7);
        presenter.onClickSeat(seatRow);
        Assert.assertTrue(seatRow.isChecked());
        seatRow = viewStub.getData().get(8);
        presenter.onClickSeat(seatRow);
        Assert.assertTrue(!seatRow.isChecked());
        Assert.assertEquals("You cannot select more seats.Proceed to checkout?",viewStub.getMessage());
    }

    /**
     * This method checks the method onClickProceed.
     */
    @Test
    public void onClickProceed(){
        presenter.onClickProceed();
        Assert.assertEquals("2018/04/23",viewStub.getDepartureDate());
        Assert.assertEquals("Ναυπλιο",viewStub.getDeparturePoint());
        Assert.assertEquals("Αθηνα",viewStub.getDestination());
        Assert.assertEquals("9:00AM",viewStub.getDepartureTime());
        Assert.assertEquals("4",viewStub.getSeats());
    }
}
