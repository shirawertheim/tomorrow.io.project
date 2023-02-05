package com.example.demo.pojo.RequestEntity;

public class WeatherRule {
    String name;
    boolean exists;
    String operator;;
    int value;


    public WeatherRule() {
        this.name = "none";
        this.exists = false;
        this.operator = "not initialized";
        this.value = -1;
    }

    public WeatherRule(String name, boolean exists, String operator, int value) {
        this.name = name;
        this.exists = exists;
        this.operator = operator;
        this.value = value;
    }

    public boolean isLegal(int input){
        if (this.operator.equals(">")){
            return value>input;
        }
        else if (this.operator.equals("<")){
            return value<input;
        }
        return false;
    }
}
