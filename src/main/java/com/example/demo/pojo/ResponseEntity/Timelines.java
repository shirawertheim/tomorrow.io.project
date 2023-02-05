package com.example.demo.pojo.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Timelines {
    String timestep;
    String endTime;
    String startTime;
    List<Intervals> intervals;
}
