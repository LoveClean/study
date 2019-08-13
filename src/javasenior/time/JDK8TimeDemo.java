package javasenior.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * jdk8的日期时间工具
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/13 23:10
 */
public class JDK8TimeDemo {
    public static void main(String[] args) {
        // now()：获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        System.out.println("******************");

        // of()：设置指定的年月日时分秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);
    }
}
