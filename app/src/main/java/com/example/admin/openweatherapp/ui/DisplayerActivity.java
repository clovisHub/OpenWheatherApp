package com.example.admin.openweatherapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.openweatherapp.CityNameAdapter;
import com.example.admin.openweatherapp.Linker;
import com.example.admin.openweatherapp.R;
import com.example.admin.openweatherapp.applevel.AppInit;
import com.example.admin.openweatherapp.applevel.DaggerAppComponent;
import com.example.admin.openweatherapp.data.api.ApiPicture;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DisplayerActivity extends AppCompatActivity implements DisplayerContract.View, View.OnClickListener,Linker {

    private static final String TAG = "DisplayerActivityTAG_";

    @Inject
    DisplayerContract.Presenter presenter;

    String cityName;

    @BindView(R.id.tv_feedback)
    TextView displayerTv;
    @BindView(R.id.displ_txt_tempId)
    TextView temp;
    @BindView(R.id.displ_txt_windId)
    TextView wind;
    @BindView(R.id.displ_txt_cityId)
    TextView city;
    @BindView(R.id.displ_txt_KntryId)
    TextView country;
    @BindView(R.id.displ_txt_speedId)
    TextView windSpeed;
    @BindView(R.id.displ_txt_descId)
    TextView descrip;

    @BindView(R.id.displ_imgId) ImageView image;
    @BindView(R.id.displ_btn_cityNamId) Button displayBtn;

    DisplayerContract.DataRetriever data;
    CityNameAdapter cityNameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayer);

        ButterKnife.bind(this);

     //   displayBtn.setOnClickListener(this);



        cityName = getIntent().getStringExtra("cityName").trim();
        Log.d(TAG, "onCreate: " + cityName);
        boolean yes = Pattern.matches("[0-9]",cityName);

        if(yes == false){

            presenter = DaggerAppComponent.builder().displayerPresenterModule(new DisplayerPresenterModule()).build().getPresenter();
            presenter.setView(this);
            presenter.setCityName(cityName);
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
    @OnClick(R.id.displ_btn_cityNamId)
    @Override
    public void onClick(View view) {

        cityNameAdapter = new CityNameAdapter();
        cityNameAdapter.show(getFragmentManager(),"myDialog");
    }

    @Override
    public void sCityName(String value) {

        cityName = value;
        boolean yes = Pattern.matches("[0-9]",cityName);
        if(yes == false){
            presenter.setCityName(cityName);
        }
        else{
            //   Toast.makeText(this,"Enter five digits", Toast.LENGTH_LONG).show();
        }
    }
}
