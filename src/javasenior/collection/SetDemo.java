package javasenior.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/14 18:53
 */
public class SetDemo {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("Aaa");
        set.add(new SetDemo());
        set.add(new SetDemo());
        set.add(987);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
