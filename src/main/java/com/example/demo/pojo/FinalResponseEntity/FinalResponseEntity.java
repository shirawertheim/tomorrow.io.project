package com.example.demo.pojo.FinalResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalResponseEntity {
    private String status = "success";
    private data data = new data();
}
