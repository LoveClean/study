package javasenior.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/14 23:09
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        Set set = new TreeSet<>();
        set.add(456);
        set.add(123);
        set.add(123);
//        set.add("Aaa");
//        set.add(new SetDemo());
//        set.add(new SetDemo());
        set.add(987);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
