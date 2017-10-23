package com.example.admin.openweatherapp.ui;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DisplayerDataModule {

    @Singleton
    @Provides
    DisplayerContract.DataRetriever provideDisplayerData(){
        return DisplayerData.getDisplayData();
    }
}
