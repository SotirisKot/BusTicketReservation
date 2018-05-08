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

    @Override
    public String getDepartureDate(){
        return ((EditText)findViewById(R.id.departure_date_text)).getText().toString().trim();
    }

    @Override
    public String getNumberOfSeats(){
        return ((Spinner)findViewById(R.id.seats)).getSelectedItem().toString().trim();
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
        AlertDialog.Builder alert = new AlertDialog.Builder(BuyTicketActivity.this);
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
    public void setNumberOfSeats(List<String> seats) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,seats);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.seats)).setAdapter(arrayAdapter);
    }


    @Override
    public void ShowToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


    @Override
    public void searchRoute(String destination,String departurePoint,String departureDate,String seats){
        Intent intent = new Intent(this,SearchRouteActivity.class);
        intent.putExtra("destination",destination);
        intent.putExtra("departurePoint",departurePoint);
        intent.putExtra("departureDate",departureDate);
        intent.putExtra("seats",seats);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_ticket_activity);

        final BuyTicketPresenter presenter = new BuyTicketPresenter(this,new ScheduleDAOMemory());

        findViewById(R.id.search_route_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSearchRoute(getDestination(),getDeparturepoint(),getDepartureDate(),getNumberOfSeats());
            }
        });
    }
}
