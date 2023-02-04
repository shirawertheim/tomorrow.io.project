package com.example.demo.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;


@Service
public class WeatherService {
    @GetMapping
    public List<Weather> getStudents(){
        return List.of(new Weather(	1L,
                "Mariam",
                "mariam.jamal@gmail.com",
                LocalDate.of(2000, Month.APRIL, 5),
                21
        ));
    }



    @GetMapping
    public List<Object> getCountry1() {
            String url = "https://api.tomorrow.io/v4/timelines?location=40.75872069597532,-73.98529171943665&fields=temperature&timesteps=1h&units=metric&apikey=fvFU2JQBMP1QX7MeW44ghUQnNiy97uX6";
            RestTemplate restTemplate = new RestTemplate();
            Object[] weathers = restTemplate.getForObject(url, Object[].class);


            return Arrays.asList(weathers);
    }

    @GetMapping
    public List<Object> getCountry2() throws IOException {
        URL url = new URL("https://api.tomorrow.io/v4/timelines?location=40.75872069597532,-73.98529171943665&fields=temperature&timesteps=1h&units=metric&apikey=fvFU2JQBMP1QX7MeW44ghUQnNiy97uX6");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        //Getting the response code
        int responsecode = conn.getResponseCode();

        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {

            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }
            System.out.println(inline);

            //Close the scanner
            scanner.close();

            //Using the JSON simple library parse the string into a json object

        }

        return null;

    }


    @GetMapping
    public List<Object> getCountry() throws IOException {
        // Create a neat value object to hold the URL
        URL url = new URL("https://api.tomorrow.io/v4/timelines?location=40.75872069597532,-73.98529171943665&fields=temperature&timesteps=1h&units=metric&apikey=fvFU2JQBMP1QX7MeW44ghUQnNiy97uX6");

// Open a connection(?) on the URL(??) and cast the response(???)
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

// Now it's "open", we can set the request method, headers etc.
        connection.setRequestProperty("accept", "application/json");

// This line makes the request
        InputStream responseStream = connection.getInputStream();

// Manually converting the response body InputStream to APOD using Jackson
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap = mapper.readValue(responseStream, Map.class);

// Finally we have the response
        System.out.println(jsonMap);

        return null;
    }

    @GetMapping
    public List<Object> test() throws IOException {
        System.out.println("success!!!!!");
        return null;
    }

}
