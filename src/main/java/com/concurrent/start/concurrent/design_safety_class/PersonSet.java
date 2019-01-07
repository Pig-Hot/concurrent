package com.concurrent.start.concurrent.design_safety_class;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhuran on 2018/12/26 0026
 * 实例限制:将数据封装在对象内部,对访问数据的方法进行限制
 */
class Person {

}

@ThreadSafe
public class PersonSet {
    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }
}
