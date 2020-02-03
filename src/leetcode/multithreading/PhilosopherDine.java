package leetcode.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: Zyl
 * @Date: 2020/2/1 17:35
 */
public class PhilosopherDine {
    public static void main(String[]args) {
        int n = 5;
        DiningPhilosophers diningPhilosophers = new DiningPhilosophers();
        List<Fork> forkList = new ArrayList<>( 2 * n);
        for (int i = 0; i < n; i++) {
            forkList.add(new Fork(i));
        }

        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2*n + 1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2*n, 2*n + 10, 200, TimeUnit.MILLISECONDS,
                workQueue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());


        for (int i = 0; i < n; i++) {
            final int philosopher = i;

            int rightIndex = philosopher + 1;
            if (philosopher == (n - 1)){
                rightIndex = 0;
            }

            Fork leftFork = forkList.get(philosopher);
            Fork rightFork = forkList.get(rightIndex);

            executor.execute(() -> {
                try {
                    Runnable pickLeftFork = () -> {
                        leftFork.setOwner(philosopher);
                        System.out.println("philosopher:" + philosopher + ": pickLeftFork");
                    };
                    Runnable pickRightFork = () -> {
                        rightFork.setOwner(philosopher);
                        System.out.println("philosopher:" + philosopher + ": pickRightFork");
                    };
                    Runnable eat = () -> {
                        try {
                            System.out.println("philosopher:" + philosopher + ": eating");
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    };
                    Runnable putLeftFork = () -> {
                        leftFork.setNoOwner(philosopher);
                        System.out.println("philosopher:" + philosopher + ": putLeftFork");
                    };
                    Runnable putRightFork = () -> {
                        rightFork.setNoOwner(philosopher);
                        System.out.println("philosopher:" + philosopher + ": putRightFork");
                    };
                    diningPhilosophers.wantsToEat(0, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}

class Fork{
    private int id;
    private int owner = -1;

    public Fork(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwner() {
        return owner;
    }

    public synchronized void setOwner(int owner) {
        if (!hasOwner()){
            this.owner = owner;
        }
    }

    public void setNoOwner(int owner) {
        if (iAmOwner(owner)){
            this.owner = -1;
        }
    }

    private boolean hasOwner(){
        return this.owner != -1;
    }

    public boolean iAmOwner(int philosopher){
        return this.owner == philosopher;
    }
}

class DiningPhilosophers {

    private Semaphore leftFork;
    private Semaphore rightFork;

    public DiningPhilosophers() {
        leftFork = new Semaphore(1);
        rightFork = new Semaphore(1);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        while (true){
            if (leftFork.tryAcquire()){
                if (rightFork.tryAcquire()){
                    pickLeftFork.run();
                    pickRightFork.run();
                    eat.run();
                    putLeftFork.run();
                    leftFork.release();
                    putRightFork.run();
                    rightFork.release();
                    break;
                }else {
                    leftFork.release();
                    Thread.yield();
                }
            }else {
                Thread.yield();
            }
        }
    }
}
