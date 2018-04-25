package gr.aueb.softeng.project1801.DomainModelTests;

import org.junit.Test;

import gr.aueb.softeng.project1801.Card;
import gr.aueb.softeng.project1801.SysCalendar.SystemCalendar;

import static org.junit.Assert.*;

public class CardTest {


    @Test
    public void getCardHolderName() {
        Card card = new Card();
        card.setCardID("Toni Montana");
        assertTrue(card.getCardID().equals("Toni Montana"));
    }

    @Test
    public void getCardID() {
        Card card = new Card();
        card.setCardID("6666 6666 6666 6666");
        assertTrue(card.getCardID().equals("6666 6666 6666 6666"));
    }

    @Test
    public void getExpirationDate() {
        Card card = new Card();
        SystemCalendar systemCalendar = new SystemCalendar(2020,1,1);
        card.setExpirationDate(systemCalendar);
        SystemCalendar temp_systemCalendar = new SystemCalendar(2020,1,1);
        assertTrue((card.getExpirationDate()).compareTo(temp_systemCalendar) == 0);
    }

    @Test
    public void getCVcode() {
        Card card = new Card();
        card.setCVcode(666);
        assertTrue(card.getCVcode() == 666);
    }

    @Test
    public void setCardHolderName() {
        Card card = new Card();
        card.setCardID("Toni Montana");
        assertTrue(card.getCardID().equals("Toni Montana"));
    }

    @Test
    public void setCardID() {
        Card card = new Card();
        card.setCardID("6666 6666 6666 6666");
        assertTrue(card.getCardID().equals("6666 6666 6666 6666"));
    }

    @Test
    public void setCVcode() {
        Card card = new Card();
        card.setCVcode(666);
        assertTrue(card.getCVcode() == 666);
    }

    @Test
    public void setExpirationDate() {
        Card card = new Card();
        SystemCalendar systemCalendar = new SystemCalendar(2020,1,1);
        card.setExpirationDate(systemCalendar);
        SystemCalendar temp_systemCalendar = new SystemCalendar(2020,1,1);
        assertTrue((card.getExpirationDate()).compareTo(temp_systemCalendar) == 0);
    }


    @Test
    public void equals() {
        String cardHolderName = "Toni Montana";
        String cardID = "6666 6666 6666 6666";
        int CVcode = 666;
        SystemCalendar cal = new SystemCalendar(2020,1,1);
        Card card1 = new Card();
        Card card2 = new Card();
        card1.setCardHolderName(cardHolderName);
        card1.setCardID(cardID);
        card1.setCVcode(CVcode);
        card1.setExpirationDate(cal);
        card2.setCardHolderName(cardHolderName);
        card2.setCardID(cardID);
        card2.setCVcode(CVcode);
        card2.setExpirationDate(cal);
        assertTrue(card1.equals(card2));
    }

}