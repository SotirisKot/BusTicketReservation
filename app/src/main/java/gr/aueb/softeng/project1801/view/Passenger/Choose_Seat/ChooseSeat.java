package gr.aueb.softeng.project1801.view.Passenger.Choose_Seat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import gr.aueb.softeng.project1801.view.R;

public class ChooseSeat extends AppCompatActivity implements View.OnClickListener{

    Button seat1, seat2,seat3,seat4,seat5,seat6,seat7,seat8,seat9,seat10,seat11,seat12,seat13,seat14,seat15,seat16,seat17,seat18,
            seat19,seat20,seat21,seat22,seat23,seat24,seat25,seat26,seat27,seat28,seat29,seat30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_seat);
        seat1 = (Button)findViewById(R.id.seat1);
        seat1.setOnClickListener(this);
        seat2 = (Button)findViewById(R.id.seat2);
        seat2.setOnClickListener(this);
        seat3 = (Button)findViewById(R.id.seat3);
        seat3.setOnClickListener(this);
        seat4 = (Button)findViewById(R.id.seat4);
        seat4.setOnClickListener(this);
        seat5 = (Button)findViewById(R.id.seat5);
        seat5.setOnClickListener(this);
        seat6 = (Button)findViewById(R.id.seat6);
        seat6.setOnClickListener(this);
        seat7 = (Button)findViewById(R.id.seat7);
        seat7.setOnClickListener(this);
        seat8 = (Button)findViewById(R.id.seat8);
        seat8.setOnClickListener(this);
        seat9 = (Button)findViewById(R.id.seat9);
        seat9.setOnClickListener(this);
        seat10 = (Button)findViewById(R.id.seat10);
        seat10.setOnClickListener(this);
        seat11 = (Button)findViewById(R.id.seat11);
        seat11.setOnClickListener(this);
        seat12 = (Button)findViewById(R.id.seat12);
        seat12.setOnClickListener(this);
        seat13 = (Button)findViewById(R.id.seat13);
        seat13.setOnClickListener(this);
        seat14 = (Button)findViewById(R.id.seat14);
        seat14.setOnClickListener(this);
        seat15 = (Button)findViewById(R.id.seat15);
        seat15.setOnClickListener(this);
        seat16 = (Button)findViewById(R.id.seat16);
        seat16.setOnClickListener(this);
        seat17 = (Button)findViewById(R.id.seat17);
        seat17.setOnClickListener(this);
        seat18 = (Button)findViewById(R.id.seat18);
        seat18.setOnClickListener(this);
        seat19 = (Button)findViewById(R.id.seat19);
        seat19.setOnClickListener(this);
        seat20 = (Button)findViewById(R.id.seat20);
        seat20.setOnClickListener(this);
        seat21 = (Button)findViewById(R.id.seat21);
        seat21.setOnClickListener(this);
        seat22 = (Button)findViewById(R.id.seat22);
        seat22.setOnClickListener(this);
        seat23 = (Button)findViewById(R.id.seat23);
        seat23.setOnClickListener(this);
        seat24 = (Button)findViewById(R.id.seat24);
        seat24.setOnClickListener(this);
        seat25 = (Button)findViewById(R.id.seat25);
        seat25.setOnClickListener(this);
        seat26 = (Button)findViewById(R.id.seat26);
        seat26.setOnClickListener(this);
        seat27 = (Button)findViewById(R.id.seat27);
        seat27.setOnClickListener(this);
        seat28 = (Button)findViewById(R.id.seat28);
        seat28.setOnClickListener(this);
        seat29 = (Button)findViewById(R.id.seat29);
        seat29.setOnClickListener(this);
        seat30 = (Button)findViewById(R.id.seat30);
        seat30.setOnClickListener(this);

        //sooot boreis na baleis custom adapter edo se gridview kai na min kaneis auto,xaxaxa 30 koubia,kai 8a briskeis pio patise o xristis me to id pou stou epistrefei i lista
        //kane oti 8es aplos einai ligo protogono
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.seat1:
                Toast.makeText(this,"Seat 1 selected",Toast.LENGTH_SHORT).show();
                break;
                //CONTINUE KAI GIA TA YPOLOIPA ...
        }
    }
}
