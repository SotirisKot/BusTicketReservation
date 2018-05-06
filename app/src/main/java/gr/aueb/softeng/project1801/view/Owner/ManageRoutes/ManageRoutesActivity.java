package gr.aueb.softeng.project1801.view.Owner.ManageRoutes;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import gr.aueb.softeng.project1801.memorydao.BusDAOMemory;
import gr.aueb.softeng.project1801.memorydao.DriverDAOMemory;
import gr.aueb.softeng.project1801.memorydao.ScheduleDAOMemory;
import gr.aueb.softeng.project1801.view.R;

public class ManageRoutesActivity extends AppCompatActivity implements ManageRoutesView{

    @Override
    public String getDepartureDate(){
        return ((EditText)findViewById(R.id.text_departure_date)).getText().toString().trim();
    }

    @Override
    public String getEstimatedArrivalTime() {
        return ((Spinner)findViewById(R.id.arrival_times)).getSelectedItem().toString().trim();
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
    public String getDepartureTime() {
        return ((Spinner) findViewById(R.id.departure_times)).getSelectedItem().toString().trim();
    }

    @Override
    public String getBusID() {
        return ((Spinner) findViewById(R.id.bus_ids)).getSelectedItem().toString().trim();
    }

    @Override
    public String getDriverID() {
        return ((Spinner) findViewById(R.id.driver_ids)).getSelectedItem().toString().trim();
    }

    @Override
    public void setActivityName(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void showAlertMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(ManageRoutesActivity.this);
        alert.setCancelable(true);
        alert.setMessage(message);
        alert.setPositiveButton(R.string.ok_button,null);

        alert.create().show();
    }

    @Override
    public void ShowToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSuccessMessage(String message) {
        ShowToast(message);
        finish();
    }

    @Override
    public void setBusIDsList(List<String> bus_ids) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,bus_ids);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.bus_ids)).setAdapter(arrayAdapter);
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
    public void setDepartureTimesList(List<String> times) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,times);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.departure_times)).setAdapter(arrayAdapter);
        ((Spinner) findViewById(R.id.arrival_times)).setAdapter(arrayAdapter);
    }

    @Override
    public void setDriverIDsList(List<String> driver_ids) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,driver_ids);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.driver_ids)).setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_routes_activity);

        final ManageRoutesPresenter presenter = new ManageRoutesPresenter(this,
                new ScheduleDAOMemory(),new BusDAOMemory(),new DriverDAOMemory());

        findViewById(R.id.save_route_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addRoute();
            }
        });
    }
}
