package project.POJO.RequestEntity;


import project.POJO.RequestEntity.SubRules.Humidity;
import project.POJO.RequestEntity.SubRules.RainIntensity;
import project.POJO.RequestEntity.SubRules.Temperature;
import project.POJO.RequestEntity.SubRules.WindSpeed;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class WeatherHolder {

    private Set<WeatherCondition> set= new HashSet<>();
    private Set<String> ruleNames = new HashSet<>();
    public int totalRules=0;
    private String totalOperator;
    private String lat;
    private String len;


    public WeatherHolder(){
        ruleNames.add((new Temperature()).name);
        ruleNames.add((new Humidity()).name);
        ruleNames.add((new WindSpeed()).name);
        ruleNames.add((new RainIntensity()).name);
    }

}
