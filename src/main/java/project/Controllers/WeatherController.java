package project.Controllers;

import project.POJO.LoggerHelper;
import project.POJO.ResponseAPIEntity.ResponseAPIHolder;
import project.Services.RequestService;
import project.POJO.RequestEntity.RequestEntity;
import project.Services.ResponseBuilderService;
import project.Services.ResponseHandlerService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class WeatherController {

    RequestService requestService;
    ResponseHandlerService responseHandlerService;
    ResponseBuilderService responseBuilderService;
    private Logger logger = LoggerHelper.logger;


    @Autowired
    public WeatherController(RequestService requestService, ResponseHandlerService responseHandlerService, ResponseBuilderService responseBuilderService) {
        this.requestService = requestService;
        this.responseHandlerService = responseHandlerService;
        this.responseBuilderService = responseBuilderService;
    }

    @GetMapping("weather-conditions")
    public String handleURL(@RequestParam Map<String, String> queryParams) throws IOException {

        logger.info("");
        logger.info("************ Application started ************");
        RequestEntity requestEntity = requestService.initialize(queryParams);
        ResponseAPIHolder responseAPIHolder = responseHandlerService.initialize(requestEntity);
        String response = responseBuilderService.initialize(responseAPIHolder);
        return response;

    }











}
