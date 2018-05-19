package gr.aueb.softeng.project1801.viewTests.PassengerTests.Enter_card_infoTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;
import gr.aueb.softeng.project1801.view.Passenger.Enter_card_info.cardInfoPresenter;

public class cardInfoPresenterTest {

    private Initializer dataHelper;
    private cardInfoViewStub viewStub;
    private cardInfoPresenter presenter;
    private String date1,date2,date3,date4;

    @Before
    public void setUp(){
        dataHelper = new DataInitializer();
        dataHelper.prepareData();
        viewStub = new cardInfoViewStub();
        viewStub.setDepartureDate("2018/04/23");
        viewStub.setDeparturePoint("Ναυπλιο");
        viewStub.setDestination("Αθηνα");
        viewStub.setDepartureTime("9:00AM");
        viewStub.setFirstName("Sotiris");
        viewStub.setLastName("Kotitsas");
        viewStub.setPassengerID("ΝΑ1276442282");
        viewStub.setPrice("7.5");
        viewStub.setSeats("0,1,2,3,");
        viewStub.setType("Student 50% off : 7.5€");
        presenter = new cardInfoPresenter(viewStub,dataHelper.getPassengerData(),dataHelper.getCardData());
        date1 = "2018/06/29";
        date2 = "2000/3/29";
        date3 = "2018/34/2";
        date4 = "2018/4/234";

    }

    @Test
    public void testValidateDate(){
        Assert.assertTrue(presenter.validateDate(date1));
        Assert.assertTrue(!presenter.validateDate(date2));
        Assert.assertTrue(!presenter.validateDate(date3));
        Assert.assertTrue(!presenter.validateDate(date4));
    }

    @Test
    public void testValidateLetters(){
        String name = "";
        String name1 = "12121";
        Assert.assertTrue(!presenter.validateOnlyLetters(name));
        Assert.assertTrue(!presenter.validateOnlyLetters(name1));
        Assert.assertTrue(presenter.validateOnlyLetters(viewStub.getFirstName()));
    }

    @Test
    public void testValidateOnlyDigits(){
        String code = "123dfg";
        String code1 = "dsfsdfsd";
        Assert.assertTrue(!presenter.validateOnlyDigits(code));
        Assert.assertTrue(!presenter.validateOnlyDigits(code1));
        Assert.assertTrue(presenter.validateOnlyDigits("12345567890"));
    }

    @Test
    public void testOnClickContinueWhenNameNotValid(){
        viewStub.setCardHolderName("1213");
        viewStub.setCardID("1234567890");
        viewStub.setCVcode("123");
        viewStub.setExpirationDate("2020/4/23");

        presenter.onClickContinue(viewStub.getCardHolderName(),viewStub.getCardId(),viewStub.getCVcode(),viewStub.getExpirationDate());
        Assert.assertEquals("Name field must not be empty and must be only letters.",viewStub.getMessage());
    }

    @Test
    public void testOnClickContinueWhenCardIDNotValid(){
        viewStub.setCardHolderName("Sotiris");
        viewStub.setCardID("1234567890s");
        viewStub.setCVcode("123");
        viewStub.setExpirationDate("2020/4/23");

        presenter.onClickContinue(viewStub.getCardHolderName(),viewStub.getCardId(),viewStub.getCVcode(),viewStub.getExpirationDate());
        Assert.assertEquals("Invalid format for code.Only digits!",viewStub.getMessage());
    }

    @Test
    public void testOnClickContinueWhenCVNotValid(){
        viewStub.setCardHolderName("Sotiris");
        viewStub.setCardID("1234567890");
        viewStub.setCVcode("123df");
        viewStub.setExpirationDate("2020/4/23");

        presenter.onClickContinue(viewStub.getCardHolderName(),viewStub.getCardId(),viewStub.getCVcode(),viewStub.getExpirationDate());
        Assert.assertEquals("Invalid format for cv.Only digits.",viewStub.getMessage());
    }

    @Test
    public void testOnClickContinueWhenExpDateNotValid(){
        viewStub.setCardHolderName("Sotiris");
        viewStub.setCardID("1234567890");
        viewStub.setCVcode("123");
        viewStub.setExpirationDate("2020/4/234");

        presenter.onClickContinue(viewStub.getCardHolderName(),viewStub.getCardId(),viewStub.getCVcode(),viewStub.getExpirationDate());
        Assert.assertEquals("Invalid date.",viewStub.getMessage());
    }

    @Test
    public void testOnClickContinueWhenAllValid(){
        viewStub.setCardHolderName("Sotiris");
        viewStub.setCardID("1234567890");
        viewStub.setCVcode("123");
        viewStub.setExpirationDate("2020/4/23");

        presenter.onClickContinue(viewStub.getCardHolderName(),viewStub.getCardId(),viewStub.getCVcode(),viewStub.getExpirationDate());
        Assert.assertEquals("Purchase completed!",viewStub.getMessage());
    }
}
