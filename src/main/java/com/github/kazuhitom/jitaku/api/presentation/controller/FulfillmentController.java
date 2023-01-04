package com.github.kazuhitom.jitaku.api.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fulfillment")
public class FulfillmentController {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String fulfillment(@RequestParam("grant_type") String grantType) {
        return "dummy";
    }
}
