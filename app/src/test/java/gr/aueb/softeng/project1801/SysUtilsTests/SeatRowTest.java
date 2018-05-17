package gr.aueb.softeng.project1801.SysUtilsTests;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.SysUtils.SeatRow;

import static org.junit.Assert.*;

public class SeatRowTest {

    private SeatRow seatRow;

    /**
     * Initializing a SeatRow object.
     *
     * This method creates a SeatRow object and sets values to it.
     */
    @Before
    public void setUp() throws Exception {
        seatRow = new SeatRow("not taken",1);
    }

    /** Returns the text that is  passed to the constructor.  */
    @Test
    public void getText() {
        seatRow.setText("taken");
        assertTrue(seatRow.getText().equals("taken"));
    }

    /**
     * This method sets a specific text.
     */
    @Test
    public void setText() {
        seatRow.setText("taken");
        assertTrue(seatRow.getText().equals("taken"));
    }

    /**
     * This method helps us to check a seat as "taken".
     */
    @Test
    public void check() {
        seatRow.check();
        assertTrue(seatRow.isChecked());
    }

    /**
     * This method helps us to check a seat as "not taken".
     */
    @Test
    public void uncheck() {
        seatRow.check();
        seatRow.uncheck();
        assertTrue(!seatRow.isChecked());
    }

    /**
     * This method helps us to check if a seat as "taken" or "not taken".
     */
    @Test
    public void isChecked() {
        assertTrue(!seatRow.isChecked());
        seatRow.check();
        assertTrue(seatRow.isChecked());
    }

    /**
     * This method returns a the number of the seat.
     */
    @Test
    public void getNum() {
        assertTrue(seatRow.getNum() == 1);
    }
}