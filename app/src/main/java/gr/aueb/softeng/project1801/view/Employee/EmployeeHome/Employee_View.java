package gr.aueb.softeng.project1801.view.Employee.EmployeeHome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import gr.aueb.softeng.project1801.view.Employee.FindPassenger.FindPassengerActivity;
import gr.aueb.softeng.project1801.view.R;

public class Employee_View extends AppCompatActivity implements View.OnClickListener {

    private Button find_passenger;

    /** This method creates the layout and initializes the activity.
     * @param savedInstanceState , the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_view);

        find_passenger = (Button) findViewById(R.id.find_passenger);
        find_passenger.setOnClickListener(this);
    }

    /** This method is being called when a view has been clicked.So it chooses what to do after the user's specific click.
     * @param v , the View that was clicked
     */
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.find_passenger:
                Intent intent = new Intent(Employee_View.this, FindPassengerActivity.class);
                intent.putExtra("button_id",R.id.statistic);
                startActivity(intent);
                break;
        }
    }

}
