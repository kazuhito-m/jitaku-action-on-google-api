package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.execute;

import com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.Payload;

import java.util.List;

public record ExecutePayload(
        List<Command> commands
) implements Payload {
}
