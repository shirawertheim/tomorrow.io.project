package project.POJO.RequestEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestEntity {
    private String url;
    private WeatherHolder weatherHolder;
}
