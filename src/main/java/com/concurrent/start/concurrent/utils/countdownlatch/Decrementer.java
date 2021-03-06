package com.concurrent.start.concurrent.utils.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhuran on 2019/1/7 0007
 */
public class Decrementer implements Runnable {
    CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            this.latch.countDown();
            Thread.sleep(1000);
            this.latch.countDown();
            Thread.sleep(1000);
            this.latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
