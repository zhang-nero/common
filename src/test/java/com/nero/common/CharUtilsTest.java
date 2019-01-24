package com.nero.common;

import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

/**
 * @author Nero
 * @since 2019-01-24 11:12
 */
public class CharUtilsTest {
    @Test
    public void test(){
        String string = "aaaa";
        byte[] originBytes = string.getBytes(StandardCharsets.UTF_8);
        String hexString = CharUtils.bytes2HexString(originBytes);
        byte[] convertedBytes = CharUtils.hexString2Bytes(hexString);
        String convertedString = new String(convertedBytes);
        Assert.assertEquals(string, convertedString);
        Assert.assertArrayEquals(originBytes, convertedBytes);
    }
}