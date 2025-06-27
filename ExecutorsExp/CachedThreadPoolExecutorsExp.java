package ExecutorsExp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExecutorsExp {
    public static void main(String[] args)
    {
        //This Executor Creates thread dynamically ,It can go max Integer, MAX_VALUE
        ExecutorService poolExecutors = Executors.newCachedThreadPool();
        //Each thread alive time is 60 seconds when idle.

        //As Below, we have three tasks submits It's creates 3 threads.
        poolExecutors.submit(() -> {
            System.out.println("Im running at 1 " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        poolExecutors.submit(() -> {
            System.out.println("Im running at 2 " + Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        poolExecutors.submit(() -> {
            System.out.println("Im running at 3 " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        poolExecutors.shutdown();

    }

}
