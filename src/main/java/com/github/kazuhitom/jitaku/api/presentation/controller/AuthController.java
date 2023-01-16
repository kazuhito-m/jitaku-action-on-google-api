package com.github.kazuhitom.jitaku.api.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String issuanceAuthorizationGrant(@RequestParam("redirect_uri") URI redirectUrl,
                                             @RequestParam("state") String state) {
        URI fixedUri = UriComponentsBuilder.fromUri(redirectUrl)
                .queryParam("code", "1234567890")
                .queryParam("state", state)
                .build()
                .toUri();
        String template = "<HTML><BODY><A HREF='%s'>%s</A></BODY></HTML>";
        return String.format(template, fixedUri, fixedUri);
    }
}
