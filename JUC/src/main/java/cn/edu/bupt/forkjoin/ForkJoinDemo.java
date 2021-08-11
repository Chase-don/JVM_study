package cn.edu.bupt.forkjoin;

/**
 * 求和计算的任务
 */
public class ForkJoinDemo {

    private Long start;
    private Long end;

    //临界值
    private Long temp = 10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {

    }
}
