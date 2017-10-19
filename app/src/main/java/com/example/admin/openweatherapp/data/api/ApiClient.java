package com.example.admin.openweatherapp.data.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by Admin on 10/18/2017.
 */

public class ApiClient {

    private static Retrofit retrofit = null;

    static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl("api.openweathermap.org/data/2.5/")
                .addConverterFactory(MoshiConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

    public static ApiService setClientApi(Retrofit retro){
        return retro.create(ApiService.class);
    }

}
