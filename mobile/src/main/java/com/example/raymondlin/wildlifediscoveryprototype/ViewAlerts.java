package com.example.raymondlin.wildlifediscoveryprototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by raymondlin on 7/31/15.
 */
public class ViewAlerts extends Activity {

    AlertDB mydb;
    Button add;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_alerts);

        final Intent addAlert = new Intent(this, AddNotification.class);
        add = (Button)findViewById(R.id.add);

        mydb = new AlertDB(this);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(addAlert);
            }
        });

    }



}
