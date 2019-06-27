package com.leon.leecode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem55Test {
    private Problem55 problem55;
    @Before
    public void problem55() {
        problem55 = new Problem55();
    }
    @Test
    public void test1() {
        int[] nums = new int[] {3,2,1,0,4};
        Assert.assertEquals(false, problem55.canJump(nums));
    }
}