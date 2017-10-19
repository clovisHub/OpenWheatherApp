package com.example.admin.openweatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.admin.openweatherapp.ui.DisplayerActivity;

public class MainActivity extends AppCompatActivity implements Linker{

    boolean state;
    String cityName ="";
    CityNameAdapter cityNameAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityNameAdapter = new CityNameAdapter();
        cityNameAdapter.show(getFragmentManager(),"myDialog");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("cityName",cityName);
    }

    public void goToDisplayerActivity(){

        if(!cityName.isEmpty()||cityName != null ){

            Intent intent = new Intent(this, DisplayerActivity.class);
            intent.putExtra("cityName",cityName);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, R.string.enter_city,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void setCityName(String value) {
        cityName = value;
       if(!cityName.equals("")|| cityName!= null){

           goToDisplayerActivity();
       }
    }

}

