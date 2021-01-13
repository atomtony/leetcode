package day1;

import java.util.Arrays;

public class DynamicArray {

    static class Array {

        private Object[] array;
        private int count;
        private int size;

        public Array() {
            this.count = 0;
            this.size = 10;
            this.array = new Object[this.size];
        }

        // 每次扩容１.５倍
        public void add(Object o) {
            if (count == size) {
                int newSize = size * 3 / 2;
                Object[] newArray = new Object[newSize];
                System.arraycopy(array, 0, newArray, 0, size);
                array = newArray;
                size = newSize;
            }
            array[count++] = o;
        }

        public void remove(Object o) {
            if (o == null) {
                throw new RuntimeException("o must be not null!");
            }

            for (int i = 0; i < count; i++) {
                if (array[i].equals(o)) {
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

    public static void main(String[] args) {
        Array array = new Array();

        // 添加
        for (int i = 0; i < 11; i++) {
            array.add(i);
        }
        array.printAll();

        // 删除第一个
        array.remove((Object) 0);
        array.printAll();


        // 删除最后一个
        array.remove((Object) 10);
        array.printAll();

        // 删除中间
        array.remove((Object) 5);
        array.remove((Object) 2);
        array.printAll();

    }
}
