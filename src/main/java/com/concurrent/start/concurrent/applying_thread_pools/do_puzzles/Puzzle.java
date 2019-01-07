package com.concurrent.start.concurrent.applying_thread_pools.do_puzzles;

import java.util.Set;

/**
 * Created by zhuran on 2019/1/7 0007
 * 谜题抽象接口
 */
public interface Puzzle<P, M> {
    P initialPosition();

    boolean isGoal(P position);

    Set<M> legalMoves(P position);

    P move(P position, M move);
}
