package com.leon.leecode;

/**
 * @author leon
 * @since 2019/6/22 14:20
 * https://leetcode.com/problems/jump-game/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 */
public class Problem55 {
    public boolean canJump(int[] nums) {
        int maxRight = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxRight) {
                return false;
            }
            maxRight = maxRight > (nums[i] + i) ? maxRight : nums[i] + i;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
