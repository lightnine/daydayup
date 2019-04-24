package com.leon.leecode;

import org.junit.Assert;
import org.junit.Test;

public class Problem13Test {

    @Test
    public void testIII() {
        String s = "III";
        Problem13 num = new Problem13();
        Assert.assertEquals(3, num.romanToInt(s));
    }

    @Test
    public void testIV() {
        String s = "IV";
        Problem13 num = new Problem13();
        Assert.assertEquals(4, num.romanToInt(s));
    }

    @Test
    public void testIX() {
        String s = "IX";
        Problem13 num = new Problem13();
        Assert.assertEquals(9, num.romanToInt(s));
    }

    @Test
    public void testLVIII() {
        String s = "LVIII";
        Problem13 num = new Problem13();
        Assert.assertEquals(58, num.romanToInt(s));
    }

    @Test
    public void testMCMXCIV() {
        String s = "MCMXCIV";
        Problem13 num = new Problem13();
        Assert.assertEquals(1994, num.romanToInt(s));
    }

    @Test
    public void testMMDCLVI() {
        String s = "MMDCLVI";
        Problem13 num = new Problem13();
        Assert.assertEquals(2656, num.romanToInt(s));
    }

    @Test
    public void testMCDLXXVI() {
        String s = "MCDLXXVI";
        Problem13 num = new Problem13();
        Assert.assertEquals(1476, num.romanToInt(s));
    }
}