package com.leon.niostudy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author leon
 * @date 2019/3/27
 */
public class NioClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 9999);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        // 发送hello,server到socket
        os.write("Hello, Server!\0".getBytes());

        // 读取服务端发来的数据
        int b;
        while ((b = is.read()) != 0) {
            System.out.println((char)b);
        }
        System.out.println();
        socket.close();
    }

}
