package javasenior.map;

import java.util.*;

/**
 * HashMap
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/15 16:45
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);

        // 遍历key
        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 遍历value
        Collection values = map.values();
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        // 遍历entry
        Set entrySet = map.entrySet();
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next());
        }
    }
}
