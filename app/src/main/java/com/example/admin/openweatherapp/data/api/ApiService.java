package com.example.admin.openweatherapp.data.api;


import com.example.admin.openweatherapp.BuildConfig;
import com.example.admin.openweatherapp.data.models.Feedback;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("weather?q={city},us & APPID="+BuildConfig.apikey)
    Call<Feedback> getCityCallable(@Query("city") String zipCode);
}
