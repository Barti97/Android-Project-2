package com.example.barto.insurancecalculator;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GameMainActivity extends AppCompatActivity implements View.OnClickListener {

    //image button
    private ImageButton buttonPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_main);

        //setting the orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //getting the button
        buttonPlay = (ImageButton) findViewById(R.id.buttonPlay);

        //adding a click listener
        buttonPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, GameActivity.class));
    }

    OnSwipeTouchListener onSwipeTouchListener = new OnSwipeTouchListener(GameMainActivity.this) {
        @Override
        public void onSwipeRight() {
            startActivity(new Intent(GameMainActivity.this, MainActivity.class));
        }
    };
}
