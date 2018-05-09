package gr.aueb.softeng.project1801.view.Owner.OwnerHome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import gr.aueb.softeng.project1801.view.R;

public class Owner_login extends AppCompatActivity implements View.OnClickListener {
    Button btn_next;

    /** This method creates the layout and initializes the activity.
     * @param savedInstanceState, the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);

        btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
    }


    /** This method is being called when a view has been clicked.So it chooses what to do after the user's specific click.
     * @param v, the View that was clicked
     */
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn_next:
                Toast.makeText(this,"Ιδιοκτήτης εισήλθε!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,Owner_View.class);
                startActivity(intent);
                break;
        }
    }
}
