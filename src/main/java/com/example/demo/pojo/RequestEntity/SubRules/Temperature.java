package com.example.demo.pojo.RequestEntity.SubRules;

import com.example.demo.pojo.RequestEntity.WeatherRule;
import lombok.AllArgsConstructor;

public class Temperature extends WeatherRule {

    public Temperature(){
        this.name = "temperature";
    }
    public Temperature(boolean exists, String operator, int value) {
        super("temperature", exists, operator, value);
    }

}
