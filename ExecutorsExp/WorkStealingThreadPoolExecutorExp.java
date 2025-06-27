package ExecutorsExp;

import java.util.concurrent.*;

public class WorkStealingThreadPoolExecutorExp {
    public static void main(String[] args)
    {
        //This WorkStealingPool - Internally it creates the fork-join ThreadPool Executors
        //The No.Of threads depends upon the available processor in a system
        ExecutorService poolExecutors = Executors.newWorkStealingPool();


        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> ans = pool.submit(new ComputeSumTask(0,100));

        try {
            System.out.println(ans.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        poolExecutors.shutdown();

    }

}
