package ExecutorsExp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolExecutorExp {
    public static void main(String[] args)
    {
        //This Executor creates only single thread, And all tasks will be executed by single thread only
        ExecutorService poolExecutors = Executors.newSingleThreadExecutor();
        //the below, three task are executed by single thread, it waits untill the task is finished ,then it goes into
        //the next tasks.

        //No concurrency at all.

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
