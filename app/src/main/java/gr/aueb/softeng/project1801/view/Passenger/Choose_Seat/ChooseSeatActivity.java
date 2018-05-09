package gr.aueb.softeng.project1801.view.Passenger.Choose_Seat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.dao.RouteDAO;
import gr.aueb.softeng.project1801.memorydao.RouteDAOMemory;
import gr.aueb.softeng.project1801.view.R;
import gr.aueb.softeng.project1801.view.Util.SeatAdapter;

public class ChooseSeatActivity extends AppCompatActivity {

    private GridView gridView;
    private SeatAdapter seatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_seat);

        RouteDAO routeDAO = new RouteDAOMemory();
        Route route = routeDAO.findAll().get(0);

        List<Integer> data = new ArrayList<>(route.getAvailableSeats());

        for(int i=0; i<route.getAvailableSeats(); i++){
            data.add(i);
        }

        seatAdapter = new SeatAdapter(this,route);
        seatAdapter.loadData(data);

        gridView = (GridView) findViewById(R.id.gridviewSeat);
        gridView.setAdapter(seatAdapter);
    }

}

