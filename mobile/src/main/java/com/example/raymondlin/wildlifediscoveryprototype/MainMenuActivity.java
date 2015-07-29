package com.example.raymondlin.wildlifediscoveryprototype;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by raymondlin on 7/23/15.
 */
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainMenuActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        TabHost tabHost = getTabHost();

        // Tab for Photos
        TabSpec photospec = tabHost.newTabSpec("Add Encounter");
        // setting Title and Icon for the Tab
//        photospec.setIndicator("Photos", getResources().getDrawable(R.drawable.icon_photos_tab));
        Intent photosIntent = new Intent(this, AddEncounterActivity.class);
        photospec.setContent(photosIntent);

        // Tab for Songs
        TabSpec songspec = tabHost.newTabSpec("View All Encounters");
//        songspec.setIndicator("Songs", getResources().getDrawable(R.drawable.icon_songs_tab));
        Intent songsIntent = new Intent(this, ViewEncountersActivity.class);
        songspec.setContent(songsIntent);

        // Tab for Videos
        TabSpec videospec = tabHost.newTabSpec("Notifications");
//        videospec.setIndicator("Videos", getResources().getDrawable(R.drawable.icon_videos_tab));
        Intent videosIntent = new Intent(this, NotificationActivity.class);
        videospec.setContent(videosIntent);

        // Adding all TabSpec to TabHost
        tabHost.addTab(photospec); // Adding photos tab
        tabHost.addTab(songspec); // Adding songs tab
        tabHost.addTab(videospec); // Adding videos tab
    }
}
