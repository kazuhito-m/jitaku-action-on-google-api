package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request;

public record Execution(
        Command command,
        Params params
) {
}
