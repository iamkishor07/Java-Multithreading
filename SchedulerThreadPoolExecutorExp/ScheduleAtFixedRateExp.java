package SchedulerThreadPoolExecutorExp;

import java.util.concurrent.*;

public class ScheduleAtFixedRateExp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(10);

        //The below task will execute with 5 seconds initial delay, upon that executes every 9 seconds.
        Future<?> futureObj1 =  scheduledExecutorService.scheduleAtFixedRate(() ->
        {
            System.out.println("This task is scheduled In Runnable With No Return");
            try{
                Thread.sleep(6000);
                System.out.println("This task is awaken after sleep");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },2, 5, TimeUnit.SECONDS);


        //As above that executes for every period of 5 - Seconds, But in the task it sleep for 6 seconds,
        //Internally after 5 seconds another task will be waiting in the queue , until previous task is not
        //completed the current task will not execute,

        //Once the previous task is completed, it will execute from the queue,as there would be no delay it immediately starts
        //the execution.

        //In the above exp, initial delay is 2 seconds after that the task will be running, & we have given the period as 5 seconds,
        //If the previous took more than that time, new task will be waiting in the queue,once the previous task is completed then immediate
        //it picks the task form the queue.


    }
}
