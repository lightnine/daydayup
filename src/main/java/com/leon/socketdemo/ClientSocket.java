package com.leon.socketdemo;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * client socket demo
 * @author leon
 * @date 2019/3/21
 */
public class ClientSocket {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8919;
        try {
            Socket client = new Socket(host, port);
            Writer writer = new OutputStreamWriter(client.getOutputStream());
            writer.write("Hello From Client");
            writer.flush();
            writer.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
