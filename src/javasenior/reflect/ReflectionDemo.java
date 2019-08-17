package javasenior.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/17 21:51
 */
public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // 反射之前，对于Person类的操作
        test1();
        System.out.println("****************");
        // 反射之后，对于Person类的操作
        test2();
    }

    private static void test1() {
        // 1.创建对象
        Person person = new Person("tom", 12);

        // 2.通过对象，调用其内部的属性、方法
        person.age = 10;
        System.out.println(person);

        person.show();
    }

    private static void test2() throws Exception {
        // 1.通过反射，创建对象
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        Person person = constructor.newInstance("Tom", 12);
        System.out.println(person);

        // 2.通过反射，调用对象指定的属性、方法
        // 调用属性
        Field age = personClass.getDeclaredField("age");
        age.set(person, 10);
        System.out.println(person);
        // 调用方法
        Method show = personClass.getDeclaredMethod("show");
        Object invoke = show.invoke(person);
        System.out.println(invoke);
        System.out.println("*************");


        // 通过反射，可以调用私有构造器、属性、方法
        // 调用私有构造器
        Constructor<Person> constructor2 = personClass.getDeclaredConstructor(String.class);
        constructor2.setAccessible(true);
        Person person2 = constructor2.newInstance("Tom");
        System.out.println(person2);
        // 调用私有属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person2, "hanmeimei");
        System.out.println(person2);
        // 调用私有方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        Object invoke2 = showNation.invoke(person2, "中国");
        System.out.println(invoke2);
    }
}

class Person {
    private String name;
    public int age;

    public void show() {
        System.out.println("你好，我是一个人");
    }

    private String showNation(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}