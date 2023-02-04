import com.example.demo.pojo.response.ResponseHolder;
import com.example.demo.pojo.response.Timelines;
import com.example.demo.pojo.ruleBuild.WeatherHolder;
import com.example.demo.pojo.ruleBuild.WeatherRule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.json.JSONObject;


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


    final String JsonInput1 = "{data={timelines=[{timestep=1h, endTime=2023-02-09T01:00:00Z, startTime=2023-02-04T13:00:00Z, intervals=[{startTime=2023-02-04T13:00:00Z, values={humidity=38, rainIntensity=0, temperature=-15.38, windSpeed=5}}, {startTime=2023-02-04T14:00:00Z, values={humidity=38.27, rainIntensity=0, temperature=-14.49, windSpeed=4.72}}, {startTime=2023-02-04T15:00:00Z, values={humidity=32.38, rainIntensity=0, temperature=-12.81, windSpeed=4.22}}, {startTime=2023-02-04T16:00:00Z, values={humidity=28.42, rainIntensity=0, temperature=-11.06, windSpeed=3.37}}, {startTime=2023-02-04T17:00:00Z, values={humidity=24.49, rainIntensity=0, temperature=-9.35, windSpeed=2.86}}, {startTime=2023-02-04T18:00:00Z, values={humidity=22.4, rainIntensity=0, temperature=-8.02, windSpeed=2.5}}, {startTime=2023-02-04T19:00:00Z, values={humidity=23.19, rainIntensity=0, temperature=-7.1, windSpeed=2.66}}, {startTime=2023-02-04T20:00:00Z, values={humidity=23.01, rainIntensity=0, temperature=-6.27, windSpeed=3}}, {startTime=2023-02-04T21:00:00Z, values={humidity=26.97, rainIntensity=0, temperature=-5.75, windSpeed=3.68}}, {startTime=2023-02-04T22:00:00Z, values={humidity=29.43, rainIntensity=0, temperature=-5.54, windSpeed=3.04}}, {startTime=2023-02-04T23:00:00Z, values={humidity=31.43, rainIntensity=0, temperature=-6.3, windSpeed=2.2}}, {startTime=2023-02-05T00:00:00Z, values={humidity=34.9, rainIntensity=0, temperature=-6.37, windSpeed=2.94}}, {startTime=2023-02-05T01:00:00Z, values={humidity=45.02, rainIntensity=0, temperature=-5.92, windSpeed=4.23}}, {startTime=2023-02-05T02:00:00Z, values={humidity=43.08, rainIntensity=0, temperature=-5.65, windSpeed=4.51}}, {startTime=2023-02-05T03:00:00Z, values={humidity=59.73, rainIntensity=0, temperature=-5.14, windSpeed=4.91}}, {startTime=2023-02-05T04:00:00Z, values={humidity=58.41, rainIntensity=0, temperature=-4.93, windSpeed=4.51}}, {startTime=2023-02-05T05:00:00Z, values={humidity=61.43, rainIntensity=0, temperature=-4.65, windSpeed=4.71}}, {startTime=2023-02-05T06:00:00Z, values={humidity=66.69, rainIntensity=0, temperature=-4.46, windSpeed=4.38}}, {startTime=2023-02-05T07:00:00Z, values={humidity=70.73, rainIntensity=0, temperature=-3.73, windSpeed=4.84}}, {startTime=2023-02-05T08:00:00Z, values={humidity=60.96, rainIntensity=0, temperature=-2, windSpeed=5.1}}, {startTime=2023-02-05T09:00:00Z, values={humidity=64.08, rainIntensity=0, temperature=-1.74, windSpeed=4.57}}, {startTime=2023-02-05T10:00:00Z, values={humidity=66.14, rainIntensity=0, temperature=-1.59, windSpeed=4.45}}, {startTime=2023-02-05T11:00:00Z, values={humidity=66.24, rainIntensity=0, temperature=-1.5, windSpeed=4.48}}, {startTime=2023-02-05T12:00:00Z, values={humidity=65.06, rainIntensity=0, temperature=-1.36, windSpeed=4.66}}, {startTime=2023-02-05T13:00:00Z, values={humidity=59, rainIntensity=0, temperature=-0.22, windSpeed=5.08}}, {startTime=2023-02-05T14:00:00Z, values={humidity=52.77, rainIntensity=0, temperature=1.1, windSpeed=5.44}}, {startTime=2023-02-05T15:00:00Z, values={humidity=50.65, rainIntensity=0, temperature=2.23, windSpeed=5.63}}, {startTime=2023-02-05T16:00:00Z, values={humidity=48.17, rainIntensity=0, temperature=3.81, windSpeed=5.28}}, {startTime=2023-02-05T17:00:00Z, values={humidity=44.52, rainIntensity=0, temperature=5.61, windSpeed=5.59}}, {startTime=2023-02-05T18:00:00Z, values={humidity=40.86, rainIntensity=0, temperature=7.19, windSpeed=6.02}}, {startTime=2023-02-05T19:00:00Z, values={humidity=41.54, rainIntensity=0, temperature=8.07, windSpeed=5.77}}, {startTime=2023-02-05T20:00:00Z, values={humidity=48.41, rainIntensity=0, temperature=8.18, windSpeed=4.64}}, {startTime=2023-02-05T21:00:00Z, values={humidity=52.7, rainIntensity=0, temperature=7.52, windSpeed=4.76}}, {startTime=2023-02-05T22:00:00Z, values={humidity=55.45, rainIntensity=0, temperature=5.99, windSpeed=5.26}}, {startTime=2023-02-05T23:00:00Z, values={humidity=58.63, rainIntensity=0, temperature=5.31, windSpeed=5.26}}, {startTime=2023-02-06T00:00:00Z, values={humidity=64.51, rainIntensity=0, temperature=5.05, windSpeed=4.8}}, {startTime=2023-02-06T01:00:00Z, values={humidity=74.05, rainIntensity=0, temperature=4.62, windSpeed=3.67}}, {startTime=2023-02-06T02:00:00Z, values={humidity=82.18, rainIntensity=0, temperature=3.98, windSpeed=2.87}}, {startTime=2023-02-06T03:00:00Z, values={humidity=85.77, rainIntensity=0, temperature=4, windSpeed=2.92}}, {startTime=2023-02-06T04:00:00Z, values={humidity=88.73, rainIntensity=0, temperature=4.2, windSpeed=3}}, {startTime=2023-02-06T05:00:00Z, values={humidity=91.09, rainIntensity=0, temperature=4.35, windSpeed=3.36}}, {startTime=2023-02-06T06:00:00Z, values={humidity=93.65, rainIntensity=0, temperature=4.1, windSpeed=3.34}}, {startTime=2023-02-06T07:00:00Z, values={humidity=95.33, rainIntensity=0, temperature=3.53, windSpeed=2.87}}, {startTime=2023-02-06T08:00:00Z, values={humidity=96.95, rainIntensity=0, temperature=3.04, windSpeed=2.8}}, {startTime=2023-02-06T09:00:00Z, values={humidity=98.45, rainIntensity=0, temperature=1.61, windSpeed=2.34}}, {startTime=2023-02-06T10:00:00Z, values={humidity=99.31, rainIntensity=0, temperature=0.54, windSpeed=2.56}}, {startTime=2023-02-06T11:00:00Z, values={humidity=96.6, rainIntensity=0, temperature=-0.14, windSpeed=1.78}}, {startTime=2023-02-06T12:00:00Z, values={humidity=94.57, rainIntensity=0, temperature=-0.56, windSpeed=2.14}}, {startTime=2023-02-06T13:00:00Z, values={humidity=86.71, rainIntensity=0, temperature=1.79, windSpeed=2.5}}, {startTime=2023-02-06T14:00:00Z, values={humidity=80.49, rainIntensity=0, temperature=4.01, windSpeed=2.57}}, {startTime=2023-02-06T15:00:00Z, values={humidity=71.31, rainIntensity=0, temperature=6.73, windSpeed=3.56}}, {startTime=2023-02-06T16:00:00Z, values={humidity=62.79, rainIntensity=0, temperature=8.8, windSpeed=5.15}}, {startTime=2023-02-06T17:00:00Z, values={humidity=56.84, rainIntensity=0, temperature=9.69, windSpeed=6.08}}, {startTime=2023-02-06T18:00:00Z, values={humidity=54.3, rainIntensity=0, temperature=10.02, windSpeed=6.72}}, {startTime=2023-02-06T19:00:00Z, values={humidity=51.88, rainIntensity=0, temperature=9.89, windSpeed=6.76}}, {startTime=2023-02-06T20:00:00Z, values={humidity=51.68, rainIntensity=0, temperature=9.53, windSpeed=6.65}}, {startTime=2023-02-06T21:00:00Z, values={humidity=55.24, rainIntensity=0, temperature=8.61, windSpeed=6.01}}, {startTime=2023-02-06T22:00:00Z, values={humidity=59.73, rainIntensity=0, temperature=7.09, windSpeed=4.71}}, {startTime=2023-02-06T23:00:00Z, values={humidity=64.14, rainIntensity=0, temperature=5.33, windSpeed=4.68}}, {startTime=2023-02-07T00:00:00Z, values={humidity=66.29, rainIntensity=0, temperature=4.54, windSpeed=4.88}}, {startTime=2023-02-07T01:00:00Z, values={humidity=69.59, rainIntensity=0, temperature=3.61, windSpeed=4.94}}, {startTime=2023-02-07T02:00:00Z, values={humidity=74.79, rainIntensity=0, temperature=2.59, windSpeed=4.72}}, {startTime=2023-02-07T03:00:00Z, values={humidity=80.2, rainIntensity=0, temperature=1.48, windSpeed=4.34}}, {startTime=2023-02-07T04:00:00Z, values={humidity=84.17, rainIntensity=0, temperature=0.6, windSpeed=4.41}}, {startTime=2023-02-07T05:00:00Z, values={humidity=85.91, rainIntensity=0, temperature=-0.17, windSpeed=4.4}}, {startTime=2023-02-07T06:00:00Z, values={humidity=86.19, rainIntensity=0, temperature=-0.96, windSpeed=4.35}}, {startTime=2023-02-07T07:00:00Z, values={humidity=86.31, rainIntensity=0, temperature=-1.72, windSpeed=3.39}}, {startTime=2023-02-07T08:00:00Z, values={humidity=85.96, rainIntensity=0, temperature=-2.31, windSpeed=3.12}}, {startTime=2023-02-07T09:00:00Z, values={humidity=86.21, rainIntensity=0, temperature=-2.8, windSpeed=2.52}}, {startTime=2023-02-07T10:00:00Z, values={humidity=86.15, rainIntensity=0, temperature=-3.08, windSpeed=2.44}}, {startTime=2023-02-07T11:00:00Z, values={humidity=87.31, rainIntensity=0, temperature=-3.49, windSpeed=1.9}}, {startTime=2023-02-07T12:00:00Z, values={humidity=87.65, rainIntensity=0, temperature=-3.6, windSpeed=1.87}}, {startTime=2023-02-07T13:00:00Z, values={humidity=83.71, rainIntensity=0, temperature=-1.51, windSpeed=2}}, {startTime=2023-02-07T14:00:00Z, values={humidity=79.96, rainIntensity=0, temperature=0.64, windSpeed=1.61}}, {startTime=2023-02-07T15:00:00Z, values={humidity=79.02, rainIntensity=0, temperature=2.61, windSpeed=3.23}}, {startTime=2023-02-07T16:00:00Z, values={humidity=75.45, rainIntensity=0, temperature=4.68, windSpeed=4.87}}, {startTime=2023-02-07T17:00:00Z, values={humidity=72.74, rainIntensity=0, temperature=5.72, windSpeed=5.22}}, {startTime=2023-02-07T18:00:00Z, values={humidity=70.33, rainIntensity=0, temperature=6.49, windSpeed=5.72}}, {startTime=2023-02-07T19:00:00Z, values={humidity=71.71, rainIntensity=0, temperature=6.78, windSpeed=5.94}}, {startTime=2023-02-07T20:00:00Z, values={humidity=72.54, rainIntensity=0, temperature=6.76, windSpeed=6.41}}, {startTime=2023-02-07T21:00:00Z, values={humidity=72.31, rainIntensity=0, temperature=6.79, windSpeed=6.79}}, {startTime=2023-02-07T22:00:00Z, values={humidity=73.42, rainIntensity=0, temperature=6.62, windSpeed=7.09}}, {startTime=2023-02-07T23:00:00Z, values={humidity=71.36, rainIntensity=0, temperature=6.49, windSpeed=6.76}}, {startTime=2023-02-08T00:00:00Z, values={humidity=71.82, rainIntensity=0, temperature=6.59, windSpeed=6.37}}, {startTime=2023-02-08T01:00:00Z, values={humidity=71.85, rainIntensity=0, temperature=6.69, windSpeed=5.51}}, {startTime=2023-02-08T02:00:00Z, values={humidity=69.27, rainIntensity=0, temperature=6.95, windSpeed=5.76}}, {startTime=2023-02-08T03:00:00Z, values={humidity=69.66, rainIntensity=0, temperature=7.11, windSpeed=5.54}}, {startTime=2023-02-08T04:00:00Z, values={humidity=71.22, rainIntensity=0, temperature=7.35, windSpeed=6.2}}, {startTime=2023-02-08T05:00:00Z, values={humidity=73.4, rainIntensity=0, temperature=7.55, windSpeed=5.85}}, {startTime=2023-02-08T06:00:00Z, values={humidity=77.1, rainIntensity=0, temperature=7.55, windSpeed=5.13}}, {startTime=2023-02-08T07:00:00Z, values={humidity=80.52, rainIntensity=0, temperature=7.49, windSpeed=4.77}}, {startTime=2023-02-08T08:00:00Z, values={humidity=83.32, rainIntensity=0, temperature=7.31, windSpeed=4.37}}, {startTime=2023-02-08T09:00:00Z, values={humidity=84.49, rainIntensity=0, temperature=7.28, windSpeed=3.83}}, {startTime=2023-02-08T10:00:00Z, values={humidity=90.21, rainIntensity=0, temperature=6.37, windSpeed=3.05}}, {startTime=2023-02-08T11:00:00Z, values={humidity=92.08, rainIntensity=0, temperature=6.01, windSpeed=3.36}}, {startTime=2023-02-08T12:00:00Z, values={humidity=92.63, rainIntensity=0, temperature=5.64, windSpeed=3.1}}, {startTime=2023-02-08T13:00:00Z, values={humidity=89.54, rainIntensity=0, temperature=5.79, windSpeed=2.84}}, {startTime=2023-02-08T14:00:00Z, values={humidity=76.68, rainIntensity=0, temperature=6.72, windSpeed=2.54}}, {startTime=2023-02-08T15:00:00Z, values={humidity=62.01, rainIntensity=0, temperature=7.48, windSpeed=2.67}}, {startTime=2023-02-08T16:00:00Z, values={humidity=45.22, rainIntensity=0, temperature=8.57, windSpeed=3.54}}, {startTime=2023-02-08T17:00:00Z, values={humidity=35.81, rainIntensity=0, temperature=9.69, windSpeed=3.21}}, {startTime=2023-02-08T18:00:00Z, values={humidity=30.56, rainIntensity=0, temperature=10.64, windSpeed=3.37}}, {startTime=2023-02-08T19:00:00Z, values={humidity=27.95, rainIntensity=0, temperature=11.45, windSpeed=3.08}}, {startTime=2023-02-08T20:00:00Z, values={humidity=26.82, rainIntensity=0, temperature=12.04, windSpeed=3.12}}, {startTime=2023-02-08T21:00:00Z, values={humidity=27.37, rainIntensity=0, temperature=12.17, windSpeed=2.97}}, {startTime=2023-02-08T22:00:00Z, values={humidity=30.74, rainIntensity=0, temperature=11.06, windSpeed=1.92}}, {startTime=2023-02-08T23:00:00Z, values={humidity=35.21, rainIntensity=0, temperature=10.14, windSpeed=2.27}}, {startTime=2023-02-09T00:00:00Z, values={humidity=38.4, rainIntensity=0, temperature=9.63, windSpeed=2.03}}, {startTime=2023-02-09T01:00:00Z, values={humidity=40.18, rainIntensity=0, temperature=9.26, windSpeed=1.25}}]}]}}";
    final static String JsonInput = "timelines=[{timestep=1h, endTime=2023-02-09T01:00:00Z, startTime=2023-02-04T13:00:00Z, intervals=[{startTime=2023-02-04T13:00:00Z, values={humidity=38, rainIntensity=0, temperature=-15.38, windSpeed=5}}, {startTime=2023-02-04T14:00:00Z, values={humidity=38.27, rainIntensity=0, temperature=-14.49, windSpeed=4.72}}, {startTime=2023-02-04T15:00:00Z, values={humidity=32.38, rainIntensity=0, temperature=-12.81, windSpeed=4.22}}, {startTime=2023-02-04T16:00:00Z, values={humidity=28.42, rainIntensity=0, temperature=-11.06, windSpeed=3.37}}, {startTime=2023-02-04T17:00:00Z, values={humidity=24.49, rainIntensity=0, temperature=-9.35, windSpeed=2.86}}, {startTime=2023-02-04T18:00:00Z, values={humidity=22.4, rainIntensity=0, temperature=-8.02, windSpeed=2.5}}, {startTime=2023-02-04T19:00:00Z, values={humidity=23.19, rainIntensity=0, temperature=-7.1, windSpeed=2.66}}, {startTime=2023-02-04T20:00:00Z, values={humidity=23.01, rainIntensity=0, temperature=-6.27, windSpeed=3}}, {startTime=2023-02-04T21:00:00Z, values={humidity=26.97, rainIntensity=0, temperature=-5.75, windSpeed=3.68}}, {startTime=2023-02-04T22:00:00Z, values={humidity=29.43, rainIntensity=0, temperature=-5.54, windSpeed=3.04}}, {startTime=2023-02-04T23:00:00Z, values={humidity=31.43, rainIntensity=0, temperature=-6.3, windSpeed=2.2}}, {startTime=2023-02-05T00:00:00Z, values={humidity=34.9, rainIntensity=0, temperature=-6.37, windSpeed=2.94}}, {startTime=2023-02-05T01:00:00Z, values={humidity=45.02, rainIntensity=0, temperature=-5.92, windSpeed=4.23}}, {startTime=2023-02-05T02:00:00Z, values={humidity=43.08, rainIntensity=0, temperature=-5.65, windSpeed=4.51}}, {startTime=2023-02-05T03:00:00Z, values={humidity=59.73, rainIntensity=0, temperature=-5.14, windSpeed=4.91}}, {startTime=2023-02-05T04:00:00Z, values={humidity=58.41, rainIntensity=0, temperature=-4.93, windSpeed=4.51}}, {startTime=2023-02-05T05:00:00Z, values={humidity=61.43, rainIntensity=0, temperature=-4.65, windSpeed=4.71}}, {startTime=2023-02-05T06:00:00Z, values={humidity=66.69, rainIntensity=0, temperature=-4.46, windSpeed=4.38}}, {startTime=2023-02-05T07:00:00Z, values={humidity=70.73, rainIntensity=0, temperature=-3.73, windSpeed=4.84}}, {startTime=2023-02-05T08:00:00Z, values={humidity=60.96, rainIntensity=0, temperature=-2, windSpeed=5.1}}, {startTime=2023-02-05T09:00:00Z, values={humidity=64.08, rainIntensity=0, temperature=-1.74, windSpeed=4.57}}, {startTime=2023-02-05T10:00:00Z, values={humidity=66.14, rainIntensity=0, temperature=-1.59, windSpeed=4.45}}, {startTime=2023-02-05T11:00:00Z, values={humidity=66.24, rainIntensity=0, temperature=-1.5, windSpeed=4.48}}, {startTime=2023-02-05T12:00:00Z, values={humidity=65.06, rainIntensity=0, temperature=-1.36, windSpeed=4.66}}, {startTime=2023-02-05T13:00:00Z, values={humidity=59, rainIntensity=0, temperature=-0.22, windSpeed=5.08}}, {startTime=2023-02-05T14:00:00Z, values={humidity=52.77, rainIntensity=0, temperature=1.1, windSpeed=5.44}}, {startTime=2023-02-05T15:00:00Z, values={humidity=50.65, rainIntensity=0, temperature=2.23, windSpeed=5.63}}, {startTime=2023-02-05T16:00:00Z, values={humidity=48.17, rainIntensity=0, temperature=3.81, windSpeed=5.28}}, {startTime=2023-02-05T17:00:00Z, values={humidity=44.52, rainIntensity=0, temperature=5.61, windSpeed=5.59}}, {startTime=2023-02-05T18:00:00Z, values={humidity=40.86, rainIntensity=0, temperature=7.19, windSpeed=6.02}}, {startTime=2023-02-05T19:00:00Z, values={humidity=41.54, rainIntensity=0, temperature=8.07, windSpeed=5.77}}, {startTime=2023-02-05T20:00:00Z, values={humidity=48.41, rainIntensity=0, temperature=8.18, windSpeed=4.64}}, {startTime=2023-02-05T21:00:00Z, values={humidity=52.7, rainIntensity=0, temperature=7.52, windSpeed=4.76}}, {startTime=2023-02-05T22:00:00Z, values={humidity=55.45, rainIntensity=0, temperature=5.99, windSpeed=5.26}}, {startTime=2023-02-05T23:00:00Z, values={humidity=58.63, rainIntensity=0, temperature=5.31, windSpeed=5.26}}, {startTime=2023-02-06T00:00:00Z, values={humidity=64.51, rainIntensity=0, temperature=5.05, windSpeed=4.8}}, {startTime=2023-02-06T01:00:00Z, values={humidity=74.05, rainIntensity=0, temperature=4.62, windSpeed=3.67}}, {startTime=2023-02-06T02:00:00Z, values={humidity=82.18, rainIntensity=0, temperature=3.98, windSpeed=2.87}}, {startTime=2023-02-06T03:00:00Z, values={humidity=85.77, rainIntensity=0, temperature=4, windSpeed=2.92}}, {startTime=2023-02-06T04:00:00Z, values={humidity=88.73, rainIntensity=0, temperature=4.2, windSpeed=3}}, {startTime=2023-02-06T05:00:00Z, values={humidity=91.09, rainIntensity=0, temperature=4.35, windSpeed=3.36}}, {startTime=2023-02-06T06:00:00Z, values={humidity=93.65, rainIntensity=0, temperature=4.1, windSpeed=3.34}}, {startTime=2023-02-06T07:00:00Z, values={humidity=95.33, rainIntensity=0, temperature=3.53, windSpeed=2.87}}, {startTime=2023-02-06T08:00:00Z, values={humidity=96.95, rainIntensity=0, temperature=3.04, windSpeed=2.8}}, {startTime=2023-02-06T09:00:00Z, values={humidity=98.45, rainIntensity=0, temperature=1.61, windSpeed=2.34}}, {startTime=2023-02-06T10:00:00Z, values={humidity=99.31, rainIntensity=0, temperature=0.54, windSpeed=2.56}}, {startTime=2023-02-06T11:00:00Z, values={humidity=96.6, rainIntensity=0, temperature=-0.14, windSpeed=1.78}}, {startTime=2023-02-06T12:00:00Z, values={humidity=94.57, rainIntensity=0, temperature=-0.56, windSpeed=2.14}}, {startTime=2023-02-06T13:00:00Z, values={humidity=86.71, rainIntensity=0, temperature=1.79, windSpeed=2.5}}, {startTime=2023-02-06T14:00:00Z, values={humidity=80.49, rainIntensity=0, temperature=4.01, windSpeed=2.57}}, {startTime=2023-02-06T15:00:00Z, values={humidity=71.31, rainIntensity=0, temperature=6.73, windSpeed=3.56}}, {startTime=2023-02-06T16:00:00Z, values={humidity=62.79, rainIntensity=0, temperature=8.8, windSpeed=5.15}}, {startTime=2023-02-06T17:00:00Z, values={humidity=56.84, rainIntensity=0, temperature=9.69, windSpeed=6.08}}, {startTime=2023-02-06T18:00:00Z, values={humidity=54.3, rainIntensity=0, temperature=10.02, windSpeed=6.72}}, {startTime=2023-02-06T19:00:00Z, values={humidity=51.88, rainIntensity=0, temperature=9.89, windSpeed=6.76}}, {startTime=2023-02-06T20:00:00Z, values={humidity=51.68, rainIntensity=0, temperature=9.53, windSpeed=6.65}}, {startTime=2023-02-06T21:00:00Z, values={humidity=55.24, rainIntensity=0, temperature=8.61, windSpeed=6.01}}, {startTime=2023-02-06T22:00:00Z, values={humidity=59.73, rainIntensity=0, temperature=7.09, windSpeed=4.71}}, {startTime=2023-02-06T23:00:00Z, values={humidity=64.14, rainIntensity=0, temperature=5.33, windSpeed=4.68}}, {startTime=2023-02-07T00:00:00Z, values={humidity=66.29, rainIntensity=0, temperature=4.54, windSpeed=4.88}}, {startTime=2023-02-07T01:00:00Z, values={humidity=69.59, rainIntensity=0, temperature=3.61, windSpeed=4.94}}, {startTime=2023-02-07T02:00:00Z, values={humidity=74.79, rainIntensity=0, temperature=2.59, windSpeed=4.72}}, {startTime=2023-02-07T03:00:00Z, values={humidity=80.2, rainIntensity=0, temperature=1.48, windSpeed=4.34}}, {startTime=2023-02-07T04:00:00Z, values={humidity=84.17, rainIntensity=0, temperature=0.6, windSpeed=4.41}}, {startTime=2023-02-07T05:00:00Z, values={humidity=85.91, rainIntensity=0, temperature=-0.17, windSpeed=4.4}}, {startTime=2023-02-07T06:00:00Z, values={humidity=86.19, rainIntensity=0, temperature=-0.96, windSpeed=4.35}}, {startTime=2023-02-07T07:00:00Z, values={humidity=86.31, rainIntensity=0, temperature=-1.72, windSpeed=3.39}}, {startTime=2023-02-07T08:00:00Z, values={humidity=85.96, rainIntensity=0, temperature=-2.31, windSpeed=3.12}}, {startTime=2023-02-07T09:00:00Z, values={humidity=86.21, rainIntensity=0, temperature=-2.8, windSpeed=2.52}}, {startTime=2023-02-07T10:00:00Z, values={humidity=86.15, rainIntensity=0, temperature=-3.08, windSpeed=2.44}}, {startTime=2023-02-07T11:00:00Z, values={humidity=87.31, rainIntensity=0, temperature=-3.49, windSpeed=1.9}}, {startTime=2023-02-07T12:00:00Z, values={humidity=87.65, rainIntensity=0, temperature=-3.6, windSpeed=1.87}}, {startTime=2023-02-07T13:00:00Z, values={humidity=83.71, rainIntensity=0, temperature=-1.51, windSpeed=2}}, {startTime=2023-02-07T14:00:00Z, values={humidity=79.96, rainIntensity=0, temperature=0.64, windSpeed=1.61}}, {startTime=2023-02-07T15:00:00Z, values={humidity=79.02, rainIntensity=0, temperature=2.61, windSpeed=3.23}}, {startTime=2023-02-07T16:00:00Z, values={humidity=75.45, rainIntensity=0, temperature=4.68, windSpeed=4.87}}, {startTime=2023-02-07T17:00:00Z, values={humidity=72.74, rainIntensity=0, temperature=5.72, windSpeed=5.22}}, {startTime=2023-02-07T18:00:00Z, values={humidity=70.33, rainIntensity=0, temperature=6.49, windSpeed=5.72}}, {startTime=2023-02-07T19:00:00Z, values={humidity=71.71, rainIntensity=0, temperature=6.78, windSpeed=5.94}}, {startTime=2023-02-07T20:00:00Z, values={humidity=72.54, rainIntensity=0, temperature=6.76, windSpeed=6.41}}, {startTime=2023-02-07T21:00:00Z, values={humidity=72.31, rainIntensity=0, temperature=6.79, windSpeed=6.79}}, {startTime=2023-02-07T22:00:00Z, values={humidity=73.42, rainIntensity=0, temperature=6.62, windSpeed=7.09}}, {startTime=2023-02-07T23:00:00Z, values={humidity=71.36, rainIntensity=0, temperature=6.49, windSpeed=6.76}}, {startTime=2023-02-08T00:00:00Z, values={humidity=71.82, rainIntensity=0, temperature=6.59, windSpeed=6.37}}, {startTime=2023-02-08T01:00:00Z, values={humidity=71.85, rainIntensity=0, temperature=6.69, windSpeed=5.51}}, {startTime=2023-02-08T02:00:00Z, values={humidity=69.27, rainIntensity=0, temperature=6.95, windSpeed=5.76}}, {startTime=2023-02-08T03:00:00Z, values={humidity=69.66, rainIntensity=0, temperature=7.11, windSpeed=5.54}}, {startTime=2023-02-08T04:00:00Z, values={humidity=71.22, rainIntensity=0, temperature=7.35, windSpeed=6.2}}, {startTime=2023-02-08T05:00:00Z, values={humidity=73.4, rainIntensity=0, temperature=7.55, windSpeed=5.85}}, {startTime=2023-02-08T06:00:00Z, values={humidity=77.1, rainIntensity=0, temperature=7.55, windSpeed=5.13}}, {startTime=2023-02-08T07:00:00Z, values={humidity=80.52, rainIntensity=0, temperature=7.49, windSpeed=4.77}}, {startTime=2023-02-08T08:00:00Z, values={humidity=83.32, rainIntensity=0, temperature=7.31, windSpeed=4.37}}, {startTime=2023-02-08T09:00:00Z, values={humidity=84.49, rainIntensity=0, temperature=7.28, windSpeed=3.83}}, {startTime=2023-02-08T10:00:00Z, values={humidity=90.21, rainIntensity=0, temperature=6.37, windSpeed=3.05}}, {startTime=2023-02-08T11:00:00Z, values={humidity=92.08, rainIntensity=0, temperature=6.01, windSpeed=3.36}}, {startTime=2023-02-08T12:00:00Z, values={humidity=92.63, rainIntensity=0, temperature=5.64, windSpeed=3.1}}, {startTime=2023-02-08T13:00:00Z, values={humidity=89.54, rainIntensity=0, temperature=5.79, windSpeed=2.84}}, {startTime=2023-02-08T14:00:00Z, values={humidity=76.68, rainIntensity=0, temperature=6.72, windSpeed=2.54}}, {startTime=2023-02-08T15:00:00Z, values={humidity=62.01, rainIntensity=0, temperature=7.48, windSpeed=2.67}}, {startTime=2023-02-08T16:00:00Z, values={humidity=45.22, rainIntensity=0, temperature=8.57, windSpeed=3.54}}, {startTime=2023-02-08T17:00:00Z, values={humidity=35.81, rainIntensity=0, temperature=9.69, windSpeed=3.21}}, {startTime=2023-02-08T18:00:00Z, values={humidity=30.56, rainIntensity=0, temperature=10.64, windSpeed=3.37}}, {startTime=2023-02-08T19:00:00Z, values={humidity=27.95, rainIntensity=0, temperature=11.45, windSpeed=3.08}}, {startTime=2023-02-08T20:00:00Z, values={humidity=26.82, rainIntensity=0, temperature=12.04, windSpeed=3.12}}, {startTime=2023-02-08T21:00:00Z, values={humidity=27.37, rainIntensity=0, temperature=12.17, windSpeed=2.97}}, {startTime=2023-02-08T22:00:00Z, values={humidity=30.74, rainIntensity=0, temperature=11.06, windSpeed=1.92}}, {startTime=2023-02-08T23:00:00Z, values={humidity=35.21, rainIntensity=0, temperature=10.14, windSpeed=2.27}}, {startTime=2023-02-09T00:00:00Z, values={humidity=38.4, rainIntensity=0, temperature=9.63, windSpeed=2.03}}, {startTime=2023-02-09T01:00:00Z, values={humidity=40.18, rainIntensity=0, temperature=9.26, windSpeed=1.25}}]}]}";


    public static void main(String[] args) {
//        extractVariables(GETURL);
//        String correctURL = buildURL(GETURL);
//        System.out.println(correctURL);


        createPOJO();
    }

    public static void createPOJO()  {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ResponseHolder res = objectMapper.readValue(JsonInput, ResponseHolder.class);
            System.out.println(res);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

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
