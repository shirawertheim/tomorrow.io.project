package com.example.demo.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DataRoot {
    List<Timelines> timelines;
}
