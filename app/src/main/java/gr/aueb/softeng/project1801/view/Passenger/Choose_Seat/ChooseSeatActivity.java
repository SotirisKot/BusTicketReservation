package gr.aueb.softeng.project1801.view.Passenger.Choose_Seat;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import java.util.List;
import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.SysUtils.SeatRow;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.RouteDAO;
import gr.aueb.softeng.project1801.memorydao.RouteDAOMemory;
import gr.aueb.softeng.project1801.view.R;
import gr.aueb.softeng.project1801.view.Util.SeatAdapter;

public class ChooseSeatActivity extends AppCompatActivity implements ChooseSeatView {

    private GridView gridView;
    private SeatAdapter seatAdapter;
    private ChooseSeatPresenter presenter;

    @Override
    public String getDestination(){
        if(this.getIntent().hasExtra("destination")){
            return this.getIntent().getExtras().getString("destination");

        }else{
            return null;
        }
    }

    @Override
    public String getDeparturePoint(){
        if(this.getIntent().hasExtra("departurePoint")){
            return this.getIntent().getExtras().getString("departurePoint");

        }else{
            return null;
        }
    }

    @Override
    public String getDepartureDate(){
        if(this.getIntent().hasExtra("departureDate")){
            return this.getIntent().getExtras().getString("departureDate");

        }else{
            return null;
        }
    }

    @Override
    public String getSeats(){
        if(this.getIntent().hasExtra("seats")){
            return this.getIntent().getExtras().getString("seats");

        }else{
            return null;
        }
    }

    @Override
    public String getDepartureTime(){
        if(this.getIntent().hasExtra("departureTime")){
            return this.getIntent().getExtras().getString("departureTime");

        }else{
            return null;
        }
    }

    @Override
    public void showToast(String value){
        Toast.makeText(this,value,Toast.LENGTH_LONG).show();
    }


    @Override
    public void showAlertMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(null);
        alert.setCancelable(true);
        alert.setMessage(message);
        alert.setPositiveButton(R.string.yes_button,null);
        alert.setNegativeButton(R.string.no_button,null);
        alert.create().show();
    }

    @Override
    public void setActivityName(String title){
        getSupportActionBar().setTitle(title);
    }


    @Override
    public void loadData(List<SeatRow> data) {
        seatAdapter.loadData(data);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_seat);

        seatAdapter = new SeatAdapter(this);

        gridView = (GridView) findViewById(R.id.gridviewSeat);
        gridView.setAdapter(seatAdapter);

        RouteDAO routeDAO = new RouteDAOMemory();
        String date = getDepartureDate();
        String[] parts = date.split("/");
        SystemCalendar calendar = new SystemCalendar(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));

        final Route route = routeDAO.find(getDestination(),getDepartureTime(),getDeparturePoint(),calendar);
        presenter = new ChooseSeatPresenter(this,route);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SeatRow seat = (SeatRow) parent.getItemAtPosition(position);
                presenter.onClickSeat(route,seat);
                seatAdapter.notifyDataSetChanged();
            }
        });
    }

}

