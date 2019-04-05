package com.leon.socketdemo.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * BIO socket server
 * @author leon
 * @date 2019/3/21
 */
public class BIOServer {
    private static final int PORT = 9090;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        // use thread pool, avoid thread create and destroy
        ThreadPoolExecutor executor = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("start server...");
            executor = new ThreadPoolExecutor(10, 100, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(50));
            while (true) {
                System.out.println("server while, and the server thread:" + Thread.currentThread().getName());
                socket = server.accept();
                BIOServerHandler serverHandler = new BIOServerHandler(socket);
                executor.execute(serverHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != socket) {
                    socket.close();
                    socket = null;
                }
                if (null != server) {
                    server.close();
                    server = null;
                    System.out.println("BIO Server close !!!");
                }
                if (null != executor) {
                    executor.shutdown();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
