package project.POJO.RequestEntity;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class URLRequest {

    private String prefix;
    private String tomorrowURL;
    private String apiKey;

    private String fields;
    private String timesteps;
    private String units;




    public String buildURL(WeatherHolder weatherHolder){
        return tomorrowURL +
                weatherHolder.getLat() + "," + weatherHolder.getLen() + "&" +
                fields + "&" +
                timesteps + "&" +
                units + "&" +
                apiKey;
    }

}
