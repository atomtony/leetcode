package day2.stack;

public class ArrayStack {

    static class Stack<T> {

        private int size;
        private Object[] array;
        private int count;

        public Stack() {
            this.size = 10;
            this.count = 0;
            this.array = new Object[this.size];
        }

        public boolean push(T item) {
            if (count >= size) {
                return false;
            }
            array[count++] = item;
            return true;
        }

        public T pop() {
            if (count <= 0) {
                return null;
            }
            return (T) array[--count];
        }
    }

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < 12; i++) {
            stack.push(String.valueOf(i));
        }

        System.out.println(stack.size);

        System.out.println(stack.pop().equals("9"));


    }
}
