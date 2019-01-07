package com.concurrent.start.concurrent.build_blocks.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhuran on 2018/12/27 0027
 */
public class Memoizer2<A, V> implements Computable<A, V>{
    private final Map<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            System.out.println("cache");
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
