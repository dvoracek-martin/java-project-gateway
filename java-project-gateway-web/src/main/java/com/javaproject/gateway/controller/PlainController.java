package com.javaproject.gateway.controller;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class PlainController {

    private static final Logger logger = Logger.getLogger(TimeController.class);

    @RequestMapping(method = RequestMethod.GET)
    String getTime() {
        logger.info("Application received " + RequestMethod.GET + " request on url: /");
        String response = new JSONObject()
                .put("NECO", "NECO")
                .toString();
        return response;
    }
}
