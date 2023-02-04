import com.example.demo.pojo.ruleBuild.WeatherHolder;
import com.example.demo.pojo.ruleBuild.WeatherRule;

public class sideMain {


    /**
     * GETURL:
     GET/weather-conditions?location=40.7,-73.9&rule=temperature>30,windSpeed<10,visibility>4&operator=OR
     * requestURL:
     * 'https://api.tomorrow.io/v4/timelines?location=40.75872069597532,-73.98529171943665&fields=temperature&timesteps=1h&units=metric&apikey=fvFU2JQBMP1QX7MeW44ghUQnNiy97uX6
     */

    static final String prefix = "GET/weather-conditions" + "\\?" + "location=";
    static final String tomorrowURL = "https://api.tomorrow.io/v4/timelines?";
    static final String apiKey = "apikey=fvFU2JQBMP1QX7MeW44ghUQnNiy97uX6";
    static String GETURL = "GET/weather-conditions?location=40.7,-73.9&rule=temperature>30,windSpeed<10,rainIntensity>4&operator=OR";
    static String requestURL = "https://api.tomorrow.io/v4/timelines?location=40.75872069597532,-73.98529171943665&fields=temperature&timesteps=1h&units=metric&apikey=fvFU2JQBMP1QX7MeW44ghUQnNiy97uX6";

    static WeatherHolder weatherHolder = new WeatherHolder();




    public static void main(String[] args) {
        extractVariables(GETURL);
        String correctURL = buildURL(GETURL);
        System.out.println(correctURL);

    }

    static void extractVariables(String GETURL){
        String correctURL = null;

        String urlWithoutPrefix = GETURL.replaceFirst(prefix, "");
        String[] splitGETURL = urlWithoutPrefix.split("&", 3);

        handleFirstPartLocations(splitGETURL[0]);
        handleSecondPart(splitGETURL[1]);
        handleThirdPart(splitGETURL[2]);

        System.out.println("hiiiii");

    }

    private static void handleFirstPartLocations(String s) {
        String[] location = getLocation(s);
        String lat = location[0];
        String lon = location[1];

        weatherHolder.setLat(lat);
        weatherHolder.setLen(lon);

    }

    static String buildURL(String fixedLocationsPart){
        return tomorrowURL + fixedLocationsPart + "&" + "fields=temperature,humidity,windSpeed,rainIntensity&timesteps=1h&units=metric" + "&" + apiKey;
    }


    static String[] getLocation(String splitGETURL) {
        return splitGETURL.split(",");
    }

    private static String handleSecondPart(String s) {

        if (!s.startsWith("rule=")){
            System.out.println("***400!!!!***");
            return null;
        }

        s = s.replaceFirst("rule=", "");
        String[] rules = s.split(",");


        for (String rule : rules){
            String ruleOperator = operatorInitializer(rule);
            String[] currRule = rule.split(ruleOperator);
            int value =  Integer.valueOf(currRule[1]);
            String ruleName = currRule[0];
            int counter = 0;
            boolean exists = weatherHolder.getRuleNames().contains(ruleName);
            if (exists){
                WeatherRule weatherRule = new WeatherRule(ruleName, true, ruleOperator, value);
                weatherHolder.getSet().add(weatherRule); //todo check if added
            }
            weatherHolder.setTotalRules(counter);
        }
        return null;
    }

    private static String operatorInitializer(String rule) {
        String ruleOperator = null;
        if (rule.contains(">")){
            ruleOperator = ">";
        }
        else if (rule.contains("<")){
            ruleOperator = "<";
        }
        else{
            System.out.println("***400!!!***");
        }
        return ruleOperator;
    }

    private static void handleThirdPart(String s) {
        String[] split = s.split("=");
        String totalOperator = split[1];
        if (!totalOperator.equals("OR") || !totalOperator.equals("AND")){
            System.out.println("****400!!!!*****");
        }
        weatherHolder.setTotalOperator(totalOperator);
    }




}
