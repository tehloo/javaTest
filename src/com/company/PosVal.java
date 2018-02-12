package com.company;

import javafx.geometry.Pos;

import java.util.Arrays;

public class PosVal {
    byte[] fullMark;


    public PosVal() {
        fullMark = new byte[6250];
        Arrays.fill(fullMark, (byte) 0x00);
    }

    public void markIt(int i) {
        int bytePos = i / 8;
        int byteRest = i % 8;
        byte b = (byte) (1 << byteRest);
        fullMark[bytePos] |= b;
    }

    public String dump() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            byte b = fullMark[i];
            sb.append(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));

            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return new String(fullMark, 0, fullMark.length);
    }
}
