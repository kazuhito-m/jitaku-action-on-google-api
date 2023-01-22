package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request.Input;
import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request.Payload;

import java.util.List;

public record FulfillmentResponse(
        String requestId,
        List<Input> inputs,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Payload payload
) {
}
