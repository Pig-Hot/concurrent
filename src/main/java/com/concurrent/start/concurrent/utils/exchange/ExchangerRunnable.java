package com.concurrent.start.concurrent.utils.exchange;

import java.util.concurrent.Exchanger;

/**
 * Created by zhuran on 2019/1/7 0007
 */
public class ExchangerRunnable implements Runnable{
    private Exchanger exchanger;
    private Object object;
    public ExchangerRunnable(Exchanger exchanger,Object o){
        this.exchanger = exchanger;
        this.object = o;
    }
    @Override
    public void run() {
        Object previous = this.object;
        try {
            this.object = this.exchanger.exchange(this.object);
            System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
