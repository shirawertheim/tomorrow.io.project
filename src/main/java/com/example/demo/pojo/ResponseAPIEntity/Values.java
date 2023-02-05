package com.example.demo.pojo.ResponseAPIEntity;

import com.example.demo.pojo.RequestEntity.SubRules.Humidity;
import com.example.demo.pojo.RequestEntity.SubRules.RainIntensity;
import com.example.demo.pojo.RequestEntity.SubRules.Temperature;
import com.example.demo.pojo.RequestEntity.SubRules.WindSpeed;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class Values {
    long humidity;
    long rainIntensity;
    long temperature;
    long windSpeed;

    Map<String, Long> valuesMap = new HashMap<>();

    public void updateValuesMap(){
        valuesMap.put("humidity", humidity);
        valuesMap.put("rainIntensity", rainIntensity);
        valuesMap.put("temperature", temperature);
        valuesMap.put("windSpeed", windSpeed);
    }
}
