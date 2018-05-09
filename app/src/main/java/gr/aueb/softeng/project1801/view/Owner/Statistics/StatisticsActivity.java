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


    /** This method creates the layout and initializes the activity.
     * @param savedInstanceState, the Instance state
     */
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

    /**
     * This method loads the data(a List).
     * @param data, the list that is going to be loaded
     */
    public void loadData(List<DataRow> data) {
       adapter.loadData(data);
    }

    /**
     *
     * This method method redirects the user to another activity after a click event.
     * @param departurePoint, the departure point of the route
     * @param destination, the destination of the route
     * @param departureDate, the departure date of the route
     * @param departureTime, the departure time of the route
     */
    public void clickItem(String departurePoint,String destination,String departureDate,String departureTime){
        Intent intent = new Intent(this,StatisticsDetailsActivity.class);
        intent.putExtra("destination",destination);
        intent.putExtra("departurePoint",departurePoint);
        intent.putExtra("departureDate",departureDate);
        intent.putExtra("departureTime",departureTime);
        startActivityForResult(intent,1);
    }

    /**
     * This method pops up a toast.
     * @param value, the message we want to print in the toast
     */
    @Override
    public void showToast(String value) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }

    /**
     * This method submits the text.
     * @param query, sets the text as a query
     * @return false
     */
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    /**
     * This method alters the text.
     * @param newText, the text that is going to be altered
     * @return true
     */
    @Override
    public boolean onQueryTextChange(String newText) {
        Filter filter = adapter.getFilter();
        filter.filter(newText);
        return true;
    }

    /**
     * This method clears the text of the search bar.
     * @return true
     */
    @Override
    public boolean onClose() {
        clear_search_results();
        return true;
    }

    /**
     * This method clears the text that is being written in the search bar.
     */
    private void clear_search_results() {
        searchListRoute.setQuery("", false);
        searchListRoute.clearFocus();
        presenter.onloadData();
    }

    /** This method recreates the activity with a new instance in case of the requested code gets the value "1".
     * @param requestCode, the requested code
     * @param resultCode, the result code
     * @param data, the intent
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){//deletion successful...recreate the activity
            recreate();
        }
    }
}
