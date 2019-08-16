package javasenior.io;

import java.io.*;

/**
 * 字符流
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/16 17:05
 */
public class FileReaderWriterDemo {
    public static void main(String[] args) {
//        testRead1();
//        System.out.println();
//        testRead2();
//        System.out.println();
//        testWrite();
        copyFile();
    }

    private static void copyFile() {
        File file = new File("hello.txt");
        File file1 = new File("hi.txt");
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(file1, true);

            char[] chars = new char[5];
            int len;
            while (true) {
                len = fileReader.read(chars);
                if (len == -1) {
                    break;
                }
                fileWriter.write(chars, 0, len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 写出操作
     */
    private static void testWrite() {
        FileWriter fileWriter = null;
        try {
            // 1.实例化
            File file = new File("hello1.txt");
            // 2.提供具体的流
            fileWriter = new FileWriter(file, false);
            // 3.数据的写出
            fileWriter.write("i have a dream!\n");
            fileWriter.write("you need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    // 4.流的关闭操作
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将hello.txt读入程序中，并输出到控制台
     * 说明点：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
     */
    private static void testRead1() {
        FileReader fileReader = null;
        try {
            // 1.实例化
            File file = new File("hello.txt");
            // 2.提供具体的流
            fileReader = new FileReader(file);
            // 3.数据的读入
            // read()：返回读入的一个字符。如果达到文件末尾，返回-1
            int read;
            while ((read = fileReader.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.流的关闭操作
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testRead2() {
        FileReader fileReader = null;
        try {
            // 1.实例化
            File file = new File("hello.txt");
            // 2.提供具体的流
            fileReader = new FileReader(file);
            // 3.数据的读入
            // read(char[] chars)：返回读入的chars字符数量。如果达到文件末尾，返回-1
            char[] chars = new char[5];
            int len;
            while ((len = fileReader.read(chars)) != -1) {
                // 方式一：
                for (int i = 0; i < len; i++) {
                    System.out.print(chars[i]);
                }
                // 方式二：
//                String str = new String(chars, 0, len);
//                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.流的关闭操作
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
