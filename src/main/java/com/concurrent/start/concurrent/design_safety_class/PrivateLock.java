package com.concurrent.start.concurrent.design_safety_class;

import javax.annotation.concurrent.GuardedBy;

/**
 * Created by zhuran on 2018/12/27 0027
 * 私有锁保护状态:使用私有锁,客户端无法获取它的同步策略,公有锁允许客户端修改
 */
class Widget{

}
public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("myLock")
    Widget widget;
    void someMethod(){
        synchronized (myLock){
            //访问修改属性状态
        }
    }

}
