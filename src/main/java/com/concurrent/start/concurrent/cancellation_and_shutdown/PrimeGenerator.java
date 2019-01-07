package com.concurrent.start.concurrent.cancellation_and_shutdown;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by zhuran on 2018/12/28 0028
 */
public class PrimeGenerator implements Runnable {
    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> getPrimes() {
        return new ArrayList<>(primes);
    }

    public static void main(String[] args) {
        PrimeGenerator p = new PrimeGenerator();
        new Thread(p).start();
        try{
            SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            p.cancel();
            System.out.println(p.getPrimes());
        }
    }
}
