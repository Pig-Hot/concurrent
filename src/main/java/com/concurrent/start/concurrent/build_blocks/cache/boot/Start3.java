package com.concurrent.start.concurrent.build_blocks.cache.boot;

import com.concurrent.start.concurrent.build_blocks.cache.ExpensiveFunction;
import com.concurrent.start.concurrent.build_blocks.cache.Memoizer2;
import com.concurrent.start.concurrent.build_blocks.cache.Memoizer3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuran on 2018/12/27 0027
 */
public class Start3 {
    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        List<Thread> threads = new ArrayList<Thread>();
        ExpensiveFunction e = new ExpensiveFunction();
        Memoizer3 m3 = new Memoizer3(e);
        for (int i = 0; i < 100000; i++) {
            Thread t = new Thread(() -> {
                try {
                    m3.compute("1");
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            });
            t.start();
            threads.add(t);
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }
}
