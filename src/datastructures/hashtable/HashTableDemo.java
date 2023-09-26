package datastructures.hashtable;

/**
 * 哈希表
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/7/28 10:53
 */
public class HashTableDemo {
    public static void main(String[] args) {
        Emp emp1 = new Emp(1, "1");
        Emp emp2 = new Emp(2, "2");
        Emp emp3 = new Emp(2, "1");

        HashTable hashTable = new HashTable(7);
        hashTable.add(emp1);
        hashTable.add(emp2);
        System.out.println(hashTable.findById(1));
        System.out.println(hashTable.findById(3));
        hashTable.add(emp3);
        System.out.println(hashTable.findById(2));
        hashTable.remove(2);
        System.out.println(hashTable.findById(2));
//        hashTable.list();
    }

}

/**
 * 创建HashTable 管理多条链表
 */
class HashTable {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTable(int size) {
        // 初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        this.size = size;
        // ？留一个坑，这时不要忘记分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加雇员
     */
    public void add(Emp emp) {
        // 根据员工的id，得到该员工应当添加到哪条链表
        int empLinkedListArrayNo = hashFund(emp.id);
        // 将emp 添加到对应的链表中
        empLinkedListArray[empLinkedListArrayNo].add(emp);
    }

    /**
     * 遍历所有的链表，遍历HashTable
     */
    public void list() {
        for (int i = 0; i < empLinkedListArray.length; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    /**
     * 根据id查找雇员
     */
    public Emp findById(int id) {
        // 根据员工的id，得到该员工应当到哪条链表查找
        int empLinkedListArrayNo = hashFund(id);
        // 将到对应的链表中查找 emp
        return empLinkedListArray[empLinkedListArrayNo].findById(id);
    }

    /**
     * 编写散列函数，使用一个简单取模法
     */
    private int hashFund(int id) {
        return id % size;
    }

    public void remove(int key) {
        // 根据员工的id，得到该员工应当到哪条链表查找
        int empLinkedListArrayNo = hashFund(key);
        empLinkedListArray[empLinkedListArrayNo].del(key);
    }
}

/**
 * 表示一个雇员
 */
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

/**
 * 创建EmpLinkedList，表示链表
 */
class EmpLinkedList {
    /**
     * 头指针，执行第一个Emp，因此我们这个链表的head 是指向第一个Emp
     */
    private Emp head;

    /**
     * 添加雇员到链表
     * 说明
     * 1.假定，当添加雇员时，id 是自增长，即id的分配总是从小到大
     * 因此我们将该雇员直接加入到本链表的最后即可
     */
    public void add(Emp emp) {
        // 如果是第一个
        if (head == null) {
            head = emp;
            return;
        }
        //否则
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == emp.id) {
                curEmp.name = emp.name;
                return;
            }
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    /**
     * 遍历链表的雇员信息
     */
    public void list(int no) {
        if (head == null) {
            System.out.println("第 " + (no + 1) + " 链表为空");
            return;
        }
        //否则
        System.out.print("第 " + (no + 1) + " 链表为 ");
        Emp curEmp = head;
        while (true) {
            System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    /**
     * 根据id查找雇员
     */
    public Emp findById(int id) {
        if (head == null) {
            return null;
        }
        //否则
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                return curEmp;
            }
            if (curEmp.next == null) {
                return null;
            }
            curEmp = curEmp.next;
        }
    }

    /**
     * 删除节点的信息，根据no编号来删除。
     * 说明
     * 1.head 不能动，因此我们需要一个temp辅助节点找到待删除的前一个节点
     * 2.说明我们在比较时，是temp.next.no 和 需要删除的节点的no比较
     */
    public void del(int no) {
        //判断是否为空
        if (head == null) return;
        //如果要删除的节点是头节点
        if (head.id == no) {
            head = head.next;
            return;
        }
        Emp temp = head;
        //遍历链表，找到最后
        while (true) {
            //说明temp已经在链表的最后
            if (temp.next == null) {
                System.out.printf("要删除的%d 节点不存在\n", no);
                break;
            }
            //说明编号存在
            if (temp.next.id == no) {
                temp.next = temp.next.next;
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.next;
        }
    }
}