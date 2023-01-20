package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment;

import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request.FulfillmentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fulfillment")
public class FulfillmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FulfillmentController.class);

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String fulfillment(@RequestBody FulfillmentRequest request) {
        LOGGER.info("requestId:{}, intent:{}", request.requestId(), request.inputs().get(0).intent());
        return "{}";
    }
}
