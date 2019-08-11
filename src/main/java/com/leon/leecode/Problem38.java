package com.leon.leecode;

/**
 * https://leetcode.com/problems/count-and-say/
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 * @author leon
 * @since 2019/8/10 16:43
 */
public class Problem38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String preStr = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        char previous = preStr.charAt(0);
        int num = 1;
        for (int i = 1; i < preStr.length(); i++) {
            char cur = preStr.charAt(i);
            if (cur == previous) {
                num++;
            } else {
                result.append(num).append(previous);
                previous = cur;
                num = 1;
            }
        }
        result.append(num).append(previous);
        return result.toString();
    }

    public static void main(String[] args) {
        Problem38 problem38 = new Problem38();
        System.out.println(problem38.countAndSay(2));
    }
}
