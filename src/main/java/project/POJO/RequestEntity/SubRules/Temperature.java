package project.POJO.RequestEntity.SubRules;

import project.POJO.RequestEntity.WeatherCondition;

public class Temperature extends WeatherCondition {

    public Temperature(){
        this.name = "temperature";
    }

    public Temperature(boolean exists, String operator, int value) {
        super("temperature", exists, operator, value);
    }

}
