package com.concurrent.start.concurrent.design_safety_class;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/**
 * Created by zhuran on 2018/12/26 0026
 * 设计线程安全的类:
 * 1.确定对象状态是由哪些变量构成
 * 2.确定限制状态变量的不变约束
 * 3.制定一个管理并发访问对象状态的策略
 * 同步策略:定义对象如何协调状态的访问,并且不会违反不变性或后验条件,它规定如何把不变性、线程限制和锁结合起来,从而维护线程安全
 */
@ThreadSafe
public final class Count {
    @GuardedBy("this")
    private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() throws IllegalAccessException {
        if (value == Long.MAX_VALUE) {
            throw new IllegalAccessException("count overflow");
        }
        return ++value;
    }

}
