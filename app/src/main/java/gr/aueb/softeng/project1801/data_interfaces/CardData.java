package gr.aueb.softeng.project1801.data_interfaces;

import java.util.List;

import gr.aueb.softeng.project1801.Card;
import gr.aueb.softeng.project1801.Passenger;

public interface CardData {

    //finds a card based on the owner's name
    Card find(String cardHolderName);

    //saves a card in the database..must be linked to a passenger
    void save(Card card);

    //deletes a card from the database
    void delete(Card card);

    //returns all the cards
    List<Card> findAll();
}
