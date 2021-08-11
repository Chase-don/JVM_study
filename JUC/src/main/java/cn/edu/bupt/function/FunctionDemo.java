package cn.edu.bupt.function;

import java.util.function.Function;

/**
 * Function 函数型接口，有一个输入参数，有一个输出
 * 只要是函数型接口，都可以用 lambda表达式简化
 */
public class FunctionDemo {

    public static void main(String[] args) {
//        Function<String, String> function = new Function<String, String>(){
//            @Override
//            public String apply(String s) {
//                return s;
//            }
//        };

        Function<String, String> function = (s) -> {return s;};

        System.out.println(function.apply("asfe"));
    }
}
