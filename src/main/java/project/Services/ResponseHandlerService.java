package project.Services;

import org.slf4j.Logger;
import project.POJO.ExceptionEntity.Types.NotFoundException;
import project.POJO.ExceptionEntity.Types.ServiceErrorException;
import project.POJO.FinalResponseEntity.FinalResponseEntity;
import project.POJO.LoggerHelper;
import project.POJO.RequestEntity.RequestEntity;
import project.POJO.ResponseAPIEntity.ResponseHolder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Service
public class ResponseHandlerService {

    private Logger logger = LoggerHelper.logger;

    public String initialize(RequestEntity requestEntity){
        InputStream inputStream = sendRequest(requestEntity.getUrl());
        String responseURL = convertInputStreamToString(inputStream);
        ResponseHolder responseHolder = createPOJO(responseURL);
        ResponseBuilderService responseBuilderService = new ResponseBuilderService();
        responseBuilderService.updateDates(responseHolder);
        FinalResponseEntity finalResponseEntity = responseBuilderService.createResponse(responseHolder, requestEntity.getWeatherHolder());

        return convertObjectToJSON(finalResponseEntity);
    }


    /**
     * Send the URL to tomorrow.io API
     * @param urlInput
     * @return inputstream
     */
    @GetMapping
    public InputStream sendRequest(String urlInput){
        // Create a neat value object to hold the URL
        URL url = null;
        try {
            url = new URL(urlInput);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            InputStream responseStream = connection.getInputStream();
            return responseStream;
        }

        catch (MalformedURLException e) {
            throw new NotFoundException("Didn't find any data");
        } catch (IOException e) {
            throw new ServiceErrorException("Couldn't connect server");
        }

    }


    /**
     * convert the inputStream to String
     * @param inputStream
     * @return
     */
    String convertInputStreamToString(InputStream inputStream){
        return new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
    }


    /**
     * create a ResponseHolder POJO from url
     * @param url
     * @return
     */
    public ResponseHolder createPOJO(String url)  {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ResponseHolder res = objectMapper.readValue(url, ResponseHolder.class);
            logger.info("Response Holder: ", res);
            return res;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
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
            logger.info("jsonString: ", jsonString);
            logger.info(jsonString);
            return jsonString;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
