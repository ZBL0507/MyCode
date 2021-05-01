package com.zbl.concurrent;

/**
 * synchronized 可重入锁演示
 */
@SuppressWarnings("all")
public class ReEnterLockDemo01 {
    public static void main(String[] args) {
        new ReEnterLockDemo01().test01();
    }

    public synchronized void test01() {
        System.out.println("=========1111111========");
        test02();
    }

    public synchronized void test02() {
        System.out.println("===========2222222==========");
        test03();
    }

    public synchronized void test03() {
        System.out.println("===========3333333==========");
    }
}
