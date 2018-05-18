package gr.aueb.softeng.project1801.view.Passenger.Enter_card_info;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import gr.aueb.softeng.project1801.memorydao.CardDAOMemory;
import gr.aueb.softeng.project1801.memorydao.PassengerDAOMemory;
import gr.aueb.softeng.project1801.view.R;

public class cardInfoActivity extends AppCompatActivity implements cardInfoView {

    private cardInfoPresenter presenter;

    /** This method returns a destination.
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

    /** This method returns a departure point.
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

    /** This method returns a departure date.
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

    /** This method returns a departure time.
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
     * This method returns a FirstName.
     * @return a String object that has the FirstName
     */
    @Override
    public String getFirstname() {
        if(this.getIntent().hasExtra("firstname")){
            return this.getIntent().getExtras().getString("firstname");
        }else{
            return null;
        }
    }

    /**
     * This method returns a LastName.
     * @return a String object that has the LastName
     */
    @Override
    public String getLastname() {
        if(this.getIntent().hasExtra("lastname")){
            return this.getIntent().getExtras().getString("lastname");
        }else{
            return null;
        }
    }

    /**
     * This method returns a passengerID.
     * @return a String object that has the passengerID
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
     * This method returns a price.
     * @return a String object that has the price
     */
    @Override
    public String getPrice() {
        if(this.getIntent().hasExtra("price")){
            return this.getIntent().getExtras().getString("price");
        }else{
            return null;
        }
    }

    /** This method returns the number of seats.
     * @return a String object that has the number of seats
     */
    @Override
    public String getSeats() {
        if(this.getIntent().hasExtra("seats")){
            return this.getIntent().getExtras().getString("seats");
        }else{
            return null;
        }
    }

    /** This method returns a type of the card.
     * @return a String object that has the type of the card
     */
    @Override
    public String getType() {
        if(this.getIntent().hasExtra("type")){
            return this.getIntent().getExtras().getString("type");
        }else{
            return null;
        }
    }

    /** This method sets name to a specific Activity.
     * @param title, the title we want to set in a specific Activity
     */
    @Override
    public void setActivityName(String title) {
        getSupportActionBar().setTitle(title);
    }

    /**
     *  This method pops up a toast.
     * @param value, the message we want to print in the toast
     */
    @Override
    public void showToast(String value) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }

    /**
     * This method returns a CVcode.
     * @return a String object that has the CVcode
     */
    @Override
    public String getCVcode(){
        return ((EditText)findViewById(R.id.text_cv_code)).getText().toString().trim();
    }

    /**
     * This method returns a cardHolderName.
     * @return a String object that has the cardHolderName
     */
    @Override
    public String getCardHolderName(){
        return ((EditText)findViewById(R.id.text_holdername)).getText().toString().trim();
    }

    /**
     * This method returns a cardID.
     * @return a String object that has the cardID
     */
    @Override
    public String getCardId(){
        return ((EditText)findViewById(R.id.text_card_id)).getText().toString().trim();
    }

    /** This method shows alert messages
     * @param message, the alert message we want to print
     */
    @Override
    public void showAlertMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(cardInfoActivity.this);
        alert.setCancelable(true);
        alert.setMessage(message);
        alert.setPositiveButton(R.string.ok_button,null);

        alert.create().show();
    }

    /**
     * This method returns an expirationDate.
     * @return a String object that has the expirationDate
     */
    @Override
    public String getExpirationDate(){
        return ((EditText)findViewById(R.id.text_expiration_date)).getText().toString().trim();
    }

    /**
     *  This method pops up a toast.
     * @param message, the message we want to show in the toast
     */
    @Override
    public void clickCheckout(String message){
        presenter.onShowToast(message);
        finish();
    }

    /** This method creates the layout and initializes the activity.
     * @param savedInstanceState, the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_info_activity);

        presenter = new cardInfoPresenter(this,new PassengerDAOMemory(),new CardDAOMemory());

        findViewById(R.id.checkout_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickContinue(presenter.OngetCardHolderName(),presenter.OngetCardCode(),
                        presenter.OngetCV(),presenter.OngetExpDate());
            }
        });

    }

}
