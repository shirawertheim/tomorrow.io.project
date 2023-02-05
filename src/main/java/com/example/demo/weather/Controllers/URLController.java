package com.example.demo.weather.Controllers;

import com.example.demo.weather.Services.RequestService;
import com.example.demo.weather.Services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
//@RequestMapping()
public class URLController {

    RequestService requestService;
    ResponseService responseService;

    @Autowired
    public URLController(RequestService requestService, ResponseService responseService) {
        this.requestService = requestService;
        this.responseService = responseService;
    }

    @GetMapping("weather-conditions")
    public void handleURL(@RequestParam Map<String, String> queryParams) throws IOException {


        String request = requestService.initialize(queryParams);
        responseService.initialize(request);






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
