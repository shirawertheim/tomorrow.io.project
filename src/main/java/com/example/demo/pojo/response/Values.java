package com.example.demo.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Values {
    int humidity;
    int rainIntensity;
    long temperature;
    long windSpeed;
}
