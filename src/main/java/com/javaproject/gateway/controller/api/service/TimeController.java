package com.javaproject.gateway.controller.api.service;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;
import java.util.Locale;

@RestController
@RequestMapping(value = "/api/time")
public class TimeController {

    @Autowired
    private MessageSource messageSource;

    private static final String ROOT_URL = "/api/time";
    private static final String V1 = "/v1";

    private static final Logger logger = Logger.getLogger(TimeController.class);

    @RequestMapping(value = V1, method = RequestMethod.GET)
    public String getTime(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.info("Application "
                + messageSource.getMessage("app.name", null, Locale.getDefault())
                + " received " + RequestMethod.GET + "request on url:" + ROOT_URL + V1);
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        String response = new JSONObject()
                .put("time", String.valueOf(LocalTime.now()))
                .put("pod", System.getenv("HOSTNAME"))
                .toString();
        return response;
    }
}

