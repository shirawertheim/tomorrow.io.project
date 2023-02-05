package com.example.demo.pojo.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Values {
    int humidity;
    int rainIntensity;
    long temperature;
    long windSpeed;
}
