package gr.aueb.softeng.project1801.view.Employee.EmployeeHome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gr.aueb.softeng.project1801.view.R;

public class Employee_login extends AppCompatActivity implements View.OnClickListener {


    private String employee = "George";
    private String passEmpl = "1801";
    private Button button_next;
    private EditText name,pass;



    /** This method creates the layout and initializes the activity.
     * @param savedInstanceState , the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

        button_next = (Button) findViewById(R.id.button_next);
        button_next.setOnClickListener(this);

        name = (EditText) findViewById(R.id.name);
        pass = (EditText) findViewById(R.id.pass);
    }


    /** This method is being called when a view has been clicked.So it chooses what to do after the user's specific click.
     * @param v , the View that was clicked
     */
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button_next:
                if((name.getText().toString()).equals(employee) && (pass.getText().toString()).equals(passEmpl)){
                    Toast.makeText(this,"Ιδιοκτήτης εισήλθε!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this,Employee_View.class);
                    startActivity(intent);
                    break;
                }else{
                    Toast.makeText(this,"Wrong username or password",Toast.LENGTH_LONG).show();
                }

        }
    }
}
