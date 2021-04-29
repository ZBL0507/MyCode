package com.zbl.concurrent;

/**
 * 死锁演示
 * 死锁：线程双方占用着对方想要的资源，而没有任何一方先释放手上的资源形成死锁  或者是多个线程形成一个环形死锁
 */
public class DeadLockTest {
    public static void main(String[] args) {
        final DeadLock deadLock = new DeadLock("AA", "BB");
        new Thread(new Runnable() {
            public void run() {
                deadLock.testLockA();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                deadLock.testLockB();
            }
        }).start();
    }
}

@SuppressWarnings("unused")
class DeadLock {
    private final String lockA;
    private final String lockB;

    DeadLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @SuppressWarnings("Duplicates")
    void testLockA() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "获取到锁" + lockA);
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "尝试获取锁" + lockB);
                System.out.println(Thread.currentThread().getName() + "---------------------------");
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + "获取到锁" + lockB);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("Duplicates")
    void testLockB() {
        synchronized (lockB) {
            System.out.println(Thread.currentThread().getName() + "获取到锁" + lockB);
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "尝试获取锁" + lockA);
                System.out.println(Thread.currentThread().getName() + "---------------------------");
                synchronized (lockA) {
                    System.out.println(Thread.currentThread().getName() + "获取到锁" + lockA);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
