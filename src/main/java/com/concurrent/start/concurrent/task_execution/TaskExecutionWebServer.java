package com.concurrent.start.concurrent.task_execution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by zhuran on 2018/12/28 0028
 * 使用Execute框架将任务提交与执行解耦
 * 无论何时看到一个new Thread(new Runnable).start()都考虑替换Execute
 */
public class TaskExecutionWebServer {
    private static final int NTHREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true){
            final Socket socket = serverSocket.accept();
            Runnable task = () -> {
                //handleRequest(socket)
            };
            exec.execute(task);
        }
    }
}
