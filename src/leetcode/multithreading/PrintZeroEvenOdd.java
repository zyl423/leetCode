package leetcode.multithreading;

import java.util.concurrent.*;
import java.util.function.IntConsumer;

/**
 * @Author: Zyl
 * @Date: 2020/1/13 23:06
 */
public class PrintZeroEvenOdd{
    public static void main(String[]args){
        int n = 6;
        ZeroEvenOdd printer = new ZeroEvenOdd(n);
        IntConsumer intConsumer = new IntConsumerImpl();

        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2*n + 1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2*n, 2*n + 10, 200, TimeUnit.MILLISECONDS,
                workQueue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        executor.execute(() -> {
            try {
                printer.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                printer.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                printer.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
    }

    private static class IntConsumerImpl implements IntConsumer {
        @Override
        public void accept(int value) {
            System.out.print(value);
        }
    }
}

class ZeroEvenOdd {

    private int n;

    private Semaphore zeroSemaphore;
    private Semaphore evenSemaphore;
    private Semaphore oddSemaphore;

    public ZeroEvenOdd(int n) {
        this.n = n;
        zeroSemaphore = new Semaphore(1);
        evenSemaphore = new Semaphore(0);
        oddSemaphore = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++){
            zeroSemaphore.acquire();
            printNumber.accept(0);
            // is odd
            if((i & 1) == 1){
                oddSemaphore.release();
            }else{
                evenSemaphore.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2){
            evenSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2){
            oddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }
}
