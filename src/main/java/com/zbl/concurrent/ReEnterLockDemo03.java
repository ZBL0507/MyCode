package com.zbl.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 可重入锁演示
 */
@SuppressWarnings("Duplicates")
public class ReEnterLockDemo03 {
    private static Lock myLock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getName() + " 尝试获取锁");
            myLock.lock();
            try {
                System.out.println("当前线程：" + Thread.currentThread().getName() + " 获取到锁");
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                myLock.unlock();
            }
        }).start();

        new Thread(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getName() + " 尝试获取锁");
            myLock.lock();
            try {
                System.out.println("当前线程：" + Thread.currentThread().getName() + " 获取到锁");
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                myLock.unlock();
            }
        }).start();

        new Thread(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getName() + " 尝试获取锁");
            myLock.lock();
            try {
                System.out.println("当前线程：" + Thread.currentThread().getName() + " 获取到锁");
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                myLock.unlock();
            }
        }).start();

        new Thread(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getName() + " 尝试获取锁");
            myLock.lock();
            try {
                System.out.println("当前线程：" + Thread.currentThread().getName() + " 获取到锁");
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                myLock.unlock();
            }
        }).start();

    }
}
