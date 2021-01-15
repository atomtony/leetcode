package day2.queue;

public class LinkedQueue<T> {

    // 队列的队首和队尾
    private Node head = null;
    private Node tail = null;

    static class Node<T> {
        T value;
        Node<T> next = null;
    }

    public boolean enqueue(T item) {
        if (head == null) {
            Node<T> newNode = new Node();
            newNode.value = item;

            head = newNode;
            tail = newNode;
        } else {
            Node<T> newNode = new Node();
            newNode.value = item;

            tail.next = newNode;
            tail = newNode;
        }
        return true;
    }

    public T dequeue() {
        Node<T> node = null;
        if (head == null) {
            return null;
        }
        if (head == tail) {
            node = head;
            head = null;
            tail = null;
        } else {
            node = head;
            head = head.next;
            node.next = null;
        }
        return node.value;
    }

    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>();
        for (int i = 0; i < 7; i++) {
            queue.enqueue(String.valueOf(i));
        }

        for (int i = 0; i < 8; i++) {
            System.out.println(queue.dequeue());
        }

    }
}
