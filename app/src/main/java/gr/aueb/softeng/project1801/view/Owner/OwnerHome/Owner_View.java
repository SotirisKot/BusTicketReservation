package gr.aueb.softeng.project1801.view.Owner.OwnerHome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import gr.aueb.softeng.project1801.view.Owner.ManageRoutes.ManageRoutesActivity;
import gr.aueb.softeng.project1801.view.Owner.Statistics.StatisticsActivity;
import gr.aueb.softeng.project1801.view.R;

public class Owner_View extends AppCompatActivity implements View.OnClickListener{

    Button statistics;
    Button AddRoute;

    /** This method creates the layout and initializes the activity.
     * @param savedInstanceState, the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_view);

        statistics = (Button) findViewById(R.id.statistics);
        statistics.setOnClickListener(this);

        AddRoute = (Button) findViewById(R.id.AddRoute);
        AddRoute.setOnClickListener(this);
    }

    /** This method is being called when a view has been clicked.So it chooses what to do after the user's specific click.
     * @param v, the View that was clicked
     */
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.statistics:
                Intent intent = new Intent(Owner_View.this, StatisticsActivity.class);
                intent.putExtra("button_id",R.id.statistics);
                startActivity(intent);
                break;
            case R.id.AddRoute:
                Intent intent1 = new Intent(Owner_View.this, ManageRoutesActivity.class);
                startActivityForResult(intent1,1);
                break;

        }
    }


    /** This method recreates the activity with a new instance in case of the requested code gets the value "1".
     * @param requestCode, the requested code
     * @param resultCode, the result code
     * @param data, the intent
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){//creation successful...recreate the activity
            recreate();
        }
    }


}
