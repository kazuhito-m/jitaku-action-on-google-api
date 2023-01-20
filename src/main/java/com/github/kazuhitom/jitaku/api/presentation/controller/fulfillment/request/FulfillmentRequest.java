package com.github.kazuhitom.jitaku.api.presentation.controller.fulfillment.request;

import java.util.List;

public record FulfillmentRequest (
     String requestId,
     List<InputRequest> inputs
) {}
