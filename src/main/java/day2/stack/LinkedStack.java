package day2.stack;

public class LinkedStack {

    static class Node<T> {
        private T value;
        private Node next;
    }

    static class Stack<T> {

        private Node<T> head;

        public boolean push(T item) {
            if (head == null) {
                head = new Node<>();
                head.value = item;
            } else {
                Node tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }

                Node<T> newNode = new Node<>();
                newNode.value = item;
                tail.next = newNode;
            }
            return true;
        }

        public T pop() {
            Node<T> tail = head;
            // 无数据
            if (tail == null) {
                return null;
            }

            // 只有一个元素
            if (tail.next == null) {
                head = null;
                return tail.value;
            }

            //
            Node<T> parent = head;
            while (tail.next != null) {
                parent = tail;
                tail = tail.next;
            }

            parent.next = null;
            return tail.value;
        }
    }


    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < 12; i++) {
            stack.push(String.valueOf(i));
        }


        for (int i = 0; i < 20; i++) {
            System.out.println(stack.pop());
        }


    }
}
