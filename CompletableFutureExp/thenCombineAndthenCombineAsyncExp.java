package CompletableFutureExp;

import java.util.concurrent.*;

public class thenCombineAndthenCombineAsyncExp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 4, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
        );

        /*
        Both thenCombine and thenCombineAsync
        are used to combine the results of two CompletableFutures once both are complete.
        The difference lies in how the combining function is executed: synchronously or asynchronously.
         */

        CompletableFuture<String> futureObj1 = CompletableFuture.supplyAsync(() ->
        {
            System.out.println("new task executing default poolExecutor " + Thread.currentThread().getName());
            return "Multi";
        });

        CompletableFuture<String> futureObj2 = CompletableFuture.supplyAsync(() ->
        {
            System.out.println("new task executing with custom TheadPoolExecutor " + Thread.currentThread().getName());
            return " Threading";
        },threadPoolExecutor);


        CompletableFuture<String> completableFutureSync = futureObj2.thenCombine(futureObj1 ,(s1,s2) -> {
            System.out.println("Inside theCombine :" +Thread.currentThread().getName());
            return s1 + " " + s2;
        });
        CompletableFuture<String> completableFutureAsync = futureObj2.thenCombineAsync(futureObj1 ,(s1,s2) -> {
            System.out.println("Inside theCombineAsync :" +Thread.currentThread().getName());

            return s1 + " " + s2;
        });

        System.out.println(futureObj1.get());
        System.out.println(futureObj2.get());

        System.out.println(completableFutureSync.get());
        System.out.println(completableFutureAsync.get());

        threadPoolExecutor.shutdown();

    }
}
