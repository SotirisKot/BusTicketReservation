package gr.aueb.softeng.project1801.view.Employee.PrintTicketOverView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import gr.aueb.softeng.project1801.memorydao.ScheduleDAOMemory;
import gr.aueb.softeng.project1801.view.R;

public class PrintTicketActivity extends AppCompatActivity implements PrintTicketView {

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
     * This method sets a specific departure date.
     * @param departureDate , a String object that contains the departure date
     */
    @Override
    public void setDepartureDate(String departureDate){
        ((TextView)findViewById(R.id.text_departure_date)).setText(departureDate);
    }

    /**
     * This method sets a specific passenger ID.
     * @param passengerID , a String object that contains the passenger ID
     */
    @Override
    public void setPassengerID(String passengerID){
        ((TextView)findViewById(R.id.text_passenger_id)).setText(passengerID);
    }

    /**
     * This method sets a passenger's firstName.
     * @param name , a passenger's firstName
     */
    @Override
    public void setPassengerFirstname(String name){
        ((TextView)findViewById(R.id.edit_firstname)).setText(name);
    }

    /**
     * This method sets a passenger's lastName.
     * @param name , a passenger's lastName
     */
    @Override
    public void setPassengerLastname(String name){
        ((TextView)findViewById(R.id.edit_lastname)).setText(name);
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
     * This method sets a specific price on a ticket.
     * @param price , a String object that contains the price of the ticket
     */
    @Override
    public void setPrice(String price){
        ((TextView)findViewById(R.id.price_text)).setText(price);
    }

    /**
     * This method sets a types.
     * @param type , a specific type
     */
    @Override
    public void setType(String type){
        ((TextView)findViewById(R.id.ticket_type)).setText(type);
    }

    /**
     * This method sets a seat.
     * @param seat , a specific seat
     */
    @Override
    public void setSeat(String seat){
        ((TextView)findViewById(R.id.seats_text)).setText(seat);
    }

    /**
     * This method sets a specific departure time.
     * @param departureTime , a String object that contains the departure time
     */
    @Override
    public void setDepartureTime(String departureTime){
        ((TextView)findViewById(R.id.text_departure_time)).setText(departureTime);
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
        AlertDialog.Builder alert = new AlertDialog.Builder(PrintTicketActivity.this);
        alert.setCancelable(true);
        alert.setMessage(message);
        alert.setPositiveButton(R.string.ok_button,null);
        alert.create().show();
    }

    /**
     * This method helps us to print a passenger's ticket.
     * @param message, the message we want to print
     */
    @Override
    public void printTicket(String message){
        Intent retData = new Intent();
        retData.putExtra("message_to_toast", message);
        setResult(10, retData);
        finish();
    }

    /**
     * This method returns a passenger's ID.
     * @return a String object that has the passenger's ID
     */
    @Override
    public String getPassengerID() {
        if(this.getIntent().hasExtra("id")){
            return this.getIntent().getExtras().getString("id");
        }else{
            return null;
        }
    }

    /**
     * This method returns a passenger's FirstName.
     * @return a String object that has the passenger's FirstName
     */
    @Override
    public String getPassengerFirstname() {
        if(this.getIntent().hasExtra("firstname")){
            return this.getIntent().getExtras().getString("firstname");
        }else{
            return null;
        }
    }

    /**
     * This method returns a passenger's LastName.
     * @return a String object that has the passenger's LastName
     */
    @Override
    public String getPassengerLastname() {
        if(this.getIntent().hasExtra("lastname")){
            return this.getIntent().getExtras().getString("lastname");
        }else{
            return null;
        }
    }

    /**
     * This method terminates the process
     */
    @Override
    public void kill(){
        Intent retData = new Intent();
        retData.putExtra("message_to_toast", "Ticket does not exist");
        setResult(11, retData);
        finish();
    }

    /**
     * This method creates the layout and initializes the activity.
     * @param savedInstanceState , the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.print_ticket_activity);

        final PrintTicketPresenter presenter = new PrintTicketPresenter(this,new ScheduleDAOMemory());

        findViewById(R.id.print_ticket_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onPrintTicket("Ticket printed!");
            }
        });
    }
}

