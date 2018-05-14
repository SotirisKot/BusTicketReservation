package gr.aueb.softeng.project1801.view.Passenger.Search_Route;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;
import gr.aueb.softeng.project1801.SysUtils.DataRow;
import gr.aueb.softeng.project1801.memorydao.ScheduleDAOMemory;
import gr.aueb.softeng.project1801.view.Passenger.Choose_Seat.ChooseSeatActivity;
import gr.aueb.softeng.project1801.view.R;
import gr.aueb.softeng.project1801.view.Util.CustomAdapter;

public class SearchRouteActivity extends AppCompatActivity implements SearchRouteView{

    SearchRoutePresenter presenter;
    private ListView requestedRoutes;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_route_activity);

        adapter = new CustomAdapter(this);

        requestedRoutes = (ListView) findViewById(R.id.requested_route_list);
        requestedRoutes.setAdapter(adapter);

        presenter = new SearchRoutePresenter(this, new ScheduleDAOMemory());

        requestedRoutes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataRow data = (DataRow) parent.getItemAtPosition(position);
                presenter.onclickItem("Are you sure this is the route you want?",data.getData1().split(" {2}-")[0],
                        data.getData2(),data.getData3(),data.getData4(),getSeats());
            }
        });
    }

    //Επιστρεφει τον προορισμο του route
    @Override
    public String getDestination() {
        if(this.getIntent().hasExtra("destination")){
            return this.getIntent().getExtras().getString("destination");

        }else{
            return null;
        }
    }

    //Επιστρεφει την αφετηρια του Route
    @Override
    public String getDeparturePoint() {
        if(this.getIntent().hasExtra("departurePoint")){
            return this.getIntent().getExtras().getString("departurePoint");
        }else {
            return null;
        }
    }

    //Επιστρεφει την ημερομηνια αναχωρησης του route
    @Override
    public String getDepartureDate() {
        if(this.getIntent().hasExtra("departureDate")){
            return this.getIntent().getExtras().getString("departureDate");
        }else{
            return null;
        }
    }

    @Override
    public String getSeats(){
        if(this.getIntent().hasExtra("seats")){
            return this.getIntent().getExtras().getString("seats");
        }else{
            return null;
        }
    }

    @Override
    public void showToast(String value) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showAlertMessage(String message, final String departurePoint, final String destination, final String departureDate, final String departureTime,
                                 final String seats){
        AlertDialog.Builder alert = new AlertDialog.Builder(SearchRouteActivity.this);
        alert.setCancelable(true);
        DialogInterface.OnClickListener Positivelistener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.onFinalClick(destination,departurePoint,departureDate,departureTime,seats);
            }
        };
        DialogInterface.OnClickListener Negativelistener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("Purchase Cancelled");

            }
        };
        alert.setPositiveButton(R.string.yes_button,Positivelistener);
        alert.setNegativeButton(R.string.no_button,Negativelistener);
        alert.setMessage(message);
        alert.create().show();
    }

    @Override
    public void clickItem(String destination,String departurePoint,String departureDate,String departureTime,String seats){
        Intent intent = new Intent(this, ChooseSeatActivity.class);
        intent.putExtra("destination",destination);
        intent.putExtra("departurePoint",departurePoint);
        intent.putExtra("departureDate",departureDate);
        intent.putExtra("departureTime",departureTime);
        intent.putExtra("seats",seats);
        startActivityForResult(intent,1);
    }

    @Override
    public void loadData(List<DataRow> data) {
        adapter.loadData(data);
    }

    @Override
    public void setActivityName(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){//purchase successful...recreate the activity
            finish();
        }
    }
}
