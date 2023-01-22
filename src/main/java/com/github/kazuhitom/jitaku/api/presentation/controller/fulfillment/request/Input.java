package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.kazuhitom.jitaku.api.domain.model.action.Intent;

public record Input(
        Intent intent,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Payload payload
) {
}
