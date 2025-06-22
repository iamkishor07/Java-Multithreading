package CompletableFutureExp;

import java.util.concurrent.*;

public class SupplyAsyncExp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 4, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
        );

        CompletableFuture<String> futureObj1 = CompletableFuture.supplyAsync(() ->
        {
            System.out.println("new task executing default poolExecutor " + Thread.currentThread().getName());
            return "Executed";
        });

        CompletableFuture<String> futureObj2 = CompletableFuture.supplyAsync(() ->
        {
            System.out.println("new task executing with custom TheadPoolExecutor " + Thread.currentThread().getName());
            return "Executed";
        },threadPoolExecutor);

        System.out.println(futureObj1.get());
        System.out.println(futureObj2.get());

        threadPoolExecutor.shutdown();


    }
}
