package ExecutorsExp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExecutorsExp {
    public static void main(String[] args)
    {
        ExecutorService poolExecutors = Executors.newFixedThreadPool(1);
        //Only five threads are created at the start.

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
            System.out.println("Im running at 3" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        poolExecutors.shutdown();

    }

}
