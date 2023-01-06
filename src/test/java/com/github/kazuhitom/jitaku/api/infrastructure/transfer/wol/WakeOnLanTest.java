package com.github.kazuhitom.jitaku.api.infrastructure.transfer.wol;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class WakeOnLanTest {
    @Test
    void 指定したMacアドレスにマジックパケットを送ることができる() throws IOException {
        WakeOnLan sut = new WakeOnLan();

        sut.sendMagickPacket("AA-AA-AA-AA-AA-AA", "192.168.1.255");
    }
}