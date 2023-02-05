package com.example.demo.weather;


import com.example.demo.pojo.URLEntity.URLRequest;
import com.example.demo.pojo.URLEntity.WeatherHolder;
import com.example.demo.pojo.URLEntity.WeatherRule;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;



@Service
public class DratRequestService {

    /**
     * GETURL:
    GET/weather-conditions?location=40.7,-73.9&rule=temperature>30,wind<10,visibility>4&operator=OR
     * requestURL:
     * 'https://api.tomorrow.io/v4/timelines?location=40.75872069597532,-73.98529171943665&fields=temperature&timesteps=1h&units=metric&apikey=fvFU2JQBMP1QX7MeW44ghUQnNiy97uX6
    */

    final String prefix = "GET/weather-conditions?location=";
    static final String tomorrowURL = "https://api.tomorrow.io/v4/timelines?";
    final String apiKey = "apikey=fvFU2JQBMP1QX7MeW44ghUQnNiy97uX6";
    final static WeatherHolder weatherHolder = new WeatherHolder();

    String GETURL = "GET/weather-conditions?location=40.7,-73.9&rule=temperature>30,wind<10,visibility>4&operator=OR";
    URLRequest urlRequest = new URLRequest();



    @GetMapping
    public String initialize() {
        System.out.println("URLBuilder");
        extractVariables(GETURL);
        String url = urlRequest.buildURL(weatherHolder);
        System.out.println(url);
        return url;

    }



    static void extractVariables(String GETURL){

        String urlWithoutPrefix = GETURL.replaceFirst(URLRequest.prefix, "");
        String[] splitGETURL = urlWithoutPrefix.split("&", 3);

        handleFirstPartLocations(splitGETURL[0]);
        handleSecondPart(splitGETURL[1]);
        handleThirdPart(splitGETURL[2]);

        System.out.println("hiiiii");

    }

    private static void handleFirstPartLocations(String s) {
        String[] location = getLocation(s);
        String lat = location[0];
        String lon = location[1];

        weatherHolder.setLat(lat);
        weatherHolder.setLen(lon);

    }


    static String[] getLocation(String splitGETURL) {
        return splitGETURL.split(",");
    }

    private static String handleSecondPart(String s) {

        if (!s.startsWith("rule=")){
            System.out.println("***400!!!!***");
            return null;
        }

        s = s.replaceFirst("rule=", "");
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

    private static void handleThirdPart(String s) {
        String[] split = s.split("=");
        String totalOperator = split[1];
        if (!(totalOperator.equals("OR") || totalOperator.equals("AND"))){
            System.out.println("****400!!!!*****");
        }
        weatherHolder.setTotalOperator(totalOperator);
    }


}
