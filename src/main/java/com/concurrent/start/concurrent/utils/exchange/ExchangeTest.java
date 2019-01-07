package com.concurrent.start.concurrent.utils.exchange;

import java.util.concurrent.Exchanger;

/**
 * Created by zhuran on 2019/1/7 0007
 */
public class ExchangeTest {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        ExchangerRunnable exchangerRunnable = new ExchangerRunnable(exchanger,"A");
        ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger,"B");
        new Thread(exchangerRunnable).start();
        new Thread(exchangerRunnable2).start();
    }
}
