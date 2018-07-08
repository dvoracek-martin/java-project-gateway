package com.javaproject.gateway.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api/time")
public class TimeController {

    private final String V1 = "/v1";
    private final String TIME_PROVIDER_URL = "http://java-project.default.svc.cluster.local";
    private final String TIME_PROVIDER_PORT = "90";

    private static final Logger logger = Logger.getLogger(TimeController.class);


    @RequestMapping(value = V1, method = RequestMethod.GET)
    public String getTime(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.info("Application received " + RequestMethod.GET + " request on url: /api/time/v1");
        RestTemplate restTemplate = new RestTemplate();
        String result;
        try {
            result = restTemplate.getForObject(TIME_PROVIDER_URL + ":" + TIME_PROVIDER_PORT + "/", String.class);
        } catch (Exception e) {
            logger.error("URL " + TIME_PROVIDER_URL + ":" + TIME_PROVIDER_PORT + "not found.\n" + e.getStackTrace());
            httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        return result;
    }
}

