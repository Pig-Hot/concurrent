package com.concurrent.start.concurrent.build_blocks;

import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Vector;

/**
 * Created by zhuran on 2018/12/27 0027
 * 同步容器都是线程安全,但是对于复合操作还是需要额外的操作保证线程安全
 */
//多线程同时调用getLast和deleteLast时,可能出现数组越界异常,但是并不代表线程不安全
public class UnSafeVector {

    public static Object getLast(Vector vector) {
        int lastIndex = vector.size() - 1;
        return vector.get(lastIndex);
    }

    public static void deleteLast(Vector vector) {
        int lastIndex = vector.size() - 1;
        vector.remove(lastIndex);
    }

}

//使用客户端加锁的方法,但是在迭代的过程中还是会抛出异常
class SafeVector {

    public static Object getLast(Vector vector) {
        synchronized (vector) {
            int lastIndex = vector.size() - 1;
            return vector.get(lastIndex);
        }
    }

    public static void deleteLast(Vector vector) {
        synchronized (vector) {
            int lastIndex = vector.size() - 1;
            vector.remove(lastIndex);
        }
    }
}

//最好的方法是在客户端调用的时候,通过自己实现的
