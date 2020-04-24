package multithread.c1114;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

public class Foo {
    private CountDownLatch latch2 = new CountDownLatch(1);//此处不能用静态
    private CountDownLatch latch3 = new CountDownLatch(1);//此处不能用静态

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        latch2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        latch2.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        latch3.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        latch3.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {

        Runnable printFirst = new Runnable() {
            public void run() {
                System.out.println("first");
            }
        };
        Runnable printSecond = new Runnable() {
            public void run() {
                System.out.println("second");
            }
        };

        Runnable printThird = new Runnable() {
            public void run() {
                System.out.println("third");
            }
        };


    }

}
