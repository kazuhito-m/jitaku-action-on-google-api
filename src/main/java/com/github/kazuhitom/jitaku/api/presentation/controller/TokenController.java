package com.github.kazuhitom.jitaku.api.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/token")
public class TokenController {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String issuanceToken(@RequestParam("grant_type") String grantType) {
        String jsonTemplate = """
                {"token_type": "Bearer","access_token": "1234567890", "expires_in": 7776000%s}
                """;
        return switch (grantType) {
            case "authorization_code" -> String.format(jsonTemplate, ", \"refresh_token\": \"1234567890\"");
            case "refresh_token" -> String.format(jsonTemplate, "");
            default -> throw new IllegalArgumentException("Unrecognized parameter value.");
        };
    }
}
