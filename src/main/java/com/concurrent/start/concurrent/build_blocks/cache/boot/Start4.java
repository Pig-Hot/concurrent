package com.concurrent.start.concurrent.build_blocks.cache.boot;

import com.concurrent.start.concurrent.build_blocks.cache.ExpensiveFunction;
import com.concurrent.start.concurrent.build_blocks.cache.Memoizer3;
import com.concurrent.start.concurrent.build_blocks.cache.Memoizer4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuran on 2018/12/27 0027
 */
public class Start4 {
    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        List<Thread> threads = new ArrayList<Thread>();
        ExpensiveFunction e = new ExpensiveFunction();
        Memoizer4 m4 = new Memoizer4(e);
        for (int i = 0; i < 100000; i++) {
            Thread t = new Thread(() -> {
                try {
                    m4.compute("1");
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
