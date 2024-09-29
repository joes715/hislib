package com.hospital.adapt.utils;

import java.util.Base64;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CodecUtil2 {
    private static Logger log = LoggerFactory.getLogger(CodecUtil2.class);

    public static String decode(String decode) {
        String result = null;

        if (Str2.notNull(decode)) {
            try {
                result = new String(Base64.getDecoder().decode(Hex.decodeHex(decode)));
            } catch (DecoderException e) {
                log.error("CodecUtil2 decode exception:", e);
            }
        }
        return result;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() < 2) {
                sb.append(0);
            }
            sb.append(hex.toUpperCase());
        }

        return sb.toString();
    }

    private static void main(String[] args) {

    }

}
