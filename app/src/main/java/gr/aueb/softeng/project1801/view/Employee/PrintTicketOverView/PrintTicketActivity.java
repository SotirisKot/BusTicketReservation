/*
package gr.aueb.softeng.project1801.view.Employee.PrintTicketOverView;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import gr.aueb.softeng.project1801.view.R;

public class PrintTicketActivity extends AppCompatActivity implements PrintTicketView {

    private PrintTicketPresenter presenter;

    @Override
    public void setActivityName(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void showToast(String value) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setDepartureDate(String departureDate){
        ((TextView)findViewById(R.id.text_departure_date)).setText(departureDate);
    }

    @Override
    public void setPassengerID(String passengerID){
        ((TextView)findViewById(R.id.text_passenger_id)).setText(passengerID);
    }

    @Override
    public void setPassengerFirstname(String name){
        ((TextView)findViewById(R.id.edit_firstname)).setText(name);
    }

    @Override
    public void setPassengerLastname(String name){
        ((TextView)findViewById(R.id.edit_lastname)).setText(name);
    }

    @Override
    public void setDeparturePoint(String departurePoint){
        ((TextView)findViewById(R.id.text_departure_point)).setText(departurePoint);
    }

    @Override
    public void setPrice(String price){
        ((TextView)findViewById(R.id.price_text)).setText(price);
    }

    @Override
    public void setType(String type){
        ((TextView)findViewById(R.id.ticket_type)).setText(type);
    }

    @Override
    public void setSeat(String seat){
        ((TextView)findViewById(R.id.seats_text)).setText(seat);
    }

    @Override
    public void setDepartureTime(String departureTime){
        ((TextView)findViewById(R.id.text_departure_time)).setText(departureTime);
    }

    @Override
    public void setDestination(String destination){
        ((TextView)findViewById(R.id.text_destination)).setText(destination);
    }

    @Override
    public void showAlertMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(PrintTicketActivity.this);
        alert.setCancelable(true);
        alert.setMessage(message);
        alert.setPositiveButton(R.string.ok_button,null);

        alert.create().show();
    }

    @Override
    public void printTicket(String message){

    }

    @Override
    public String getPassengerID() {
        if(this.getIntent().hasExtra("id")){
            return this.getIntent().getExtras().getString("id");

        }else{
            return null;
        }
    }

    @Override
    public String getPassengerFirstname() {
        if(this.getIntent().hasExtra("firstname")){
            return this.getIntent().getExtras().getString("firstname");

        }else{
            return null;
        }
    }

    @Override
    public String getPassengerLastname() {
        if(this.getIntent().hasExtra("lastname")){
            return this.getIntent().getExtras().getString("lastname");

        }else{
            return null;
        }
    }


}
*/
