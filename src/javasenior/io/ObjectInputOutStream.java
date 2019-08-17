package javasenior.io;

import java.io.*;

/**
 * 对象流
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/17 9:44
 */
public class ObjectInputOutStream {
    public static void main(String[] args) {
        Person person = new Person("咸鱼", 20);
        testObjectOutputStream(person);
        testObjectInputStream();
    }

    /**
     * 序列化过程
     */
    private static void testObjectOutputStream(Object object) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("object.dat")));

            objectOutputStream.writeObject("我是String对象");
            objectOutputStream.flush();

            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 反序列化过程
     */
    private static void testObjectInputStream() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(new File("object.dat")));

            Object object = objectInputStream.readObject();
            System.out.println(object);

            Object object2 = objectInputStream.readObject();
            System.out.println(object2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Person implements Serializable {
    public static final long serialVersionUID = 4437658655552L;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
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