package com.zbl.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            public void run() {
                System.out.println("最终要执行的任务");
            }
        });

        for (int i = 0; i < 3; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                public void run() {
                    System.out.println("前期要随便执行的任务：" + finalI);
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }

    }
}
