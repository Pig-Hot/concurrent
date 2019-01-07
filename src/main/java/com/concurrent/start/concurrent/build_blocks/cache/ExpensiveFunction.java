package com.concurrent.start.concurrent.build_blocks.cache;

import java.math.BigInteger;

/**
 * Created by zhuran on 2018/12/27 0027
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {

    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }
}
