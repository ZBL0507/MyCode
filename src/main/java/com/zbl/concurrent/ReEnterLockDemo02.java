package com.zbl.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 可重入锁演示
 */
public class ReEnterLockDemo02 {
    private static Lock myLock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                myLock.lock();
                try {
                    System.out.println("1111111111111");
                    myLock.lock();
                    try {
                        System.out.println("2222222222");
                        myLock.lock();
                        try {
                            System.out.println("333333333333333");
                        } finally {
                            myLock.unlock();
                        }
                    } finally {
                        myLock.unlock();
                    }
                } finally {
                    myLock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                myLock.lock();
                try {
                    System.out.println("other thread ...");
                } finally {
                    myLock.unlock();
                }
            }
        }).start();

    }
}
