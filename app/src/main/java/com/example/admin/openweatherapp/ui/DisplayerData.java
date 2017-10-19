package com.example.admin.openweatherapp.ui;

import com.example.admin.openweatherapp.data.api.ApiClient;
import com.example.admin.openweatherapp.data.api.ApiService;
import com.example.admin.openweatherapp.data.models.Feedback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Query;

public class DisplayerData implements DisplayerContract.DataRetriever{

    private static String name;
    private Feedback reply;

    public static DisplayerData obj = null;

    private DisplayerData(){}
    ApiService client;

    public static DisplayerData getDisplayer(){

        if(obj == null){
            obj = new DisplayerData();
        }
        return obj;
    }



    @Override
    public void loadData(String cityname) {

        if(!(cityname.equals("")||cityname != null)){

            name = cityname;

            client.getCityCallable(cityname).enqueue(new Callback<Feedback>() {
                @Override
                public void onResponse(Call<Feedback> call, Response<Feedback> response) {

                    if(response.isSuccessful()){

                        reply = response.body();
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
    }

    @Override
    public Feedback getData() {
        return reply;
    }
}
