package gr.aueb.softeng.project1801.daoMemoryTests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Card;
import gr.aueb.softeng.project1801.DomainModel.Schedule;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.CardDAO;
import gr.aueb.softeng.project1801.memorydao.CardDAOMemory;

import static org.junit.Assert.*;

public class CardDAOMemoryTest {

    private Card card1 = new Card();
    private Card card2 = new Card();
    private Card card3 = new Card();
    private Card card4 = new Card();
    private CardDAO cardDAO;
  //  private List<Card> cardList = new ArrayList<>();


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

        cardDAO = new CardDAOMemory();
        cardDAO.save(card1);
        cardDAO.save(card2);
        cardDAO.save(card3);
        cardDAO.save(card4);
    }

    /**
     * Deleting a card;
     *
     * This method deletes a card from the database.
     */
    @Test
    public void delete() {
        Card card5 = new Card();
        card5.setCardHolderName("Toni Montana");
        cardDAO.save(card5);
        cardDAO.delete(card5);
        assertTrue(!cardDAO.findAll().contains(card5));

/*        if(cardList.contains(card3)){
            cardList.remove(card3);
        }
        assertTrue(!cardList.contains(card3));*/

    }

    /**
     * Saving a new card.
     *
     * This method saves a new card in the database.
     */
    @Test
    public void save(){
        Card card5 = new Card();
        card5.setCardHolderName("Toni Montana");
        cardDAO.save(card5);
        assertTrue(cardDAO.findAll().contains(card5));


      /*  if(!cardList.contains(card5)){
            cardList.add(card5);
        }
        assertTrue(cardList.contains(card5));*/
    }

    /**
     * Finding all the cards.
     *
     * This method finds and returns all the cards that are saved in the database.
     * @return all the cards
     */
    @Test
    public void findAll(){

        assertTrue(cardDAO.findAll().contains(card1));
        assertTrue(cardDAO.findAll().contains(card2));
        assertTrue(cardDAO.findAll().contains(card3));
        assertTrue(cardDAO.findAll().contains(card4));
        assertTrue(cardDAO.findAll().size() == 4);

    /*    for (Card card : cardList) {
            assertTrue(cardList.contains(card));
        }
        assertTrue(cardList.contains(card1));
        assertTrue(cardList.contains(card2));
        assertTrue(cardList.contains(card3));
        assertTrue(cardList.contains(card4));
*/

    }
    /**
     * Finding a specific card.
     *
     * This method finds a card based on the CardID.
     */
    @Test
    public void find() {
        Card card5 = new Card();
        card5.setCardHolderName("Toni Montana");
        cardDAO.save(card5);
        assertTrue(cardDAO.find("Toni Montana").equals(card5));

  /*      for(Card card: cardList){
            if(card.getCardID().equals("5733")){
                assertTrue(card3.getCardID().equals("5733"));
                break;
            }
        }
        assertTrue(!(card3.getCardID().equals("1232")));
        assertTrue(!(card3.getCardID().equals("4512")));
        assertTrue(!(card3.getCardID().equals("1674")));
    }*/
    }
}