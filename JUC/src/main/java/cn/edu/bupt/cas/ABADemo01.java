package cn.edu.bupt.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ABA问题的出现：
 */
public class ABADemo01 {
    //CAS compareAndSwap：比较并交换！
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);

        //两个参数，前面是expect后面是update
        //public final boolean compareAndSet(int expect, int update)    返回值是个boolean
        //如果我期望的值达到了，那么就更新，否则就不更新。
        // ================== 捣乱的线程 ===================
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2021, 2020));
        System.out.println(atomicInteger.get());

        // ================== 期望的线程 ===================
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());
    }
}
