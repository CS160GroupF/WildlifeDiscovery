package com.example.raymondlin.wildlifediscoveryprototype;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by raymondlin on 7/29/15.
 */
public class NotificationActivity extends Activity {

    Button back, set;
    EditText ed4, ed5, ed6;

    public static final String MyPREFERENCES = "Notifications";
    SharedPreferences sharedpreferences;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_main);

        final Intent view_encounters = new Intent(this, ViewEncountersActivity.class);

        back = (Button)findViewById(R.id.button3);
        set = (Button)findViewById(R.id.button4);

        ed4 = (EditText)findViewById(R.id.editText4);
        ed5 = (EditText)findViewById(R.id.editText5);
        ed6 = (EditText)findViewById(R.id.editText6);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed4.setText("");
                ed5.setText("");
                ed6.setText("");

                startActivity(view_encounters);
            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ed4.getText().toString().length() > 0 && ed5.getText().toString().length() > 0 && ed6.getText().toString().length() > 0) {

                    String animal_name = ed4.getText().toString();
                    int radius = Integer.parseInt(ed5.getText().toString());
                    String note = ed6.getText().toString();


                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString("animal_name", animal_name.toLowerCase());
                    editor.putInt("radius", radius);
                    editor.putString("note", note.toLowerCase());
                    editor.commit();

                    Toast.makeText(NotificationActivity.this, "Alert has been set", Toast.LENGTH_LONG).show();
                    startActivity(view_encounters);

                } else {
                    Toast.makeText(NotificationActivity.this, "Please fill in all fields", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}