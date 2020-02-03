package leetcode.multithreading;

import java.util.concurrent.*;

/**
 * @Author: Zyl
 * @Date: 2020/1/12 17:18
 */
public class AlternatelyPrintFoobars{

    public static void main(String[] args) {
        int n = 10;
        FooBar foobar = new FooBar(n);
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2*n + 1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2*n, 2*n + 10, 200, TimeUnit.MILLISECONDS,
                workQueue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        executor.execute(() -> {
            try {
                foobar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                foobar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
    }
}

class FooBar {
    private int n;
    private Semaphore fooSemaphore;
    private Semaphore barSemaphore;

    public FooBar(int n) {
        this.n = n;
        fooSemaphore = new Semaphore(1);
        barSemaphore = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            fooSemaphore.acquire();
            printFoo.run();
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {

            barSemaphore.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSemaphore.release();
        }
    }
}