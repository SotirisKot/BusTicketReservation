package gr.aueb.softeng.project1801.view.Owner.Statistics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;
import gr.aueb.softeng.project1801.SysUtils.DataRow;
import gr.aueb.softeng.project1801.memorydao.RouteDAOMemory;
import gr.aueb.softeng.project1801.view.R;
import gr.aueb.softeng.project1801.view.Util.CustomAdapter;

public class StatisticsActivity extends AppCompatActivity implements StatisticsView {

    StatisticsPresenter presenter;
    private ListView routeList;
    private CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_statistics);

        adapter = new CustomAdapter(this);

        routeList = (ListView) findViewById(R.id.route_list);
        routeList.setAdapter(adapter);

        presenter = new StatisticsPresenter(this, new RouteDAOMemory());

        routeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataRow data = (DataRow) parent.getItemAtPosition(position);
                presenter.onclickItem(data.getData1(),data.getData2(),data.getData3(),data.getData4());
            }
        });

    }


    public void loadData(List<DataRow> data) {
       adapter.loadData(data);
    }

    public void clickItem(String destination,String departurePoint,String departureDate,String departureTime){
        Intent intent = new Intent(this,StatisticsActivity.class);
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
}
