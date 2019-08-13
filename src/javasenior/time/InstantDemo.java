package javasenior.time;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Instant：类似于Date
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/13 23:24
 */
public class InstantDemo {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.toEpochMilli());

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        Instant instant1 = Instant.ofEpochMilli(1565710188855L);
        System.out.println(instant1);
    }
}
