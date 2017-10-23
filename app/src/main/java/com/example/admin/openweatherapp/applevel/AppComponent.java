package com.example.admin.openweatherapp.applevel;


import com.example.admin.openweatherapp.data.api.ApiClientModule;
import com.example.admin.openweatherapp.data.api.ApiService;
import com.example.admin.openweatherapp.ui.DisplayerActivity;
import com.example.admin.openweatherapp.ui.DisplayerContract;
import com.example.admin.openweatherapp.ui.DisplayerData;
import com.example.admin.openweatherapp.ui.DisplayerDataModule;
import com.example.admin.openweatherapp.ui.DisplayerPresenterImpl;
import com.example.admin.openweatherapp.ui.DisplayerPresenterModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiClientModule.class,
           DisplayerPresenterModule.class, DisplayerDataModule.class})
public interface AppComponent {

    ApiService getApiService();
    DisplayerContract.DataRetriever getDisplayerData();
    DisplayerContract.Presenter getPresenter();

   //void inject(DisplayerPresenterImpl target);
   //void inject(DisplayerData target);
    //void inject(DisplayerActivity target);
}
