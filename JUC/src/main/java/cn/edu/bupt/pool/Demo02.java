package cn.edu.bupt.pool;

import java.util.concurrent.*;


/**
 * 四种拒绝策略：
 * 1. new ThreadPoolExecutor.AbortPolicy() //银行满了，还有人进来，不处理这个人的线程，抛出异常
 * 2. new ThreadPoolExecutor.CallerRunsPolicy() //哪儿来的回哪儿去（例如回到主线程）
 * 3. new ThreadPoolExecutor.DiscardPolicy() //队列满了，丢弃当前任务，不会抛出异常！
 * 4.new ThreadPoolExecutor.DiscardOldestPolicy() //队列满了，丢弃阻塞队列的队首元素，然后再调用execute方法尝试进入队列，不会对正在执行的线程有任何影响
 */
public class Demo02 {
    public static void main(String[] args) {
        //自定义线程池(ThreadPoolExecutor)
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy() //银行满了，还有人进来，不处理这个人的线程，抛出异常
//                new ThreadPoolExecutor.CallerRunsPolicy() //哪儿来的回哪儿去（例如回到主线程）
//                new ThreadPoolExecutor.DiscardPolicy() //队列满了，丢掉当前任务，不会抛出异常！
                new ThreadPoolExecutor.DiscardOldestPolicy() //队列满了，丢弃阻塞队列的队首元素，然后再调用execute方法尝试进入队列，不会对正在执行的线程有任何影响
        );

        try {
            //最大承载： Queue + max
            for (int i = 1; i <= 9; i++) {
                //使用了线程池以后，要使用线程池的方法来创建
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}