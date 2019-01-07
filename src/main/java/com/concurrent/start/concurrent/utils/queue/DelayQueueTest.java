package com.concurrent.start.concurrent.utils.queue;

import java.util.concurrent.DelayQueue;

/**
 * Created by zhuran on 2019/1/7 0007
 */
public class DelayQueueTest {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue queue = new DelayQueue();
        DelayedElement delayedElement = new DelayedElement(1);
        queue.put(delayedElement);
        DelayedElement delayedElement2 = (DelayedElement) queue.take();
        System.out.println(delayedElement2.compareTo(delayedElement));
    }
}
