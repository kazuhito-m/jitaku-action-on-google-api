package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public record FulfillmentRequest(
        String requestId,
        List<Input> inputs
) {
}
