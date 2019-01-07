package com.concurrent.start.concurrent.applying_thread_pools.do_puzzles;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.Immutable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zhuran on 2019/1/7 0007
 */
@Immutable
public class ValueLatch<T> {
    @GuardedBy("this")
    private T value = null;
    private final CountDownLatch downLatch = new CountDownLatch(1);

    public boolean isSet(){
        return (downLatch.getCount() == 0);
    }

    public synchronized void setValue(T newValue){
        if(isSet()){
            value = newValue;
            downLatch.countDown();
        }
    }

    public T getValue() throws InterruptedException {
        downLatch.await();
        synchronized (this){
            return value;
        }
    }
}
