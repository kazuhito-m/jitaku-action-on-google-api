package com.github.kazuhitom.jitaku.api.domain.model.wol;

public class MagicPacket {
    private final MacAddress macAddress;

    private static final int REPEAT_COUNT_OF_MAC_ADDRESS = 16;

    public MagicPacket(MacAddress macAddress) {
        this.macAddress = macAddress;
    }
}
