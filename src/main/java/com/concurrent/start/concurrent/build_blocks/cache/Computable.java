package com.concurrent.start.concurrent.build_blocks.cache;

/**
 * Created by zhuran on 2018/12/27 0027
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
