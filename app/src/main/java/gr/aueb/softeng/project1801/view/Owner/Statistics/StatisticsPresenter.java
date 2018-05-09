package gr.aueb.softeng.project1801.view.Owner.Statistics;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.SysUtils.DataRow;
import gr.aueb.softeng.project1801.dao.RouteDAO;


public class StatisticsPresenter {

    private StatisticsView view;
    private RouteDAO routeDAO;

    private List<DataRow> createData(List<Route> routes){
        List<DataRow> data = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        for(Route route : routes){
            data.add(new DataRow(route.getDeparturePoint()+"  -",route.getDestination(),
                    dateFormat.format(route.getDepartureDate().getJavaCalendar().getTime()),route.getDepartureTime()));

        }

        return data;
    }

    public StatisticsPresenter(StatisticsView view,RouteDAO schedule){
        this.view = view;
        this.routeDAO = schedule;

        onloadData();
    }

    public void onloadData(){
        view.loadData(createData(routeDAO.findAll()));
    }

    public void onShowToast(String value)
    {
        view.showToast(value);
    }

    public void onclickItem(String destination,String departurePoint,String departureDate,String departureTime){
        view.clickItem(destination,departurePoint,departureDate,departureTime);
    }

}
