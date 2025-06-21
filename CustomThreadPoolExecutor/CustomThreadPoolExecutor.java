package CustomThreadPoolExecutor;

import java.util.concurrent.*;

public class CustomThreadPoolExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,4,6000, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),new customRejecHandler()
        );
                //if this is speicified then only the the keepAliveTime will work , else if you specify that keepAliveTime it won't work
                threadPoolExecutor.allowCoreThreadTimeOut(true);

            for(int i = 1; i<= 16; i++)
            {
                threadPoolExecutor.submit(
                        ()->
                        {
                            try {
                                Thread.sleep(5000);
                                System.out.println("Thread Name "+ Thread.currentThread().getName() );
                            } catch (Exception e) {

                            }
                        }

                );
            }

            threadPoolExecutor.shutdown();
    }
}

class customRejecHandler implements RejectedExecutionHandler
{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected "+r.toString());
    }
}

