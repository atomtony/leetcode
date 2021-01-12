package day1;

public class DynamicArray {

    static class Array {

        private Object[] array;
        private int count;
        private int size = 10;

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

            int index = 0;
            for (int i = 0; i < count; i++) {
                if (array[i].equals(o)) {
                    remove(i);
                    break;
                }
            }
        }

        public void remove(int index) {
            if (index >= count) {
                throw new RuntimeException("index must less than " + count);
            }
            System.arraycopy(array,index,array,index+1,count-index);
        }

    }

    public static void main(String[] args) {
        Array array = new Array();

        for (int i = 0; i < 11; i++) {
            array.add(i);
        }

        System.out.println(array);
    }
}
