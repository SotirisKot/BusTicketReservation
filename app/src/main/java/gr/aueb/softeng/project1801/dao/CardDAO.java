package gr.aueb.softeng.project1801.dao;

import java.util.List;

import gr.aueb.softeng.project1801.Card;

public interface CardDAO {

    /**
     * This method finds a card based on the owner's name.
     * @param cardHolderName ,the owner's name
     * @return the card
     */
    Card find(String cardHolderName);

    /**
     * This method saves a card in the database and must be linked with a passenger.
     * @param card ,the card
     */
    void save(Card card);

    /**
     * This method deletes a card from the database.
     * @param card ,the card
     */
    void delete(Card card);

    /**
     * This method finds and returns all the cards that are saved in the database.
     * @return all the cards
     */
    List<Card> findAll();
}
