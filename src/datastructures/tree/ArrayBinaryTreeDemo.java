package datastructures.tree;

/**
 * 顺序存储二叉树
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/7/28 20:42
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree();
        arrayBinaryTree.setArr(arr);
        arrayBinaryTree.preOrder();
    }
}

/**
 * 编写一个ArrayBinaryTree，实现顺序存储二叉树遍历
 */
class ArrayBinaryTree {
    private int[] arr;

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    /**
     * 重载preOrder
     */
    public void preOrder() {
        preOrder(0);
    }

    /**
     * 编写一个方法，完成顺序存储二叉树的前序遍历
     *
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        // 如果数组为空，或者arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        // 输出当前这个元素
        System.out.println(arr[index]);
        // 向左递归
        if (left(index) < arr.length) {
            preOrder(left(index));
        }
        // 向右递归
        if (right(index) < arr.length) {
            preOrder(right(index));
        }
    }

    /**
     * 左子结点 => this.left
     */
    private int left(int n) {
        return 2 * n + 1;
    }

    /**
     * 右子结点 => this.right
     */
    private int right(int n) {
        return 2 * n + 2;
    }
}