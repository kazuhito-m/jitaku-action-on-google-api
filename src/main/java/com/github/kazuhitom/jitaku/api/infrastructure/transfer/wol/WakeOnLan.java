package com.github.kazuhitom.jitaku.api.infrastructure.transfer.wol;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class WakeOnLan {
    public void sendMagickPacket(String macAddress, String ipAddress) throws IOException {
        InetSocketAddress address = new InetSocketAddress(ipAddress, 9);
        byte[] packetByte = getMagickPacket(macAddress);
        DatagramPacket packet = new DatagramPacket(packetByte, packetByte.length, address);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);
    }

    private byte[] getMagickPacket(String macAddress) {
        byte[] macAddressByte = convertMacAddressBytes(macAddress);

        byte[] packet = new byte[102];
        int index = 0;
        for (int i = 0; i < macAddressByte.length; i++) {
            packet[index++] = (byte) 0xff;
        }

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < macAddressByte.length; j++) {
                packet[index++] = macAddressByte[j];
            }
        }

        return packet;
    }

    private byte[] convertMacAddressBytes(String macAddress) {
        String[] macArray = macAddress.split("-");
        if (macArray.length != 6) {
            throw new RuntimeException("MACアドレスが不正");
        }

        byte[] macAddressByte = new byte[6];
        for (int i = 0; i < macArray.length; i++) {
            macAddressByte[i] = (byte) Integer.parseInt(macArray[i], 16);
        }

        return macAddressByte;
    }
}
