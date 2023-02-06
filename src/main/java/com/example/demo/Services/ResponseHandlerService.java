package com.example.demo.Services;

import com.example.demo.POJO.ExceptionEntity.Types.BadRequestException;
import com.example.demo.POJO.ExceptionEntity.Types.NotFoundException;
import com.example.demo.POJO.ExceptionEntity.Types.ServiceErrorException;
import com.example.demo.POJO.FinalResponseEntity.FinalResponseEntity;
import com.example.demo.POJO.RequestEntity.RequestEntity;
import com.example.demo.POJO.ResponseAPIEntity.ResponseHolder;
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


    public String initialize(RequestEntity requestEntity){
        InputStream inputStream = sendRequest(requestEntity.getUrl());
        String responseURL = convertInputStreamToString(inputStream);
        ResponseHolder responseHolder = createPOJO(responseURL);
        ResponseBuilderService responseBuilderService = new ResponseBuilderService();
        responseBuilderService.updateDates(responseHolder);
        FinalResponseEntity finalResponseEntity = responseBuilderService.createResponse(responseHolder, requestEntity.getWeatherHolder());
        System.out.println(finalResponseEntity);

        String finalResponse = convertObjectToJSON(finalResponseEntity);
        return finalResponse;
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
        String text = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
        return text;
    }


    /**
     * create a ResponseHolder POJO from url
     * @param url
     * @return
     */
    public static ResponseHolder createPOJO(String url)  {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ResponseHolder res = objectMapper.readValue(url, ResponseHolder.class);
            System.out.println(res);
            return res;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * convert the FinalResponseEntity to JSON
     * @param finalResponseEntity
     */
    private static String convertObjectToJSON(FinalResponseEntity finalResponseEntity) {
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        try {
            String jsonString = mapper.writeValueAsString(finalResponseEntity);
            System.out.println(jsonString);
            return jsonString;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    /*
    public Map<String, Object> createJSONFromURLResponse(InputStream inputStream){
        // Manually converting the response body InputStream to APOD using Jackson
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap = null;
        try {
            jsonMap = mapper.readValue(inputStream, Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Finally we have the response
        System.out.println(jsonMap);

        return jsonMap;
    }

    */
}
