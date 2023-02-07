package project.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import project.POJO.ExceptionEntity.Types.BadRequestException;
import project.POJO.FinalResponseEntity.NumberOfHours;
import project.POJO.FinalResponseEntity.FinalResponseEntity;
import project.POJO.FinalResponseEntity.FinalTimeLines;
import project.POJO.FinalResponseEntity.data;
import project.POJO.LoggerHelper;
import project.POJO.RequestEntity.RequestEntity;
import project.POJO.RequestEntity.WeatherCondition;
import project.POJO.RequestEntity.WeatherHolder;
import project.POJO.ResponseAPIEntity.Intervals;
import project.POJO.ResponseAPIEntity.ResponseAPIHolder;
import project.POJO.ResponseAPIEntity.ResponseHolder;
import project.POJO.ResponseAPIEntity.Timelines;

import java.util.ArrayList;
import java.util.List;
@Service
@Configuration
@PropertySource("application.properties")
public class ResponseBuilderService implements InitializingBean {

    @Autowired
    Environment env1;

    @Override
    public void afterPropertiesSet() {
        setDatabaseConfig();
    }

    private Logger logger = LoggerHelper.logger;

    private NumberOfHours numberOfHoursObj;



    /**
     * initialize URLRequest object from application.properties file
     */
    private void setDatabaseConfig() {
        numberOfHoursObj = new NumberOfHours();
        numberOfHoursObj.setNumberOfHours(Integer.parseInt(env1.getProperty("response.numberOfHours")));
    }

    public String initialize(ResponseAPIHolder responseAPIHolder) {
        ResponseHolder responseHolder = responseAPIHolder.getResponseHolder();
        RequestEntity requestEntity = responseAPIHolder.getRequestEntity();
        updateDates(responseHolder);
        FinalResponseEntity finalResponseEntity = createResponse(responseHolder, requestEntity.getWeatherHolder());

        String finalResponse = convertObjectToJSON(finalResponseEntity);
        return finalResponse;
    }


    /**
     * main function holds the logic
     * @param responseHolder
     * @param weatherHolder
     * @return
     */
    public FinalResponseEntity createResponse(ResponseHolder responseHolder, WeatherHolder weatherHolder) {
        logger.info("*** ResponseBuilderService ***");
        try {
            afterPropertiesSet();
        } catch (Exception e) {
            throw new BadRequestException("Couldn't find the property of counter");
        }
        FinalResponseEntity finalResponseEntity = new FinalResponseEntity();
        List<FinalTimeLines> list = new ArrayList<>();
        int totalNumOfHours = numberOfHoursObj.getNumberOfHours();
        for (Timelines timelines :
                responseHolder.getData().getTimelines()) {

            String firstStartTime = null;
            String currStartTime;
            String currEndTime;
            String prevEndTime = null;
            boolean currRule;
            boolean prevRule = false;
            boolean firstInterval = true;

            for (int i = 0; i < totalNumOfHours; i++) {
                Intervals interval = timelines.getIntervals().get(i);
                currStartTime = interval.getStartTime();
                currEndTime = interval.getEndTime();

                if (firstInterval){ //first time initialized
                    firstStartTime = currStartTime;
                    prevRule = legalRuleFunc(weatherHolder, interval);
                    firstInterval = false;
                    prevEndTime = currEndTime;
                    continue;
                }

                currRule = legalRuleFunc(weatherHolder, interval);

                if (i == totalNumOfHours-1){ //final interval
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

    private boolean legalRuleFunc(WeatherHolder weatherHolder, Intervals interval) {
        String totalOperator = weatherHolder.getTotalOperator();
        if (totalOperator.equals("OR")){
            return checkORLLegality(weatherHolder, interval);
        }
        else{ //AND operator
            return checkANDELegality(weatherHolder, interval);
        }
    }

    private boolean checkANDELegality(WeatherHolder weatherHolder, Intervals interval) {
        for (WeatherCondition weatherCondition : weatherHolder.getSet()){
            String weatherRuleName = weatherCondition.getName();
            long value = interval.getValues().getValuesMap().get(weatherRuleName);
            if (!weatherCondition.isLegal(value))
                return false;
        }
        return true;
    }

    private boolean checkORLLegality(WeatherHolder weatherHolder, Intervals interval) {
        for (WeatherCondition weatherCondition : weatherHolder.getSet()){
            String weatherRuleName = weatherCondition.getName();
            long value = interval.getValues().getValuesMap().get(weatherRuleName);
            if (weatherCondition.isLegal(value))
                return true;
        }
        return false;
    }


    protected void updateDates(ResponseHolder responseHolder) {
        for (Timelines timelines :
                responseHolder.getData().getTimelines()) {
            timelines.updateDate();
            for(Intervals interval : timelines.getIntervals()){
                interval.updateDate();
                interval.getValues().updateValuesMap();
            }
        }

    }


    /**
     * convert the FinalResponseEntity to JSON
     * @param finalResponseEntity
     */
    private String convertObjectToJSON(FinalResponseEntity finalResponseEntity) {
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        try {
            String jsonString = mapper.writeValueAsString(finalResponseEntity);
            logger.info("Response: ", jsonString);
            logger.info(jsonString);
            return jsonString;
        } catch (JsonProcessingException e) {
            throw new BadRequestException("Invalid response");
        }
    }


}
