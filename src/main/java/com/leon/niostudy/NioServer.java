package com.leon.niostudy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author leon
 * @date 2019/3/27
 */
public class NioServer {
    public static void main(String[] args) throws IOException {
        // 定义一个selector
        Selector selector = Selector.open();
        // define socketChannel
        ServerSocketChannel listenChannel = ServerSocketChannel.open();

        listenChannel.bind(new InetSocketAddress(9999));
        // 配置channel为非阻塞
        listenChannel.configureBlocking(false);
        // 将channel注册到selector上，并且监听accept事件
        listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer buffer = ByteBuffer.allocate(100);

        while (true) {
            // 选择准备好事件的key
            selector.select();
            Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();

            while (keyIter.hasNext()) {
                SelectionKey key = keyIter.next();
                if (key.isAcceptable()) {
                    SocketChannel channel = ((ServerSocketChannel) key.channel()).accept();
                    channel.configureBlocking(false);
                    // 再次注册read事件
                    channel.register(selector, SelectionKey.OP_READ);
                    System.out.println("connect：" + channel.getRemoteAddress());
                } else if (key.isReadable()) {
                    buffer.clear();
                    if (((SocketChannel) key.channel()).read(buffer) == -1) {
                        key.channel().close();
                        continue;
                    }
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        byte b = buffer.get();
                        // 用0表示终止
                        if (b == 0) {
                            System.out.println();
                            buffer.clear();
                            // buffer中写入Hello,Client!\0
                            buffer.put("Hello, Client!\0".getBytes());
                            buffer.flip();
                            while (buffer.hasRemaining()) {
                                ((SocketChannel) key.channel()).write(buffer);
                            }
                        } else {
                            System.out.println((char) b);
                        }
                    }
                }
                // 处理完这个事件后，移除
                keyIter.remove();
            }
        }
    }
}
