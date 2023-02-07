package project.Services;

import org.slf4j.Logger;
import project.POJO.FinalResponseEntity.FinalResponseEntity;
import project.POJO.FinalResponseEntity.FinalTimeLines;
import project.POJO.FinalResponseEntity.data;
import project.POJO.LoggerHelper;
import project.POJO.ResponseAPIEntity.Intervals;
import project.POJO.ResponseAPIEntity.ResponseHolder;
import project.POJO.ResponseAPIEntity.Timelines;
import project.POJO.RequestEntity.WeatherHolder;
import project.POJO.RequestEntity.WeatherCondition;

import java.util.ArrayList;
import java.util.List;

public class ResponseBuilderService {

    private Logger logger = LoggerHelper.logger;

    /**
     * main function holds the logic
     * @param responseHolder
     * @param weatherHolder
     * @return
     */
    public FinalResponseEntity createResponse(ResponseHolder responseHolder, WeatherHolder weatherHolder) {
        logger.info("*** ResponseBuilderService ***");
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
