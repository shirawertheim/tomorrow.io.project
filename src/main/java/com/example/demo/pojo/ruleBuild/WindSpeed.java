package com.example.demo.pojo.ruleBuild;

public class WindSpeed extends WeatherRule{

    public WindSpeed(){
        this.name = "windSpeed";
    }
    public WindSpeed(boolean exists, String operator, int value) {
        super("windSpeed", exists, operator, value);
    }
}

