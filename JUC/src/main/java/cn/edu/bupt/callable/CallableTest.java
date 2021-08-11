package cn.edu.bupt.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //new Thread(new Runnable()).start();
        //new Thread(new FutureTask()).start();
        //new Thread(new FutureTask( Callable )).start();
        new Thread().start(); //怎么启动Callable

        MyThread myThread = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<>(myThread);  //适配器

        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start();  // 两个线程执行，结果还是一个call()。---> 原因是结果会被缓存，效率高

        Integer integer = futureTask.get(); //这个get方法可能产生阻塞，把它放到最后面
        System.out.println(integer);
    }
}


class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("call()");
        return 1024;
    }
}