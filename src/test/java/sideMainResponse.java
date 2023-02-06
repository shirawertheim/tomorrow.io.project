import com.example.demo.POJO.FinalResponseEntity.data;
import com.example.demo.POJO.FinalResponseEntity.FinalResponseEntity;
import com.example.demo.POJO.FinalResponseEntity.FinalTimeLines;
import com.example.demo.POJO.RequestEntity.*;
import com.example.demo.POJO.RequestEntity.SubRules.RainIntensity;
import com.example.demo.POJO.RequestEntity.SubRules.Temperature;
import com.example.demo.POJO.RequestEntity.SubRules.WindSpeed;
import com.example.demo.POJO.ResponseAPIEntity.Intervals;
import com.example.demo.POJO.ResponseAPIEntity.ResponseHolder;
import com.example.demo.POJO.ResponseAPIEntity.Timelines;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class sideMainResponse {



    final static String JsonInput1 = "{\"data\":{\"timelines\":[{\"timestep\":\"1h\",\"endTime\":\"2023-02-09T23:00:00Z\",\"startTime\":\"2023-02-05T11:00:00Z\",\"intervals\":[{\"startTime\":\"2023-02-05T11:00:00Z\",\"values\":{\"humidity\":68,\"rainIntensity\":0,\"temperature\":-2.19,\"windSpeed\":3.19}},{\"startTime\":\"2023-02-05T12:00:00Z\",\"values\":{\"humidity\":66.99,\"rainIntensity\":0,\"temperature\":-2.13,\"windSpeed\":3.43}},{\"startTime\":\"2023-02-05T13:00:00Z\",\"values\":{\"humidity\":67.02,\"rainIntensity\":0,\"temperature\":-1.04,\"windSpeed\":3.78}},{\"startTime\":\"2023-02-05T14:00:00Z\",\"values\":{\"humidity\":57.74,\"rainIntensity\":0,\"temperature\":1.33,\"windSpeed\":5.11}},{\"startTime\":\"2023-02-05T15:00:00Z\",\"values\":{\"humidity\":47.38,\"rainIntensity\":0,\"temperature\":3.08,\"windSpeed\":5.34}},{\"startTime\":\"2023-02-05T16:00:00Z\",\"values\":{\"humidity\":41.79,\"rainIntensity\":0,\"temperature\":4.77,\"windSpeed\":5.33}},{\"startTime\":\"2023-02-05T17:00:00Z\",\"values\":{\"humidity\":37.99,\"rainIntensity\":0,\"temperature\":6.3,\"windSpeed\":5.2}},{\"startTime\":\"2023-02-05T18:00:00Z\",\"values\":{\"humidity\":32.18,\"rainIntensity\":0,\"temperature\":9.31,\"windSpeed\":5.59}},{\"startTime\":\"2023-02-05T19:00:00Z\",\"values\":{\"humidity\":30.53,\"rainIntensity\":0,\"temperature\":11.27,\"windSpeed\":5.2}},{\"startTime\":\"2023-02-05T20:00:00Z\",\"values\":{\"humidity\":43.99,\"rainIntensity\":0,\"temperature\":10.38,\"windSpeed\":3.97}},{\"startTime\":\"2023-02-05T21:00:00Z\",\"values\":{\"humidity\":49.75,\"rainIntensity\":0,\"temperature\":9.74,\"windSpeed\":3.48}},{\"startTime\":\"2023-02-05T22:00:00Z\",\"values\":{\"humidity\":44.85,\"rainIntensity\":0,\"temperature\":8.64,\"windSpeed\":2.58}},{\"startTime\":\"2023-02-05T23:00:00Z\",\"values\":{\"humidity\":59.02,\"rainIntensity\":0,\"temperature\":6.22,\"windSpeed\":2.67}},{\"startTime\":\"2023-02-06T00:00:00Z\",\"values\":{\"humidity\":53.6,\"rainIntensity\":0,\"temperature\":5.61,\"windSpeed\":3.14}},{\"startTime\":\"2023-02-06T01:00:00Z\",\"values\":{\"humidity\":53.61,\"rainIntensity\":0,\"temperature\":4.63,\"windSpeed\":3.19}},{\"startTime\":\"2023-02-06T02:00:00Z\",\"values\":{\"humidity\":58.48,\"rainIntensity\":0,\"temperature\":4.15,\"windSpeed\":2.68}},{\"startTime\":\"2023-02-06T03:00:00Z\",\"values\":{\"humidity\":61.29,\"rainIntensity\":0,\"temperature\":3.86,\"windSpeed\":2.77}},{\"startTime\":\"2023-02-06T04:00:00Z\",\"values\":{\"humidity\":75.03,\"rainIntensity\":0,\"temperature\":3.67,\"windSpeed\":2.67}},{\"startTime\":\"2023-02-06T05:00:00Z\",\"values\":{\"humidity\":88.1,\"rainIntensity\":0,\"temperature\":3.89,\"windSpeed\":2.68}},{\"startTime\":\"2023-02-06T06:00:00Z\",\"values\":{\"humidity\":81.48,\"rainIntensity\":0,\"temperature\":1.66,\"windSpeed\":2.34}},{\"startTime\":\"2023-02-06T07:00:00Z\",\"values\":{\"humidity\":85.08,\"rainIntensity\":0,\"temperature\":1.17,\"windSpeed\":2.27}},{\"startTime\":\"2023-02-06T08:00:00Z\",\"values\":{\"humidity\":86.46,\"rainIntensity\":0,\"temperature\":0.21,\"windSpeed\":2.47}},{\"startTime\":\"2023-02-06T09:00:00Z\",\"values\":{\"humidity\":85.36,\"rainIntensity\":0,\"temperature\":-0.09,\"windSpeed\":2.05}},{\"startTime\":\"2023-02-06T10:00:00Z\",\"values\":{\"humidity\":88.43,\"rainIntensity\":0,\"temperature\":-1.18,\"windSpeed\":2.21}},{\"startTime\":\"2023-02-06T11:00:00Z\",\"values\":{\"humidity\":86.27,\"rainIntensity\":0,\"temperature\":-1.24,\"windSpeed\":2.39}},{\"startTime\":\"2023-02-06T12:00:00Z\",\"values\":{\"humidity\":85.82,\"rainIntensity\":0,\"temperature\":-1.11,\"windSpeed\":3.05}},{\"startTime\":\"2023-02-06T13:00:00Z\",\"values\":{\"humidity\":76.69,\"rainIntensity\":0,\"temperature\":1.21,\"windSpeed\":3.67}},{\"startTime\":\"2023-02-06T14:00:00Z\",\"values\":{\"humidity\":73.4,\"rainIntensity\":0,\"temperature\":3.04,\"windSpeed\":4.01}},{\"startTime\":\"2023-02-06T15:00:00Z\",\"values\":{\"humidity\":70.96,\"rainIntensity\":0,\"temperature\":4.89,\"windSpeed\":4.14}},{\"startTime\":\"2023-02-06T16:00:00Z\",\"values\":{\"humidity\":61.08,\"rainIntensity\":0,\"temperature\":7.91,\"windSpeed\":5.14}},{\"startTime\":\"2023-02-06T17:00:00Z\",\"values\":{\"humidity\":55.83,\"rainIntensity\":0,\"temperature\":9.1,\"windSpeed\":6.59}},{\"startTime\":\"2023-02-06T18:00:00Z\",\"values\":{\"humidity\":51.71,\"rainIntensity\":0,\"temperature\":9.52,\"windSpeed\":7.24}},{\"startTime\":\"2023-02-06T19:00:00Z\",\"values\":{\"humidity\":49.52,\"rainIntensity\":0,\"temperature\":9.94,\"windSpeed\":7.04}},{\"startTime\":\"2023-02-06T20:00:00Z\",\"values\":{\"humidity\":48.57,\"rainIntensity\":0,\"temperature\":9.54,\"windSpeed\":7.64}},{\"startTime\":\"2023-02-06T21:00:00Z\",\"values\":{\"humidity\":52.8,\"rainIntensity\":0,\"temperature\":8.55,\"windSpeed\":6.47}},{\"startTime\":\"2023-02-06T22:00:00Z\",\"values\":{\"humidity\":58.57,\"rainIntensity\":0,\"temperature\":6.42,\"windSpeed\":6.23}},{\"startTime\":\"2023-02-06T23:00:00Z\",\"values\":{\"humidity\":64.55,\"rainIntensity\":0,\"temperature\":4.64,\"windSpeed\":5.82}},{\"startTime\":\"2023-02-07T00:00:00Z\",\"values\":{\"humidity\":69.34,\"rainIntensity\":0,\"temperature\":3.55,\"windSpeed\":5.27}},{\"startTime\":\"2023-02-07T01:00:00Z\",\"values\":{\"humidity\":74.53,\"rainIntensity\":0,\"temperature\":2.48,\"windSpeed\":5.17}},{\"startTime\":\"2023-02-07T02:00:00Z\",\"values\":{\"humidity\":76.02,\"rainIntensity\":0,\"temperature\":1.58,\"windSpeed\":4.99}},{\"startTime\":\"2023-02-07T03:00:00Z\",\"values\":{\"humidity\":77.46,\"rainIntensity\":0,\"temperature\":0.52,\"windSpeed\":4.79}},{\"startTime\":\"2023-02-07T04:00:00Z\",\"values\":{\"humidity\":76.75,\"rainIntensity\":0,\"temperature\":-0.46,\"windSpeed\":4.45}},{\"startTime\":\"2023-02-07T05:00:00Z\",\"values\":{\"humidity\":73.71,\"rainIntensity\":0,\"temperature\":-1.28,\"windSpeed\":4.2}},{\"startTime\":\"2023-02-07T06:00:00Z\",\"values\":{\"humidity\":70.87,\"rainIntensity\":0,\"temperature\":-1.97,\"windSpeed\":3.95}},{\"startTime\":\"2023-02-07T07:00:00Z\",\"values\":{\"humidity\":68.67,\"rainIntensity\":0,\"temperature\":-2.49,\"windSpeed\":4.03}},{\"startTime\":\"2023-02-07T08:00:00Z\",\"values\":{\"humidity\":69.11,\"rainIntensity\":0,\"temperature\":-2.95,\"windSpeed\":3.7}},{\"startTime\":\"2023-02-07T09:00:00Z\",\"values\":{\"humidity\":70.48,\"rainIntensity\":0,\"temperature\":-3.31,\"windSpeed\":3.38}},{\"startTime\":\"2023-02-07T10:00:00Z\",\"values\":{\"humidity\":72.22,\"rainIntensity\":0,\"temperature\":-3.5,\"windSpeed\":2.87}},{\"startTime\":\"2023-02-07T11:00:00Z\",\"values\":{\"humidity\":74.99,\"rainIntensity\":0,\"temperature\":-3.71,\"windSpeed\":2.44}},{\"startTime\":\"2023-02-07T12:00:00Z\",\"values\":{\"humidity\":79.5,\"rainIntensity\":0,\"temperature\":-4.02,\"windSpeed\":1.99}},{\"startTime\":\"2023-02-07T13:00:00Z\",\"values\":{\"humidity\":75.89,\"rainIntensity\":0,\"temperature\":-2.21,\"windSpeed\":1.79}},{\"startTime\":\"2023-02-07T14:00:00Z\",\"values\":{\"humidity\":72.76,\"rainIntensity\":0,\"temperature\":-0.41,\"windSpeed\":1.65}},{\"startTime\":\"2023-02-07T15:00:00Z\",\"values\":{\"humidity\":67.24,\"rainIntensity\":0,\"temperature\":1.32,\"windSpeed\":2.19}},{\"startTime\":\"2023-02-07T16:00:00Z\",\"values\":{\"humidity\":64.79,\"rainIntensity\":0,\"temperature\":2.6,\"windSpeed\":2.52}},{\"startTime\":\"2023-02-07T17:00:00Z\",\"values\":{\"humidity\":67.56,\"rainIntensity\":0,\"temperature\":3.3,\"windSpeed\":3.53}},{\"startTime\":\"2023-02-07T18:00:00Z\",\"values\":{\"humidity\":71.86,\"rainIntensity\":0,\"temperature\":3.51,\"windSpeed\":4.42}},{\"startTime\":\"2023-02-07T19:00:00Z\",\"values\":{\"humidity\":67.34,\"rainIntensity\":0,\"temperature\":4.34,\"windSpeed\":5.19}},{\"startTime\":\"2023-02-07T20:00:00Z\",\"values\":{\"humidity\":70.97,\"rainIntensity\":0,\"temperature\":4.46,\"windSpeed\":5.13}},{\"startTime\":\"2023-02-07T21:00:00Z\",\"values\":{\"humidity\":71.97,\"rainIntensity\":0,\"temperature\":4.72,\"windSpeed\":5.65}},{\"startTime\":\"2023-02-07T22:00:00Z\",\"values\":{\"humidity\":78.53,\"rainIntensity\":0,\"temperature\":4.16,\"windSpeed\":5.57}},{\"startTime\":\"2023-02-07T23:00:00Z\",\"values\":{\"humidity\":83.16,\"rainIntensity\":0,\"temperature\":4.15,\"windSpeed\":6.06}},{\"startTime\":\"2023-02-08T00:00:00Z\",\"values\":{\"humidity\":83.88,\"rainIntensity\":0,\"temperature\":4.35,\"windSpeed\":5.55}},{\"startTime\":\"2023-02-08T01:00:00Z\",\"values\":{\"humidity\":84.28,\"rainIntensity\":0,\"temperature\":4.19,\"windSpeed\":4.88}},{\"startTime\":\"2023-02-08T02:00:00Z\",\"values\":{\"humidity\":83.92,\"rainIntensity\":0,\"temperature\":4.07,\"windSpeed\":4.44}},{\"startTime\":\"2023-02-08T03:00:00Z\",\"values\":{\"humidity\":85.69,\"rainIntensity\":0,\"temperature\":3.55,\"windSpeed\":3.36}},{\"startTime\":\"2023-02-08T04:00:00Z\",\"values\":{\"humidity\":81.78,\"rainIntensity\":0,\"temperature\":4.4,\"windSpeed\":3.66}},{\"startTime\":\"2023-02-08T05:00:00Z\",\"values\":{\"humidity\":81.92,\"rainIntensity\":0,\"temperature\":4.59,\"windSpeed\":5.17}},{\"startTime\":\"2023-02-08T06:00:00Z\",\"values\":{\"humidity\":82.28,\"rainIntensity\":0,\"temperature\":4.57,\"windSpeed\":4.31}},{\"startTime\":\"2023-02-08T07:00:00Z\",\"values\":{\"humidity\":80.91,\"rainIntensity\":0.01,\"temperature\":4.58,\"windSpeed\":4.61}},{\"startTime\":\"2023-02-08T08:00:00Z\",\"values\":{\"humidity\":80.87,\"rainIntensity\":0,\"temperature\":4.68,\"windSpeed\":3.66}},{\"startTime\":\"2023-02-08T09:00:00Z\",\"values\":{\"humidity\":84.38,\"rainIntensity\":0,\"temperature\":4.06,\"windSpeed\":3.34}},{\"startTime\":\"2023-02-08T10:00:00Z\",\"values\":{\"humidity\":86.59,\"rainIntensity\":0,\"temperature\":3.84,\"windSpeed\":3.37}},{\"startTime\":\"2023-02-08T11:00:00Z\",\"values\":{\"humidity\":89.26,\"rainIntensity\":0,\"temperature\":3.39,\"windSpeed\":3.78}},{\"startTime\":\"2023-02-08T12:00:00Z\",\"values\":{\"humidity\":90.36,\"rainIntensity\":0,\"temperature\":3.27,\"windSpeed\":3.28}},{\"startTime\":\"2023-02-08T13:00:00Z\",\"values\":{\"humidity\":87.95,\"rainIntensity\":0,\"temperature\":4.39,\"windSpeed\":3.43}},{\"startTime\":\"2023-02-08T14:00:00Z\",\"values\":{\"humidity\":73.64,\"rainIntensity\":0,\"temperature\":6.39,\"windSpeed\":3.95}},{\"startTime\":\"2023-02-08T15:00:00Z\",\"values\":{\"humidity\":61.83,\"rainIntensity\":0,\"temperature\":7.38,\"windSpeed\":4.46}},{\"startTime\":\"2023-02-08T16:00:00Z\",\"values\":{\"humidity\":51.09,\"rainIntensity\":0,\"temperature\":8.45,\"windSpeed\":4.3}},{\"startTime\":\"2023-02-08T17:00:00Z\",\"values\":{\"humidity\":42.67,\"rainIntensity\":0,\"temperature\":9.45,\"windSpeed\":3.77}},{\"startTime\":\"2023-02-08T18:00:00Z\",\"values\":{\"humidity\":36.03,\"rainIntensity\":0,\"temperature\":10.46,\"windSpeed\":3.66}},{\"startTime\":\"2023-02-08T19:00:00Z\",\"values\":{\"humidity\":31.77,\"rainIntensity\":0,\"temperature\":11.24,\"windSpeed\":3.11}},{\"startTime\":\"2023-02-08T20:00:00Z\",\"values\":{\"humidity\":31.64,\"rainIntensity\":0,\"temperature\":11.61,\"windSpeed\":2.62}},{\"startTime\":\"2023-02-08T21:00:00Z\",\"values\":{\"humidity\":33.49,\"rainIntensity\":0,\"temperature\":11.54,\"windSpeed\":2.55}},{\"startTime\":\"2023-02-08T22:00:00Z\",\"values\":{\"humidity\":38.84,\"rainIntensity\":0,\"temperature\":10.46,\"windSpeed\":2.05}},{\"startTime\":\"2023-02-08T23:00:00Z\",\"values\":{\"humidity\":44.01,\"rainIntensity\":0,\"temperature\":9.63,\"windSpeed\":2.03}},{\"startTime\":\"2023-02-09T00:00:00Z\",\"values\":{\"humidity\":48.78,\"rainIntensity\":0,\"temperature\":9.09,\"windSpeed\":2.29}},{\"startTime\":\"2023-02-09T01:00:00Z\",\"values\":{\"humidity\":53.69,\"rainIntensity\":0,\"temperature\":6.4,\"windSpeed\":1.81}},{\"startTime\":\"2023-02-09T02:00:00Z\",\"values\":{\"humidity\":55.81,\"rainIntensity\":0,\"temperature\":6.04,\"windSpeed\":1.69}},{\"startTime\":\"2023-02-09T03:00:00Z\",\"values\":{\"humidity\":56.7,\"rainIntensity\":0,\"temperature\":5.77,\"windSpeed\":2.2}},{\"startTime\":\"2023-02-09T04:00:00Z\",\"values\":{\"humidity\":57.09,\"rainIntensity\":0,\"temperature\":5.26,\"windSpeed\":2.08}},{\"startTime\":\"2023-02-09T05:00:00Z\",\"values\":{\"humidity\":56.97,\"rainIntensity\":0,\"temperature\":4.75,\"windSpeed\":2.29}},{\"startTime\":\"2023-02-09T06:00:00Z\",\"values\":{\"humidity\":58.86,\"rainIntensity\":0,\"temperature\":4.28,\"windSpeed\":1.5}},{\"startTime\":\"2023-02-09T07:00:00Z\",\"values\":{\"humidity\":59.51,\"rainIntensity\":0,\"temperature\":4.21,\"windSpeed\":1.83}},{\"startTime\":\"2023-02-09T08:00:00Z\",\"values\":{\"humidity\":58.92,\"rainIntensity\":0,\"temperature\":4.41,\"windSpeed\":1.63}},{\"startTime\":\"2023-02-09T09:00:00Z\",\"values\":{\"humidity\":58.4,\"rainIntensity\":0,\"temperature\":4.6,\"windSpeed\":2.08}},{\"startTime\":\"2023-02-09T10:00:00Z\",\"values\":{\"humidity\":61.15,\"rainIntensity\":0,\"temperature\":4.95,\"windSpeed\":2.2}},{\"startTime\":\"2023-02-09T11:00:00Z\",\"values\":{\"humidity\":68.19,\"rainIntensity\":0,\"temperature\":5.3,\"windSpeed\":2.89}},{\"startTime\":\"2023-02-09T12:00:00Z\",\"values\":{\"humidity\":71.45,\"rainIntensity\":0,\"temperature\":6.25,\"windSpeed\":4.33}},{\"startTime\":\"2023-02-09T13:00:00Z\",\"values\":{\"humidity\":77.04,\"rainIntensity\":0,\"temperature\":7.4,\"windSpeed\":5.32}},{\"startTime\":\"2023-02-09T14:00:00Z\",\"values\":{\"humidity\":91.92,\"rainIntensity\":0.56,\"temperature\":7.71,\"windSpeed\":6.1}},{\"startTime\":\"2023-02-09T15:00:00Z\",\"values\":{\"humidity\":95.4,\"rainIntensity\":0.74,\"temperature\":8.39,\"windSpeed\":6.83}},{\"startTime\":\"2023-02-09T16:00:00Z\",\"values\":{\"humidity\":96.41,\"rainIntensity\":0.69,\"temperature\":8.59,\"windSpeed\":7.53}},{\"startTime\":\"2023-02-09T17:00:00Z\",\"values\":{\"humidity\":97.43,\"rainIntensity\":0.79,\"temperature\":8.46,\"windSpeed\":7.12}},{\"startTime\":\"2023-02-09T18:00:00Z\",\"values\":{\"humidity\":97.06,\"rainIntensity\":0.7,\"temperature\":8.52,\"windSpeed\":7.33}},{\"startTime\":\"2023-02-09T19:00:00Z\",\"values\":{\"humidity\":88.34,\"rainIntensity\":0.03,\"temperature\":12.11,\"windSpeed\":7.19}},{\"startTime\":\"2023-02-09T20:00:00Z\",\"values\":{\"humidity\":89.95,\"rainIntensity\":0.17,\"temperature\":10.66,\"windSpeed\":6.27}},{\"startTime\":\"2023-02-09T21:00:00Z\",\"values\":{\"humidity\":87.59,\"rainIntensity\":0.02,\"temperature\":13.25,\"windSpeed\":6.11}},{\"startTime\":\"2023-02-09T22:00:00Z\",\"values\":{\"humidity\":91.43,\"rainIntensity\":0.11,\"temperature\":11.31,\"windSpeed\":4.98}},{\"startTime\":\"2023-02-09T23:00:00Z\",\"values\":{\"humidity\":90.55,\"rainIntensity\":0.09,\"temperature\":12.02,\"windSpeed\":4.29}}]}]}}";
    final static String JsonInput2 = "{\"data\":{\"timelines\":[{\"timestep\":\"1h\",\"endTime\":\"2023-02-09T23:00:00Z\",\"startTime\":\"2023-02-05T11:00:00Z\",\"intervals\":[{\"startTime\":\"2023-02-05T11:00:00Z\",\"values\":{\"humidity\":68,\"rainIntensity\":0,\"temperature\":-2.19,\"windSpeed\":30.19}},{\"startTime\":\"2023-02-05T12:00:00Z\",\"values\":{\"humidity\":66.99,\"rainIntensity\":0,\"temperature\":-2.13,\"windSpeed\":3.43}}]}]}}";



    public static void main(String[] args) {

        WeatherHolder weatherHolder = initializeWeatherHolder();
        ResponseHolder responseHolder = createPOJO();
        updateDates(responseHolder);
        FinalResponseEntity finalResponseEntity = createResponse(responseHolder, weatherHolder);
        System.out.println(finalResponseEntity);

        convertObjectToJSON(finalResponseEntity);


    }

    /**
     * convert the FinalResponseEntity to JSON
     * @param finalResponseEntity
     */
    private static void convertObjectToJSON(FinalResponseEntity finalResponseEntity) {
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        try {
            String jsonString = mapper.writeValueAsString(finalResponseEntity);
            System.out.println(jsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    private static FinalResponseEntity createResponse(ResponseHolder responseHolder, WeatherHolder weatherHolder) {
        FinalResponseEntity finalResponseEntity = new FinalResponseEntity();
        List<FinalTimeLines> list = new ArrayList<>();
        for (Timelines timelines :
                responseHolder.getData().getTimelines()) {

            String firstStartTime = null;
            String currStartTime;
            String currEndTime;
            boolean currRule;
            boolean prevRule = false;
            boolean firstInterval = true;

            String finalStartTime = null, finalEndTime = null;
            boolean finalRule = false;
            for(Intervals interval : timelines.getIntervals()){

                currStartTime = interval.getStartTime();
                currEndTime = interval.getEndTime();

                if (firstInterval){ //first time initialized
                    firstStartTime = currStartTime;
                    prevRule = legalRuleFunc(weatherHolder, interval);
                    firstInterval = false;
                    continue;
                }

                currRule = legalRuleFunc(weatherHolder, interval);

                if (prevRule!=currRule){
                    FinalTimeLines finalTimeline = new FinalTimeLines(firstStartTime, currEndTime, currRule);
                    list.add(finalTimeline);
                    firstStartTime = currStartTime;
                }

                prevRule = currRule;

                finalStartTime = firstStartTime;
                finalEndTime = currEndTime;
                finalRule = currRule;
            }
            FinalTimeLines finalTimeline = new FinalTimeLines(finalStartTime, finalEndTime, finalRule);
            list.add(finalTimeline);
            data data = new data(list);

            finalResponseEntity.setData(data);
        }

        return finalResponseEntity;

    }




    private static boolean legalRuleFunc(WeatherHolder weatherHolder, Intervals interval) {
        String totalOperator = weatherHolder.getTotalOperator();
        if (totalOperator.equals("OR")){
            return checkORLLegality(weatherHolder, interval);
        }
        else{
            return checkANDELegality(weatherHolder, interval);
        }
    }

    private static boolean checkANDELegality(WeatherHolder weatherHolder, Intervals interval) {
        for (WeatherCondition weatherCondition : weatherHolder.getSet()){
            String weatherRuleName = weatherCondition.getName();
            long value = interval.getValues().getValuesMap().get(weatherRuleName);
            if (!weatherCondition.isLegal(value))
                return false;
        }
        return true;
    }

    private static boolean checkORLLegality(WeatherHolder weatherHolder, Intervals interval) {
        for (WeatherCondition weatherCondition : weatherHolder.getSet()){
            String weatherRuleName = weatherCondition.getName();
            long value = interval.getValues().getValuesMap().get(weatherRuleName);
            if (weatherCondition.isLegal(value))
                return true;
        }
        return false;
    }

    private static void updateDates(ResponseHolder responseHolder) {
        for (Timelines timelines :
                responseHolder.getData().getTimelines()) {
                timelines.updateDate();
            for(Intervals interval : timelines.getIntervals()){
                interval.updateDate();
                interval.getValues().updateValuesMap();
            }
        }

    }

    private static WeatherHolder initializeWeatherHolder() {
        WeatherHolder weatherHolder = new WeatherHolder();
        weatherHolder.setLat("40.7");
        weatherHolder.setLen("-73.9");
        Temperature temperature = new Temperature(true, ">", 30);
        WindSpeed windSpeed = new WindSpeed(true, "<", 3);
        RainIntensity rainIntensity = new RainIntensity(true, ">", 4);
        Set<WeatherCondition> weatherConditionSet = new HashSet<>();
        weatherConditionSet.add(temperature);
        weatherConditionSet.add(windSpeed);
        weatherConditionSet.add(rainIntensity);
        weatherHolder.setSet(weatherConditionSet);
        weatherHolder.setTotalOperator("OR");
        return weatherHolder;
    }

    public static ResponseHolder createPOJO()  {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ResponseHolder res = objectMapper.readValue(JsonInput1, ResponseHolder.class);
            System.out.println(res);
            return res;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }















}
