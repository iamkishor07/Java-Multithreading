public class DaemonAsyncThreadExp {
    public  static  void main(String[] args)
    {
        System.out.println("Main thread running....");
        Thread th1 = new Thread(() ->
        {
            while (true) {
                System.out.println("Daemon thread running...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
        });

        th1.setDaemon(true);
        th1.start();
        // Main thread (user thread)
        try {
            Thread.sleep(1000); // Let daemon run for a while
            //th1.join(); //Join Method -> the current main thread is blocked or waited until the specified thread finished.
        } catch (InterruptedException e) {}


        System.out.println("Main thread finished");

    }

  /*
  Out put :
    Main thread running....
    Daemon thread running...
    Daemon thread running...
    Daemon thread running...
    Daemon thread running...
    Main thread finished
   */


}
