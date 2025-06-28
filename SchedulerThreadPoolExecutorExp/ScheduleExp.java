package SchedulerThreadPoolExecutorExp;

import java.util.concurrent.*;

public class ScheduleExp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(10);

        //The below task will be executed after 9 Seconds delay from start.
       Future<?> futureObj1 =  scheduledExecutorService.schedule(() ->
        {
            System.out.println("This task is scheduled In Runnable With No Return");
        }, 9, TimeUnit.SECONDS);

        Future<String > futureObj2 = scheduledExecutorService.schedule(() ->
        {
            System.out.println("This task is scheduled In Callable with return");
            return "hello";
        }, 9, TimeUnit.SECONDS);

        System.out.println(futureObj2.get());


    }
}
