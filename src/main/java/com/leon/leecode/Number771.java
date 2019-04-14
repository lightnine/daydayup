package com.leon.leecode;

import java.util.*;

/**
 * @Author leon
 * @Date 2019/4/14 17:00
 * You're given strings J representing the types of stones that are jewels,
 * and S representing the stones you have.  Each character in S is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
     * Example 1:
     *
     * Input: J = "aA", S = "aAAbbbb"
     * Output: 3
 *
     * Example 2:
     *
     * Input: J = "z", S = "ZZ"
     * Output: 0
 *
 * Note:
 *
 * 1. S and J will consist of letters and have length at most 50.
 * 2. The characters in J are distinct.
 */
public class Number771 {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        Set<Character> jewelSet = new HashSet<>();
        for (char c : J.toCharArray()) {
            jewelSet.add(c);
        }
        for (char stone :S.toCharArray()) {
            if (jewelSet.contains(stone)) {
                res++;
            }
        }
        return res;
    }
    // 从leetcode 讨论帖上看到的
//    public int numJewelsInStones(String J, String S) {
//        return S.replaceAll("[^" + J + "]", "").length();
//    }
}
