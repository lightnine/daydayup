package com.leon.leecode;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Problem66Test {

    @Test
    public void plusOneCase1() {
        Problem66 problem66 = new Problem66();
        int[] digits = new int[] {1,2,3};
        Assert.assertThat(1, is(problem66.plusOne(digits)[0]));
    }
}