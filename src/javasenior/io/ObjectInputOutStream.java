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
//        testObjectOutputStream();
        testObjectInputStream();
    }

    /**
     * 序列化过程
     */
    private static void testObjectOutputStream() {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("object.dat")));
            objectOutputStream.writeObject(new String("我爱北京天安门"));
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
