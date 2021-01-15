package day2.queue;

public class CircularQueue<T> {

    private Object[] array;
    private int head = 0;
    private int tail = 0;
    private int n = 0;

    public CircularQueue() {
        this.n = 10;
        this.array = new Object[this.n];
    }

    public boolean enqueue(T item) {
        if ((tail + 1) % n == head) {
            return false;
        }
        array[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public T dequeue() {
        if ((head + 1) % n == tail) {
            return null;
        }

        T item = (T) array[head];
        array[head] = null;
        head = (head + 1) % n;

        return item;
    }

    public static void main(String[] args) {


        CircularQueue<String> queue = new CircularQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(String.valueOf(i));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(queue.dequeue());
        }

    }
}
