package com.example.barto.insurancecalculator;

import android.content.Context;

import java.util.Arrays;

public class Calculator {

    private String[] data;
    private Context context;

    private final int MAKE = 0;
    private final int MODEL = 1;
    private final int ENGINE = 2;
    private final int YEAR = 3;
    private final int CLAIM_BONUS = 4;
    private final int COUNTY = 5;
    private final int VALUE = 6;
    private final int AGE = 7;

    String make;
    String model;
    String engine;
    String year;
    String claimsBonus;
    String county;
    int value;
    int age;

    private String[] audiModels;

    private float cost;

    public Calculator(Context context, String[] data)
    {
        this.context = context;
        this.data = data;
        cost = 500f;
        audiModels = context.getResources().getStringArray(R.array.audi_array);
        make = data[MAKE];
        model = data[MODEL];
        engine = data[ENGINE];
        year = data[YEAR];
        claimsBonus = data[CLAIM_BONUS];
        county = data[COUNTY];
        value = Integer.parseInt(data[VALUE]);
        age = Integer.parseInt(data[AGE]);
    }

    public float calculateCost()
    {
        if(make.equals("Audi"))
        {
            cost *= 1.5f;
            if(model.equals("A3")){
                cost *= 1.1f;
            }
            else if(model.equals("A4")){
                cost *= 1.2f;
            }
            else if(model.equals("A5")){
                cost *= 1.3f;
            }
            else if(model.equals("A6")){
                cost *= 1.4f;
            }
            else if(model.equals("A7")){
                cost *= 1.5f;
            }

            if(engine.equals("1.6 FSI")){
                cost *= 1.3f;
            }
            else if(model.equals("1.8 TFSI")){
                cost *= 1.4f;
            }
            else if(model.equals("1.9 TDI")){
                cost *= 1.2f;
            }
            else if(model.equals("2.0 TDI")){
                cost *= 1.5f;
            }
        }

        else if(make.equals("BMW"))
        {
            cost *= 1.7f;
            if(model.equals("1 Series")){
                cost *= 1.2f;
            }
            else if(model.equals("3 Series")){
                cost *= 1.4f;
            }
            else if(model.equals("4 Series")){
                cost *= 1.5f;
            }
            else if(model.equals("5 Series")){
                cost *= 1.6f;
            }
            else if(model.equals("7 Series")){
                cost *= 1.7f;
            }

            if(engine.equals("2.0i")){
                cost *= 1.4f;
            }
            else if(model.equals("2.0d")){
                cost *= 1.4f;
            }
            else if(model.equals("3.0i")){
                cost *= 2.0f;
            }
            else if(model.equals("3.0d")){
                cost *= 2.0f;
            }
        }

        else if(make.equals("Ford"))
        {
            cost *= 1.3f;
            if(model.equals("Fiesta")){
                cost *= 1.1f;
            }
            else if(model.equals("Focus")){
                cost *= 1.3f;
            }
            else if(model.equals("Mondeo")){
                cost *= 1.4f;
            }
            else if(model.equals("Mustang")){
                cost *= 1.8f;
            }

            if(engine.equals("1.0 Ecoboost")){
                cost *= 1.2f;
            }
            else if(model.equals("1.5 Ecoboost")){
                cost *= 1.3f;
            }
            else if(model.equals("1.6 Duratorq")){
                cost *= 1.4f;
            }
            else if(model.equals("2.0 Duratorq")){
                cost *= 1.5f;
            }
        }

        else if(make.equals("Mazda"))
        {
            cost *= 1.25f;
            if(model.equals("3")){
                cost *= 1.2f;
            }
            else if(model.equals("6")){
                cost *= 1.4f;
            }
            else if(model.equals("CX-3")){
                cost *= 1.3f;
            }
            else if(model.equals("CX-5")){
                cost *= 1.5f;
            }

            if(engine.equals("1.5 SkyActive-G")){
                cost *= 1.2f;
            }
            else if(model.equals("2.0 SkyActive-G")){
                cost *= 1.3f;
            }
            else if(model.equals("2.0 SkyActive-D")){
                cost *= 1.5f;
            }
        }

        else if(make.equals("Opel"))
        {
            cost *= 1.2f;
            if(model.equals("Astra")){
                cost *= 1.2f;
            }
            else if(model.equals("Corsa")){
                cost *= 1.1f;
            }
            else if(model.equals("Insignia")){

            }cost *= 1.4f;

            if(engine.equals("1.4 TwinPort")){
                cost *= 1.2f;
            }
            else if(model.equals("1.6 TwinPort")){
                cost *= 1.3f;
            }
            else if(model.equals("1.7 CDTI")){
                cost *= 1.3f;
            }
            else if(model.equals("2.0 CDTI")){
                cost *= 1.4f;
            }
        }

        else if(make.equals("Volkswagen"))
        {
            cost *= 1.2f;
            if(model.equals("Golf")){
                cost *= 1.25f;
            }
            else if(model.equals("Passat")){
                cost *= 1.3f;
            }
            else if(model.equals("Polo")){
                cost *= 1.1f;
            }
            else if(model.equals("Scirocco")){
                cost *= 1.5f;
            }
            else if(model.equals("Touareg")){
                cost *= 1.5f;
            }

            if(engine.equals("1.6 FSI")){
                cost *= 1.3f;
            }
            else if(model.equals("1.8 T")){
                cost *= 1.4f;
            }
            else if(model.equals("1.9 TDI")){
                cost *= 1.2f;
            }
            else if(model.equals("2.0 TDI")){
                cost *= 1.5f;
            }
        }

        if(year.equals("2018")){
            cost *= 1.1f;
        }
        else if(year.equals("2017")){
            cost *= 1.15f;
        }
        else if(year.equals("2016")){
            cost *= 1.2f;
        }
        else if(year.equals("2015")){
            cost *= 1.25f;
        }
        else if(year.equals("2014")){
            cost *= 1.3f;
        }
        else if(year.equals("2013")){
            cost *= 1.35f;
        }
        else if(year.equals("2012")){
            cost *= 1.4f;
        }
        else if(year.equals("2011")){
            cost *= 1.45f;
        }
        else if(year.equals("2010")){
            cost *= 1.5f;
        }
        else if(year.equals("2009")){
            cost *= 1.55f;
        }
        else if(year.equals("2008")){
            cost *= 1.6f;
        }

        if(age <= 18){
            cost *= 3.0f;
        }
        else if(age == 19){
            cost *= 2.5f;
        }
        else if(age == 20){
        cost *= 2.0f;
        }
        else if(age == 21){
            cost *= 1.5f;
        }
        else if(age > 21 && age <=25){
            cost *= 1.25f;
        }
        else if(age > 25 && age <60) {
            cost *= 1.05f;
        }
        else if(age >= 60){
            cost *= 1.3f;
        }

        if(county.equals("Connacht")){
            cost *= 1.2f;
        }
        else if(county.equals("Leinster")){
            cost *= 1.3f;
        }
        else if(county.equals("Munster")){
            cost *= 1.1f;
        }
        else if(county.equals("Ulster")){
            cost *= 1.2f;
        }

        if(claimsBonus.equals("Less than 1")){
            cost *= 1.0f;
        }
        else if(claimsBonus.equals("1")){
            cost *= 0.9f;
        }
        else if(claimsBonus.equals("2")){
            cost *= 0.8f;
        }
        else if(claimsBonus.equals("3")){
            cost *= 0.7f;
        }
        else if(claimsBonus.equals("4")){
            cost *= 0.6f;
        }
        else if(claimsBonus.equals("5")){
            cost *= 0.5f;
        }
        else if(claimsBonus.equals("6")){
            cost *= 0.4f;
        }
        else if(claimsBonus.equals("7+")){
            cost *= 0.35f;
        }

        return cost;
    }

}
