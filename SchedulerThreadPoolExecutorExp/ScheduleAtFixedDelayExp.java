package SchedulerThreadPoolExecutorExp;

import java.util.concurrent.*;

public class ScheduleAtFixedDelayExp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(10);

        //The below task will execute with 5 seconds initial delay, upon that executes every 9 seconds.
        Future<?> futureObj1 =  scheduledExecutorService.scheduleWithFixedDelay(() ->
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

        //In here no matter what the delay is , it will consider the delay time once previous task is completed.

        //In the above exp ,initial delay is 2 seconds after that the task will be running, & once it completd no matter
        //how much time does it took, once its completed then it start after the 5 seconds delay.

    }
}
