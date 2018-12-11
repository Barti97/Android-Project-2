package com.example.barto.insurancecalculator;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

public class Settings extends AppCompatActivity {

    private int seekRed, seekGreen, seekBlue;
    private RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SeekBar sbRed = findViewById(R.id.RedSeekBar);
        SeekBar sbGreen =findViewById(R.id.GreenSeekBar);
        SeekBar sbBlue = findViewById(R.id.BlueSeekBar);

        rl = findViewById(R.id.rl);


        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekRed = progress;

                doSomethingWithColor();
            }
        });

        sbGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekGreen = progress;

                doSomethingWithColor();
            }
        });

        sbBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBlue = progress;

                doSomethingWithColor();
            }
        });

    }

    private void doSomethingWithColor() {
        int color = Color.rgb(seekRed, seekGreen, seekBlue);
        rl.setBackgroundColor(color);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
        case R.id.InsuranceCalculator:
            Intent in = new Intent( Settings.this, MainActivity.class);
            startActivity(in);
            return(true);
        case R.id.Settings:
            Settings.this.recreate();
            return(true);
        case R.id.Exit:
            finish();
            return(true);
    }
        return(super.onOptionsItemSelected(item));
    }

    OnSwipeTouchListener onSwipeTouchListener = new OnSwipeTouchListener(Settings.this) {
        @Override
        public void onSwipeLeft() {
            startActivity(new Intent(Settings.this, MainActivity.class));
        }
    };
}
