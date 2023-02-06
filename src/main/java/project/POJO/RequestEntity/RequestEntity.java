package project.POJO.RequestEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Data
@AllArgsConstructor
public class RequestEntity {
    private String url;
    private WeatherHolder weatherHolder;

}
