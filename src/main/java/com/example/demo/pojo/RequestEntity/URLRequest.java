package com.example.demo.pojo.RequestEntity;

import lombok.Data;

@Data
public class URLRequest {

    public static final String prefix = "GET/weather-conditions" + "\\?" + "location=";
    public static final String tomorrowURL = "https://api.tomorrow.io/v4/timelines?location=";
    public static final String apiKey = "apikey=fvFU2JQBMP1QX7MeW44ghUQnNiy97uX6";

    public static String requestURL = "https://api.tomorrow.io/v4/timelines?location=40.75872069597532,-73.98529171943665&fields=temperature&timesteps=1h&units=metric&apikey=fvFU2JQBMP1QX7MeW44ghUQnNiy97uX6";





    public String buildURL(WeatherHolder weatherHolder){
        return tomorrowURL + weatherHolder.getLat() + "," + weatherHolder.getLen() + "&" + "fields=temperature,humidity,windSpeed,rainIntensity&timesteps=1h&units=metric" + "&" + apiKey;
    }

}
