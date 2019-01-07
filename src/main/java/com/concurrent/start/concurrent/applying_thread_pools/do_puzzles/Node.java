package com.concurrent.start.concurrent.applying_thread_pools.do_puzzles;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhuran on 2019/1/7 0007
 */
@Immutable
public class Node<P,M> {
    final P pos;
    final M move;
    final Node<P,M> prev;

    Node(P pos,M move,Node<P,M> prev){
        this.move = move;
        this.pos = pos;
        this.prev = prev;
    }

    List<M> asMoveList(){
        List<M> solution = new LinkedList<>();
        for (Node<P,M> n = this;n.move != null;n = n.prev){
            solution.add(0,n.move);
        }
        return solution;
    }
}
