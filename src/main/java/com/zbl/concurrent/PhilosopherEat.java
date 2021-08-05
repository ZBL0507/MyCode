package com.zbl.concurrent;

/**
 * 哲学家就餐演示
 */
public class PhilosopherEat {
    public static void main(String[] args) {
        Chopstick c1 = new Chopstick();
        Chopstick c2 = new Chopstick();
        Chopstick c3 = new Chopstick();
        Chopstick c4 = new Chopstick();
        Chopstick c5 = new Chopstick();
        new Philosopher("柏拉图", c1, c2).start();
        new Philosopher("苏格拉底", c2, c3).start();
        new Philosopher("亚里士多德", c3, c4).start();
        new Philosopher("阿基米德", c4, c5).start();
        new Philosopher("莱布尼茨", c5, c1).start();
    }
}

class Philosopher extends Thread {
    private final Chopstick left;
    private final Chopstick right;

    Philosopher(String name, Chopstick left, Chopstick right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    @SuppressWarnings("all")
    @Override
    public void run() {
        while (true) {
            eat();
        }
    }

    private void eat() {
        synchronized (left) {
            synchronized (right) {
                System.out.println(Thread.currentThread().getName() + " : 开始就餐...");
            }
        }
    }
}

class Chopstick {
}

/*
  jstack 进程号

 * Found one Java-level deadlock:
=============================
"莱布尼茨":
  waiting to lock monitor 0x0610e78c (object 0x157dba68, a com.zbl.concurrent.Chopstick),
  which is held by "柏拉图"
"柏拉图":
  waiting to lock monitor 0x05b4c2ac (object 0x157dbf08, a com.zbl.concurrent.Chopstick),
  which is held by "苏格拉底"
"苏格拉底":
  waiting to lock monitor 0x05b4cfcc (object 0x157dbd80, a com.zbl.concurrent.Chopstick),
  which is held by "亚里士多德"
"亚里士多德":
  waiting to lock monitor 0x0610d9fc (object 0x157dbbf8, a com.zbl.concurrent.Chopstick),
  which is held by "阿基米德"
"阿基米德":
  waiting to lock monitor 0x0610e7fc (object 0x157dba70, a com.zbl.concurrent.Chopstick),
  which is held by "莱布尼茨"

Java stack information for the threads listed above:
===================================================
"莱布尼茨":
        at com.zbl.concurrent.Philosopher.eat(PhilosopherEat.java:41)
        - waiting to lock <0x157dba68> (a com.zbl.concurrent.Chopstick)
        - locked <0x157dba70> (a com.zbl.concurrent.Chopstick)
        at com.zbl.concurrent.Philosopher.run(PhilosopherEat.java:34)
"柏拉图":
        at com.zbl.concurrent.Philosopher.eat(PhilosopherEat.java:41)
        - waiting to lock <0x157dbf08> (a com.zbl.concurrent.Chopstick)
        - locked <0x157dba68> (a com.zbl.concurrent.Chopstick)
        at com.zbl.concurrent.Philosopher.run(PhilosopherEat.java:34)
"苏格拉底":
        at com.zbl.concurrent.Philosopher.eat(PhilosopherEat.java:41)
        - waiting to lock <0x157dbd80> (a com.zbl.concurrent.Chopstick)
        - locked <0x157dbf08> (a com.zbl.concurrent.Chopstick)
        at com.zbl.concurrent.Philosopher.run(PhilosopherEat.java:34)
"亚里??多德":
        at com.zbl.concurrent.Philosopher.eat(PhilosopherEat.java:41)
        - waiting to lock <0x157dbbf8> (a com.zbl.concurrent.Chopstick)
        - locked <0x157dbd80> (a com.zbl.concurrent.Chopstick)
        at com.zbl.concurrent.Philosopher.run(PhilosopherEat.java:34)
"阿基米德":
        at com.zbl.concurrent.Philosopher.eat(PhilosopherEat.java:41)
        - waiting to lock <0x157dba70> (a com.zbl.concurrent.Chopstick)
        - locked <0x157dbbf8> (a com.zbl.concurrent.Chopstick)
        at com.zbl.concurrent.Philosopher.run(PhilosopherEat.java:34)

Found 1 deadlock.
 */
