package com.example.demo.POJO.FinalResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class data {
    List<FinalTimeLines> timelines;
}
