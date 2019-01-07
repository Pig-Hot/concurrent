package com.concurrent.start.concurrent.applying_thread_pools.do_puzzles;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/**
 * Created by zhuran on 2019/1/7 0007
 */
public class ConcurrentPuzzleSolver<P, M> {
    private final Puzzle<P, M> puzzle;
    private final ExecutorService exec;
    private final ConcurrentHashMap<P, Boolean> seen;
    final ValueLatch<Node<P, M>> solution = new ValueLatch();

    public ConcurrentPuzzleSolver(Puzzle<P, M> puzzle, ExecutorService exec, ConcurrentHashMap<P, Boolean> seen) {
        this.puzzle = puzzle;
        this.exec = exec;
        this.seen = seen;
    }

    public List<M> solve() throws InterruptedException {
        P p = puzzle.initialPosition();
        exec.execute(newTask(p, null, null));
        try {
            Node<P, M> solnNOode = solution.getValue();
            return (solnNOode == null) ? null : solnNOode.asMoveList();
        } finally {
            exec.shutdownNow();
        }
    }

    private Runnable newTask(P p, M m, Node<P, M> node) {
        return new SolverTask(p, m, node);
    }

    class SolverTask extends Node<P, M> implements Runnable {

        SolverTask(P pos, M move, Node<P, M> prev) {
            super(pos, move, prev);
        }

        @Override
        public void run() {
            if (solution.isSet() || seen.putIfAbsent(pos, true) != null) {
                return;
            }
            if (puzzle.isGoal(pos)) {
                solution.setValue(this);
            } else {
                for (M m : puzzle.legalMoves(pos)) {
                    exec.execute(newTask(puzzle.move(pos, m), m, this));
                }
            }
        }
    }
}

