package leetcode.multithreading;

import java.util.concurrent.*;

/**
 * @Author: Zyl
 * @Date: 2020/1/30 23:57
 */
public class GeneratedH2O {
    static volatile String input = "hhooohhhhhho";

    public static void main(String[] args) {
        H2O h2o = new H2O();
        int n = input.length();
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(n);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2*n, 2*n + 10, 200, TimeUnit.MILLISECONDS,
                workQueue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        executor.execute(() -> {
            final String element = "h";
            try {
                while(true){
                    h2o.hydrogen(() -> {
                        synchronized (input){
                            if(input.contains(element)){
                                System.out.print(input.charAt(input.indexOf(element)));
                                input = input.replaceFirst(element, "");
                            }
                        }
                    });
                    synchronized (input){
                        if(!input.contains(element)){
                            break;
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            final String element = "h";
            try {
                while(true){
                    h2o.hydrogen(() -> {
                        synchronized (input){
                            if(input.contains(element)){
                                System.out.print(input.charAt(input.indexOf(element)));
                                input = input.replaceFirst(element, "");
                            }
                        }
                    });
                    synchronized (input){
                        if(!input.contains(element)){
                            break;
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            final String element = "o";
            try {
                while(true){
                    h2o.oxygen(() -> {
                        synchronized (input){
                            if(input.contains(element)){
                                System.out.print(input.charAt(input.indexOf(element)));
                                input = input.replaceFirst(element, "");
                            }
                        }
                    });
                    synchronized (input){
                        if(!input.contains(element)){
                            break;
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
    }

}

class H2O {

    private CyclicBarrier barrier;

    private Semaphore semaphoreH;
    private Semaphore semaphoreO;

    public H2O() {
        semaphoreH = new Semaphore(2);
        semaphoreO = new Semaphore(1);
        barrier  = new CyclicBarrier(3, () -> {
            semaphoreH.release(2);
            semaphoreO.release();
        });
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreH.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphoreO.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}