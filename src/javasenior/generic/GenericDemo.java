package javasenior.generic;

import java.util.Arrays;
import java.util.List;

/**
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/15 19:57
 */
public class GenericDemo<T> {
    public static void main(String[] args) {
        GenericDemo<Integer> stringGenericDemo = new GenericDemo<>();
        stringGenericDemo.setDate(22);

        GenericMethod genericMethod = new GenericMethod();
        genericMethod.getMine("r");
        genericMethod.getMine(223);

        GenericMethod.arrToList(new String[]{"1", "2"});
        GenericMethod.arrToList(new Integer[]{1, 2});
    }


    private int id;
    private String name;
    private T date;

    public GenericDemo() {
    }

    public GenericDemo(int id, String name, T date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}

class GenericMethod {
    public <T> T getMine(T date) {
        System.out.println(date);
        return date;
    }

    public static <E> List<E> arrToList(E[] date) {
        List<E> list = Arrays.asList(date);
        System.out.println(list);
        return list;
    }
}