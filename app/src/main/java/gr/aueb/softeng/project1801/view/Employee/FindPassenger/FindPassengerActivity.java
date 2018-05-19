package gr.aueb.softeng.project1801.view.Employee.FindPassenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import gr.aueb.softeng.project1801.view.Employee.PrintTicketOverView.PrintTicketActivity;
import gr.aueb.softeng.project1801.view.R;

public class FindPassengerActivity extends AppCompatActivity implements FindPassengerView{

    private FindPassengerPresenter presenter;

    /**
     * This method returns a passenger's FirstName.
     * @return a String object that has the passenger's FirstName
     */
    @Override
    public String getFirstname(){
        return ((EditText)findViewById(R.id.text_firstname)).getText().toString().trim();
    }

    /**
     * This method returns a passenger's LastName.
     * @return a String object that has the passenger's LastName
     */
    @Override
    public String getLastname(){
        return ((EditText)findViewById(R.id.text_lastname)).getText().toString().trim();
    }

    /**
     * This method sets a specific passenger ID.
     */
    @Override
    public String getPassengerID(){
        return ((EditText)findViewById(R.id.text_passenger_id)).getText().toString().trim();
    }

    /**
     * This method shows alert messages
     * @param message , the alert message we want to print
     */
    @Override
    public void showAlertMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(FindPassengerActivity.this);
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
     *  This method pops up a toast.
     * @param value , the message we want to print in the toast
     */
    @Override
    public void showToast(String value) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }

    /**
     * This methods helps us to find a specific passenger.
     * @param firstname , the fistName of the passenger
     * @param lastname , the lastName of the passenger
     * @param id , the passegner's ID number
     */
    @Override
    public void findPassenger(String firstname,String lastname,String id){
        Intent intent = new Intent(this, PrintTicketActivity.class);
        intent.putExtra("firstname",firstname);
        intent.putExtra("lastname",lastname);
        intent.putExtra("id",id);
        startActivityForResult(intent,10);
    }

    /**
     * This method creates the layout and initializes the activity.
     * @param savedInstanceState , the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_passenger_activity);

        presenter = new FindPassengerPresenter(this);

        findViewById(R.id.find_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onFindPassenger(presenter.onGetPassengerFirstname(),presenter.onGetPassengerLastname(),
                        presenter.onGetPassengerID());
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
        System.out.println("geaiaiaaiaiai");
        if(requestCode == 10){
            recreate();
            presenter.onShowToast(data.getStringExtra("message_to_toast"));
        }else if(requestCode == 11){
            recreate();
            presenter.onShowToast(data.getStringExtra("message_to_toast"));
        }
    }
}
