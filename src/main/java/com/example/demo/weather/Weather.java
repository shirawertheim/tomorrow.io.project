package com.example.demo.weather;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Weather {
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;

    public Weather(Long id, String name, String email, LocalDate dob, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }
}
