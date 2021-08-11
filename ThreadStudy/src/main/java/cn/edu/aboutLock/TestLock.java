package cn.edu.aboutLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试Lock锁
 */
public class TestLock {
    public static void main(String[] args) {

        TestLock2 testLock2 = new TestLock2();

        new Thread(testLock2, "1").start();
        new Thread(testLock2, "2").start();
        new Thread(testLock2, "3").start();


    }
}


class TestLock2 implements Runnable {

    int ticketNums = 1000;

    //定义Lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                //加锁
                lock.lock();
                if (ticketNums > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：" +ticketNums--);
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }

        }
    }
}
