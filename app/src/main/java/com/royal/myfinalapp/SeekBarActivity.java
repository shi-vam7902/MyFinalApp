package com.royal.myfinalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SeekBarActivity extends AppCompatActivity {

    private SeekBar seekbar;
    private TextView tvSeekbar;
    private Button btnseekbar;
    private RatingBar rating;
    private TextView tv_rating;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);
        seekbar = (SeekBar)findViewById(R.id.seekbar);
        tvSeekbar =(TextView)findViewById(R.id.tv_seekbar);
        btnseekbar = (Button)findViewById(R.id.btn_seekbar);
        rating = (RatingBar) findViewById(R.id.ratingbar);
        tv_rating = (TextView)findViewById(R.id.tv_rating);

        btnseekbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String seekbarvalue = tvSeekbar.getText().toString();
                Toast.makeText(SeekBarActivity.this, "SeekBar Value  is"+tvSeekbar, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SeekBarActivity.this,HomeActivitynew.class);
                i.putExtra("KEY_SEEKBAR",seekbarvalue);
                startActivity(i);
            }
        });

        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                tv_rating.setText(String.valueOf(v));
            }
        });
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvSeekbar.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}