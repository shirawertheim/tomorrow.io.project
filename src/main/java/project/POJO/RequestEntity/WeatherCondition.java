package project.POJO.RequestEntity;

import lombok.Data;

@Data
public class WeatherCondition {
    protected String name;
    protected boolean exists;
    protected String operator;;
    protected long value;


    public WeatherCondition() {
        this.name = "none";
        this.exists = false;
        this.operator = "not initialized";
        this.value = -1;
    }

    public WeatherCondition(String name, boolean exists, String operator, int value) {
        this.name = name;
        this.exists = exists;
        this.operator = operator;
        this.value = value;
    }

    public boolean isLegal(long input){
        if (this.operator.equals(">")){
            return input>value;
        }
        else if (this.operator.equals("<")){
            return input<value;
        }
        return false;
    }
}
