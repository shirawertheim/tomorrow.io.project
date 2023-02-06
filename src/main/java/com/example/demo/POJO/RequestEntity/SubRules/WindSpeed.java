package com.example.demo.POJO.RequestEntity.SubRules;

import com.example.demo.POJO.RequestEntity.WeatherCondition;

public class WindSpeed extends WeatherCondition {

    public WindSpeed(){
        this.name = "windSpeed";
    }
    public WindSpeed(boolean exists, String operator, int value) {
        super("windSpeed", exists, operator, value);
    }
}

