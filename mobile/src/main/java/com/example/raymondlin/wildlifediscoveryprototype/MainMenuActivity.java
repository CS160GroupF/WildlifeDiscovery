package com.example.raymondlin.wildlifediscoveryprototype;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainMenuActivity extends TabActivity {
    /** Called when the activity is first created. */

    DBHelper mydb;

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        TabHost tabHost = getTabHost();

        TabSpec addspec = tabHost.newTabSpec("Add Encounter");
        // setting Title and Icon for the Tab
        addspec.setIndicator("Add Encounter");
        Intent addIntent = new Intent(this, AddEncounterActivity.class);
        addspec.setContent(addIntent);

        TabSpec viewspec = tabHost.newTabSpec("View All Encounters");
        viewspec.setIndicator("View All Encounters");
        Intent viewIntent = new Intent(this, ViewEncountersActivity.class);
        viewspec.setContent(viewIntent);

        TabSpec alertspec = tabHost.newTabSpec("Alerts");
        alertspec.setIndicator("Alerts");
        Intent alertIntent = new Intent(this, ViewAlerts.class);
        alertspec.setContent(alertIntent);

        // Adding all TabSpec to TabHost
        tabHost.addTab(addspec);
        tabHost.addTab(viewspec);
        tabHost.addTab(alertspec);



    }
}
