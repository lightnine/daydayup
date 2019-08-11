package com.leon.leecode;

import org.junit.Assert;
import org.junit.Test;

public class Problem38Test {
    @Test
    public void test3() {
        int num = 3;
        Problem38 problem38 = new Problem38();
        Assert.assertEquals("21", problem38.countAndSay(num));
    }

    @Test
    public void test4() {
        int num = 4;
        Problem38 problem38 = new Problem38();
        Assert.assertEquals("1211", problem38.countAndSay(num));
    }

    @Test
    public void test5() {
        int num = 5;
        Problem38 problem38 = new Problem38();
        Assert.assertEquals("111221", problem38.countAndSay(num));
    }
}