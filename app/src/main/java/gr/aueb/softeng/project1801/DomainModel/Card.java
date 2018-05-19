package gr.aueb.softeng.project1801.DomainModel;


import java.util.Objects;

import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;

public class Card {

    private String CardHolderName;
    private String CardID;
    private SystemCalendar ExpirationDate;
    private int CVcode;

    /**
     *
     * Constructor.
     * @param CardHolderName (required) Card Holder Name of the card.
     * @param CardID (required) card ID of the card.
     * @param ExpirationDate (required) expiration date of the card.
     */
    public Card(String CardHolderName,String CardID,SystemCalendar ExpirationDate,int CVcode){
        this.CardHolderName = CardHolderName;
        this.CardID = CardID;
        this.ExpirationDate = ExpirationDate;
        this.CVcode = CVcode;
    }

    /**
     *
     * Default constructor,which constructs a Card object.
     */
    public  Card() {}

    /** @return Card Holder Name passed to the constructor.  */
    public String getCardHolderName() {
        return CardHolderName;
    }

    /** @return Card ID passed to the constructor.  */
    public String getCardID() {
        return CardID;
    }

    /** @return Expiration Date of the card.  */
    public SystemCalendar getExpirationDate() {
        return ExpirationDate;
    }

    /** @return CV code of the card.  */
    public int getCVcode() {
        return CVcode;
    }

    //Setters

    /**
     *
     * @param cardHolderName Card Holder Name to set
     */
    public void setCardHolderName(String cardHolderName) {
        CardHolderName = cardHolderName;
    }

    /**
     *
     * @param cardID card ID to set
     */
    public void setCardID(String cardID) {
        CardID = cardID;
    }

    /**
     *
     * @param CVcode CV code to set
     */
    public void setCVcode(int CVcode) {
        this.CVcode = CVcode;
    }

    /**
     *
     * @param expirationDate expiration Date to set
     */
    public void setExpirationDate(SystemCalendar expirationDate) {
        ExpirationDate = expirationDate;
    }


    /**
     * Comparing two objects.
     *
     * This method checks if two object are the same.
     * @param o must be an object.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return CVcode == card.CVcode &&
                CardHolderName.equals(card.CardHolderName) &&
                CardID.equals(card.CardID) &&
                ExpirationDate.equals(card.ExpirationDate);
    }

    /**
     * Getting the hashCode of an object.
     *
     * This method checks if two object has the same hasCode.
     * If the method equals returned "true" the hasCode of the two objects must be the same.
     * If the method equals returned "false" the hasCode of the two objects must not be the same.
     */
    @Override
    public int hashCode(){
        if(CardHolderName == null && CardID == null && CVcode == 0 && ExpirationDate == null){
            return 0;
        }

        int result = 0;
        result = CardHolderName == null ? result : 13 * result + CardHolderName.hashCode();
        result = CardID == null ? result : 13 * result + CardID.hashCode();
        result = CVcode == 0 ? result : 13 * result + CVcode;
        result = ExpirationDate == null ? result : 13 * result + ExpirationDate.hashCode();

        return result;
    }

}
