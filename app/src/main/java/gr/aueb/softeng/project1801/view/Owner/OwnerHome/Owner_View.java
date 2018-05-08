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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_view);

        statistics = (Button) findViewById(R.id.statistics);
        statistics.setOnClickListener(this);

        AddRoute = (Button) findViewById(R.id.AddRoute);
        AddRoute.setOnClickListener(this);
    }

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){//creation successful...recreate the activity
            recreate();
        }
    }


}
