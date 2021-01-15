package day2.queue;

public class ArrayQueue<T> {

    private Object[] array;
    private int head = 0;
    private int tail = 0;
    private int n = 0;

    public ArrayQueue() {
        this.n = 10;
        this.array = new Object[this.n];
    }

    public boolean enqueue(T item) {
        if (tail == n) {
            return false;
        }
        array[tail++] = item;
        return true;
    }

    public T dequeue() {
        if (head == tail) {
            return null;
        }
        return (T) array[head++];
    }

    public static void main(String[] args) {

        ArrayQueue<String> queue = new ArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(String.valueOf(i));
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(queue.dequeue());
        }

    }
}
