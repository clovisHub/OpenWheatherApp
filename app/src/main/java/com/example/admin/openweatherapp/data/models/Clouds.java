
package com.example.admin.openweatherapp.data.models;

import com.squareup.moshi.Json;

public class Clouds {

    @Json(name = "all")
    private Integer all;

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

}
