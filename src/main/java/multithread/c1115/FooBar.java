package multithread.c1115;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class FooBar {
    private int n;

    private Semaphore semaphore1 = new Semaphore(1);
    private Semaphore semaphore2 = new Semaphore(1);

    public FooBar(int n) {
        this.n = n;
        try {
            semaphore2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            semaphore1.acquire();
            printFoo.run();
            semaphore2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            semaphore2.acquire();
            printBar.run();
            semaphore1.release();
        }
    }

    public static void main(String[] args) {
        final FooBar fooBar = new FooBar(10);

        new Thread(new Runnable() {
            public void run() {
                try {
                    fooBar.foo(new Runnable() {
                        public void run() {
                            System.out.printf("foo");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    fooBar.bar(new Runnable() {
                        public void run() {
                            System.out.println("bar");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
