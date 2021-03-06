package com.example.admin.openweatherapp.ui;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DisplayerPresenterModule {

    @Singleton
    @Provides
    DisplayerContract.Presenter provideDisplayPresenter(){
        return new DisplayerPresenterImpl();
    }

}
