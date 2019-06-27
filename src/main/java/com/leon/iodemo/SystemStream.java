package com.leon.iodemo;

import java.io.*;

/**
 * @author leon
 * @since 2019/6/26 17:21
 * 改变System中out指向
 */
public class SystemStream {
    public static void main(String[] args) throws IOException {
        OutputStream out=null;
        PrintStream printStream = null;
        try {
             out = new FileOutputStream("C:\\workspace\\新建文本文档.txt");
             printStream = new PrintStream(out);
            System.setOut(printStream);
            System.out.println("1111");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.flush();
            printStream.close();
            out.close();

        }
    }
}
