package gr.aueb.softeng.project1801.view.Owner.OwnerHome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gr.aueb.softeng.project1801.view.R;

public class Owner_login extends AppCompatActivity implements View.OnClickListener {
    Button btn_next;
    private String owner1 = "Sotiris";
    private String owner2 = "Tasos";
    private String owner3 = "George";
    private String pass1 = "1801";
    private EditText name,pass;

    /** This method creates the layout and initializes the activity.
     * @param savedInstanceState , the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);

        btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);

        name = (EditText) findViewById(R.id.name);
        pass = (EditText) findViewById(R.id.pass);
    }


    /** This method is being called when a view has been clicked.So it chooses what to do after the user's specific click.
     * @param v , the View that was clicked
     */
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn_next:
                if((name.getText().toString()).equals(owner1) || (name.getText().toString()).equals(owner2)
                        || (name.getText().toString()).equals(owner3) && (pass.getText().toString()).equals(pass1)){

                    Intent intent = new Intent(this,Owner_View.class);
                    Toast.makeText(this,"Ιδιοκτητης εισήλθε",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    break;
                }else{
                    Toast.makeText(this,"Wrong username or password",Toast.LENGTH_LONG).show();
                }
        }
    }
}
