package algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 快速排序
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/7/26 23:55
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9, 78, 0, 23, -567, 70};
//        quickSort(arr, 0, 8);

        // 创建要给150000个的随机的数组
        int[] arr = new int[15000000];
        for (int i = 0; i < 15000000; i++) {
            // 生成一个[0,10000000) 数
            arr[i] = (int) (Math.random() * 10000000);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date);
        System.out.println("排序前的时间是=" + dateStr);

        // 测试排序
        quickSort(arr, 0, arr.length - 1);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    /**
     * 快速排序
     * 排序150000条的速度不到1秒，速度比希尔排序快
     */
    static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        // pivot 中轴值
        int pivot = arr[(left + right) / 2];
        // 临时变量，作为交换时使用
        int temp;
        // while循环的目的是让比pivot 值小放到左边，比pivot 值大放到右边
        while (l < r) {
            // 在pivot的左边一直找，直到找到大于等于pivot值，才退出
            while (arr[l] < pivot) l++;
            // 在pivot的右边一直找，直到找到小于等于pivot值，才退出
            while (arr[r] > pivot) r--;
            // 退出
            if (l >= r) break;
            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 防止死循环（例如当l和r同时指向pivot时，比较难理解，建议画图理解）
            if (arr[l] == pivot) r--;
            if (arr[r] == pivot) l++;
        }

        // 如果l == r，必须l++，r--，否则出现栈溢出
        if (l == r) {
            l++;
            r--;
        }

        //Todo 有点难理解，建议debug理解
        if (left < r) quickSort(arr, left, r);
        if (right > l) quickSort(arr, l, right);
    }


    /**
     * 递归版本（不如上一版，此版缺少随机性）
     */
    private static void sort(int[] arr, int start, int end) {
        if (start >= end) return;
        int partition = partition(arr, start, end);
        sort(arr, start, partition);
        sort(arr, partition + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int standardNum = arr[start];
        int point = start;
        int temp;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > standardNum) {
                point++;
                temp = arr[point];
                arr[point] = arr[i];
                arr[i] = temp;
            }
        }
        arr[start] = arr[point];
        arr[point] = standardNum;
        return point;
    }
}
