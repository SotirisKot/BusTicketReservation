package gr.aueb.softeng.project1801.view.Owner.StatisticsDetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import gr.aueb.softeng.project1801.memorydao.RouteDAOMemory;
import gr.aueb.softeng.project1801.view.R;

public class StatisticsDetailsActivity extends AppCompatActivity implements StatisticsDetailsView{

    StatisticsDetailsPresenter presenter;

    //Επιστρεφει τον προορισμο του route
    @Override
    public String getDestination() {
        if(this.getIntent().hasExtra("destination")){
            return this.getIntent().getExtras().getString("destination");

        }else{
            return null;
        }
    }

    //Επιστρεφει την αφετηρια του Route
    @Override
    public String getDeparturePoint() {
        if(this.getIntent().hasExtra("departurePoint")){
            return this.getIntent().getExtras().getString("departurePoint");
        }else {
            return null;
        }
    }

    //Επιστρεφει την ημερομηνια αναχωρησης του route
    @Override
    public String getDepartureDate() {
        if(this.getIntent().hasExtra("departureDate")){
            return this.getIntent().getExtras().getString("departureDate");
        }else{
            return null;
        }
    }

    //Επιστρεφει την ωρα αναχωρισης του route
    @Override
    public String getDepartureTime() {
        if(this.getIntent().hasExtra("departureTime")){
            return this.getIntent().getExtras().getString("departureTime");
        }else{
            return null;
        }
    }

    //Εμφανιζει πανω πανω το ονομα της σελιδας..συγκεκριμενα το ονομα του route
    @Override
    public void setActivityName(String value) {
        getSupportActionBar().setTitle(value);
    }

    @Override
    public void setAvailableSeats(int availableSeats) {
        ((TextView)findViewById(R.id.text_seats)).setText(String.valueOf(availableSeats));
    }

    @Override
    public void setBusType(String busType) {
        ((TextView)findViewById(R.id.text_bus_type)).setText(busType);
    }

    @Override
    public void setDepartureDate(String departureDate) {
        ((TextView)findViewById(R.id.text_departure_date)).setText(departureDate);
    }

    @Override
    public void setDeparturePoint(String departurePoint) {
        ((TextView)findViewById(R.id.text_departure_point)).setText(departurePoint);
    }

    @Override
    public void setDepartureTime(String departureTime) {
        ((TextView)findViewById(R.id.text_departure_time)).setText(departureTime);
    }

    @Override
    public void setDestination(String destination) {
        ((TextView)findViewById(R.id.text_destination)).setText(destination);
    }

    @Override
    public void setDriverID(String driver) {
        ((TextView)findViewById(R.id.text_driver_id)).setText(driver);
    }

    @Override
    public void setEstimatedArrivalTime(String estimatedArrivalTime) {
        ((TextView)findViewById(R.id.text_arrival_time)).setText(estimatedArrivalTime);
    }

    @Override
    public void setStatistic(double statistic) {
        String statisticS = statistic +"%" +" "+ "empty";
        ((TextView)findViewById(R.id.text_statistics)).setText(statisticS);
    }

    public void showToast(String value){
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_details_activity);

        presenter = new StatisticsDetailsPresenter(this, new RouteDAOMemory());

    }
}
