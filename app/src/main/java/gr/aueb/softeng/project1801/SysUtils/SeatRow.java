package gr.aueb.softeng.project1801.SysUtils;


import java.io.Serializable;

public class SeatRow implements Serializable {

    private String seat;
    private boolean checked;
    private int num;

    public SeatRow(String text,int i){
        this.seat = text;
        this.checked = false;
        this.num = i;
    }

    public String getText() {
        return seat;
    }

    public void setText(String text){
        this.seat = text;
    }


    public void check(){
        checked = true;
    }

    public void uncheck(){
        checked = false;
    }

    public boolean isChecked(){
        if(checked){
            return true;
        }else{
            return false;
        }
    }

    public int getNum() {
        return num;
    }
}
