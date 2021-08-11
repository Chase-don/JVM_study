package cn.edu.bupt.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo02 {
    public static void main(String[] args) {
        //并发：多个线程操作同一个资源类
        Ticket2 ticket = new Ticket2();

        new Thread(() -> {for (int i = 0; i < 60; i++) ticket.sale();}, "A").start();
        new Thread(() -> {for (int i = 0; i < 60; i++) ticket.sale();}, "B").start();
        new Thread(() -> {for (int i = 0; i < 60; i++) ticket.sale();}, "C").start();

    }
}

/**
 * Lock三部曲：
 * 1. new ReentrantLock();
 * 2. lock.lock(); // 加锁
 * 3. finally => lock.unlock(); //解锁
 */
//用Lock锁
class Ticket2 {
    //属性、方法
    private int number = 50;

    Lock lock = new ReentrantLock();

    //卖票的方式
    public void sale() {

        lock.lock();//加锁
        try {
            //业务代码
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票，剩余：" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}