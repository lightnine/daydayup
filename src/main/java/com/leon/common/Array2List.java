package com.leon.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author leon
 * @Date 2019/6/7 17:21
 */
public class Array2List {
    public static void main(String[] args) {
        test1();
    }
    private static void test1() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String str : list) {
            if ("2".equals(str)) {
                list.remove(str);
            }
        }
        System.out.println(list.toString());
    }
}
