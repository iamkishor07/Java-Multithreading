package FutureExp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureAndCallableExp {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 4, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
        );

    /*
        There are 3 Submits of threadPoolExecutors
        1. Submit(Runnable)
        2. Submit(Runnable , Value)
        3. Submit(Callable)
    */


        //UseCase - 1

        Future<?> futureObj1 = threadPoolExecutor.submit(() ->
        {
            System.out.println("In this Task ");
        });


        try {
            Object object = futureObj1.get();
            System.out.println(object); //Always null
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        //UseCase 2 :
        //where it takes Runnable & result , In here we are passing list as result
        List<Integer> list = new ArrayList<>();
        Future<List<Integer>> futureObj2 = threadPoolExecutor.submit(new MyRunnable(list),list);

        try
        {
            List<Integer> lis = futureObj2.get();
            System.out.println(lis.get(0));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //UseCase : 3
        //Where here we are passing Callable function
        Future<List<Integer>> futureObj3= threadPoolExecutor.submit(() ->
        {
            List<Integer> ans = new ArrayList<>();
            System.out.println("Inside this callable Submit");
            ans.add(45);
            return ans;
        });


        try
        {
            List<Integer> lis = futureObj3.get();
            System.out.println(lis.get(0));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        threadPoolExecutor.shutdown();
    }
}
