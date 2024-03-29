package gr.aueb.softeng.project1801.daoMemoryTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.DomainModel.Card;
import gr.aueb.softeng.project1801.dao.CardDAO;
import gr.aueb.softeng.project1801.dao.Initializer;
import gr.aueb.softeng.project1801.memorydao.CardDAOMemory;
import gr.aueb.softeng.project1801.memorydao.DataInitializer;

import static org.junit.Assert.*;

public class CardDAOMemoryTest {

    private Card card1 = new Card();
    private Card card2 = new Card();
    private Card card3 = new Card();
    private Card card4 = new Card();
    private CardDAO cardDAO;
    private Initializer dataHelper = new DataInitializer();

    /**
     * Initializing data.
     *
     * This method initializes the training data.
     */
    @Before
    public void setUp(){
        card1.setCardHolderName("Sotirios Kotitsas");
        card2.setCardHolderName("Giorgios Chatzopoulos");
        card3.setCardHolderName("Tasos Lepipas");
        card4.setCardHolderName("Nikos Lyberopoulos");

        dataHelper.prepareData();
        cardDAO = dataHelper.getCardData();
        cardDAO.save(card1);
        cardDAO.save(card2);
        cardDAO.save(card3);
        cardDAO.save(card4);
    }

    @After
    public void tearDown(){ }

    /**
     * Deleting a card;
     *
     * This method deletes a card from the database.
     */
    @Test
    public void deleteCard() {
        Card card5 = new Card();
        card5.setCardHolderName("Toni Montana");
        cardDAO.save(card5);
        cardDAO.delete(card5);
        assertTrue(!cardDAO.findAll().contains(card5));

    }

    /**
     * Saving a new card.
     *
     * This method saves a new card in the database.
     */
    @Test
    public void saveCard(){
        Card card5 = new Card();
        card5.setCardHolderName("Toni Montana");
        cardDAO.save(card5);
        Assert.assertTrue(cardDAO.findAll().contains(card5));
        Assert.assertNotNull(cardDAO.find("Toni Montana"));
    }

    /**
     * Finding all the cards.
     * This method finds and returns all the cards that are saved in the database.
     */
    @Test
    public void findAllCards(){
        assertTrue(cardDAO.findAll().contains(card1));
        assertTrue(cardDAO.findAll().contains(card2));
        assertTrue(cardDAO.findAll().contains(card3));
        assertTrue(cardDAO.findAll().contains(card4));
        assertTrue(cardDAO.findAll().size() == 5);
    }

    /**
     * Finding a specific card.
     *
     * This method finds a card based on the CardID.
     */
    @Test
    public void findCard() {
        Card card5 = new Card();
        card5.setCardHolderName("Toni Montana");
        cardDAO.save(card5);
        assertTrue(cardDAO.find("Toni Montana").equals(card5));

    }
}