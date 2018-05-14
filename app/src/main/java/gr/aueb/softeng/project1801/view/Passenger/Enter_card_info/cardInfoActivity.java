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
    public String getFirstname() {
        if(this.getIntent().hasExtra("firstname")){
            return this.getIntent().getExtras().getString("firstname");
        }else{
            return null;
        }
    }

    @Override
    public String getLastname() {
        if(this.getIntent().hasExtra("lastname")){
            return this.getIntent().getExtras().getString("lastname");
        }else{
            return null;
        }
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
    public String getPrice() {
        if(this.getIntent().hasExtra("price")){
            return this.getIntent().getExtras().getString("price");
        }else{
            return null;
        }
    }

    @Override
    public String getSeats() {
        if(this.getIntent().hasExtra("seats")){
            return this.getIntent().getExtras().getString("seats");
        }else{
            return null;
        }
    }

    @Override
    public String getType() {
        if(this.getIntent().hasExtra("type")){
            return this.getIntent().getExtras().getString("type");
        }else{
            return null;
        }
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
    public String getCVcode(){
        return ((EditText)findViewById(R.id.text_cv_code)).getText().toString().trim();
    }

    @Override
    public String getCardHolderName(){
        return ((EditText)findViewById(R.id.text_holdername)).getText().toString().trim();
    }

    @Override
    public String getCardId(){
        return ((EditText)findViewById(R.id.text_card_id)).getText().toString().trim();
    }

    @Override
    public void showAlertMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(cardInfoActivity.this);
        alert.setCancelable(true);
        alert.setMessage(message);
        alert.setPositiveButton(R.string.ok_button,null);

        alert.create().show();
    }

    @Override
    public String getExpirationDate(){
        return ((EditText)findViewById(R.id.text_expiration_date)).getText().toString().trim();
    }

    @Override
    public void clickCheckout(String message){
        presenter.onShowToast(message);
        finish();
    }

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
