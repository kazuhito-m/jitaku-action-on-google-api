package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment;

import com.github.kazuhitom.jitaku.api.domain.model.action.Trait;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request.FulfillmentRequest;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request.Input;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.FulfillmentResponse;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.execute.Command;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.execute.ExecutePayload;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.execute.States;
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
            case EXECUTE -> execute(request.requestId(), input);
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
                                        List.of(Trait.OnOff),
                                        new Name("PC Switch"),
                                        true,
                                        new DeviceInfo(
                                                "kazuhito_m",
                                                "pc",
                                                "??????????????????????????????????????????????????????????????????"

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

    private FulfillmentResponse execute(String requestId, Input input) {
        return new FulfillmentResponse(
                requestId,
                new ExecutePayload(
                        List.of(
                                new Command(
                                        List.of(input.payload().commands().get(0).devices().get(0).id()),
                                        "SUCCESS",
                                        new States(true, true)
                                )
                        )
                )
        );
    }
}


