package com.example.admin.openweatherapp.applevel;

import android.app.Application;
import android.content.Context;

import com.example.admin.openweatherapp.ui.DisplayerPresenterModule;

public class AppInit extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);
    }

    protected AppComponent initDagger(Context context) {

        return DaggerAppComponent.builder()
                .appModule(new AppModule(context))
                //.displayerPresenterModule(new DisplayerPresenterModule())
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }



}
