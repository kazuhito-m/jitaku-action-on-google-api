package com.github.kazuhitom.jitaku.api.domain.model.wol;

public interface WakeOnLanRepository {
    void sendOf(MagicPacket magicPacket);
}
