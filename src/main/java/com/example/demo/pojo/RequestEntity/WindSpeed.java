package com.example.demo.pojo.RequestEntity;

public class WindSpeed extends WeatherRule{

    public WindSpeed(){
        this.name = "windSpeed";
    }
    public WindSpeed(boolean exists, String operator, int value) {
        super("windSpeed", exists, operator, value);
    }
}

