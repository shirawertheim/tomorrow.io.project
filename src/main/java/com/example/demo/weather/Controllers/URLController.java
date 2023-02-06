package com.example.demo.weather.Controllers;

import com.example.demo.pojo.RequestEntity.RequestEntity;
import com.example.demo.weather.Services.RequestService;
import com.example.demo.weather.Services.ResponseHandlerService;
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





//        return studentService.getStudents();
//        System.out.println("URLController");
//        String url = urlBuilderService.initialize();
//        System.out.println("Response Service");
//        ResponseService responseService = new ResponseService();
//        responseService.mainFunc(url);
    }


//    @GetMapping("GET/{path}")
//    public void getPath(@PathVariable String path, HttpServletRequest request) {
//        String fullPath = request.getRequestURI();
//        System.out.println("The requested path is: " + fullPath + " and the path variable is: " + path);
//    }










}
