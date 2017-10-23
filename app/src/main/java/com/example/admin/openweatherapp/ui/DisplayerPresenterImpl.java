package com.example.admin.openweatherapp.ui;

import android.content.Context;
import android.util.Log;

import com.example.admin.openweatherapp.applevel.AppInit;
import com.example.admin.openweatherapp.applevel.DaggerAppComponent;
import com.example.admin.openweatherapp.data.models.Feedback;

import javax.inject.Inject;

/**
 * Created by Admin on 10/18/2017.
 */

public class DisplayerPresenterImpl implements DisplayerContract.Presenter{

    private static final String TAG = "DisplayerImplTAG_";
    @Inject
    DisplayerContract.DataRetriever data;

    //public DisplayerPresenterImpl presenter = null;

    private DisplayerContract.View view;

    public DisplayerPresenterImpl(){
        //data = DisplayerData.getDisplayer();
        data = DaggerAppComponent.builder().displayerDataModule(new DisplayerDataModule()).build().getDisplayerData();
    }

    @Override
    public void setCityName(String cityName) {
        data.loadData(cityName, new OnDataLoaded(){
            @Override
            public void finishLoading(String [] str) {
                Log.d(TAG, "finishLoading: " + str);
                view.showData(str);
            }
        });
    }

    @Override
    public Feedback getdata() {
       return data.getData();
    }

    @Override
    public void setView(DisplayerContract.View view) {
        this.view = view;
    }

    interface OnDataLoaded{
        void finishLoading(String [] str);
    }
}
