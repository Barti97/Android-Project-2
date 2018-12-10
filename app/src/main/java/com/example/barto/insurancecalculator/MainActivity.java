package com.example.barto.insurancecalculator;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Spinner makeIn;
    private Spinner modelIn;
    private Spinner yearIn;
    private Spinner engineIn;
    private Spinner claimsBonusIn;
    private EditText valueIn;
    private Spinner countyIn;
    private EditText ageIn;
    private EditText telephoneIn;
    private EditText emailIn;
    private CheckBox checkBox;
    private Button getQuote;

    private String makeChosen;
    private String modelChosen;
    private String engineChosen;
    private String yearChosen;
    private String claimsBonusChosen;
    private String countyChosen;

    private ArrayAdapter<CharSequence> makes;
    private HashMap<String, ArrayAdapter<CharSequence>> makeMap;
    private HashMap<String, ArrayAdapter<CharSequence>> engineMap;
    private ArrayAdapter<CharSequence> audiModels;
    private ArrayAdapter<CharSequence> bmwModels;
    private ArrayAdapter<CharSequence> fordModels;
    private ArrayAdapter<CharSequence> mazdaModels;
    private ArrayAdapter<CharSequence> opelModels;
    private ArrayAdapter<CharSequence> vwModels;

    private ArrayAdapter<CharSequence> audiEngines;
    private ArrayAdapter<CharSequence> bmwEngines;
    private ArrayAdapter<CharSequence> fordEngines;
    private ArrayAdapter<CharSequence> mazdaEngines;
    private ArrayAdapter<CharSequence> opelEngines;
    private ArrayAdapter<CharSequence> vwEngines;

    private ArrayAdapter<CharSequence> years;
    private ArrayAdapter<CharSequence> noClaims;
    private ArrayAdapter<CharSequence> counties;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new String[10];

        createNotificationChannel();

        makeIn = findViewById(R.id.inMake);
        makes = ArrayAdapter.createFromResource(this,
                R.array.makes_array, android.R.layout.simple_spinner_item);
        makes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        makeIn.setAdapter(makes);
        makeIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                makeChosen = (String) parent.getItemAtPosition(position);
                modelIn.setAdapter(makeMap.get(makeChosen));
                engineIn.setAdapter(engineMap.get(makeChosen));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        modelIn = findViewById(R.id.inModel);
        modelIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                modelChosen = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        engineIn = findViewById(R.id.inEngineSize);
        engineIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                engineChosen = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        makeMap = new HashMap<>();
        engineMap = new HashMap<>();

        // Assign each make their unique models
        audiModels = ArrayAdapter.createFromResource(this,
                R.array.audi_array, android.R.layout.simple_spinner_item);
        audiModels.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bmwModels = ArrayAdapter.createFromResource(this,
                R.array.bmw_array, android.R.layout.simple_spinner_item);
        bmwModels.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fordModels = ArrayAdapter.createFromResource(this,
                R.array.ford_array, android.R.layout.simple_spinner_item);
        fordModels.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mazdaModels = ArrayAdapter.createFromResource(this,
                R.array.mazda_array, android.R.layout.simple_spinner_item);
        mazdaModels.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opelModels = ArrayAdapter.createFromResource(this,
                R.array.opel_array, android.R.layout.simple_spinner_item);
        opelModels.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vwModels = ArrayAdapter.createFromResource(this,
                R.array.volkswagen_array, android.R.layout.simple_spinner_item);
        vwModels.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Assign each make their unique engines
        audiEngines = ArrayAdapter.createFromResource(this,
                R.array.audi_engines, android.R.layout.simple_spinner_item);
        audiEngines.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bmwEngines = ArrayAdapter.createFromResource(this,
                R.array.bmw_engines, android.R.layout.simple_spinner_item);
        bmwEngines.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fordEngines = ArrayAdapter.createFromResource(this,
                R.array.ford_engines, android.R.layout.simple_spinner_item);
        fordEngines.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mazdaEngines = ArrayAdapter.createFromResource(this,
                R.array.mazda_engines, android.R.layout.simple_spinner_item);
        mazdaEngines.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opelEngines = ArrayAdapter.createFromResource(this,
                R.array.opel_engines, android.R.layout.simple_spinner_item);
        opelEngines.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vwEngines = ArrayAdapter.createFromResource(this,
                R.array.volkswagen_engines, android.R.layout.simple_spinner_item);
        vwEngines.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        makeMap.put("Audi", audiModels);
        engineMap.put("Audi", audiEngines);
        makeMap.put("BMW", bmwModels);
        engineMap.put("BMW", bmwEngines);
        makeMap.put("Ford", fordModels);
        engineMap.put("Ford", fordEngines);
        makeMap.put("Mazda", mazdaModels);
        engineMap.put("Mazda", mazdaEngines);
        makeMap.put("Opel", opelModels);
        engineMap.put("Opel", opelEngines);
        makeMap.put("Volkswagen", vwModels);
        engineMap.put("Volkswagen", vwEngines);

        yearIn = findViewById(R.id.inYear);
        years = ArrayAdapter.createFromResource(this,
                R.array.years_array, android.R.layout.simple_spinner_item);
        years.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearIn.setAdapter(years);
        yearIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                yearChosen = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        claimsBonusIn = findViewById(R.id.inClaimsBonus);
        noClaims = ArrayAdapter.createFromResource(this,
                R.array.noClaims_array, android.R.layout.simple_spinner_item);
        noClaims.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        claimsBonusIn.setAdapter(noClaims);
        claimsBonusIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                claimsBonusChosen = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        countyIn = findViewById(R.id.inCounty);
        counties = ArrayAdapter.createFromResource(this,
                R.array.counties_array, android.R.layout.simple_spinner_item);
        counties.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countyIn.setAdapter(counties);
        countyIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                countyChosen = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        valueIn = findViewById(R.id.inCarValue);
        ageIn = findViewById(R.id.inAge);
        telephoneIn = findViewById(R.id.inTelephone);
        emailIn = findViewById(R.id.inEmail);
        checkBox = findViewById(R.id.checkBox);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked())
                {
                    getQuote.setEnabled(true);
                }
                else
                {
                    getQuote.setEnabled(false);
                }
            }
        });
        getQuote = findViewById(R.id.quoteBtm);
        getQuote.setEnabled(false);
        getQuote.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String value = valueIn.getText().toString();
                String age = ageIn.getText().toString();
                String telephone = telephoneIn.getText().toString();
                String email = emailIn.getText().toString();
                if(makeChosen != null && modelChosen != null && engineChosen != null && yearChosen != null && claimsBonusChosen != null && countyChosen != null && value != null && age != null && telephone != null && email != null)
                {
                    data[MAKE] = makeChosen;
                    data[MODEL] = modelChosen;
                    data[ENGINE] = engineChosen;
                    data[YEAR] = yearChosen;
                    data[CLAIM_BONUS] = claimsBonusChosen;
                    data[COUNTY] = countyChosen;
                    data[VALUE] = value;
                    data[AGE] = age;
                    data[TELEPHONE] = telephone;
                    data[EMAIL] = email;

                    startQuoteCalculator();
                }

            }
        });

    }
    private void startQuoteCalculator()
    {
        Intent in = new Intent( MainActivity.this, QuoteCalculator.class);
        in.putExtra("Data", data);
        startActivity(in);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Channel Name";
            String description = "Channel Description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Channel_ID", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        }
        else {
        }

        return;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
        case R.id.InsuranceCalculator:
            MainActivity.this.recreate();
            return(true);
        case R.id.Game:
            startActivity(new Intent(MainActivity.this, GameMainActivity.class));
            return(true);
        case R.id.Settings:
            Intent in = new Intent( MainActivity.this, Settings.class);
            startActivity(in);
            return(true);
        case R.id.Exit:
            finish();
            return(true);
    }
        return(super.onOptionsItemSelected(item));
    }

}
