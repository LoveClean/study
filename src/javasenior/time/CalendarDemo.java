package javasenior.time;

import java.util.Calendar;

/**
 * 日历类
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/13 22:44
 */
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
