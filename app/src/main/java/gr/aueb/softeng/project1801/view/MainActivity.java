package gr.aueb.softeng.project1801.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import gr.aueb.softeng.project1801.view.Employee.EmployeeHome.Employee_login;
import gr.aueb.softeng.project1801.view.Owner.OwnerHome.Owner_login;
import gr.aueb.softeng.project1801.view.Passenger.PassengerHome.UserView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_user;
    Button btn_employee;
    Button btn_owner;

    /** This method creates the layout and initializes the activity.
     * @param savedInstanceState, the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_user = (Button)findViewById(R.id.btn_user);
        btn_employee = (Button)findViewById(R.id.btn_employee);
        btn_owner = (Button)findViewById(R.id.btn_owner);

        btn_user.setOnClickListener(this);
        btn_employee.setOnClickListener(this);
        btn_owner.setOnClickListener(this);

    }

    /** This method is being called when a view has been clicked.So it chooses what to do after the user's specific click.
     * @param v, the View that was clicked
     */
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_user:
                Toast.makeText(this,"Αγαπητέ Επιβάτη, καλώς ήρθες στην πλατφόρμα μας!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,UserView.class);
                startActivity(intent);
                break;
            case R.id.btn_employee:
                Toast.makeText(this,"Είσοδος ως Υπάλληλος",Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(MainActivity.this,Employee_login.class);
                startActivity(intent1);
                break;
            case R.id.btn_owner:
                Toast.makeText(this,"Είσοδος ως ιδιοκτήτης",Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(MainActivity.this,Owner_login.class);
                startActivity(intent2);
                break;
        }
    }
}
