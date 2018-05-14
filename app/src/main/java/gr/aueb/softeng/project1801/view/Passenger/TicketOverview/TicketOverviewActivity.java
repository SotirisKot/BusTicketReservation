package gr.aueb.softeng.project1801.view.Passenger.TicketOverview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import gr.aueb.softeng.project1801.SysUtils.SeatRow;
import gr.aueb.softeng.project1801.view.Passenger.Enter_card_info.cardInfoActivity;
import gr.aueb.softeng.project1801.view.R;

public class TicketOverviewActivity extends AppCompatActivity implements TicketOverviewView {

    private TicketOverviewPresenter presenter;


    @Override
    public String getDestination() {
        if(this.getIntent().hasExtra("destination")){
            return this.getIntent().getExtras().getString("destination");

        }else{
            return null;
        }
    }

    @Override
    public String getDeparturePoint() {
        if(this.getIntent().hasExtra("departurePoint")){
            return this.getIntent().getExtras().getString("departurePoint");
        }else {
            return null;
        }
    }

    @Override
    public String getDepartureDate() {
        if(this.getIntent().hasExtra("departureDate")){
            return this.getIntent().getExtras().getString("departureDate");
        }else{
            return null;
        }
    }

    @Override
    public String getDepartureTime() {
        if(this.getIntent().hasExtra("departureTime")){
            return this.getIntent().getExtras().getString("departureTime");
        }else{
            return null;
        }
    }

    @Override
    public List<SeatRow> getSeats(){
        if(this.getIntent().hasExtra("seats")){
            Intent i = getIntent();
            return (List<SeatRow>) i.getSerializableExtra("seats");
        }else{
            return null;
        }
    }

    @Override
    public String getType(){
        return ((Spinner) findViewById(R.id.spinner_type)).getSelectedItem().toString().trim();
    }

    @Override
    public void setDestination(String destination){
        ((TextView)findViewById(R.id.text_destination)).setText(destination);
    }

    @Override
    public void setDeparturePoint(String departurePoint){
        ((TextView)findViewById(R.id.text_departure_point)).setText(departurePoint);
    }

    @Override
    public void setDepartureDate(String departureDate){
        ((TextView)findViewById(R.id.text_departure_date)).setText(departureDate);
    }

    @Override
    public void setSeats(List<SeatRow> seats){
        StringBuilder seatsN = new StringBuilder();
        for(SeatRow seatRow : seats){
            seatsN.append(String.valueOf(seatRow.getNum())).append(",");
        }
        ((TextView)findViewById(R.id.seats_text)).setText(seatsN.toString());
    }

    @Override
    public String getSeat(){
        StringBuilder seatsN = new StringBuilder();
        for(SeatRow seatRow : getSeats()){
            seatsN.append(String.valueOf(seatRow.getNum())).append(",");
        }
        return seatsN.toString();
    }

    @Override
    public void setDepartureTime(String time){
        ((TextView)findViewById(R.id.text_departure_time)).setText(time);
    }

    @Override
    public void setPassengerId(String id){
        ((TextView)findViewById(R.id.text_passenger_id)).setText(id);
    }

    @Override
    public void setPrice(String price){
        ((TextView)findViewById(R.id.price_text)).setText(price);
    }

    @Override
    public void setTypes(List<String> types){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,types);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) findViewById(R.id.spinner_type);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String type = (String) parent.getItemAtPosition(position);
                presenter.onSetPrice(type);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    @Override
    public String getPassengerFirstname(){
        return ((EditText)findViewById(R.id.edit_firstname)).getText().toString().trim();
    }

    @Override
    public String getPassengerLastname(){
        return ((EditText)findViewById(R.id.edit_lastname)).getText().toString().trim();
    }

    @Override
    public void setEstimatedArrivalTime(String arrivalTime){
        ((TextView)findViewById(R.id.text_arrival_time)).setText(arrivalTime);
    }

    @Override
    public void showAlertMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(TicketOverviewActivity.this);
        alert.setCancelable(true);
        alert.setMessage(message);
        alert.setPositiveButton(R.string.ok_button,null);

        alert.create().show();
    }

    @Override
    public void setActivityName(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void showToast(String value) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }

    @Override
    public void clickContinue(String destination,String departurePoint,String departureDate,
                              String departureTime,String firstname,String lastname,String id,String price
                                ,String seats,String type){

        Intent intent = new Intent(this, cardInfoActivity.class);
        intent.putExtra("destination",destination);
        intent.putExtra("departurePoint",departurePoint);
        intent.putExtra("departureDate",departureDate);
        intent.putExtra("departureTime",departureTime);
        intent.putExtra("firstname",firstname);
        intent.putExtra("lastname",lastname);
        intent.putExtra("id",id);
        intent.putExtra("price",price);
        intent.putExtra("seats",seats);
        intent.putExtra("type",type);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket_overview_activity);

        presenter = new TicketOverviewPresenter(this);

        findViewById(R.id.buy_ticket_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickContinue(presenter.OngetPassengerFirstname(),
                        presenter.OngetPassengerLastname());
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){//purchase successful...recreate the activity
            finish();
        }
    }
}
