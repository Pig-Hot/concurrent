package com.concurrent.start.concurrent.design_safety_class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhuran on 2018/12/27 0027
 * 客户端实现'缺少即加入'
 */
public class SafeListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    public boolean putIfAbsent(E e) {
        synchronized (list) {
            boolean absent = !list.contains(e);
            if (absent) {
                list.add(e);
            }
            return absent;
        }
    }
}
