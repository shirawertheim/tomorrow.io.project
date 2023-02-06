package com.example.demo.POJO.RequestEntity.SubRules;

import com.example.demo.POJO.RequestEntity.WeatherCondition;

public class RainIntensity extends WeatherCondition {

    public RainIntensity(){
        this.name = "rainIntensity";
    }
    public RainIntensity(boolean exists, String operator, int value) {
        super("rainIntensity", exists, operator, value);
    }

//    public RainIntensity(String operator, boolean exists, int value)
//    {
//        super(exists, operator, value);
//        name = ruleName;
//    }

}
