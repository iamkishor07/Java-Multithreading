package CompletableFutureExp;

import java.util.concurrent.*;

public class thenApplyAndthenApplyAsyncExp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 4, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
        );

        /*
        * thenApply :
        * It's a synchronous operation
        * Means, it uses the same thread,which executes the previous Async taks
        */


        CompletableFuture<String> futureObj1 = CompletableFuture.supplyAsync(() ->
        {
            try {
                System.out.println("thread name which runs 'supplyAsync':  " + Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Multi";
        },threadPoolExecutor).thenApply((String val) ->
        {
            System.out.println("thread name which runs 'thenApply':  " + Thread.currentThread().getName());

            return  val +"Threading with thenApply";
        });


        /*
         * thenApplyAsync :
         *  It is a Asynchronous operation
         * Means,It uses different thread to execute to complete the function, not previously executed Async task
         * It uses 'fork-Join pool', if we don't provide the executor in the method
         * If multiple 'thenApplyAsync' is used , ordering is not guaranteed , they will run asynchronously
         * */

        CompletableFuture<String> futureObj2 = CompletableFuture.supplyAsync(() ->
        {
            try {
                System.out.println("thread name which runs 'supplyAsync':  " + Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return "Hello";
        }, threadPoolExecutor).thenApplyAsync((String val) -> //Calls first thenApplyAsync
        {
            try {
                System.out.println("thread name which runs 'thenApplyAsync':  " + Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            return val +" All";
        }).thenApplyAsync((String val) -> //calls second thenApplyAsync
        {
            System.out.println("thread name which runs second 'thenApplyAsync':  " + Thread.currentThread().getName());
            return  val +" World";
        });



        System.out.println("Main Thread " + Thread.currentThread().getName());
        System.out.println(futureObj1.get());
        System.out.println(futureObj2.get());
        threadPoolExecutor.shutdown();
    }
}
