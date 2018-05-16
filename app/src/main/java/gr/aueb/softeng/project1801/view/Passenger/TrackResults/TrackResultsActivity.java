package gr.aueb.softeng.project1801.view.Passenger.TrackResults;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import gr.aueb.softeng.project1801.memorydao.RouteDAOMemory;
import gr.aueb.softeng.project1801.view.R;

public class TrackResultsActivity extends FragmentActivity implements OnMapReadyCallback,TrackResultsView{

    private GoogleMap mMap;
    private ArrayList<LatLng> latLngs = new ArrayList<>();
    private ArrayList<Marker> markers = new ArrayList<>();
    private MarkerOptions markerOptions = new MarkerOptions();
    private TrackResultsPresenter presenter;
    private List<LatLng> llG = new ArrayList<>();
    private int speed = 80;//km/h
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_results_activity);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        presenter = new TrackResultsPresenter(this,new RouteDAOMemory());

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        findViewById(R.id.show_time).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location current = new Location("current");
                LatLng cur = latLngs.get(latLngs.size() - 1);
                current.setLatitude(cur.latitude);
                current.setLongitude(cur.longitude);

                Location destination = new Location("Destination");
                LatLng dest = llG.get(0);
                destination.setLatitude(dest.latitude);
                destination.setLongitude(dest.longitude);

                float distance=current.distanceTo(destination);

                float time = (distance)/1000/speed;
                if(time < 1){
                    presenter.onShowAlert("Estimated time: " + time*60 + " minutes");
                }else{
                    presenter.onShowAlert("Estimated time: " + time + " hours");
                }

            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(120000); // two minute interval
        mLocationRequest.setFastestInterval(120000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        String destination = presenter.onGetDestination();
        llG = getCoordDestination(destination);
        for(int i=0; i< llG.size(); i++){
            mMap.addMarker(new MarkerOptions().position(llG.get(i)).title("Destination"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(llG.get(i)));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(12), 2000, null);
            mMap.setTrafficEnabled(true);

            markerOptions.position(llG.get(i));
            markers.add(mMap.addMarker(markerOptions));
        }

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                //Location Permission already granted
                mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback , Looper.myLooper());
                mMap.setMyLocationEnabled(true);
            }
        }
        else {
            mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
            mMap.setMyLocationEnabled(true);
        }
    }


    LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            List<Location> locationList = locationResult.getLocations();
            if (locationList.size() > 0) {
                //The last location in the list is the newest
                Location location = locationList.get(locationList.size() - 1);
                Log.i("MapsActivity", "Location: " + location.getLatitude() + " " + location.getLongitude());
                //Place current location marker
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                latLngs.add(latLng);
                markerOptions.position(latLng);
                markerOptions.title("Current Position");
                markers.add(mMap.addMarker(markerOptions));

                //move map camera
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 11));
            }
        }
    };

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

    @Override
    public String getDepartureTime() {
        if(this.getIntent().hasExtra("departureTime")){
            return this.getIntent().getExtras().getString("departureTime");
        }else{
            return null;
        }
    }

    @Override
    public void showAlertMessage(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(TrackResultsActivity.this);
        alert.setCancelable(true);
        alert.setMessage(message);
        alert.setPositiveButton(R.string.ok_button,null);

        alert.create().show();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private List<LatLng> getCoordDestination(String location){
        List<LatLng> ll = new ArrayList<>();
        if(Geocoder.isPresent()){
            try {
                Geocoder gc = new Geocoder(this);
                List<Address> addresses= gc.getFromLocationName(location, 1); // get the found Address Objects

                ll = new ArrayList<LatLng>(addresses.size()); // A list to save the coordinates if they are available
                for(Address a : addresses){
                    if(a.hasLatitude() && a.hasLongitude()){
                        ll.add(new LatLng(a.getLatitude(), a.getLongitude()));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return ll;
    }

    @Override
    public void kill(){
        Intent retData = new Intent();
        retData.putExtra("message_to_toast", "Route does not exist");
        setResult(RESULT_CANCELED, retData);
        finish();
    }

    @Override
    public void onBackPressed(){
        Intent retData = new Intent();
        retData.putExtra("message_to_toast", "Tracking ended");
        setResult(RESULT_OK, retData);
        finish();
    }
}
