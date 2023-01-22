package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment;

import com.github.kazuhitom.jitaku.api.domain.model.action.Intent;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request.FulfillmentRequest;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request.Input;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.FulfillmentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fulfillment")
public class FulfillmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FulfillmentController.class);

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FulfillmentResponse fulfillment(@RequestBody FulfillmentRequest request) {
        LOGGER.info("request:{}", request);
        return new FulfillmentResponse(
                request.requestId(),
                List.of(new Input(Intent.SYNC)),
                null
        );
    }
}
