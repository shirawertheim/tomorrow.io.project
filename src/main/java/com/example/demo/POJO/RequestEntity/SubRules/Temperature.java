package com.example.demo.POJO.RequestEntity.SubRules;

import com.example.demo.POJO.RequestEntity.WeatherCondition;

public class Temperature extends WeatherCondition {

    public Temperature(){
        this.name = "temperature";
    }
    public Temperature(boolean exists, String operator, int value) {
        super("temperature", exists, operator, value);
    }

}
