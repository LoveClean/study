package javasenior.io;

import java.io.*;

/**
 * 缓冲流
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/16 21:17
 */
public class BufferedDemo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        bufferedStreamTest("测试文件.pdf", "测试文件4.pdf");
        long endTime = System.currentTimeMillis();
        //原时间为：21-22
        System.out.println("时间为：" + (endTime - startTime));
    }

    /**
     * 实现非文本文件的复制
     */
    private static void bufferedStreamTest(String srcPath, String destPath) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);

            // 造缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] bytes = new byte[1024];
            int len;
            while (true) {
                len = bufferedInputStream.read(bytes);
                if (len == -1) {
                    break;
                }
                bufferedOutputStream.write(bytes, 0, len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
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
