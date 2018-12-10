package com.example.barto.insurancecalculator;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class QuoteCalculator extends AppCompatActivity {

    private String[] data;

    private final int MAKE = 0;
    private final int MODEL = 1;
    private final int ENGINE = 2;
    private final int YEAR = 3;
    private final int CLAIM_BONUS = 4;
    private final int COUNTY = 5;
    private final int VALUE = 6;
    private final int AGE = 7;
    private final int TELEPHONE = 8;
    private final int EMAIL = 9;

    private float cost;

    private TextView PriceView;
    private TextView MakeView;
    private TextView ModelView;
    private TextView EngineView;
    private TextView YearView;
    private TextView NoClaimsView;
    private TextView ValueView;
    private TextView CountyView;
    private TextView AgeView;
    private TextView TelephoneView;
    private TextView EmailView;
    private Button Call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_calculator);

        Intent in = getIntent();
        data = in.getStringArrayExtra("Data");

        MakeView = findViewById(R.id.MakeView);
        String make = data[MAKE];
        MakeView.setText(make);

        ModelView= findViewById(R.id.ModelView);
        String model = data[MODEL];
        ModelView.setText(model);

        EngineView= findViewById(R.id.EngineView);
        String engine = data[ENGINE];
        EngineView.setText(engine);

        YearView= findViewById(R.id.YearView);
        String year = data[YEAR];
        YearView.setText(year);

        NoClaimsView= findViewById(R.id.NoClaimsView);
        String claimsBonus = data[CLAIM_BONUS];
        NoClaimsView.setText(claimsBonus);

        CountyView= findViewById(R.id.CountyView);
        String county = data[COUNTY];
        CountyView.setText(county);

        ValueView= findViewById(R.id.ValueView);
        String value = data[VALUE];
        ValueView.setText(value);

        AgeView= findViewById(R.id.AgeView);
        String age = data[AGE];
        AgeView.setText(age);

        TelephoneView= findViewById(R.id.TelephoneView);
        String telephone = data[TELEPHONE];
        TelephoneView.setText(telephone);

        EmailView= findViewById(R.id.EmailView);
        String email = data[EMAIL];
        EmailView.setText(email);

        Call = findViewById(R.id.callBtm);
        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification(); // do method notification()
            }
        });

        Calculator calculator = new Calculator(this, data);

        cost = calculator.calculateCost();

        PriceView = findViewById(R.id.PriceView);
        PriceView.setText("€" + String.format("%.2f", cost));
        //alt + u
    }

    private void notification() {
        Intent callIntent = new Intent(Intent.ACTION_CALL); // create call intent
        callIntent.setData(Uri.parse("tel:0210000000")); // set call number
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, callIntent, 0); // create a pending intent

        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this, "Channel_ID") // create a notification
                .setSmallIcon(R.drawable.phone_icon) // notification icon
                .setContentTitle("Make a call") // title
                .setContentText("Call: 021 000 0000") // message
                .setPriority(NotificationCompat.PRIORITY_DEFAULT) // priority
                .setContentIntent(pendingIntent) // set content of the notification
                .setAutoCancel(true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) // check for permissions
        {
            ActivityCompat.requestPermissions(QuoteCalculator.this,
                    new String[]{Manifest.permission.CALL_PHONE}, 1); // ask user and set permissions
        } else {
            notificationManager.notify(1, nBuilder.build()); //display notification
        }
    }


}
