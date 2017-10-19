package com.example.admin.openweatherapp.ui;

import android.util.Log;

import com.example.admin.openweatherapp.data.api.ApiClient;
import com.example.admin.openweatherapp.data.api.ApiService;
import com.example.admin.openweatherapp.data.models.Feedback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayerData implements DisplayerContract.DataRetriever{

    private static final String TAG = "DisplayerDataTAG_";

    private static String name;
    private Feedback reply;

    public static DisplayerData obj = null;

    private DisplayerData(){
        client = ApiClient.getClientApi();
    }
    private ApiService client;

    public static DisplayerData getDisplayer(){

        if(obj == null){
            obj = new DisplayerData();
        }
        return obj;
    }



    @Override
    public void loadData(String cityname, final DisplayerPresenterImpl.OnDataLoaded onDataLoaded) {



            name = cityname;

            client.getCityCallable(cityname).enqueue(new Callback<Feedback>() {
                @Override
                public void onResponse(Call<Feedback> call, Response<Feedback> response) {

                    if(response.isSuccessful()){
                        Log.d(TAG, "onResponse: " + response.body());
                        reply = response.body();
                        onDataLoaded.finishLoading(reply.toString());
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
        return reply;
    }
}
