package leetcode.multithreading;

import java.util.concurrent.*;
import java.util.function.IntConsumer;

/**
 * @Author: Zyl
 * @Date: 2020/2/1 11:10
 */
public class AlternatePrintingFizzBuzz {

    public static void main(String[] args) {
        int n = 15;
        FizzBuzz fizzBuzz = new FizzBuzz(n);
        IntConsumer intConsumer = new IntConsumerImpl();

        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2*n + 1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2*n, 2*n + 10, 200, TimeUnit.MILLISECONDS,
                workQueue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        executor.execute(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.print("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                fizzBuzz.number(intConsumer);
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


class FizzBuzz {
    private int n;

    private Semaphore fizzSemaphore;
    private Semaphore buzzSemaphore;
    private Semaphore fizzBuzzSemaphore;
    private Semaphore numberSemaphore;

    public FizzBuzz(int n) {
        this.n = n;
        fizzSemaphore = new Semaphore(0);
        buzzSemaphore = new Semaphore(0);
        fizzBuzzSemaphore = new Semaphore(0);
        numberSemaphore = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i % 3 == 0) && !(i % 5 == 0)) {
                fizzSemaphore.acquire();
                printFizz.run();
                numberSemaphore.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (!(i % 3 == 0) && (i % 5 == 0)) {
                buzzSemaphore.acquire();
                printBuzz.run();
                numberSemaphore.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)){
                fizzBuzzSemaphore.acquire();
                printFizzBuzz.run();
                numberSemaphore.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)){
                fizzBuzzSemaphore.release();
                numberSemaphore.acquire();
            }else if ((i % 3 == 0)) {
                fizzSemaphore.release();
                numberSemaphore.acquire();
            }else if ((i % 5 == 0)) {
                buzzSemaphore.release();
                numberSemaphore.acquire();
            }else {
                numberSemaphore.acquire();
                printNumber.accept(i);
                numberSemaphore.release();
            }
        }
    }
}