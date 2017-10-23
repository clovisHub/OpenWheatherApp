package com.example.admin.openweatherapp.applevel;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 10/22/2017.
 */
@Module
public class AppModule {

   Context context;
   public AppModule(Context contex){
       context  = contex;
   }

   @Provides
   @Singleton
    public Context getContext(){
       return context;
   }
}


