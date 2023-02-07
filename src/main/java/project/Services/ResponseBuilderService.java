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
        int counter72hours = 72; //todo
        for (Timelines timelines :
                responseHolder.getData().getTimelines()) {

            String firstStartTime = null;
            String currStartTime;
            String currEndTime;
            String prevEndTime = null;
            boolean currRule;
            boolean prevRule = false;
            boolean firstInterval = true;

            for (int i = 0; i < counter72hours; i++) {
                logger.info("" + i);
                Intervals interval = timelines.getIntervals().get(i);
                currStartTime = interval.getStartTime();
                currEndTime = interval.getEndTime();

                logger.info("currStartTime" + currStartTime);

                if (firstInterval){ //first time initialized
                    firstStartTime = currStartTime;
                    prevRule = legalRuleFunc(weatherHolder, interval);
                    firstInterval = false;
                    prevEndTime = currEndTime;
                    continue;
                }

                currRule = legalRuleFunc(weatherHolder, interval);

                if (counter72hours == counter72hours-1){ //final interval
                    if (prevRule==currRule){
                        FinalTimeLines finalTimeline = new FinalTimeLines(firstStartTime, currEndTime, prevRule);
                        list.add(finalTimeline);
                    }
                    else{
                        //prev finalTimeLine
                        FinalTimeLines finalTimeline = new FinalTimeLines(firstStartTime, prevEndTime, prevRule);
                        list.add(finalTimeline);

                        //curr finalTimeLine
                        FinalTimeLines finalTimeline1 = new FinalTimeLines(currStartTime, currEndTime, currRule);
                        list.add(finalTimeline1);
                    }
                }
                else { //not final interval
                    if (prevRule != currRule) {
                        FinalTimeLines finalTimeline = new FinalTimeLines(firstStartTime, prevEndTime, prevRule);
                        list.add(finalTimeline);
                        firstStartTime = currStartTime;
                    }
                }

                prevRule = currRule;
                prevEndTime = currEndTime;


            }

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
