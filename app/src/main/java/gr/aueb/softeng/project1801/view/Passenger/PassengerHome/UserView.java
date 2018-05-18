package gr.aueb.softeng.project1801.view.Passenger.PassengerHome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import gr.aueb.softeng.project1801.view.Passenger.Buy_Ticket.BuyTicketActivity;
import gr.aueb.softeng.project1801.view.Passenger.Track_Route.TrackRouteActivity;
import gr.aueb.softeng.project1801.view.R;

public class UserView extends AppCompatActivity implements View.OnClickListener {

    Button buy_ticket,track_route;

    /** This method creates the layout and initializes the activity.
     * @param savedInstanceState , the Instance state
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_view_activity);

        buy_ticket = (Button) findViewById(R.id.buy_ticket);
        buy_ticket.setOnClickListener(this);

        track_route = (Button) findViewById(R.id.track_route);
        track_route.setOnClickListener(this);
    }

    /** This method is being called when a view has been clicked.So it chooses what to do after the user's specific click.
     * @param v , the View that was clicked
     */
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buy_ticket:
                Intent intent = new Intent(UserView.this, BuyTicketActivity.class);
                intent.putExtra("button_id", R.id.buy_ticket);
                startActivityForResult(intent,1);
                break;
            case R.id.track_route:
                Intent intent1 = new Intent(UserView.this, TrackRouteActivity.class);
                startActivityForResult(intent1,2);
        }
    }

    /** This method recreates the activity with a new instance in case of the requested code gets the value "1".
     * @param requestCode , the requested code
     * @param resultCode , the result code
     * @param data , the intent
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){//purchase successful...recreate the activity
            recreate();
        }else if(requestCode == 2){
            recreate();
        }
    }
}
