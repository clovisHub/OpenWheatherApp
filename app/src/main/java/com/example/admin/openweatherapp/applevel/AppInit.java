package com.example.admin.openweatherapp.applevel;

import android.app.Application;
import android.content.Context;

import com.example.admin.openweatherapp.ui.DisplayerPresenterModule;

public class AppInit extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);
    }

    protected AppComponent initDagger(Context context) {

        return DaggerAppComponent.builder()
                .appModule(new AppModule(context))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }



}
