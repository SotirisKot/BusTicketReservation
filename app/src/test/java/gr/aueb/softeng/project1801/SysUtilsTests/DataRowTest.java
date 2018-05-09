package gr.aueb.softeng.project1801.SysUtilsTests;

import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.project1801.SysUtils.DataRow;

import static org.junit.Assert.*;

/**
 * Created by p3150091 on 8/5/2018.
 */
public class DataRowTest {

    private String data1;
    private String data2;
    private String data3;
    private String data4;
    private DataRow dataRow;


    /**
     * Initializing data.
     *
     * This method initializes the training data.
     */
    @Before
    public void setUp() throws Exception {
        data1 = new String("data1");
        data2 = new String("data2");
        data3 = new String("data3");
        data4 = new String("data4");
        dataRow = new DataRow(data1,data2,data3,data4);

    }

    /** @return data1 passed to the constructor.  */
    @Test
    public void getData1() throws Exception {
        assertTrue(dataRow.getData1().equals(data1));
    }

    /** @return data2 passed to the constructor.  */
    @Test
    public void getData2() throws Exception {
        assertTrue(dataRow.getData2().equals(data2));
    }

    /** @return data3 passed to the constructor.  */
    @Test
    public void getData3() throws Exception {
        assertTrue(dataRow.getData3().equals(data3));
    }

    /** @return data4 passed to the constructor.  */
    @Test
    public void getData4() throws Exception {
        assertTrue(dataRow.getData4().equals(data4));
    }

}