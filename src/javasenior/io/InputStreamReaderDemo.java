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
        utf8ToGbk("hi.txt", "hiGbk.txt");
    }

    private static void utf8ToGbk(String srcPath, String destPath) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            File file = new File(srcPath);
            File file2 = new File(destPath);
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file2);
            inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "GBK");

            char[] chars = new char[10];
            int len;
            while (true) {
                len = inputStreamReader.read(chars);
                if (len == -1) {
                    break;
                }
                outputStreamWriter.write(chars, 0, len);
//                String str = new String(chars, 0, len);
//                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStreamReader.close();
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
