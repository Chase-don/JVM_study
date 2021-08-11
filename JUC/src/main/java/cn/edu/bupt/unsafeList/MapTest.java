package cn.edu.bupt.unsafeList;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


public class MapTest {
    public static void main(String[] args) {
        //研究ConcurrentHashMap的原理
        Map<String, String> map = new ConcurrentHashMap<>();
        //  加载因子（0.75）  初始化容量（16）

        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
