package project.Controllers;

import project.POJO.LoggerHelper;
import project.Services.RequestService;
import project.POJO.RequestEntity.RequestEntity;
import project.Services.ResponseHandlerService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class URLController {

    RequestService requestService;
    ResponseHandlerService responseHandlerService;
    private Logger logger = LoggerHelper.logger;


    @Autowired
    public URLController(RequestService requestService, ResponseHandlerService responseHandlerService) {
        this.requestService = requestService;
        this.responseHandlerService = responseHandlerService;
    }

    @GetMapping("weather-conditions")
    public String handleURL(@RequestParam Map<String, String> queryParams) throws IOException {

        logger.info("");
        logger.info("************Application started************");
        RequestEntity requestEntity = requestService.initialize(queryParams);
        String response = responseHandlerService.initialize(requestEntity);
        return response;

    }











}
