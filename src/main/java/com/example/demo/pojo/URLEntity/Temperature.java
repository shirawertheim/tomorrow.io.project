package com.example.demo.pojo.URLEntity;

public class Temperature extends WeatherRule{

    public Temperature(){
        this.name = "temperature";
    }
    public Temperature(boolean exists, String operator, int value) {
        super("temperature", exists, operator, value);
    }
}
