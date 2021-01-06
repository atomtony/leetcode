import java.util.Arrays;

public class Ch28_Heap {

    static class Heap {

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

        public void removeMax() {
            if (count == 0) {
                return;
            }

            a[1] = a[count];
            --count;
            heapify(a, count, 1);
        }

        private static void heapify(int[] a, int n, int i) {//自上往下堆化
            while (true) {
                int maxPos = i;

                // 左节点大于当前节点
                if (i * 2 <= n && a[i] < a[i * 2]) {
                    maxPos = i * 2;
                }

                // 右节点大于左节点或者当前节点
                if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                    maxPos = i * 2 + 1;
                }

                // 当前节点最大
                if (maxPos == i) {
                    break;
                }

                // 交换当前节点和较大的那个子节点
                swap(a, i, maxPos);

                // 记录较大那个子节点为当前节点
                i = maxPos;
            }
        }

        private static void swap(int[] a, int index1, int index2) {
            int tmp = a[index1];
            a[index1] = a[index2];
            a[index2] = tmp;
        }

        private void print() {
            int[] b = new int[count];
            System.arraycopy(a, 1, b, 0, count);
            System.out.println(Arrays.toString(b));
        }

        // 自建堆
        public static void buildHeap(int[] a, int n) {
            for (int i = n / 2; i >= 1; --i) {
                heapify(a, n, i);
            }
        }

        // 堆排序
        public static void sort(int[] a, int n) {
            buildHeap(a, n);
            int k = n;
            while (k > 1) {
                // 每次交换，把最大的放置最后
                swap(a, 1, k);
                // 个数减少1
                --k;
                // 然后剩下的再次堆化，下标为1的又是最大的。
                heapify(a, k, 1);
            }
        }

        public static void print(int a[], int count) {
            int[] b = new int[count];
            System.arraycopy(a, 1, b, 0, count);
            System.out.println(Arrays.toString(b));
        }
    }

    public static void main(String[] args) {

        // 插入测试
        {
            Heap heap = new Heap(15);
            //第一行
            heap.insert(33);
            //第二行
            heap.insert(27);
            heap.insert(21);
            //第三行
            heap.insert(16);
            heap.insert(13);
            heap.insert(15);
            heap.insert(9);
            //第四行
            heap.insert(5);
            heap.insert(6);
            heap.insert(7);
            heap.insert(8);
            heap.insert(1);
            heap.insert(2);
            heap.print();
            // 测试插入22
            heap.insert(22);
            heap.print();
        }

        // 删除测试
        {
            Heap heap = new Heap(16);
            //第一行
            heap.insert(33);
            //第二行
            heap.insert(27);
            heap.insert(21);
            //第三行
            heap.insert(16);
            heap.insert(13);
            heap.insert(15);
            heap.insert(19);
            //第四行
            heap.insert(5);
            heap.insert(6);
            heap.insert(7);
            heap.insert(8);
            heap.insert(1);
            heap.insert(2);
            heap.insert(12);
            heap.print();
            // 删除最大
            heap.removeMax();
            heap.print();
        }

        // 自建堆测试
        {
            System.out.println("自建堆测试");
            int[] a = new int[10];
            a[1] = 7;
            a[2] = 5;
            a[3] = 19;
            a[4] = 8;
            a[5] = 4;
            a[6] = 1;
            a[7] = 20;
            a[8] = 13;
            a[9] = 16;

            Heap.print(a, 9);
            Heap.buildHeap(a, 9);
            Heap.print(a, 9);
        }

        // 堆排序
        {
            System.out.println("堆排序");
            int[] a = new int[6];
            a[1] = 9;
            a[2] = 6;
            a[3] = 3;
            a[4] = 1;
            a[5] = 5;

            Heap.print(a, 5);
            Heap.sort(a, 5);
            Heap.print(a, 5);
        }
    }
}
