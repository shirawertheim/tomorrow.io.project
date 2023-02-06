package project.Services;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import project.POJO.LoggerHelper;
import project.POJO.ExceptionEntity.Types.BadRequestException;
import project.POJO.RequestEntity.RequestEntity;
import project.POJO.RequestEntity.URLRequest;
import project.POJO.RequestEntity.WeatherHolder;
import project.POJO.RequestEntity.WeatherCondition;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import project.propertyPackage.DataSourceConfig;

import java.util.Map;


@Service
@Configuration
@PropertySource("application.properties")
public class RequestService implements InitializingBean {


    @Autowired
    Environment env;

    @Override
    public void afterPropertiesSet() throws Exception {
        setDatabaseConfig();
    }

    private static URLRequest urlRequest;

    private void setDatabaseConfig() {
        urlRequest = new URLRequest();
        urlRequest.setPrefix(env.getProperty("url.prefix"));
        urlRequest.setTomorrowURL(env.getProperty("url.tomorrowURL"));
        urlRequest.setApiKey(env.getProperty("url.apiKey"));
        urlRequest.setFields(env.getProperty("url.fields"));
        urlRequest.setTimesteps(env.getProperty("url.timesteps"));
        urlRequest.setUnits(env.getProperty("url.units"));
        System.out.println(urlRequest.toString());
    }


    /**
     * GETURL:
        GET/weather-conditions?location=40.7,-73.9&rule=temperature>30,wind<10,visibility>4&operator=OR

     * requestURL:
     * 'https://api.tomorrow.io/v4/timelines?location=40.75872069597532,-73.98529171943665&fields=temperature&timesteps=1h&units=metric&apikey=fvFU2JQBMP1QX7MeW44ghUQnNiy97uX6
    */

    final static WeatherHolder weatherHolder = new WeatherHolder();
    private Logger logger = LoggerHelper.logger;

//    @Value("${application.properties.apiKey}")
//    private String apiKey;



    /**
     * main service, build weather-holder object that saves all the relevant data in order to build a legal URL
     * @param queryParams
     * @return
     */
    @GetMapping
    public RequestEntity initialize(Map<String, String> queryParams) {

        logger.info("*** RequestService ***");
        try {
            afterPropertiesSet();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String location = queryParams.get("location");
        String rule = queryParams.get("rule");
        String operator = queryParams.get("operator");

        logger.info("location: ", location);
        logger.info("rule: " + rule);
        logger.info("operator: " + operator);


        handleFirstPartLocations(location);
        handleSecondPart(rule);
        handleThirdPart(operator);

        String url = urlRequest.buildURL(weatherHolder);
        RequestEntity requestEntity = new RequestEntity(url, weatherHolder);
        logger.info("URL: " + url);
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
