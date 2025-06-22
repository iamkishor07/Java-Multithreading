package CompletableFutureExp;

import java.util.concurrent.*;

public class thenComposeAndthenComposeAsyncExp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1, 4, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(1), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
        );

        /*
        * thenCompose
        * It's a synchronous operation
        * It's Runs in same thread as previous executed task Async Task
        * It maintains the order of execution
        * More Efficient as it uses only singe thread, Less context switching*/


        CompletableFuture<String> futureObj1 = CompletableFuture.supplyAsync(() ->
        {
            System.out.println("thread name which runs 'supplyAsync':  " + Thread.currentThread().getName());
            return "Hello ";
        },threadPoolExecutor).thenCompose((String val) ->
        {
            return CompletableFuture.supplyAsync( () ->
            {
                System.out.println("thead name which executes first 'thenCompose'  " + Thread.currentThread().getName());
                return val +"All";
            },threadPoolExecutor).thenCompose((String val1) ->
            {
                return CompletableFuture.supplyAsync( () ->
                {
                    System.out.println("thead name which executes Second 'thenCompose' " + Thread.currentThread().getName());
                    return val1 +" World";
                },threadPoolExecutor);
            });

        });

        /*
        * thenComposeAsync
        * It's Asynchronous operation
        * It's run on different threads
        * Can have custom Executors(threadpoolExecutor)
        * It maintains the order of execution
        * More context switching as it runs asynchronously */
        CompletableFuture<String> futureObj2 = CompletableFuture.supplyAsync(() ->
        {
            System.out.println("thread name which runs 'supplyAsync':  " + Thread.currentThread().getName());
            return "Hello ";
        },threadPoolExecutor).thenComposeAsync((String val) ->
        {
            return CompletableFuture.supplyAsync( () ->
            {
                try {
                    System.out.println("thead name which executes first 'thenComposeAsync' " + Thread.currentThread().getName());
                    Thread.sleep(3000);
                }
                catch (Exception e)
                {

                }
                return val +"All";
            },threadPoolExecutor).thenComposeAsync((String val1) ->
            {
                return CompletableFuture.supplyAsync( () ->
                {
                    try{
                        System.out.println("thead name which executes second 'thenComposeAsync' " + Thread.currentThread().getName());
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return val1 +" World";
                },threadPoolExecutor);
            },threadPoolExecutor).thenComposeAsync((String val1) ->
            {
                return CompletableFuture.supplyAsync( () ->
                {
                    try {

                        System.out.println("thead name which executes thrid 'thenComposeAsync' " + Thread.currentThread().getName());
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return val1 +" Async";
                },threadPoolExecutor);
            },threadPoolExecutor);

        },threadPoolExecutor);

        System.out.println(futureObj1.get());
        System.out.println(futureObj2.get());
        threadPoolExecutor.shutdown();
    }
}
