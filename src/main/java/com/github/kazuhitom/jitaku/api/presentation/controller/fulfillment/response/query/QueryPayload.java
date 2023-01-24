package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.query;

import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.Payload;

import java.util.Map;

public record QueryPayload(
        Map<String, DeviceQueryResponse> devices
) implements Payload {
}
