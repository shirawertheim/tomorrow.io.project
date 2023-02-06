package com.example.demo.POJO.FinalResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalTimeLines {
    String startTime;
    String endTime;
    boolean condition_met;
}
