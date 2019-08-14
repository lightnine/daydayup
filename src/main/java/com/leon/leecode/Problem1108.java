package com.leon.leecode;

/**
 * https://leetcode.com/problems/defanging-an-ip-address/
 * 1108. Defanging an IP Address
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 *
 * A defanged IP address replaces every period "." with "[.]".
 *
 *
 *
 * Example 1:
 *
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * Example 2:
 *
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 *
 *
 * Constraints:
 *
 * The given address is a valid IPv4 address.
 * @author leon
 * @since 2019/8/13 19:12
 */
public class Problem1108 {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "\\[\\.\\]");
    }

    public static void main(String[] args) {
        Problem1108 problem1108 = new Problem1108();
        System.out.println(problem1108.defangIPaddr("1.1.1.1"));
    }
}
