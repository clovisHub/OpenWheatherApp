package com.example.admin.openweatherapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.openweatherapp.R;
import com.example.admin.openweatherapp.data.api.ApiPicture;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayerActivity extends AppCompatActivity implements DisplayerContract.View {

    private static final String TAG = "DisplayerActivityTAG_";
    DisplayerContract.Presenter presenter;
    String cityName;
    TextView displayerTv, temp, wind, city, country,windSpeed, descrip;
    ImageView image;
    DisplayerContract.DataRetriever data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayer);

        displayerTv = (TextView) findViewById(R.id.tv_feedback);

        image = (ImageView) findViewById(R.id.displ_imgId);
        temp = (TextView) findViewById(R.id.displ_txt_tempId);
        wind = (TextView) findViewById(R.id.displ_txt_windId);

        country = (TextView) findViewById(R.id.displ_txt_KntryId);
        city = (TextView) findViewById(R.id.displ_txt_cityId);

        windSpeed = (TextView) findViewById(R.id.displ_txt_speedId);
        descrip = (TextView) findViewById(R.id.displ_txt_descId);



        cityName = getIntent().getStringExtra("cityName").trim();
        Log.d(TAG, "onCreate: " + cityName);
        boolean yes = true;

        for(int i=0; i<10; i++){

            if(cityName.contains(""+i)){
                yes = false;
                break;
            }
        }

        if(yes == true){

            presenter = new DisplayerPresenterImpl();
            presenter.setView(this);
            presenter.setCityName(cityName);

//            data = (DisplayerContract.DataRetriever) presenter.getdata();
//            displayerTv.setText(data.toString());
        }
        else{
         //   Toast.makeText(this,"Enter five digits", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("data",data.toString());
    }

    @Override
    public void showData(String[] data) {
        List<String> list = Arrays.asList(data);
        displayerTv.setText(list.toString());

        //displayerTv, temp, wind, city, country,windSpeed, descrip;

        ApiPicture picture = new ApiPicture();
         boolean yes = false;
        String testdata ="";

        windSpeed.setText(data[4]);
        country.setText(data[5]);

        city.setText(data[3]);
        temp.setText(data[1]);

        if(data[0].equalsIgnoreCase("clear sky")){
            descrip.setText("clear sky");
            Picasso.with(getApplicationContext()).load(picture.getPictures(data[2])).into(image);
            testdata ="clear sky";

            yes = true;

        }
        else if(data[0].equalsIgnoreCase("few clouds")){
            descrip.setText("few clouds");
            Picasso.with(getApplicationContext()).load(picture.getPictures(data[2])).into(image);
            testdata ="few clouds";

            yes = true;
        }
        else if(data[0].equalsIgnoreCase("scattered clouds")){
            descrip.setText("scattered clouds");
            Picasso.with(getApplicationContext()).load(picture.getPictures(data[2])).into(image);
            testdata ="scattered clouds";
            yes = true;
        }
        else if(data[0].equalsIgnoreCase("broken clouds")){
            descrip.setText("broken clouds");
            Picasso.with(getApplicationContext()).load(picture.getPictures(data[2])).into(image);
            testdata ="broken clouds";
        }
        else if(data[0].equalsIgnoreCase("shower rain")){
            descrip.setText("shower rain");
            Picasso.with(getApplicationContext()).load(picture.getPictures(data[2])).into(image);
            testdata ="shower rain";
        }
        else if(data[0].equalsIgnoreCase("rain")){
            temp.setText("rain");
            Picasso.with(getApplicationContext()).load(picture.getPictures(data[2])).into(image);
            testdata ="rain";
            yes = true;
        }
        else if(data[0].equalsIgnoreCase("thunderstorm")){
            descrip.setText("thunderstorm");
            Picasso.with(getApplicationContext()).load(picture.getPictures(data[2])).into(image);
            testdata ="thunderstorm";
            yes = true;
        }
        else if(data[0].equalsIgnoreCase("snow")){
            descrip.setText("snow");
            Picasso.with(getApplicationContext()).load(picture.getPictures(data[2])).into(image);
            testdata ="snow";
            yes = true;
        }
        else if(data[0].equalsIgnoreCase(picture.getPictures(data[2]))){
            descrip.setText("mist");
            Picasso.with(getApplicationContext()).load(picture+"50d.png").into(image);
            testdata ="mist";
            yes = true;
        }
        else{

        }

    }
}
