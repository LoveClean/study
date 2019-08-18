package javasenior.reflect;

import java.lang.reflect.Field;

/**
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/18 9:35
 */
public class NewInstanceDemo {
    public static void main(String[] args) throws Exception {
        test1();
    }

    private static void test1() throws Exception {
        Class<?> aClass = Class.forName("javasenior.reflect.Person");

        Object o = aClass.newInstance();
        System.out.println(o);

        // 获取当前运行类及其父类中声明为public访问权限的属性
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("***************");

        // 获取当前运行类中所有属性（不包含父类）
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
    }
}
