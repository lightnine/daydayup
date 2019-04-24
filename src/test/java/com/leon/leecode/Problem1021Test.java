package com.leon.leecode;

import org.junit.Assert;
import org.junit.Test;

public class Problem1021Test {
    @Test
    public void test1() {
        String S = "(()())(())";
        Problem1021 solution = new Problem1021();
        Assert.assertEquals("()()()", solution.removeOuterParentheses(S));
    }

    @Test
    public void test2() {
        String S = "(()())(())(()(()))";
        Problem1021 solution = new Problem1021();
        Assert.assertEquals("()()()()(())", solution.removeOuterParentheses(S));
    }

    @Test
    public void test3() {
        String S = "()()";
        Problem1021 solution = new Problem1021();
        Assert.assertEquals("", solution.removeOuterParentheses(S));
    }

}