package gr.aueb.softeng.project1801.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class Owner_login extends AppCompatActivity implements View.OnClickListener {
    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);

        btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
    }


    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn_next:
                Toast.makeText(this,"Ιδιοκτήτης εισήλθε!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Owner_login.this,Owner_View.class);
                startActivity(intent);
        }
    }
}
