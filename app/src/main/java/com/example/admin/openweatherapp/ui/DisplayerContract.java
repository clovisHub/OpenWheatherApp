package com.example.admin.openweatherapp.ui;

import com.example.admin.openweatherapp.data.models.Feedback;

/**
 * Created by Admin on 10/18/2017.
 */

public class DisplayerContract {

    interface Presenter{
        void setCityName(String cityName);
        Feedback getdata();

        void setView(View view);
    }

    interface View{
        void showData(String data);
    }

    interface DataRetriever{

        void loadData(String cityname, DisplayerPresenterImpl.OnDataLoaded onDataLoaded);
        Feedback getData();
    }
}
