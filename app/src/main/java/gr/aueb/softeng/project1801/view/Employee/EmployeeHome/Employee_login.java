package gr.aueb.softeng.project1801.view.Employee.EmployeeHome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import gr.aueb.softeng.project1801.view.R;

public class Employee_login extends AppCompatActivity implements View.OnClickListener {



    private Button button_next;


    /** This method creates the layout and initializes the activity.
     * @param savedInstanceState, the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

        button_next = (Button) findViewById(R.id.button_next);
        button_next.setOnClickListener(this);
    }


    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button_next:
                Toast.makeText(this,"Ιδιοκτήτης εισήλθε!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,Employee_View.class);
                startActivity(intent);
                break;
        }
    }
}
