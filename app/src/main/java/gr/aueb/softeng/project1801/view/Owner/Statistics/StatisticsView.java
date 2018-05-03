package gr.aueb.softeng.project1801.view.Owner.Statistics;

import java.util.List;

import gr.aueb.softeng.project1801.SysUtils.DataRow;

public interface StatisticsView {

    void clickItem(String destination,String departurePoint,String departureDate,String departureTime);

    void loadData(List<DataRow> data);

    void showToast(String value);
}
