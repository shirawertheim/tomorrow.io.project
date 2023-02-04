package com.example.demo.weather;



public class handleGET {

    /**
     * GETURL:
    GET/weather-conditions?location=40.7,-73.9&rule=temperature>30,wind<10,visibility>4&operator=OR
     * requestURL:
     * 'https://api.tomorrow.io/v4/timelines?location=40.75872069597532,-73.98529171943665&fields=temperature&timesteps=1h&units=metric&apikey=fvFU2JQBMP1QX7MeW44ghUQnNiy97uX6
    */

    final String prefix = "GET/weather-conditions?location=";
    final String tomorrowURL = "https://api.tomorrow.io/v4/timelines?";
    final String apiKey = "apikey=fvFU2JQBMP1QX7MeW44ghUQnNiy97uX6";

    public String getJSONfromAPI(String url){

        return null;

    }

    public String buildCorrectURL(String GETURL){
        String correctURL = null;

        String urlWithoutPrefix = GETURL.replaceFirst(prefix, "");
        String[] splitGETURL = urlWithoutPrefix.split("&", 2);

        String[] location = getLocation(splitGETURL[0]);
        String lat = location[0];
        String lon = location[1];


        return correctURL;
    }

    private String[] getLocation(String splitGETURL) {
        return splitGETURL.split(",");
    }


}
