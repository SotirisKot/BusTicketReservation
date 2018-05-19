package gr.aueb.softeng.project1801.viewTests.EmployeeTests.PrintTicketOverviewTests;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;
import gr.aueb.softeng.project1801.view.Employee.PrintTicketOverView.PrintTicketPresenter;

import static org.junit.Assert.*;

public class PrintTicketPresenterTest {

    private Initializer dataHelper;
    private PrintTicketPresenter presenter;
    private PrintTicketViewStub viewStub;

    /**
     * Initializing the necessary objects.
     *
     * This method creates a Initializer,PrintTicketPresenter,PrintTicketViewStub object and sets values to it.
     */
    @Before
    public void setUp() throws Exception {
        dataHelper = new DataInitializer();
        dataHelper.prepareData();
        viewStub = new PrintTicketViewStub();
        presenter = new PrintTicketPresenter(viewStub, dataHelper.getScheduleData());
    }

    /**
     * This method pops up a toast.
     */
    @Test
    public void onShowToast() {
    }

    /**
     * This method pops up an alert message.
     */
    @Test
    public void onShowAlertMessage() {
    }

    /**
     * This method helps us to print a passenger's ticket.
     */
    @Test
    public void onPrintTicket() {
    }
}