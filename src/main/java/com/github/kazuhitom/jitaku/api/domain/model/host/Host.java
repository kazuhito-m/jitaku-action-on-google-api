package com.github.kazuhitom.jitaku.api.domain.model.host;

import com.github.kazuhitom.jitaku.api.domain.model.wol.MacAddress;

public class Host {
    private final String name;
    private final MacAddress macAddress;
    private final String hostNameOrIpAddress;
    private final String description;

    public Host(String name, MacAddress macAddress, String hostNameOrIpAddress, String description) {
        this.name = name;
        this.macAddress = macAddress;
        this.hostNameOrIpAddress = hostNameOrIpAddress;
        this.description = description;
    }
}
