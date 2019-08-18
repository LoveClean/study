package javasenior.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream关注的是对数据的运算，与cpu打交道
 * 集合关注的是数据的存储，与内存打交道
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/18 17:44
 */
public class StreamAPIDemo {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        List<EmployeeData> employeeData = new ArrayList<>();

        // 返回一个顺序流
        Stream<EmployeeData> stream = employeeData.stream();

        // 返回一个并行流
        Stream<EmployeeData> parallelStream = employeeData.parallelStream();
    }
}

class EmployeeData {
}