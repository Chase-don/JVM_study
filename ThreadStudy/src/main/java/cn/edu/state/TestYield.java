package cn.edu.state;

//测试出让线程
//出让不一定成功，看CPU心情
public class TestYield {
    public static void main(String[] args) throws InterruptedException {
        MyYield myYield = new MyYield();
        new Thread(myYield, "first").start();
        new Thread(myYield, "second").start();

    }

}


class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}
