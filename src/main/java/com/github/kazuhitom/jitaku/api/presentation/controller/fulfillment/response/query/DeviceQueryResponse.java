package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.query;

public record DeviceQueryResponse(
        String status,
        boolean online,
        boolean on
) {
}
