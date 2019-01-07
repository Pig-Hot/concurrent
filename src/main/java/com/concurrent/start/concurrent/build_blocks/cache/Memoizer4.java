package com.concurrent.start.concurrent.build_blocks.cache;

import java.util.concurrent.*;

/**
 * Created by zhuran on 2018/12/27 0027
 */
public class Memoizer4<A,V> implements Computable<A,V>{

    private final ConcurrentHashMap<A,Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A,V> c;

    public Memoizer4(Computable<A,V> c){
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        while (true){
            Future<V> f = cache.get(arg);
            if(f == null){
                Callable<V> eval = () -> c.compute(arg);
                FutureTask<V> ft = new FutureTask<>(eval);
                System.out.println("cache");
                f = cache.putIfAbsent(arg,ft);
                if(f == null){
                    f = ft;
                    ft.run();
                }
            }
            try{
                return f.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
