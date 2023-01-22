package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request;

import java.util.List;

public record Command(
        List<Device> devices,
        Execution execution
) {
}
