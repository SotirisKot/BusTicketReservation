package gr.aueb.softeng.project1801.SysUtils;

public class DataRow {

    private String data1,data2,data3,data4;

    public DataRow(String data1,String data2,String data3,String data4){
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
    }

    public String getData1(){
        return data1;
    }

    public String getData2() {
        return data2;
    }

    public String getData3() {
        return data3;
    }

    public String getData4() {
        return data4;
    }
}
