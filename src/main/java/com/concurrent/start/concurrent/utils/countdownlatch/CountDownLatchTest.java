package com.concurrent.start.concurrent.utils.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhuran on 2019/1/7 0007
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        Waiter waiter = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);
        new Thread(waiter).start();
        new Thread(decrementer).start();
        Thread.sleep(4000);
    }
}
