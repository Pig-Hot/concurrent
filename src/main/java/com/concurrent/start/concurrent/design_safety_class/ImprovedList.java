package com.concurrent.start.concurrent.design_safety_class;

import java.util.*;

/**
 * Created by zhuran on 2018/12/27 0027
 * 通过组合的方式,将操作委托给底层,然后自己原子性的方法 '缺少即加入'
 */
public class ImprovedList<T> extends ArrayList<T> {

    private final List<T> list;

    public ImprovedList(List<T> list){
        this.list = list;
    }

    public synchronized boolean putIfAbsent(T x){
        boolean absent = list.contains(x);
        if(absent){
            list.add(x);
        }
        return absent;
    }
}
