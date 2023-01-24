package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.sync;

import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.Payload;

import java.util.List;

public record SyncPayload(
        String agentUserId,
        List<Device> devices
) implements Payload {
}
