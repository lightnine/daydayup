package com.leon.socketdemo.bio;

import com.leon.socketdemo.util.CalculatorUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author leon
 * @date 2019/3/21
 */
public class BIOServerHandler implements Runnable {
    private Socket socket;

    public BIOServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            writer = new PrintWriter(this.socket.getOutputStream(), true);
            String body = null;
            while (true) {
                body = reader.readLine();
                if (null == body) {
                    break;
                }
                System.out.println("server thread: " + Thread.currentThread());
                System.out.println("server accept data: " + body);
                writer.println(body + "=" + CalculatorUtil.cal(body).toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                writer.close();
            }
            try {
                if (null != reader) {
                    reader.close();
                }
                if (null != this.socket) {
                    this.socket.close();
                    this.socket = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
