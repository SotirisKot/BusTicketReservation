package gr.aueb.softeng.project1801.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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
                Intent intent = new Intent(Owner_View.this, Owner_Operations.class);
                intent.putExtra("button_id",R.id.statistics);
                startActivity(intent);
                break;
            case R.id.AddRoute:
                Intent intent1 = new Intent(Owner_View.this, Owner_Operations.class);
                intent1.putExtra("route_button",R.id.AddRoute);
                startActivity(intent1);
                break;

        }
    }


}
