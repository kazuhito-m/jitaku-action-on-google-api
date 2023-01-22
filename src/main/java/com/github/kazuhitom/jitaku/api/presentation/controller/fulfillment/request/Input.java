package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request;

import com.github.kazuhitom.jitaku.api.domain.model.action.Intent;

public record Input(
        Intent intent
) {
}
