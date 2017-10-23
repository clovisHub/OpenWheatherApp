package com.example.admin.openweatherapp.ui;

import android.util.Log;

import com.example.admin.openweatherapp.applevel.AppInit;
import com.example.admin.openweatherapp.applevel.DaggerAppComponent;
import com.example.admin.openweatherapp.data.api.ApiClientModule;
import com.example.admin.openweatherapp.data.api.ApiService;
import com.example.admin.openweatherapp.data.models.Feedback;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DisplayerData implements DisplayerContract.DataRetriever{

    private static final String TAG = "DisplayerDataTAG_";

    private Feedback reply;


    public static DisplayerData obj = null;

    @Inject
    ApiService client;


   private DisplayerData(){

       client = DaggerAppComponent.builder().apiClientModule(new ApiClientModule()).build().getApiService();
      //   client = (new AppInit()).getAppComponent().getApiService();
    }


    public static DisplayerData getDisplayer(){

        if(obj == null){
            obj = new DisplayerData();
        }
        return obj;
    }



    @Override
    public void loadData(String cityname, final DisplayerPresenterImpl.OnDataLoaded onDataLoaded) {

            client.getCityCallable(cityname).enqueue(new Callback<Feedback>() {
                @Override
                public void onResponse(Call<Feedback> call, Response<Feedback> response) {

                    if(response.isSuccessful()){
                        Log.d(TAG, "onResponse: " + response.body());
                        reply = response.body();
                        String [] data = new String[6];
                        data[0] = reply.getWeather().get(0).getDescription();
                        data[1] = reply.getMain().getTemp().toString();
                        data[2] = reply.getWeather().get(0).getIcon();
                        data[3] = reply.getName();
                        data[4] = reply.getWind().getSpeed().toString();
                        data[5] = reply.getSys().getCountry();
                        onDataLoaded.finishLoading(data);
                    }
                    else{
                        int statusCode  = response.code();
                    }

                }

                @Override
                public void onFailure(Call<Feedback> call, Throwable t) {

                }
            });

    }

    @Override
    public Feedback getData() {
        return null;
    }


}
