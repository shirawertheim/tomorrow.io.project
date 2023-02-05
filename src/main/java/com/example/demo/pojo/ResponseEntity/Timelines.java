package com.example.demo.pojo.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Data
@NoArgsConstructor
public class Timelines {
    String timestep;
    String endTime;
    String startTime;
    LocalDateTime endTimeFormatted;
    LocalDateTime startTimeFormatted;
    List<Intervals> intervals;


    public void updateDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        this.endTimeFormatted = LocalDateTime.parse(endTime.toString(), formatter);
        this.startTimeFormatted = LocalDateTime.parse(startTime.toString(), formatter);
    }
}
