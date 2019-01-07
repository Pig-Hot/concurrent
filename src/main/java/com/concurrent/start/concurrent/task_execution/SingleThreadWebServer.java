package com.concurrent.start.concurrent.task_execution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhuran on 2018/12/28 0028
 * 这是一个不可能出现在生产环境的WevServer,因为他一次只能执行一个请求,一个Web请求包括执行运算和I/O操作
 */
public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true){
            Socket socket = serverSocket.accept();
//            handleRequest(socket);
        }
    }
}
