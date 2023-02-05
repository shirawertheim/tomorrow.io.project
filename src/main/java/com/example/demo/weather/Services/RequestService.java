package com.example.demo.weather.Services;


import com.example.demo.pojo.RequestEntity.RequestEntity;
import com.example.demo.pojo.RequestEntity.URLRequest;
import com.example.demo.pojo.RequestEntity.WeatherHolder;
import com.example.demo.pojo.RequestEntity.WeatherRule;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;


@Service
public class RequestService {




    /**
     * GETURL:
        GET/weather-conditions?location=40.7,-73.9&rule=temperature>30,wind<10,visibility>4&operator=OR

     * requestURL:
     * 'https://api.tomorrow.io/v4/timelines?location=40.75872069597532,-73.98529171943665&fields=temperature&timesteps=1h&units=metric&apikey=fvFU2JQBMP1QX7MeW44ghUQnNiy97uX6
    */

    final static WeatherHolder weatherHolder = new WeatherHolder();
    URLRequest urlRequest = new URLRequest();


    /**
     * main service, build weather-holder object that saves all the relevant data in order to build a legal URL
     * @param queryParams
     * @return
     */
    @GetMapping
    public RequestEntity initialize(Map<String, String> queryParams) {

        System.out.println("***RequestService started***");

        String location = queryParams.get("location");
        String rule = queryParams.get("rule");
        String operator = queryParams.get("operator");
        System.out.println("location: " + location);
        System.out.println("rule: " + rule);
        System.out.println("operator: " + operator);


        handleFirstPartLocations(location);
        handleSecondPart(rule);
        handleThirdPart(operator);

        String url = urlRequest.buildURL(weatherHolder);
        RequestEntity requestEntity = new RequestEntity(url, weatherHolder);
        System.out.println("URL: " + url);
        return requestEntity;
    }


    /**
     * initialize location part, throw exception if not legal
     * @param s
     */
    private static void handleFirstPartLocations(String s) {
        String[] location = s.split(",");
        String lat = location[0];
        String lon = location[1];

        weatherHolder.setLat(lat);
        weatherHolder.setLen(lon);

    }



    /**
     * initialize rules part, throw exception if not legal
     * @param s
     */
    private static String handleSecondPart(String s) {

        String[] rules = s.split(",");

        for (String rule : rules){
            String ruleOperator = operatorInitializer(rule);
            String[] currRule = rule.split(ruleOperator);
            int value =  Integer.valueOf(currRule[1]);
            String ruleName = currRule[0];
            int counter = 0;
            boolean exists = weatherHolder.getRuleNames().contains(ruleName);
            if (exists){
                WeatherRule weatherRule = new WeatherRule(ruleName, true, ruleOperator, value);
                weatherHolder.getSet().add(weatherRule); //todo check if added
            }
            weatherHolder.setTotalRules(counter);
        }
        return null;
    }

    /**
     * helper function, check operator eqaals ">" or "<"
     * @param rule
     * @return
     */
    private static String operatorInitializer(String rule) {
        String ruleOperator = null;
        if (rule.contains(">")){
            ruleOperator = ">";
        }
        else if (rule.contains("<")){
            ruleOperator = "<";
        }
        else{
            System.out.println("***400!!!***");
        }
        return ruleOperator;
    }

    /**
     * initialize OPERATOR part, throw exception if not legal
     * @param s
     */
    private static void handleThirdPart(String s) {
        if (s.equals("OR") || s.equals("AND")){
            weatherHolder.setTotalOperator(s);
        }
        else{
            System.out.println("****400!!!!*****");
        }
    }


}
