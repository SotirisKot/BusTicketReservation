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

    /** This method returns a departure date.
     * @return a String object that has the departure date
     */
    @Override
    public String getDepartureDate(){
        return ((EditText)findViewById(R.id.text_departure_date)).getText().toString().trim();
    }

    /** This method returns an estimated arrival time of the bus.
     * @return a String object that has the estimated arrival time of the bus.
     */
    @Override
    public String getEstimatedArrivalTime() {
        return ((Spinner)findViewById(R.id.arrival_times)).getSelectedItem().toString().trim();
    }

    /** This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    @Override
    public String getDestination(){
        return ((Spinner) findViewById(R.id.destinations_list)).getSelectedItem().toString().trim();
    }

    /** This method returns a departure point.
     * @return a String object that has the departure point
     */
    @Override
    public String getDeparturepoint() {
        return ((Spinner) findViewById(R.id.departure_points)).getSelectedItem().toString().trim();
    }

    /** This method returns a departure time.
     * @return a String object that has the departure time
     */
    @Override
    public String getDepartureTime() {
        return ((Spinner) findViewById(R.id.departure_times)).getSelectedItem().toString().trim();
    }

    /** This method returns a BusID.
     * @return a String object that has the BusID number
     */
    @Override
    public String getBusID() {
        return ((Spinner) findViewById(R.id.bus_ids)).getSelectedItem().toString().trim();
    }

    /** This method returns a DriverID.
     * @return a String object that has the DriverID number
     */
    @Override
    public String getDriverID() {
        return ((Spinner) findViewById(R.id.driver_ids)).getSelectedItem().toString().trim();
    }

    /** This method sets name to a specific Activity.
     * @param title, the name_value we want to set in a specific Activity
     */
    @Override
    public void setActivityName(String title) {
        getSupportActionBar().setTitle(title);
    }

    /** This method shows alert messages
     * @param message, the alert message we want to print
     */
    @Override
    public void showAlertMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(ManageRoutesActivity.this);
        alert.setCancelable(true);
        alert.setMessage(message);
        alert.setPositiveButton(R.string.ok_button,null);

        alert.create().show();
    }

    /** This method pops up a toast.
     * @param message, the message we want to print in the toast
     */
    @Override
    public void ShowToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    /** This method shows success messages.
     * @param message, the success message we want to print
     * */
    @Override
    public void showSuccessMessage(String message) {
        ShowToast(message);
        finish();
    }

    /** This method sets a list of BusIDs.
     * @param bus_ids, a set of BusIDs we want to have
     */
    @Override
    public void setBusIDsList(List<String> bus_ids) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,bus_ids);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.bus_ids)).setAdapter(arrayAdapter);
    }

    /** This method sets a list of destinations.
     * @param destinations, a set of destinations we want to have
     */
    @Override
    public void setDestinationsList(List<String> destinations) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,destinations);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.destinations_list)).setAdapter(arrayAdapter);
    }

    /** This method sets a list of departures.
     * @param departures, a set of departures we want to have
     */
    @Override
    public void setDeparturePointsList(List<String> departures) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,departures);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.departure_points)).setAdapter(arrayAdapter);
    }

    /** This method sets a list of times we want to departure our buses.
     * @param times, a set of times that the buses can start their routs
     */
    @Override
    public void setDepartureTimesList(List<String> times) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,times);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.departure_times)).setAdapter(arrayAdapter);
        ((Spinner) findViewById(R.id.arrival_times)).setAdapter(arrayAdapter);
    }

    /** This method sets a list of DriverIDs.
     * @param driver_ids, a set of DriverIDs we want to have
     */
    @Override
    public void setDriverIDsList(List<String> driver_ids) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,driver_ids);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.driver_ids)).setAdapter(arrayAdapter);
    }

    /** This method creates the layout and initializes the activity.
     * @param savedInstanceState, the Instance state
     */
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
