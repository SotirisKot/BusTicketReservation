package gr.aueb.softeng.project1801.SysUtils;


import java.io.Serializable;

public class SeatRow implements Serializable {

    private String seat;
    private boolean checked;
    private int num;

    /**
     *
     * Constructor.
     * @param text (required) the text that we want a seat to have("taken" or "not taken").
     * @param i (required) the number of the seat.
     * by default the seat is "not taken"
     */
    public SeatRow(String text,int i){
        this.seat = text;
        this.checked = false;
        this.num = i;
    }

    /**
     *
     * Default constructor,which constructs a SeatRow object.
     */
    public SeatRow(){}

    /**
     * This method returns a specific text.
     * @return a String object that has the text
     */
    public String getText() {
        return seat;
    }

    /**
     * This method sets a specific text.
     * @param text , the text that we want to set
     */
    public void setText(String text){
        this.seat = text;
    }


    /**
     * This method helps us to check a seat as "taken".
     */
    public void check(){
        checked = true;
    }

    /**
     * This method helps us to check a seat as "not taken".
     */
    public void uncheck(){
        checked = false;
    }

    /**
     * This method helps us to check if a seat as "taken" or "not taken".
     */
    public boolean isChecked(){
        if(checked){
            return true;
        }else{
            return false;
        }
    }

    /**
     * This method returns a the number of the seat.
     * @return an integer that has the number of the seat
     */
    public int getNum() {
        return num;
    }
}
