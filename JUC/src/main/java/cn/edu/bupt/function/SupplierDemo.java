package cn.edu.bupt.function;

import java.util.function.Supplier;

/**
 * Supplier 供给型接口 没有参数(没有输入)，只有返回值
 */
public class SupplierDemo {
    public static void main(String[] args) {
//        Supplier<Integer> supplier = new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                System.out.println("get()");
//                return 1024;
//            }
//        };

        Supplier<Integer> supplier = () -> {return 1024;};

        System.out.println(supplier.get());
    }
}
