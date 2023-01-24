package com.github.kazuhitom.jitaku.api.domain.model.action;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Trait {
    OnOff;

    @JsonValue
    @Override
    public String toString() {
        return "action.devices.traits." + super.name();
    }

    @JsonCreator
    public static Intent of(String value) {
        return Arrays.stream(Intent.values())
                .filter(i -> i.toString().equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }
}
