package javasenior.comparable;

import java.util.Arrays;

/**
 * Comparable比较器
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/13 23:49
 */
public class ComparableDemo {
    public static void main(String[] args) {
        Custom custom1 = new Custom("黄鹏飞", 7);
        Custom custom2 = new Custom("黄先生", 9);
        System.out.println(custom1.compareTo(custom2));

        Custom[] customs = new Custom[2];
        customs[0] = custom1;
        customs[1] = custom2;
        Arrays.sort(customs);
        System.out.println(Arrays.toString(customs));
    }
}

class Custom implements Comparable<Custom> {
    private String username;
    private int sort;

    public Custom(String username, int sort) {
        this.username = username;
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Custom{" +
                "username='" + username + '\'' +
                ", sort=" + sort +
                '}';
    }

    @Override
    public int compareTo(Custom o) {
        // 表示从小到大排序
        return this.sort - o.sort;
    }
}