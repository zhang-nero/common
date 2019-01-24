package com.nero.common;

/**
 * 字符处理工具
 * @author Nero
 * @since 2019-01-24 11:05
 */
public class CharUtils {

    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * 将byte数组转换成16进制字符串
     * @param bytes
     * @return
     */
    public static String bytes2HexString(byte[] bytes) {
        char[] chars = new char[bytes.length*2];
        int index = 0;
        for (byte b: bytes){
            chars[index++] = HEX_CHAR[(b>>4)&0xF];
            chars[index++] = HEX_CHAR[b&0xF];
        }
        return new String(chars);
    }

    /**
     * 将16进制字符串转换成byte数组
     * @param hexString
     * @return
     */
    public static byte[] hexString2Bytes(String hexString) {
        int length = hexString.length();
        if ((length & 1) != 0){
            throw new RuntimeException("Hex string length is odd.");
        }
        byte[] bytes = new byte[length/2];
        for (int i=0; i<length/2; i++){
            String subString = hexString.substring(i*2, (i+1)*2);
            bytes[i] = (byte) Integer.parseInt(subString, 16);
        }
        return bytes;
    }
}
