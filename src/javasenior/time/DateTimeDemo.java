package javasenior.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * System类和Date类
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/13 18:13
 */
public class DateTimeDemo {
    public static void main(String[] args) throws ParseException {
        System.out.println(System.currentTimeMillis());

        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());

        // 实例化：使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();
        System.out.println(sdf.format(date));

        String str = "2019-08-09 下午10:29";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        // ******按指定方式格式化************
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf2.format(date));

        System.out.println("********************");

        String birth = "2020-09-08";

        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
        Date date3 = sdf3.parse(birth);
        long time = date3.getTime();

        java.sql.Date date4 = new java.sql.Date(time);
        System.out.println(date3);
        System.out.println(date4);
    }
}
