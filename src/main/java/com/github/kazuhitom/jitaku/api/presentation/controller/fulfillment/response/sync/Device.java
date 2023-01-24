package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.sync;

import java.util.List;

public record Device(
        String id,
        String type,
        List<String> traits,
        Name name,
        boolean willReportState,
        DeviceInfo deviceInfo
) {
}
