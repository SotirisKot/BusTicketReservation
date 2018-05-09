package gr.aueb.softeng.project1801.view.Owner.StatisticsDetails;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import gr.aueb.softeng.project1801.memorydao.RouteDAOMemory;
import gr.aueb.softeng.project1801.view.R;

public class StatisticsDetailsActivity extends AppCompatActivity implements StatisticsDetailsView{

    StatisticsDetailsPresenter presenter;

    /** This method returns a destination.
     * @return a String object that has the name of the destination we asked
     */
    @Override
    public String getDestination() {
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
    public String getDeparturePoint() {
        if(this.getIntent().hasExtra("departurePoint")){
            return this.getIntent().getExtras().getString("departurePoint");
        }else {
            return null;
        }
    }

    /** This method returns a departure date.
     * @return a String object that has the departure date
     */
    @Override
    public String getDepartureDate() {
        if(this.getIntent().hasExtra("departureDate")){
            return this.getIntent().getExtras().getString("departureDate");
        }else{
            return null;
        }
    }

    /** This method returns a departure time.
     * @return a String object that has the departure time
     */
    @Override
    public String getDepartureTime() {
        if(this.getIntent().hasExtra("departureTime")){
            return this.getIntent().getExtras().getString("departureTime");
        }else{
            return null;
        }
    }

    /** This method sets name to a specific Activity.
     * @param value, the name_value we want to set in a specific Activity
     */
    @Override
    public void setActivityName(String value) {
        getSupportActionBar().setTitle(value);
    }

    /**
     * This method sets the number of available seats of a bus.
     * @param availableSeats, the number of available seats of a bus
     */
    @Override
    public void setAvailableSeats(int availableSeats) {
        ((TextView)findViewById(R.id.text_seats)).setText(String.valueOf(availableSeats));
    }

    /**
     * This method sets the bus type that is going to be used in a route.
     * @param busType, the bus type being used in the route
     */
    @Override
    public void setBusType(String busType) {
        ((TextView)findViewById(R.id.text_bus_type)).setText(busType);
    }

    /**
     * This method sets a departure date to a route.
     * @param departureDate, the departure date of the route
     */
    @Override
    public void setDepartureDate(String departureDate) {
        ((TextView)findViewById(R.id.text_departure_date)).setText(departureDate);
    }

    /**
     * This method sets a departure point to a route.
     * @param departurePoint, the departure point of the route
     */
    @Override
    public void setDeparturePoint(String departurePoint) {
        ((TextView)findViewById(R.id.text_departure_point)).setText(departurePoint);
    }

    /**
     * This method sets a departure time to a route.
     * @param departureTime, the departure time of the route
     */
    @Override
    public void setDepartureTime(String departureTime) {
        ((TextView)findViewById(R.id.text_departure_time)).setText(departureTime);
    }

    /**
     * This method sets a destination to a route.
     * @param destination, the destination of the route
     */
    @Override
    public void setDestination(String destination) {
        ((TextView)findViewById(R.id.text_destination)).setText(destination);
    }

    /**
     * This method sets the driver's ID.
     * @param driver, the driver's ID
     */
    @Override
    public void setDriverID(String driver) {
        ((TextView)findViewById(R.id.text_driver_id)).setText(driver);
    }

    /**
     * This method sets an estimated arrival time to a route.
     * @param estimatedArrivalTime, the estimated arival time of the route
     */
    @Override
    public void setEstimatedArrivalTime(String estimatedArrivalTime) {
        ((TextView)findViewById(R.id.text_arrival_time)).setText(estimatedArrivalTime);
    }

    /**
     * This method sets the statistics of a route.
     * @param statistic, the statistics of a route
     */
    @Override
    public void setStatistic(double statistic) {
        String statisticS = statistic +"%" +" "+ "empty";
        ((TextView)findViewById(R.id.text_statistics)).setText(statisticS);
    }


    /** This method prints a warning dialog message before deletion in order to ensure the process that is going to be executed.
     * @param warning, the warning dialog message for deletion
     */
    @Override
    public void ClickDeleteButton(String warning) {
        AlertDialog.Builder alert = new AlertDialog.Builder(StatisticsDetailsActivity.this);
        alert.setCancelable(true);
        DialogInterface.OnClickListener Positivelistener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.onDelete();
            }
        };
        DialogInterface.OnClickListener Negativelistener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("Deletion Cancelled");

            }
        };

        alert.setPositiveButton(R.string.yes_button,Positivelistener);
        alert.setNegativeButton(R.string.no_button,Negativelistener);
        alert.setMessage(warning);
        alert.create().show();
    }

    /**
     * This method pops up a toest with a deletion message.
     * @param message, the deletion message
     */
    @Override
    public void delete(String message) {
        showToast(message);
        finish();
    }

    /** This method pops up a toast.
     * @param value, the message we want to print in the toast
     */
    public void showToast(String value){
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }

    /** This method creates the layout and initializes the activity.
     * @param savedInstanceState, the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_details_activity);

        presenter = new StatisticsDetailsPresenter(this, new RouteDAOMemory());

        findViewById(R.id.delete_route_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickDeleteButton();
            }
        });
    }
}
