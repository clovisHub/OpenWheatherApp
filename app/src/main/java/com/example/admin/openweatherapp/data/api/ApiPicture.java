package com.example.admin.openweatherapp.data.api;

public final class ApiPicture {
    String url = "http://openweathermap.org/img/w/";

    public ApiPicture(){
    }

    public String getPictures(String icon) {
        return url+icon+".png";
    }

}
