package project.POJO.RequestEntity.SubRules;

import project.POJO.RequestEntity.WeatherCondition;
import lombok.Data;

@Data
public class Humidity extends WeatherCondition {

    public Humidity(){
        this.name = "humidity";
    }

    public Humidity(boolean exists, String operator, int value) {
        super("humidity", exists, operator, value);
    }


}
