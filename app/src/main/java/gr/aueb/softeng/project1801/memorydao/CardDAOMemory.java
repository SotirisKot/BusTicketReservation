package gr.aueb.softeng.project1801.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.Card;
import gr.aueb.softeng.project1801.dao.CardDAO;


public class CardDAOMemory implements CardDAO {

    protected static List<Card> entities = new ArrayList<Card>();

    public void delete(Card card){
        entities.remove(card);
    }

    public void save(Card card){
        if(!entities.contains(card)){
            entities.add(card);
        }
    }

    public List<Card> findAll() {
        return new ArrayList<>(entities);
    }

    public Card find(String name){
        for(Card card : entities){
            if(card.getCardHolderName().equals(name)){
                return card;
            }
        }
        return null;
    }
}
