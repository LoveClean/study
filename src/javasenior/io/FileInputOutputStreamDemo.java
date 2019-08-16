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
        long startTime = System.currentTimeMillis();
        copyFile("测试文件.pdf", "测试文件2.pdf");
        long endTime = System.currentTimeMillis();
        //原时间为：87-94
        System.out.println("时间为：" + (endTime - startTime));
    }

    private static void copyFile(String srcPath, String destPath) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(srcPath);
            File file1 = new File(destPath);
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file1);
            byte[] bytes = new byte[1024];
            int len;
            while (true) {
                len = fileInputStream.read(bytes);
                if (len == -1) {
                    break;
                }
                fileOutputStream.write(bytes,0,len);
//                for (int i = 0; i < len; i++) {
//                    fileOutputStream.write(bytes[i]);
//                }
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
