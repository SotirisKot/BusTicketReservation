package gr.aueb.softeng.project1801.view.Passenger.Buy_Ticket;

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
import gr.aueb.softeng.project1801.view.Passenger.Search_Route.SearchRouteActivity;
import gr.aueb.softeng.project1801.view.R;

public class BuyTicketActivity extends AppCompatActivity implements BuyTicketsView {

    /** This method returns a departure date.
     * @return a String object that has the departure date
     */
    @Override
    public String getDepartureDate(){
        return ((EditText)findViewById(R.id.departure_date_text)).getText().toString().trim();
    }

    /** This method returns the number of seats.
     * @return a String object that has the number of seats
     */
    @Override
    public String getNumberOfSeats(){
        return ((Spinner)findViewById(R.id.seats)).getSelectedItem().toString().trim();
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

    /** This method sets name to a specific Activity.
     * @param title , the name_value we want to set in a specific Activity
     */
    @Override
    public void setActivityName(String title) {
        getSupportActionBar().setTitle(title);
    }

    /** This method shows alert messages
     * @param message , the alert message we want to print
     */
    @Override
    public void showAlertMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(BuyTicketActivity.this);
        alert.setCancelable(true);
        alert.setMessage(message);
        alert.setPositiveButton(R.string.ok_button,null);

        alert.create().show();
    }

    /** This method sets a list of destinations.
     * @param destinations , a set of destinations we want to have
     */
    @Override
    public void setDestinationsList(List<String> destinations) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,destinations);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.destinations_list)).setAdapter(arrayAdapter);
    }

    /** This method sets a list of departures.
     * @param departures , a set of departures we want to have
     */
    @Override
    public void setDeparturePointsList(List<String> departures) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,departures);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.departure_points)).setAdapter(arrayAdapter);
    }

    /** This method sets a list of number of seats.
     * @param seats , a set of number of seats
     */
    @Override
    public void setNumberOfSeats(List<String> seats) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,seats);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.seats)).setAdapter(arrayAdapter);
    }


    /**
     *  This method pops up a toast.
     * @param message , the message we want to print in the toast
     */
    @Override
    public void ShowToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


    /**
     * This method search a route based on the details given.
     * @param destination , the destination
     * @param departurePoint , the departure point
     * @param departureDate , the departure date
     * @param seats , the seat
     */
    @Override
    public void searchRoute(String destination,String departurePoint,String departureDate,String seats){
        Intent intent = new Intent(this,SearchRouteActivity.class);
        intent.putExtra("destination",destination);
        intent.putExtra("departurePoint",departurePoint);
        intent.putExtra("departureDate",departureDate);
        intent.putExtra("seats",seats);
        startActivityForResult(intent,1);
    }

    /** This method creates the layout and initializes the activity.
     * @param savedInstanceState , the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_ticket_activity);

        final BuyTicketPresenter presenter = new BuyTicketPresenter(this,new ScheduleDAOMemory());

        findViewById(R.id.search_route_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSearchRoute(presenter.onGetDestination(),presenter.onGetDeparture(),
                        presenter.onGetDepartureDate(),presenter.onGetSeats());
            }
        });
    }

    /** This method recreates the activity with a new instance in case of the requested code gets the value "1".
     * @param requestCode , the requested code
     * @param resultCode , the result code
     * @param data , the intent
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){//purchase successful...recreate the activity
            finish();
        }
    }
}
