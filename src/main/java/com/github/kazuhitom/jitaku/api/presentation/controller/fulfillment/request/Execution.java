package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request;

public record Execution(
        String command,
        Params params
) {
}
