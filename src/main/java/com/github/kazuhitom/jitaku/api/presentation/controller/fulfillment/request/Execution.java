package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request;

import com.github.kazuhitom.jitaku.api.domain.model.action.CommandType;

public record Execution(
        CommandType command,
        Params params
) {
}
