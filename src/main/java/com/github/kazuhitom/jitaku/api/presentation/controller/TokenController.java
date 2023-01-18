package com.github.kazuhitom.jitaku.api.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/token")
public class TokenController {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> issuanceToken(@RequestParam("grant_type") String grantType) {
        if (!List.of("authorization_code", "refresh_token").contains(grantType))
            throw new IllegalArgumentException("Unrecognized parameter value.");

        Map<String, Object> jsonParams = Map.of(
                "token_type", "Bearer",
                "access_token", "1234567890",
                "expires_in", 7776000
        );

        if (grantType.equals("refresh_token")) return jsonParams;

        Map<String, Object> extendsParams = new HashMap<>(jsonParams);
        extendsParams.put("refresh_token", "1234567890");
        return extendsParams;
    }
}
