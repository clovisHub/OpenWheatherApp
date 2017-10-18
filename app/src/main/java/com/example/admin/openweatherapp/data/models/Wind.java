
package com.example.admin.openweatherapp.data.models;

import com.squareup.moshi.Json;

public class Wind {

    @Json(name = "speed")
    private Double speed;
    @Json(name = "deg")
    private Integer deg;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

}
