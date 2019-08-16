package javasenior.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 转化流
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/16 21:51
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        try {
            File file = new File("hi.txt");
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

            char[] chars = new char[10];
            int len;
            while (true) {
                len = inputStreamReader.read(chars);
                if (len == -1) {
                    break;
                }
                String str = new String(chars, 0, len);
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
