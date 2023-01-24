package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment;

import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request.FulfillmentRequest;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request.Input;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.FulfillmentResponse;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.query.DeviceQueryResponse;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.query.QueryPayload;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.sync.Device;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.sync.DeviceInfo;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.sync.Name;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.sync.SyncPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fulfillment")
public class FulfillmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FulfillmentController.class);

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FulfillmentResponse fulfillment(@RequestBody FulfillmentRequest request) {
        LOGGER.info("request:{}", request);
        Input input = request.inputs().get(0);
        return switch (input.intent()) {
            case SYNC -> sync(request.requestId());
            case QUERY -> query(request.requestId(), input);
            case EXECUTE -> null;
            default -> throw new IllegalStateException("Illegal intent type.");
        };
    }

    private FulfillmentResponse sync(String requestId) {
        return new FulfillmentResponse(
                requestId,
                new SyncPayload(
                        "user123",
                        List.of(
                                new Device(
                                        "123",
                                        "action.devices.types.SWITCH",
                                        List.of("action.devices.traits.OnOff"),
                                        new Name("PC Switch"),
                                        true,
                                        new DeviceInfo(
                                                "kazuhito_m",
                                                "pc",
                                                "説明のところ、日本語入れといてもいけるかな？"

                                        )
                                )
                        )
                )
        );
    }

    private FulfillmentResponse query(String requestId, Input input) {
        return new FulfillmentResponse(
                requestId,
                new QueryPayload(
                        Map.of(
                                input.payload().devices().get(0).id(),
                                new DeviceQueryResponse(
                                        "SUCCESS",
                                        true,
                                        true
                                )
                        )
                )
        );
    }
}


