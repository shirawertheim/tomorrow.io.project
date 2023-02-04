package com.example.demo.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

@Service
public class ResponseService {


    public void mainFunc(String url){
        InputStream inputStream = sendRequest(url);
        Map<String, Object> jsonMap = createJSON(inputStream);
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
