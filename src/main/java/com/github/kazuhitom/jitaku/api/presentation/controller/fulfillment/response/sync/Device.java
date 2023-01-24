package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.sync;

import com.github.kazuhitom.jitaku.api.domain.model.action.Trait;

import java.util.List;

public record Device(
        String id,
        String type,
        List<Trait> traits,
        Name name,
        boolean willReportState,
        DeviceInfo deviceInfo
) {
}
