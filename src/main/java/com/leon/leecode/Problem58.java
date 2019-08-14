package com.leon.leecode;

/**
 * https://leetcode.com/problems/length-of-last-word/
 * 58. Length of Last Word
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 * @author leon
 * @since 2019/8/13 19:19
 */
public class Problem58 {
    public int lengthOfLastWord(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }

    public static void main(String[] args) {
        Problem58 problem58 = new Problem58();
        String s = "   ";
        System.out.println(problem58.lengthOfLastWord(s));
    }
}
