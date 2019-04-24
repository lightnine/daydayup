package com.leon.leecode;

/**
 * @Author leon
 * @Date 2019/4/24 23:04
 * https://leetcode.com/problems/remove-outermost-parentheses/
 * Remove Outermost Parentheses
 */
public class Problem1021 {
    public String removeOuterParentheses(String S) {
        String result = "";
        for (int i = 0; i < S.length(); ) {
            int num_left = 0;
            for (int j = i; ; j++) {
                if (S.charAt(j) == '(') {
                    num_left++;
                } else {
                    num_left--;
                }
                if (num_left == 0) {
                    result += S.substring(i+1, j);
                    i = j + 1;
                    break;
                }
            }
        }
        return result;
    }
}
