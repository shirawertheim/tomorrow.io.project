package com.example.demo.pojo.FinalResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalTimeline {
    String startTime;
    String endTime;
    boolean condition_met;
}
