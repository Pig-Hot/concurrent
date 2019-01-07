package com.concurrent.start.concurrent.task_execution;

import sun.misc.Request;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhuran on 2018/12/28 0028
 * 通过ExecutorService做到可关闭
 */
public class LifecycleWebServer {
    private final ExecutorService executorService = Executors.newFixedThreadPool(100);
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (!executorService.isShutdown()){
            final Socket socket = serverSocket.accept();
            executorService.execute(() -> {
                //
            });
        }
    }
    public void stop(){
        executorService.shutdown();
    }
}
