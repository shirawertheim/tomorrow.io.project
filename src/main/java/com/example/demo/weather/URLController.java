package com.example.demo.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
//@RequestMapping(path = "/")
public class URLController {

    URLBuilderService urlBuilderService = new URLBuilderService();

    @Autowired
    public URLController(URLBuilderService urlBuilderService) {
        this.urlBuilderService = urlBuilderService;
    }

    @GetMapping("/weather-conditions")
    public void getStudents() throws IOException {
//        return studentService.getStudents();
        System.out.println("URLController");
        String url = urlBuilderService.initialize();
        System.out.println("Response Service");
        ResponseService responseService = new ResponseService();
        responseService.mainFunc(url);
    }


//    @GetMapping("GET/{path}")
//    public void getPath(@PathVariable String path, HttpServletRequest request) {
//        String fullPath = request.getRequestURI();
//        System.out.println("The requested path is: " + fullPath + " and the path variable is: " + path);
//    }










}
