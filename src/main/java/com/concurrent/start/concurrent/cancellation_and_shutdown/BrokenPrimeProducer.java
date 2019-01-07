package com.concurrent.start.concurrent.cancellation_and_shutdown;

import java.math.BigInteger;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zhuran on 2018/12/28 0028
 */
public class BrokenPrimeProducer extends Thread{
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;
    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled){
            try {
                queue.put(p = p.nextProbablePrime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void cancel(){
        cancelled = true;
    }
}
