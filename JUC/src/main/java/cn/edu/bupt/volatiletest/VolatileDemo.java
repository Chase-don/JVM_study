package cn.edu.bupt.volatiletest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 不保证原子性
 */
public class VolatileDemo {
    //加了volatile依旧不足20k，说明volatile不保证原子性
    //原子类的Integer
    private volatile static AtomicInteger num = new AtomicInteger();

    public static void add() {
//        num++; //不是一个原子性操作！
        num.getAndIncrement(); // AtomicInteger的 +1 方法，用的是CAS
    }

    public static void main(String[] args) {
        //理论上num结果为20000
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " " + num);
    }
}
