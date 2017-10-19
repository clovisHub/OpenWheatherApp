package com.example.admin.openweatherapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.openweatherapp.R;
import com.example.admin.openweatherapp.data.models.Feedback;

import static android.R.attr.data;

public class DisplayerActivity extends AppCompatActivity {

    DisplayerContract.Presenter presenter;
    String cityName;
    TextView displayerTv;
    DisplayerContract.DataRetriever data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayer);

        displayerTv = (TextView) findViewById(R.id.tv_feedback);

        cityName = getIntent().getStringExtra("cityName").trim();
        boolean yes = true;

        for(int i=0; i<10; i++){

            if(cityName.contains(""+i)){
                yes = false;
            }
        }

        if(yes == true){

            presenter = new DisplayerPresenterImpl();
            presenter.setCityName(cityName);

            data = (DisplayerContract.DataRetriever) presenter.getdata();
            displayerTv.setText(data.toString());
        }
        else{
            Toast.makeText(this,"Enter five digits", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("data",data.toString());
    }
}
