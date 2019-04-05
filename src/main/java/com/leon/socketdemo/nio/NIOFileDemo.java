package com.leon.socketdemo.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

/**
 * 采用nio进行文件读取写入操作
 * @author leon
 * @date 2019/3/25
 */
public class NIOFileDemo {
    private static void nioFile() throws IOException {
        FileChannel channel = new RandomAccessFile("1.txt", "rw").getChannel();
        // 设置channel file的位置
        channel.position(channel.size());
        // 创建ByteBuffer缓冲区,position=0 limit=capacity
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        byteBuffer.put("hello, 世界 \n".getBytes(StandardCharsets.UTF_8));

        // limit=position, position=0
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            // 将buffer中的内容写入channel中
            channel.write(byteBuffer);
        }
        // 设置channel中的位置
        channel.position(0);
        CharBuffer charBuffer = CharBuffer.allocate(10);
        CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();
        // limit=capacity, position=0
        byteBuffer.clear();
        // 将channel中的内容写入buffer中，并且将byteBuffer中的内容写入charBuffer
        while (channel.read(byteBuffer) != -1 || byteBuffer.position() > 0) {
            byteBuffer.flip();
            charBuffer.clear();
            // 将byteBuffer中的内容写入charBuffer中，
            // decode()方法第三个参数 false 的作用就是让 Decoder 把无法映射的字节及其后面的数据都视作附加数据
            decoder.decode(byteBuffer, charBuffer, false);
            System.out.println(charBuffer.flip().toString());
            // 将position与limit之间的内容拷贝到缓存的最前面，为下一次读取做准备
            byteBuffer.compact();
        }
        channel.close();
    }
    public static void main(String[] args) {
        try {
            NIOFileDemo.nioFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
