package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public record Payload(
        @JsonInclude(JsonInclude.Include.NON_NULL)
        List<Device> devices,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        List<Command> commands
) {
}
