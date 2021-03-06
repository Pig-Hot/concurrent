package com.concurrent.start.concurrent.utils.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zhuran on 2019/1/7 0007
 */
public class ArrayBlockQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(1024);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
        Thread.sleep(4000);
    }
}
