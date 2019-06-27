package com.leon.iodemo;

import java.io.File;

/**
 * @author leon
 * @since 2019/6/20 18:39
 */
public class Demo1 {
    public static void main(String[] args) {
        String str = "C://a";
        File file = new File(str);
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.lastModified());
    }
}
