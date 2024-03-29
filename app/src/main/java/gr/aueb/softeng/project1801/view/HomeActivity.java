package gr.aueb.softeng.project1801.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import gr.aueb.softeng.project1801.memorydao.DataInitializer;

public class HomeActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    private static boolean initialized = false;

    /** This method creates the layout and initializes the activity.
     * @param savedInstanceState , the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);

        if(!initialized){
            new DataInitializer().prepareData();
            initialized = true;
            Toast.makeText(this,"Loading Data!!",Toast.LENGTH_LONG).show();
        }
    }
}
