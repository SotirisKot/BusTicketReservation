package gr.aueb.softeng.project1801;


import gr.aueb.softeng.project1801.SysCalendar.SystemCalendar;

public class Card {

    private String CardHolderName;
    private String CardID;
    private SystemCalendar ExpirationDate;
    private int CVcode;

    //Constructor
    public Card(String CardHolderName,String CardID,SystemCalendar ExpirationDate){
        this.CardHolderName = CardHolderName;
        this.CardID = CardID;
        this.ExpirationDate = ExpirationDate;
    }

    public  Card() {}

    //Returns the card's CardHolderName
    public String getCardHolderName() {
        return CardHolderName;
    }

    //Returns the card's CardID
    public String getCardID() {
        return CardID;
    }

    //Returns the card's ExpirationDate
    public SystemCalendar getExpirationDate() {
        return ExpirationDate;
    }

    //Returns the card's CVcode
    public int getCVcode() {
        return CVcode;
    }

    //Setters
    public void setCardHolderName(String cardHolderName) {
        CardHolderName = cardHolderName;
    }

    public void setCardID(String cardID) {
        CardID = cardID;
    }

    public void setCVcode(int CVcode) {
        this.CVcode = CVcode;
    }

    public void setExpirationDate(SystemCalendar expirationDate) {
        ExpirationDate = expirationDate;
    }


    //Overrides equals
    @Override
    public boolean equals(Object other){
        if(other == null){
            return false;
        }

        if(this == other){
            return false;
        }

        Card theCard = (Card) other;
        if(! (CardHolderName == null ? theCard.CardHolderName == null
                : CardHolderName.equals(theCard.CardHolderName))){
            return false;
        }

        if(! (CardID == null ? theCard.CardID == null
                : CardID.equals(theCard.CardID))){
            return false;
        }

        if(! (ExpirationDate == null ? theCard.ExpirationDate == null
                : ExpirationDate.equals(theCard.ExpirationDate))){
            return false;
        }

        if(! (CVcode == 0 ? theCard.CVcode == 0
                : CVcode == theCard.CVcode)){
            return false;
        }

        return true;
    }

    //Overrides hashCode
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
