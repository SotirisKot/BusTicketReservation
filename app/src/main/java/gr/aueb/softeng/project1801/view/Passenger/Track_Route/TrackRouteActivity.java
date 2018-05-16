package gr.aueb.softeng.project1801.view.Passenger.Track_Route;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import gr.aueb.softeng.project1801.memorydao.ScheduleDAOMemory;
import gr.aueb.softeng.project1801.view.Passenger.Buy_Ticket.BuyTicketPresenter;
import gr.aueb.softeng.project1801.view.Passenger.TrackResults.TrackResultsActivity;
import gr.aueb.softeng.project1801.view.R;

public class TrackRouteActivity extends AppCompatActivity implements TrackRouteView {

    private TrackRoutePresenter presenter;

    @Override
    public String getDepartureDate(){
        return ((EditText)findViewById(R.id.departure_date_text)).getText().toString().trim();
    }

    @Override
    public String getDepartureTime(){
        return ((Spinner)findViewById(R.id.times_list)).getSelectedItem().toString().trim();
    }

    @Override
    public String getDestination(){
        return ((Spinner) findViewById(R.id.destinations_list)).getSelectedItem().toString().trim();
    }

    @Override
    public String getDeparturepoint() {
        return ((Spinner) findViewById(R.id.departure_points)).getSelectedItem().toString().trim();
    }

    @Override
    public void setActivityName(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void showAlertMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(TrackRouteActivity.this);
        alert.setCancelable(true);
        alert.setMessage(message);
        alert.setPositiveButton(R.string.ok_button,null);

        alert.create().show();
    }

    @Override
    public void setDestinationsList(List<String> destinations) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,destinations);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.destinations_list)).setAdapter(arrayAdapter);
    }

    @Override
    public void setDeparturePointsList(List<String> departures) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,departures);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.departure_points)).setAdapter(arrayAdapter);
    }


    @Override
    public void setDepartureTimesList(List<String> departuretimes) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,departuretimes);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.times_list)).setAdapter(arrayAdapter);
    }

    @Override
    public void ShowToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_route_activity);

        presenter = new TrackRoutePresenter(this,new ScheduleDAOMemory());

        findViewById(R.id.search_route_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onTrackRoute(presenter.onGetDestination(),presenter.onGetDeparture(),
                        presenter.onGetDepartureDate(),presenter.onGetDepartureTime());
            }
        });
    }

    @Override
    public void trackRoute(String destination,String departurePoint,String departureDate,String departureTime){
        Intent intent = new Intent(this, TrackResultsActivity.class);
        intent.putExtra("destination",destination);
        intent.putExtra("departurePoint",departurePoint);
        intent.putExtra("departureDate",departureDate);
        intent.putExtra("departureTime",departureTime);
        startActivityForResult(intent,10);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("geaiaiaaiaiai");
        if(resultCode == Activity.RESULT_CANCELED){
            recreate();
            presenter.onShowToast(data.getStringExtra("message_to_toast"));
        }else{
            recreate();
            presenter.onShowToast(data.getStringExtra("message_to_toast"));
        }
    }
}
