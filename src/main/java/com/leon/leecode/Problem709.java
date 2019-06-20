package com.leon.leecode;

/**
 * @author leon
 * @since 2019/6/15 13:27
 * https://leetcode.com/problems/to-lower-case/
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 *
 *
 * Example 1:
 *
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 *
 * Input: "here"
 * Output: "here"
 * Example 3:
 *
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class Problem709 {
    public String toLowerCase(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if ('A' <= a[i] && a[i] <= 'Z') {
                a[i] = (char)(a[i] - 'A' + 'a');
            }
        }
        return new String(a);
    }
}
