package cn.edu.bupt.juc;

//基本的卖票例子

/**
 * 真正的多线程开发，即公司的开发中： 降低耦合性
 * 线程就是 一个单独的资源类，没有任何附属的操作！
 * 1. 属性、方法
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        //并发：多个线程操作同一个资源类
        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "C").start();
    }
}


//资源类 OOP
class Ticket {
    //属性、方法
    private int number = 50;

    //卖票的方式
    //synchronized 本质：锁，排队
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票，剩余：" + number);
        }
    }
}