package com.leon.httpClientDemo;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author leon
 * @since 2019/6/27 16:55
 * 当前包工具类
 */
public class httpClientUtil {
    public static void closeIgnoringIOException(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                System.out.println("关闭" + c + "出错, 忽略此异常");
            }
        }
    }
}
