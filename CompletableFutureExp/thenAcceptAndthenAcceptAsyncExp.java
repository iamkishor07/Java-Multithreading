package CompletableFutureExp;

import java.util.concurrent.*;

public class thenAcceptAndthenAcceptAsyncExp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 4, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
        );

        /*thenAccept
        *  used to handle the result of a computation after it's completed, without returning a new result.
        * Executes synchronously on the same thread that completed the previous stage
        * Good when your logic is lightweight and doesn’t block
        * */
        CompletableFuture<Void> futureObj1 = CompletableFuture.supplyAsync(() ->
        {
            System.out.println("thread name which runs 'supplyAsync':  " + Thread.currentThread().getName());
            return "Executed";
        },threadPoolExecutor).thenApply((String val) ->
        {
            System.out.println("thread name which runs 'thenApply':     " + Thread.currentThread().getName());
            return val +" thenApply";
        }).thenCompose((String val) ->
        {
            System.out.println("thread name which runs 'thenCompose':  " + Thread.currentThread().getName());
            return  CompletableFuture.supplyAsync(() ->
            {
                return val + " thenCompose";
            });

        }).thenAccept( s -> {  //Runs on the same thread
            System.out.println(s);
            System.out.println("thread name which runs 'thenAccept':  " + Thread.currentThread().getName());
        });

        /*thenAcceptAsync
        *  used to handle the result of a computation after it's completed, without returning a new result.
        * Executes asynchronously, typically using the ForkJoinPool.commonPool() or a custom executor if provided.
        * Useful when the consumer logic is time-consuming or should not block the main thread.
        * */

        CompletableFuture<Void> futureObj2 = CompletableFuture.supplyAsync(() ->
        {
            System.out.println("thread name which runs 'supplyAsync':  " + Thread.currentThread().getName());
            return "Executed";
        },threadPoolExecutor).thenAcceptAsync(s ->
        {
            System.out.println("thread name which runs 'thenAcceptAsync':  " + Thread.currentThread().getName());
            System.out.println(s);
        },threadPoolExecutor);

        System.out.println(futureObj1.get());
        System.out.println(futureObj2.get());

        threadPoolExecutor.shutdown();


    }

}
