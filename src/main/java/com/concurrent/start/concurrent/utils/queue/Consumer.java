package com.concurrent.start.concurrent.utils.queue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by zhuran on 2019/1/7 0007
 */
public class Consumer implements Runnable{

    private BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
