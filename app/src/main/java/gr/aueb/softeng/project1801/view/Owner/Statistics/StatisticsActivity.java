package gr.aueb.softeng.project1801.view.Owner.Statistics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import java.util.List;
import gr.aueb.softeng.project1801.SysUtils.DataRow;
import gr.aueb.softeng.project1801.memorydao.RouteDAOMemory;
import gr.aueb.softeng.project1801.view.Owner.StatisticsDetails.StatisticsDetailsActivity;
import gr.aueb.softeng.project1801.view.R;
import gr.aueb.softeng.project1801.view.Util.CustomAdapter;

public class StatisticsActivity extends AppCompatActivity implements StatisticsView,SearchView.OnQueryTextListener,SearchView.OnCloseListener {

    StatisticsPresenter presenter;
    private ListView routeList;
    private CustomAdapter adapter;
    private SearchView searchListRoute;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_statistics);

        adapter = new CustomAdapter(this);

        routeList = (ListView) findViewById(R.id.route_list);
        routeList.setAdapter(adapter);
        routeList.setTextFilterEnabled(false);

        searchListRoute = (SearchView) findViewById(R.id.routes_list_search);
        searchListRoute.setOnQueryTextListener(this);
        searchListRoute.setOnCloseListener(this);

        presenter = new StatisticsPresenter(this, new RouteDAOMemory());

        routeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataRow data = (DataRow) parent.getItemAtPosition(position);
                presenter.onclickItem(data.getData1().split(" {2}-")[0],data.getData2(),data.getData3(),data.getData4());
            }
        });

    }


    public void loadData(List<DataRow> data) {
       adapter.loadData(data);
    }

    public void clickItem(String departurePoint,String destination,String departureDate,String departureTime){
        Intent intent = new Intent(this,StatisticsDetailsActivity.class);
        intent.putExtra("destination",destination);
        intent.putExtra("departurePoint",departurePoint);
        intent.putExtra("departureDate",departureDate);
        intent.putExtra("departureTime",departureTime);
        startActivity(intent);
    }

    @Override
    public void showToast(String value) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Filter filter = adapter.getFilter();
        filter.filter(newText);
        return true;
    }

    @Override
    public boolean onClose() {
        clear_search_results();
        return true;
    }

    private void clear_search_results() {
        searchListRoute.setQuery("", false);
        searchListRoute.clearFocus();
        presenter.onloadData();
    }
}
