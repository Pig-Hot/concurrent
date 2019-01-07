package com.concurrent.start.concurrent.utils.queue;

import javax.annotation.security.RunAs;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zhuran on 2019/1/7 0007
 */
public class Producer implements Runnable {

    private BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put(1);
            Thread.sleep(1000);
            queue.put(2);
            Thread.sleep(1000);
            queue.put(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
