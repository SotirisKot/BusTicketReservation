package gr.aueb.softeng.project1801.SysUtils;

public class DataRow {

    private String data1,data2,data3,data4;

    /**
     *
     * Constructor.
     * @param data1 (required) data1 for the list -> String.
     * @param data2 (required) data2 for the list -> String.
     * @param data3 (required) data3 for the list -> String.
     * @param data4 (required) data4 for the list -> String.
     */
    public DataRow(String data1,String data2,String data3,String data4){
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
    }

    /** @return data1 passed to the constructor.  */
    public String getData1(){
        return data1;
    }

    /** @return data2 passed to the constructor.  */
    public String getData2() {
        return data2;
    }

    /** @return data3 passed to the constructor.  */
    public String getData3() {
        return data3;
    }

    /** @return data4 passed to the constructor.  */
    public String getData4() {
        return data4;
    }
}
