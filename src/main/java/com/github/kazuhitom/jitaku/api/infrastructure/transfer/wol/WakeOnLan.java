package com.github.kazuhitom.jitaku.api.infrastructure.transfer.wol;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class WakeOnLan {
    private static final int OCTET_LENGTH_OF_MAC_ADDRESS = 6;
    private static final String DEFAULT_MAC_ADDRESS_SEPARATOR = ":";

    public void sendMagickPacket(String macAddress, String ipAddress) throws IOException {
        InetSocketAddress address = new InetSocketAddress(ipAddress, 9);
        byte[] packetBytes = generateMagickPacket(macAddress);
        DatagramPacket packet = new DatagramPacket(packetBytes, packetBytes.length, address);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);
    }

    private byte[] generateMagickPacket(String macAddress) {
        byte[] macAddressBytes = convertMacAddressBytes(macAddress);

        byte[] packet = new byte[102];
        int index = 0;
        for (int i = 0; i < macAddressBytes.length; i++) {
            packet[index++] = (byte) 0xff;
        }

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < macAddressBytes.length; j++) {
                packet[index++] = macAddressBytes[j];
            }
        }

        return packet;
    }

    private byte[] convertMacAddressBytes(String macAddress) {
        String[] macArray = macAddress.split(DEFAULT_MAC_ADDRESS_SEPARATOR);
        if (macArray.length != OCTET_LENGTH_OF_MAC_ADDRESS)
            throw new RuntimeException("MACアドレスが不正");

        byte[] macAddressByte = new byte[macArray.length];
        for (int i = 0; i < macArray.length; i++) {
            macAddressByte[i] = (byte) Integer.parseInt(macArray[i], 16);
        }

        return macAddressByte;
    }
}
