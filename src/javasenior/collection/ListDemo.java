package javasenior.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/14 15:15
 */
public class ListDemo {
    public static void main(String[] args) {
        Collection<Object> collection = new ArrayList<>();

        collection.add("aa");
        collection.add("bb");
        collection.add(123);
        collection.add(new Date());

        System.out.println(collection);
        System.out.println(collection.hashCode());
        for (Object o : collection) {
            System.out.println(o);
        }
        System.out.println("*********方式二******************");
        Iterator<Object> iterator = collection.iterator();
//        for (int i = 0; i < collection.size(); i++) {
//            System.out.println(iterator.next());
//        }
        System.out.println("*********方式三******************");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(collection);
    }
}
