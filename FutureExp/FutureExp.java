package FutureExp;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.*;

public class FutureExp {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 4, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy()
        );

        Future<?> futureObj1 = threadPoolExecutor.submit(()->{
            try {
                Thread.sleep(7000);
            System.out.println("In this task" + + System.currentTimeMillis());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        //In main thread, checking whether that execution is done or not
        System.out.println("Is that task Completed "+ futureObj1.isDone());

        try {
            futureObj1.get(2,TimeUnit.MILLISECONDS);

        } catch (Exception e) {
            System.out.println("Time Out Expection");
        }

        //Now will do a get
        try {
            System.out.println("waiting for that taks to get completed" + System.currentTimeMillis());
            futureObj1.get();
            //wait untill that task thread completes
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Is task done" + futureObj1.isDone() + " " + + System.currentTimeMillis());
        threadPoolExecutor.shutdown();
    }
}
