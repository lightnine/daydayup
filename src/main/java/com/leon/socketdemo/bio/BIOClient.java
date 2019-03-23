package com.leon.socketdemo.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

/**
 * BIO client
 * @author leon
 * @date 2019/3/21
 */
public class BIOClient {
    private static int PORT = 9090;
    private static String IP_ADDRESS = "127.0.0.1";

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            clientReq(i);
        }
    }

    private static void clientReq(int i) {
        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            // get socket data
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // send socket data
            writer = new PrintWriter(socket.getOutputStream(), true);
            // prepare send data
            String[] operators = {"+", "-", "*", "/"};
            Random random = new Random(System.currentTimeMillis());
            String expression = random.nextInt(10) + operators[random.nextInt(4)] + (random.nextInt(10) + 1);
            System.out.println("client send data: " + expression);
            // must use println or (print + "\n" and flush()) , must need enter indicate the line is end
            writer.println(expression);
//            writer.print(expression + "\n");
//            writer.flush();
            System.out.println(i + " client accept data: " + reader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader) {
                    reader.close();
                }
                if (null != socket) {
                    socket.close();
                    socket = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
