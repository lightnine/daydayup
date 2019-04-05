package com.leon.niostudy;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @author leon
 * @date 2019/3/25
 */
public class Test1 {
    private static void remainDemo() {
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e'};
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        System.out.println("A capacity()=" + charBuffer.capacity() + " limit=" + charBuffer.limit() + " position=" + charBuffer.position());
        charBuffer.position(2);
//        charBuffer.limit(2);
        System.out.println("B capacity()=" + charBuffer.capacity() + " limit=" + charBuffer.limit() + " position=" + charBuffer.position());
        System.out.println("C remain=" + charBuffer.remaining());
        for (int i = 0; i < 5; i++) {
            System.out.println("i:" + charBuffer.get(i));
        }
    }
    public static void main(String[] args) {
//        byte[] bytes = new byte[]{1, 2, 3};
//        char[] chars = new char[]{'a', 'b', 'c', 'd'};
//
//        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
//        CharBuffer charBuffer = CharBuffer.wrap(chars);
//        System.out.println("byteBuffer=" + byteBuffer.getClass().getName());
//        System.out.println("charBuffer=" + charBuffer.getClass().getName());
//
//        System.out.println("byteBuffer capacity=" + byteBuffer.capacity());
//        System.out.println("charBuffer capacity=" + charBuffer.capacity());
        Test1.remainDemo();
    }


}
