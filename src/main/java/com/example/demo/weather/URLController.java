package com.example.demo.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class URLController {

    URLBuilder urlBuilder = new URLBuilder();

    @Autowired
    public URLController(URLBuilder urlBuilder) {
        this.urlBuilder = urlBuilder;
    }

    @GetMapping()
    public void getStudents() throws IOException {
//        return studentService.getStudents();
        System.out.println("URLController");
        urlBuilder.initialize();
    }










}
