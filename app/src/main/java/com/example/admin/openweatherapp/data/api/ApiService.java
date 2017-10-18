package com.example.admin.openweatherapp.data.api;


import com.example.admin.openweatherapp.BuildConfig;
import com.example.admin.openweatherapp.data.models.Feedback;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api.openweathermap.org/data/2.5/weather?q={city},us & APPID=")
    Call<Feedback> forecastForZipCallable(@Query("city") String zipCode);
}
