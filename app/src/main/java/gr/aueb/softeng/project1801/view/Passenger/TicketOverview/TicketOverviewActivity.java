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


    /**
     * This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    @Override
    public String getDestination() {
        if(this.getIntent().hasExtra("destination")){
            return this.getIntent().getExtras().getString("destination");

        }else{
            return null;
        }
    }

    /**
     *  This method returns a departure point.
     * @return a String object that has the departure point
     */
    @Override
    public String getDeparturePoint() {
        if(this.getIntent().hasExtra("departurePoint")){
            return this.getIntent().getExtras().getString("departurePoint");
        }else {
            return null;
        }
    }

    /**
     * This method returns a departure date.
     * @return a String object that has the departure date
     */
    @Override
    public String getDepartureDate() {
        if(this.getIntent().hasExtra("departureDate")){
            return this.getIntent().getExtras().getString("departureDate");
        }else{
            return null;
        }
    }

    /**
     * This method returns a departure time.
     * @return a String object that has the departure time
     */
    @Override
    public String getDepartureTime() {
        if(this.getIntent().hasExtra("departureTime")){
            return this.getIntent().getExtras().getString("departureTime");
        }else{
            return null;
        }
    }

    /**
     * This method returns a set of SeatRow objects.
     * @return a list that has the SeatRow objects
     */
    @Override
    public List<SeatRow> getSeats(){
        if(this.getIntent().hasExtra("seats")){
            Intent i = getIntent();
            return (List<SeatRow>) i.getSerializableExtra("seats");
        }else{
            return null;
        }
    }

    /**
     * This method returns a type of the card.
     * @return a String object that has the type of the card
     */
    @Override
    public String getType(){
        return ((Spinner) findViewById(R.id.spinner_type)).getSelectedItem().toString().trim();
    }

    /**
     * This method sets a specific destination.
     * @param destination , a String object that contains the destination
     */
    @Override
    public void setDestination(String destination){
        ((TextView)findViewById(R.id.text_destination)).setText(destination);
    }

    /**
     * This method sets a specific departure point.
     * @param departurePoint , a String object that contains the departure point
     */
    @Override
    public void setDeparturePoint(String departurePoint){
        ((TextView)findViewById(R.id.text_departure_point)).setText(departurePoint);
    }

    /**
     * This method sets a specific departure date.
     * @param departureDate , a String object that contains the departure date
     */
    @Override
    public void setDepartureDate(String departureDate){
        ((TextView)findViewById(R.id.text_departure_date)).setText(departureDate);
    }

    /**
     * This method sets a set of seats.
     * @param seats , a list that contains the set of seats
     */
    @Override
    public void setSeats(List<SeatRow> seats){
        StringBuilder seatsN = new StringBuilder();
        for(SeatRow seatRow : seats){
            seatsN.append(String.valueOf(seatRow.getNum())).append(",");
        }
        ((TextView)findViewById(R.id.seats_text)).setText(seatsN.toString());
    }

    /**
     * This method returns the number of seats.
     * @return a String object that has the number of seats
     */
    @Override
    public String getSeat(){
        StringBuilder seatsN = new StringBuilder();
        for(SeatRow seatRow : getSeats()){
            seatsN.append(String.valueOf(seatRow.getNum())).append(",");
        }
        return seatsN.toString();
    }

    /**
     * This method sets a specific departure time.
     * @param time , a String object that contains the departure time
     */
    @Override
    public void setDepartureTime(String time){
        ((TextView)findViewById(R.id.text_departure_time)).setText(time);
    }

    /**
     * This method sets a specific passenger ID.
     * @param id , a String object that contains the passenger ID
     */
    @Override
    public void setPassengerId(String id){
        ((TextView)findViewById(R.id.text_passenger_id)).setText(id);
    }

    /**
     * This method sets a specific price on a ticket.
     * @param price , a String object that contains the price of the ticket
     */
    @Override
    public void setPrice(String price){
        ((TextView)findViewById(R.id.price_text)).setText(price);
    }

    /**
     * This method sets a set of ticket types.
     * @param types , a list that contains the set of ticket types
     */
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

    /**
     * This method returns a passenger's FirstName.
     * @return a String object that has the passenger's FirstName
     */
    @Override
    public String getPassengerFirstname(){
        return ((EditText)findViewById(R.id.edit_firstname)).getText().toString().trim();
    }

    /**
     * This method returns a passenger's LastName.
     * @return a String object that has the passenger's LastName
     */
    @Override
    public String getPassengerLastname(){
        return ((EditText)findViewById(R.id.edit_lastname)).getText().toString().trim();
    }

    /**
     * This method sets a specific estimated arrival time.
     * @param arrivalTime , a String object that contains the estimated arrival time
     */
    @Override
    public void setEstimatedArrivalTime(String arrivalTime){
        ((TextView)findViewById(R.id.text_arrival_time)).setText(arrivalTime);
    }

    /**
     * This method shows alert messages
     * @param message , the alert message we want to print
     */
    @Override
    public void showAlertMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(TicketOverviewActivity.this);
        alert.setCancelable(true);
        alert.setMessage(message);
        alert.setPositiveButton(R.string.ok_button,null);

        alert.create().show();
    }

    /**
     * This method sets name to a specific Activity.
     * @param title , the name_value we want to set in a specific Activity
     */
    @Override
    public void setActivityName(String title) {
        getSupportActionBar().setTitle(title);
    }

    /**
     * This method pops up a toast.
     * @param value , the message we want to print in the toast
     */
    @Override
    public void showToast(String value) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }

    /**
     *
     * This method method redirects the user to another activity after a click event.
     * @param destination , the destination of the route
     * @param departurePoint , the departure point of the route
     * @param departureDate , the departure date of the route
     * @param departureTime , the departure time of the route
     * @param firstname , the first name of the passenger
     * @param lastname , the last name of the passenger
     * @param id , the passenger id
     * @param price , the price of the ticket
     * @param seats , the seat of the ticket
     * @param type , the type of the ticket
     */
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

    /**
     * This method creates the layout and initializes the activity.
     * @param savedInstanceState , the Instance state
     */
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

    /**
     * This method recreates the activity with a new instance in case of the requested code gets the value "1".
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
