package com.example.admin.openweatherapp.ui;

import com.example.admin.openweatherapp.data.models.Feedback;

/**
 * Created by Admin on 10/18/2017.
 */

public class DisplayerPresenterImpl implements DisplayerContract.Presenter{

    DisplayerContract.DataRetriever data;

    public DisplayerPresenterImpl presenter = null;

    public DisplayerPresenterImpl(){
        data = DisplayerData.getDisplayer();
    }

    @Override
    public void setCityName(String cityName) {
        data.loadData(cityName);
    }

    @Override
    public Feedback getdata() {
       return data.getData();
    }
}
