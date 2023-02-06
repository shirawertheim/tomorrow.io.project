package com.example.demo.Controllers;

import com.example.demo.POJO.RequestEntity.RequestEntity;
import com.example.demo.Services.RequestService;
import com.example.demo.Services.ResponseHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
//@RequestMapping()
public class URLController {

    RequestService requestService;
    ResponseHandlerService responseHandlerService;

    @Autowired
    public URLController(RequestService requestService, ResponseHandlerService responseHandlerService) {
        this.requestService = requestService;
        this.responseHandlerService = responseHandlerService;
    }

    @GetMapping("weather-conditions")
    public String handleURL(@RequestParam Map<String, String> queryParams) throws IOException {

        RequestEntity requestEntity = requestService.initialize(queryParams);
        String response = responseHandlerService.initialize(requestEntity);
        return response;

    }











}
