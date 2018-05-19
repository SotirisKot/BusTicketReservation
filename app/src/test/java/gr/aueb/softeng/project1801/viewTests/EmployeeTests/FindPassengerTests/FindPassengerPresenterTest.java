package gr.aueb.softeng.project1801.viewTests.EmployeeTests.FindPassengerTests;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;
import gr.aueb.softeng.project1801.view.Employee.FindPassenger.FindPassengerPresenter;

import static org.junit.Assert.*;

public class FindPassengerPresenterTest {

    private Initializer dataHelper;
    private FindPassengerPresenter presenter;
    private FindPassengerViewStub viewStub;

    /**
     * Initializing the necessary objects.
     *
     * This method creates a Initializer,PrintTicketPresenter,PrintTicketViewStub object and sets values to it.
     */
    @Before
    public void setUp() throws Exception {
        dataHelper = new DataInitializer();
        dataHelper.prepareData();
        viewStub = new FindPassengerViewStub();
        presenter = new FindPassengerPresenter(viewStub);
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
     * This method returns a passenger's FirstName.
     * @return a String object that has the passenger's FirstName
     */
    @Test
    public void onGetPassengerFirstname() {
    }

    /**
     * This method returns a passenger's LastName.
     * @return a String object that has the passenger's LastName
     */
    @Test
    public void onGetPassengerLastname() {
    }

    /**
     * This method return a passenger's ID.
     * @return a String object that has the passenger's ID
     */
    @Test
    public void onGetPassengerID() {
    }

    /**
     * This methods helps us to find a specific passenger.
     */
    @Test
    public void onFindPassenger() {
    }
}