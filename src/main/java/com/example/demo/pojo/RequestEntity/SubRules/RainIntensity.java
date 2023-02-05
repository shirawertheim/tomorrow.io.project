package com.example.demo.pojo.RequestEntity.SubRules;

import com.example.demo.pojo.RequestEntity.WeatherRule;

public class RainIntensity extends WeatherRule {

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
