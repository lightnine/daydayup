package com.leon.leecode;

import java.util.Stack;

/**
 * @Author leon
 * @Date 2019/4/24 23:04
 * https://leetcode.com/problems/remove-outermost-parentheses/
 * Remove Outermost Parentheses
 */
public class Problem1021 {
    public String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < S.length(); ) {
            int num_left = 0;
            for (int j = i; ; j++) {
                if (S.charAt(j) == '(') {
                    num_left++;
                } else {
                    num_left--;
                }
                if (num_left == 0) {
                    result.append(S, i+1, j);
                    i = j + 1;
                    break;
                }
            }
        }
        return result.toString();
    }
//    public String removeOuterParentheses(String S) {
//        StringBuilder s = new StringBuilder();
//        int opened = 0;
//        for (char c : S.toCharArray()) {
//            if (c == '(' && opened++ > 0) {
//                s.append(c);
//            }
//            if (c == ')' && opened-- > 1) {
//                s.append(c);
//            }
//        }
//        return s.toString();
//    }
}
