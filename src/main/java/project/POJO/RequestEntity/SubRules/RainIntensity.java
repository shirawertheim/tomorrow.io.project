package project.POJO.RequestEntity.SubRules;

import project.POJO.RequestEntity.WeatherCondition;

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
