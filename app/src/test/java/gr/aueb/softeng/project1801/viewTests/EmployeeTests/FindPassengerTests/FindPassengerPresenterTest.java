package gr.aueb.softeng.project1801.viewTests.EmployeeTests.FindPassengerTests;

import org.junit.Assert;
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
        viewStub.setFirstName("Sotiris");
        viewStub.setLastName("Kotitsas");
        viewStub.setPassengerID("ΝΑ1276442282");
        presenter = new FindPassengerPresenter(viewStub);
    }

    /**
     * This method pops up a toast.
     */
    @Test
    public void onShowToast() {
        Assert.assertEquals("", viewStub.getValue());
        presenter.onShowToast("hello");
        Assert.assertEquals("hello", viewStub.getValue());
    }

    /**
     * This method pops up an alert message.
     */
    @Test
    public void onShowAlertMessage() {
        Assert.assertEquals("", viewStub.getMessage());
        presenter.onShowAlertMessage("hello");
        Assert.assertEquals("hello", viewStub.getMessage());
    }

    /**
     * This method test if the getter returns a passenger's FirstName.
     *
     */
    @Test
    public void onGetPassengerFirstname() {
        viewStub.setFirstName("Sotiris");
        Assert.assertEquals("Sotiris", presenter.onGetPassengerFirstname());
    }

    /**
     * This method test if the getter returns a passenger's LastName.
     *
     */
    @Test
    public void onGetPassengerLastname() {
        viewStub.setLastName("Kot");
        Assert.assertEquals("Kot", presenter.onGetPassengerLastname());
    }

    /**
     * This method test if the getter returns a passenger's ID.
     * 
     */
    @Test
    public void onGetPassengerID() {
        viewStub.setPassengerID("NA12345");
        Assert.assertEquals("NA12345", presenter.onGetPassengerID());
    }

    /**
     * This methods helps us to find a specific passenger.
     */
    @Test
    public void onFindPassengerWithInvalidFirstName() {
        viewStub.setFirstName("Sotiris1");
        presenter.onFindPassenger(viewStub.getFirstname(),viewStub.getLastname(),viewStub.getPassengerID());
        Assert.assertEquals("Names must be only letters",viewStub.getMessage());
    }

    /**
     * This methods helps us to find a specific passenger.
     */
    @Test
    public void onFindPassengerWithInvalidLastName() {
        viewStub.setLastName("Sotiris1");
        presenter.onFindPassenger(viewStub.getFirstname(),viewStub.getLastname(),viewStub.getPassengerID());
        Assert.assertEquals("Names must be only letters",viewStub.getMessage());
    }

    /**
     * This methods helps us to find a specific passenger.
     */
    @Test
    public void onFindPassengerWithValidInfo() {
        presenter.onFindPassenger(viewStub.getFirstname(),viewStub.getLastname(),viewStub.getPassengerID());
        Assert.assertEquals("Sotiris",viewStub.getFirstname());
        Assert.assertEquals("Kotitsas",viewStub.getLastname());
        Assert.assertEquals("ΝΑ1276442282",viewStub.getPassengerID());
    }

    @Test
    public void ValidateLettersWithInvalidName() {
        viewStub.setFirstName("Sotiris123");
        Assert.assertTrue(!presenter.validateOnlyLetters(viewStub.getFirstname()));
    }

    @Test
    public void ValidateLettersWithValidName() {
        viewStub.setFirstName("sotiris");
        Assert.assertTrue(presenter.validateOnlyLetters(viewStub.getFirstname()));
    }
}