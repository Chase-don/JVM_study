package cn.edu.bupt.auxiliary;

import java.util.concurrent.CountDownLatch;

// 计数器
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //总数是6，必须要执行任务的时候，再使用！
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " go out");
                countDownLatch.countDown(); //-1
            }, String.valueOf(i)).start();
        }

        //等待计数器归零，然后再向下执行
        countDownLatch.await();

        System.out.println("close door");
    }
}
