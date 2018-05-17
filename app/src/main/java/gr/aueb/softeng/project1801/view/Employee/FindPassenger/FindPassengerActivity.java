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

    @Override
    public String getFirstname(){
        return ((EditText)findViewById(R.id.text_firstname)).getText().toString().trim();
    }

    @Override
    public String getLastname(){
        return ((EditText)findViewById(R.id.text_lastname)).getText().toString().trim();
    }

    @Override
    public String getPassengerID(){
        return ((EditText)findViewById(R.id.text_passenger_id)).getText().toString().trim();
    }

    @Override
    public void showAlertMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(FindPassengerActivity.this);
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
    public void findPassenger(String firstname,String lastname,String id){
        Intent intent = new Intent(this, PrintTicketActivity.class);
        intent.putExtra("firstname",firstname);
        intent.putExtra("lastname",lastname);
        intent.putExtra("id",id);
        startActivityForResult(intent,10);
    }

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
