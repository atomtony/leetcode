package multithread.c1116;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        printNumber.accept(0);
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        printNumber.accept(0);
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

    }

    public static void main(String[] args) throws InterruptedException {
        final ZeroEvenOdd fooBar = new ZeroEvenOdd(10);

        fooBar.zero(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });

    }
}
