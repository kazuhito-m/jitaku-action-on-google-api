package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.response.execute;

import java.util.List;

public record Command(
        List<String> ids,
        String status,
        States states

) {
}
