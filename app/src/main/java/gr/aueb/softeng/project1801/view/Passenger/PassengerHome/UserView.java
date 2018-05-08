package gr.aueb.softeng.project1801.view.Passenger.PassengerHome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import gr.aueb.softeng.project1801.view.Passenger.Buy_Ticket.BuyTicketActivity;
import gr.aueb.softeng.project1801.view.R;

public class UserView extends AppCompatActivity implements View.OnClickListener {

    Button buy_ticket;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_view_activity);

        buy_ticket = (Button) findViewById(R.id.buy_ticket);
        buy_ticket.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buy_ticket:
                Intent intent = new Intent(UserView.this, BuyTicketActivity.class);
                intent.putExtra("button_id", R.id.buy_ticket);
                startActivity(intent);
                break;
        }
    }
}
