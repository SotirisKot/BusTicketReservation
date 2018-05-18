package gr.aueb.softeng.project1801.view.Passenger.Choose_Seat;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;
import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.SysUtils.SeatRow;
import gr.aueb.softeng.project1801.SysUtils.SystemCalendar;
import gr.aueb.softeng.project1801.dao.RouteDAO;
import gr.aueb.softeng.project1801.memorydao.RouteDAOMemory;
import gr.aueb.softeng.project1801.view.Passenger.TicketOverview.TicketOverviewActivity;
import gr.aueb.softeng.project1801.view.R;
import gr.aueb.softeng.project1801.view.Util.SeatAdapter;

public class ChooseSeatActivity extends AppCompatActivity implements ChooseSeatView {

    private GridView gridView;
    private SeatAdapter seatAdapter;
    private ChooseSeatPresenter presenter;


    /** This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    @Override
    public String getDestination(){
        if(this.getIntent().hasExtra("destination")){
            return this.getIntent().getExtras().getString("destination");

        }else{
            return null;
        }
    }

    /** This method returns a departure point.
     * @return a String object that has the departure point
     */
    @Override
    public String getDeparturePoint(){
        if(this.getIntent().hasExtra("departurePoint")){
            return this.getIntent().getExtras().getString("departurePoint");

        }else{
            return null;
        }
    }

    /** This method returns a departure date.
     * @return a String object that has the departure date
     */
    @Override
    public String getDepartureDate(){
        if(this.getIntent().hasExtra("departureDate")){
            return this.getIntent().getExtras().getString("departureDate");

        }else{
            return null;
        }
    }

    /** This method returns the number of seats.
     * @return a String object that has the number of seats
     */
    @Override
    public String getSeats(){
        if(this.getIntent().hasExtra("seats")){
            return this.getIntent().getExtras().getString("seats");

        }else{
            return null;
        }
    }

    /** This method returns a departure time.
     * @return a String object that has the departure time
     */
    @Override
    public String getDepartureTime(){
        if(this.getIntent().hasExtra("departureTime")){
            return this.getIntent().getExtras().getString("departureTime");

        }else{
            return null;
        }
    }

    /**
     *  This method pops up a toast.
     * @param value , the message we want to print in the toast
     */
    @Override
    public void showToast(String value){
        Toast.makeText(this,value,Toast.LENGTH_LONG).show();
    }


    /** This method shows alert messages
     * @param message , the alert message we want to print
     */
    @Override
    public void showAlertMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(ChooseSeatActivity.this);
        alert.setCancelable(true);
        alert.setMessage(message);
        DialogInterface.OnClickListener Positivelistener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.onClickProceed();
            }
        };
        alert.setPositiveButton(R.string.yes_button,Positivelistener);
        alert.setNegativeButton(R.string.no_button,null);
        alert.create().show();
    }

    /** This method sets name to a specific Activity.
     * @param title , the name_value we want to set in a specific Activity
     */
    @Override
    public void setActivityName(String title){
        getSupportActionBar().setTitle(title);
    }


    /**
     * This method loads the data(a List).
     * @param data , the data that we want to load
     */
    @Override
    public void loadData(List<SeatRow> data) {
        seatAdapter.loadData(data);
    }


    /**
     *
     * This method method redirects the user to another activity after a click event.
     * @param destination , the destination of the route
     * @param departurePoint , the departure point of the route
     * @param departureDate , the departure date of the route
     * @param departureTime , the departure time of the route
     */
    @Override
    public void clickProceed(String destination,String departurePoint,String departureDate,String departureTime){
        List<SeatRow> seats = presenter.getSeatsSelected();
        Intent intent = new Intent(this, TicketOverviewActivity.class);
        intent.putExtra("destination",destination);
        intent.putExtra("departurePoint",departurePoint);
        intent.putExtra("departureDate",departureDate);
        intent.putExtra("departureTime",departureTime);
        intent.putExtra("seats", (Serializable) seats);
        startActivityForResult(intent,1);
    }


    /** This method creates the layout and initializes the activity.
     * @param savedInstanceState , the Instance state
     */
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
                presenter.onClickSeat(seat);
                seatAdapter.notifyDataSetChanged();
            }
        });
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
            finish();
        }
    }
}

