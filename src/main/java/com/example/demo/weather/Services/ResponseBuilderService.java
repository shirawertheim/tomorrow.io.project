package com.example.demo.weather.Services;

import com.example.demo.pojo.FinalResponseEntity.FinalResponseEntity;
import com.example.demo.pojo.FinalResponseEntity.FinalTimeLines;
import com.example.demo.pojo.FinalResponseEntity.data;
import com.example.demo.pojo.RequestEntity.WeatherHolder;
import com.example.demo.pojo.RequestEntity.WeatherRule;
import com.example.demo.pojo.ResponseAPIEntity.Intervals;
import com.example.demo.pojo.ResponseAPIEntity.ResponseHolder;
import com.example.demo.pojo.ResponseAPIEntity.Timelines;

import java.util.ArrayList;
import java.util.List;

public class ResponseBuilderService {


    /**
     * main function holds the logic
     * @param responseHolder
     * @param weatherHolder
     * @return
     */
    protected static FinalResponseEntity createResponse(ResponseHolder responseHolder, WeatherHolder weatherHolder) {
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
        for (WeatherRule weatherRule : weatherHolder.getSet()){
            String weatherRuleName = weatherRule.getName();
            long value = interval.getValues().getValuesMap().get(weatherRuleName);
            if (!weatherRule.isLegal(value))
                return false;
        }
        return true;
    }

    private static boolean checkORLLegality(WeatherHolder weatherHolder, Intervals interval) {
        for (WeatherRule weatherRule : weatherHolder.getSet()){
            String weatherRuleName = weatherRule.getName();
            long value = interval.getValues().getValuesMap().get(weatherRuleName);
            if (weatherRule.isLegal(value))
                return true;
        }
        return false;
    }


    protected static void updateDates(ResponseHolder responseHolder) {
        for (Timelines timelines :
                responseHolder.getData().getTimelines()) {
            timelines.updateDate();
            for(Intervals interval : timelines.getIntervals()){
                interval.updateDate();
                interval.getValues().updateValuesMap();
            }
        }

    }

}
