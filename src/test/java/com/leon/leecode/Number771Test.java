package com.leon.leecode;

import org.junit.Assert;
import org.junit.Test;

public class Number771Test {
    @Test
    public void test1() {
        String J = "aA";
        String S = "aAAbbbb";
        Number771 num = new Number771();
        Assert.assertEquals(3, num.numJewelsInStones(J, S));
    }
    @Test
    public void test2() {
        String J = "z";
        String S = "ZZ";
        Number771 num = new Number771();
        Assert.assertEquals(0, num.numJewelsInStones(J, S));
    }
}