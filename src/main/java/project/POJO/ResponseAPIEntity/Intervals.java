package project.POJO.ResponseAPIEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
@NoArgsConstructor
public class Intervals {
    String startTime;
    String endTime;
    LocalDateTime startTimeFormatted;
    LocalDateTime endTimeFormatted;
    Values values;


    public void updateDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        this.startTimeFormatted = LocalDateTime.parse(startTime, formatter);
        this.endTimeFormatted = startTimeFormatted.plusHours(1);
        this.endTime = formatter.format(endTimeFormatted);
    }
}
