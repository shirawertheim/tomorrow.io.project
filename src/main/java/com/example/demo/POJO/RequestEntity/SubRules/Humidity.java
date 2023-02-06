package com.example.demo.POJO.RequestEntity.SubRules;

import com.example.demo.POJO.RequestEntity.WeatherCondition;
import lombok.Data;

@Data
public class Humidity extends WeatherCondition {

    public Humidity(){
        this.name = "humidity";
    }

    public Humidity(boolean exists, String operator, int value) {
        super("humidity", exists, operator, value);
    }

//    public Humidity(String operator, boolean exists, int value)
//    {
//        super(exists, operator, value);
//        name = ruleName;
//    }

}