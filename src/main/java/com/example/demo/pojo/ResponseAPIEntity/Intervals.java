package com.example.demo.pojo.ResponseAPIEntity;

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
    Values values;


    public void updateDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        this.startTimeFormatted = LocalDateTime.parse(startTime.toString(), formatter);
        LocalDateTime endTimeFormatted = startTimeFormatted.plusHours(72);
        this.endTime = endTimeFormatted + "";
    }
}
