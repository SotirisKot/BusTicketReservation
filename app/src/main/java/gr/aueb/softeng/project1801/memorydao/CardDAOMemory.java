package gr.aueb.softeng.project1801.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.Card;
import gr.aueb.softeng.project1801.dao.CardDAO;


public class CardDAOMemory implements CardDAO {

    protected static List<Card> entities = new ArrayList<Card>();

    /**
     * This method deletes a card from the database.
     * @param card ,the card
     */
    public void delete(Card card){
        entities.remove(card);
    }

    /**
     * This method saves a card in the database and must be linked with a passenger.
     * @param card ,the card
     */
    public void save(Card card){
        if(!entities.contains(card)){
            entities.add(card);
        }
    }

    /**
     * This method finds and returns all the cards that are saved in the database.
     * @return all the cards
     */
    public List<Card> findAll() {
        return new ArrayList<>(entities);
    }

    /**
     * This method finds a card based on the owner's name.
     * @param name ,the owner's name
     * @return the card that is found or null
     */
    public Card find(String name){
        for(Card card : entities){
            if(card.getCardHolderName().equals(name)){
                return card;
            }
        }
        return null;
    }
}
