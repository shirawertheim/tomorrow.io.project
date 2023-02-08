package project.POJO.RequestEntity.SubRules;

import project.POJO.RequestEntity.WeatherCondition;

public class WindSpeed extends WeatherCondition {

    public WindSpeed(){
        this.name = "windSpeed";
    }
    public WindSpeed(boolean exists, String operator, int value) {
        super("windSpeed", exists, operator, value);
    }
}

