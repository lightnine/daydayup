package com.leon.leecode;

import org.junit.Assert;
import org.junit.Test;

public class Problem771Test {
    @Test
    public void test1() {
        String J = "aA";
        String S = "aAAbbbb";
        Problem771 num = new Problem771();
        Assert.assertEquals(3, num.numJewelsInStones(J, S));
    }
    @Test
    public void test2() {
        String J = "z";
        String S = "ZZ";
        Problem771 num = new Problem771();
        Assert.assertEquals(0, num.numJewelsInStones(J, S));
    }
}