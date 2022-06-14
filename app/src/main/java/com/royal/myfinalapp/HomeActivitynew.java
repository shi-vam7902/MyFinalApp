package com.royal.myfinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivitynew extends AppCompatActivity {
TextView seekbarval;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activitynew);

        seekbarval = findViewById(R.id.tv_seekbar);
        Intent i = getIntent();
        String strUsername = i.getStringExtra("KEY_SEEKBAR");
        seekbarval.setText("Seekbar value is  " + strUsername);

    }
}