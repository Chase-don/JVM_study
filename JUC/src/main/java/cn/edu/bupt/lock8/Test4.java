package cn.edu.bupt.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 7. 一个静态的同步方法，一个普通的同步方法，一个对象。那么，先打印发短信还是打电话  （先打电话再发短信）
 * 8. 一个静态的同步方法，一个普通的同步方法，两个对象。同样的还是先电话后短信（一个是对象锁一个是类锁）
 */
public class Test4 {
    public static void main(String[] args) {
        //两个对象的Class类模板只有一个，static：锁的是class
        Phone4 phone = new Phone4();


        new Thread(()->{
            phone.sendSms();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        }, "B").start();

    }
}



class Phone4 {
    // 静态的同步方法 这里锁的是 Class类
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    //普通的同步方法  这里锁的是 对象，方法的调用者
    public synchronized void call() {
        System.out.println("打电话");
    }
}
