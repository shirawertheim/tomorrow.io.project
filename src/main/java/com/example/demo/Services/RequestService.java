package com.example.demo.Services;


import com.example.demo.POJO.ExceptionEntity.Types.BadRequestException;
import com.example.demo.POJO.RequestEntity.RequestEntity;
import com.example.demo.POJO.RequestEntity.URLRequest;
import com.example.demo.POJO.RequestEntity.WeatherHolder;
import com.example.demo.POJO.RequestEntity.WeatherCondition;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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
        if (requestEntity.getWeatherHolder().getSet().size() >= 3)
        System.out.println("URL: " + url);
        return requestEntity;
    }


    /**
     * initialize location part, throw exception if not legal
     * @param s
     */
    private static void handleFirstPartLocations(String s) {
        try {
            String[] location = s.split(",");
            String lat = location[0];
            String lon = location[1];

            weatherHolder.setLat(lat);
            weatherHolder.setLen(lon);
        }
        catch (Exception e){
            throw new BadRequestException("Invalid operator provided, please use lat,lon structure");
        }


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
                WeatherCondition weatherCondition = new WeatherCondition(ruleName, true, ruleOperator, value);
                weatherHolder.getSet().add(weatherCondition); //todo check if added
            }
            weatherHolder.setTotalRules(counter);
        }
        return null;
    }

    /**
     * helper function, check operator equals ">" or "<"
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
            throw new BadRequestException("Invalid operator provided, please use '>' or '<'");
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
            throw new BadRequestException("Invalid operator provided, please use 'AND' or 'OR'");
        }
    }


}
