package cn.edu.bupt.blockq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
//        test1();

//        test2();
//        test3();
        test4();
    }

    /**
     * 抛出异常
     */
    public static void test1() {
        //参数是阻塞队列的大小
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.add("c"));
        //java.lang.IllegalStateException: Queue full
        //System.out.println(arrayBlockingQueue.add("d"));
        arrayBlockingQueue.element();
        System.out.println("===========");

        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        //java.util.NoSuchElementException  抛出异常
        //System.out.println(arrayBlockingQueue.remove());
    }

    /**
     * 有返回值，不抛出异常
     */
    public static void test2() {
        //参数是阻塞队列的大小
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c"));
        System.out.println(arrayBlockingQueue.offer("d"));  //打印出false，不抛出异常！

        System.out.println("===============");
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());  //null  有返回值没有异常！
    }


    /**
     * 等待，阻塞（一直等待）
     */
    public static void test3() throws InterruptedException {
        //参数是阻塞队列的大小
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        //一直阻塞
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("c");
        //arrayBlockingQueue.put("d");      //队列没有位置了，一直阻塞

        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        //System.out.println(arrayBlockingQueue.take());   //没有这个元素，一直阻塞
    }


    /**
     * 等待，阻塞（等待超时）
     */
    public static void test4() throws InterruptedException {
        //参数是阻塞队列的大小
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        arrayBlockingQueue.offer("a");
        arrayBlockingQueue.offer("b");
        arrayBlockingQueue.offer("c");
        arrayBlockingQueue.offer("d", 2, TimeUnit.SECONDS);  //等待两秒超过就退出

        System.out.println("====================");
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        arrayBlockingQueue.poll(2, TimeUnit.SECONDS);  //等待超过两秒退出
    }

}
