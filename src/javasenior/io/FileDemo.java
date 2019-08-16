package javasenior.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/16 14:00
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
        File file = new File("hello.txt");
        file.createNewFile();
    }

    /**
     * 三种构造方法
     */
    private static void test1() {
        // 相对于当前module
        File file1 = new File("hello1.txt");
        // 绝对路径
        File file2 = new File("C:\\Users\\64165\\Desktop\\study\\hello2.txt");
        System.out.println(file1);
        System.out.println(file2);

        File file3 = new File("C:\\Users\\64165\\Desktop", "study");
        System.out.println(file3);

        File file4 = new File(file3, "hello4.txt");
        System.out.println(file4);
    }

    /**
     * 常用方法
     */
    private static void test2() {
        File file1 = new File("hello1.txt");
        File file2 = new File("C:\\Users\\64165\\Desktop\\study\\hello2.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    /**
     * 常用方法2
     */
    private static void test3() {
        File file1 = new File("C:\\Users\\64165\\Desktop\\study");

        String[] list = file1.list();
        for (String s : list) {
            System.out.println(s);
        }

        File[] files = file1.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    /**
     * 常用方法3：重命名
     * 要想保证返回true，需要file1存在，file2不存在
     */
    private static void test4() {
        File file1 = new File("hello1.txt");
        File file2 = new File("C:\\Users\\64165\\Desktop\\study\\hello2.txt");

        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);
    }

    /**
     * 常用方法4：判断功能
     */
    private static void test5() {
        File file1 = new File("hello2.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println("***********************");

        File file2 = new File("C:\\Users\\64165\\Desktop\\study");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
    }

    /**
     * 常用方法4：创建和删除
     */
    private static void test6() throws IOException {
        // 文件的创建
        File file1 = new File("hello1.txt");
        if (!file1.exists()) {
            file1.createNewFile();
            System.out.println("创建成功");
        } else {
            file1.delete();
            System.out.println("删除成功");
        }

        // 文件目录的创建
//        file1.mkdir();
//        file1.mkdirs();
    }
}
