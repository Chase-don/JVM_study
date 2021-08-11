package cn.edu.bupt;

import java.util.concurrent.*;

//线程创建方式三： 实现Callable接口

/**
 * 实现Callable接口的步骤：
 * 1. 实现Callable接口，需要返回值类型
 * 2. 重写call方法，需要抛出异常
 * 3. 创建目标对象
 * 4. 创建执行服务： ExecutorService ser = Executor.newFixedThreadPool(1);
 * 5. 提交执行： Future<Boolean> result = ser.submit(t1);
 * 6. 获取结果： boolean r1 = result.get();
 * 7. 关闭服务： ser.shutdownNow();
 *
 *
 * Callable的好处：
 * 1. 可以定义返回值
 * 2. 可以抛出异常
 */
public class TestCallable implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < 10000; i++) {
            System.out.println("我在学代码----");
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable testCallable = new TestCallable();

        //创建线程池
        ExecutorService ser = Executors.newFixedThreadPool(1);

        //提交执行
        Future<Boolean> result = ser.submit(testCallable);


        for (int i = 0; i < 10000; i++) {
            System.out.println("学习JUC====");
        }

        //获取结果
        Boolean res = result.get();

        System.out.println(res);

        //关闭服务
        ser.shutdownNow();


    }
}
