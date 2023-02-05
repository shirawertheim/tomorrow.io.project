package com.example.demo.pojo.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Timelines {
    String timestep;
    String endTime;
    String startTime;
    List<Intervals> intervals;
}
