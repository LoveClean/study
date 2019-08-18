package javasenior.java8;

import java.util.Comparator;

/**
 * Lambda表达式
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/18 16:24
 */
public class LambdaDemo {
    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        System.out.println("******原表达式********");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        runnable.run();

        System.out.println("******Lambda表达式********");

        Runnable runnable2 = () -> {
            System.out.println("我爱北京天安门");
            System.out.println("我爱北京天安门");
            System.out.println("我爱北京天安门");
        };
        runnable2.run();
    }

    private static void test2() {
        System.out.println("******原表达式********");
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare = comparator.compare(12, 21);
        System.out.println(compare);

        System.out.println("******Lambda表达式********");
        // Lambda表达式
        Comparator<Integer> comparator2 = (Integer o1, Integer o2) -> {
            return Integer.compare(o1, o2);
        };
        int compare2 = comparator2.compare(32, 21);
        System.out.println(compare2);

        System.out.println("******方法引用********");
        // 方法引用
        Comparator<Integer> comparator3 = Integer::compare;
        int compare3 = comparator3.compare(32, 21);
        System.out.println(compare3);
    }
}
