package javasenior.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/17 10:29
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) {
        copyTest();
    }

    private static void copyTest() {
        RandomAccessFile r = null;
        RandomAccessFile rw = null;
        try {
            r = new RandomAccessFile(new File("hi.txt"), "r");
            rw = new RandomAccessFile(new File("hiCopy.txt"), "rw");

            byte[] bytes = new byte[10];
            int len;
            while (true) {
                len = r.read(bytes);
                if (len == -1) {
                    break;
                }
                rw.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                r.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
