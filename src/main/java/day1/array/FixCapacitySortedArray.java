package day1.array;

import java.util.Arrays;
import java.util.List;

public class FixCapacitySortedArray {

    static class Array<T extends Comparable<T>> {
        private Object[] array;
        private int count;
        private int size;

        public Array() {
            this(10);
        }

        public Array(int size) {
            this.size = size;
            this.array = new Object[size];
        }

        public void add(T value) {

            if (count >= size) {
                throw new RuntimeException("array full");
            }

            // 空数组，插入一点个元素
            if (count == 0) {
                array[count++] = value;
                return;
            }

            int index = -1;
            for (int i = 0; i < count; i++) {
                T item = (T) array[i];
                if (value.compareTo(item) > 0) {
                    index = i;
                } else {
                    break;
                }
            }

            // 下标0位置插入，所有元素后移一位
            if (index == -1) {
                System.arraycopy(array, 0, array, 1, count);
                array[0] = value;
                count++;
                return;
            }

            // 最后一个元素之后插入
            if (index + 1 == count) {
                array[count++] = value;
                return;
            }

            // 中间位置插入
            int insertIndex = index + 1;
            for (int i = count - 1; i >= insertIndex; i--) {
                array[i + 1] = array[i];
            }
            array[insertIndex] = value;
            count++;
        }

        public void remove(T value) {
            if (count <= 0) {
                return;
            }

            for (int i = 0; i < count; i++) {
                T item = (T) array[i];
                if (value.compareTo(item) == 0) {
                    remove(i);
                    break;
                }
            }

        }

        public void remove(int index) {

            if (index < 0 || index >= count) {
                throw new RuntimeException("index must more than zero and less than " + count);
            }

            // 最后一个
            if (index == count - 1) {
                count--;
                array[index] = null;
                return;
            }

            System.arraycopy(array, index+1, array, index , count - index - 1);
            count--;
        }

        public void printAll() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            for (int i = 0; i < count; i++) {
                builder.append(array[i]).append(",");
            }
            builder.append("]");
            System.out.println(builder.toString());
        }


    }

    static class MyInteger implements Comparable<MyInteger> {

        private final Integer value;

        public MyInteger() {
            this(0);
        }

        public MyInteger(Integer value) {
            this.value = value;
        }

        @Override
        public int compareTo(MyInteger myInteger) {
            return value - myInteger.value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public static void main(String[] args) {
        Array<MyInteger> array = new Array<>();

        List<Integer> values = Arrays.asList(1, 2, 5, 47, 3, 9,9,9,12);

        // 添加
        for (Integer value : values) {
            array.add(new MyInteger(value));
        }
        array.printAll();

        // 删除第一个
        array.remove(new MyInteger(1));
        array.printAll();

        // 删除最后一个
        array.remove(new MyInteger(47));
        array.printAll();

        // 删除中间
        array.remove(new MyInteger(3));
        array.remove(new MyInteger(5));
        array.printAll();
    }
}
