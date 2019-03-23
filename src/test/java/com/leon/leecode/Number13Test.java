package com.leon.leecode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Number13Test {

    @Test
    public void testIII() {
        String s = "III";
        Number13 num = new Number13();
        Assert.assertEquals(3, num.romanToInt(s));
    }

    @Test
    public void testIV() {
        String s = "IV";
        Number13 num = new Number13();
        Assert.assertEquals(4, num.romanToInt(s));
    }

    @Test
    public void testIX() {
        String s = "IX";
        Number13 num = new Number13();
        Assert.assertEquals(9, num.romanToInt(s));
    }

    @Test
    public void testLVIII() {
        String s = "LVIII";
        Number13 num = new Number13();
        Assert.assertEquals(58, num.romanToInt(s));
    }

    @Test
    public void testMCMXCIV() {
        String s = "MCMXCIV";
        Number13 num = new Number13();
        Assert.assertEquals(1994, num.romanToInt(s));
    }

    @Test
    public void testMMDCLVI() {
        String s = "MMDCLVI";
        Number13 num = new Number13();
        Assert.assertEquals(2656, num.romanToInt(s));
    }

    @Test
    public void testMCDLXXVI() {
        String s = "MCDLXXVI";
        Number13 num = new Number13();
        Assert.assertEquals(1476, num.romanToInt(s));
    }
}