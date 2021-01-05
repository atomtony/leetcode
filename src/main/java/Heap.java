import java.util.Arrays;

public class Heap {

    private int[] a;//数组，从下标1开始存储数据
    private int n;//堆可以存储的最大数据个数
    private int count;//堆中可以春除的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n) {
            return;//堆满了
        }
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {//自下往上堆化
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    private void swap(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    private void print() {
        int[] b = new int[count];
        System.arraycopy(a, 1, b, 0, count);
        System.out.println(Arrays.toString(b));
    }

    public static void main(String[] args) {
        Heap heap = new Heap(15);
        heap.insert(1);
        heap.insert(2);
        heap.insert(33);
        heap.insert(21);
        heap.insert(17);
        heap.insert(16);
        heap.insert(13);
        heap.insert(15);
        heap.insert(9);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.print();
    }
}
