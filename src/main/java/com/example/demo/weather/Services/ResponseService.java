package com.example.demo.weather.Services;

import com.example.demo.pojo.RequestEntity.RequestEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ResponseService {


    public void initialize(RequestEntity requestEntity){
        InputStream inputStream = sendRequest(requestEntity.getUrl());
        String response = convertInputStreamToString(inputStream);
        Map<String, Object> WW = createJSON(inputStream);
    }


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
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    String convertInputStreamToString(InputStream inputStream){
        String text = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
        return text;
    }

    public Map<String, Object> createJSON(InputStream inputStream){
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
}
