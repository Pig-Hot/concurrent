package com.concurrent.start.concurrent.build_blocks.cache;

import javax.annotation.concurrent.GuardedBy;
import java.util.HashMap;
import java.util.Map;

public class Memoizer1<A, V> implements Computable<A, V> {
    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<>();
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            System.out.println("cache");
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
