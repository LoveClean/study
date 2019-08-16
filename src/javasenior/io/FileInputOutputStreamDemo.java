package javasenior.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/16 20:20
 */
public class FileInputOutputStreamDemo {
    public static void main(String[] args) {
        copyFile();
    }

    private static void copyFile() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File("图片1.png");
            File file1 = new File("图片copy.png");
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file1);
            byte[] bytes = new byte[5];
            int len;
            while (true) {
                len = fileInputStream.read(bytes);
                if (len == -1) {
                    break;
                }
                for (int i = 0; i < len; i++) {
                    fileOutputStream.write(bytes[i]);
                }
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
