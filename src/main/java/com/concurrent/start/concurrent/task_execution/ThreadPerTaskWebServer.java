package com.concurrent.start.concurrent.task_execution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhuran on 2018/12/28 0028
 * 主程序不断运行接收外部连接和请求,但是不同的是,主程序为每一个连接都创建了一个线程
 * 缺点:线程生命周期开销,资源消耗严重,
 */
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true){
            final Socket socket = serverSocket.accept();
            Runnable task = () -> {
                //handleRequest(socket)
            };
            new Thread(task).start();
        }
    }
}
