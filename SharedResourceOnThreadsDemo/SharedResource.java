package SharedResourceOnThreadsDemo;

public class SharedResource {

    private boolean isItemAvailable  = false;

    //As it is synchronized method,it puts a monitor lock
    //as soon as it executes at end it is calling notifyAll() method,
    //that calls all the waiting threads on this object instance... as it removes the monitor lock
    public synchronized void addItem(){
        isItemAvailable = true;
        System.out.println("Adding Task" + Thread.currentThread().getName());
        notifyAll();
    }

    //This method is of synchronized, it put monitor lock while executing
    //Inside this wait() method is being called,that wait method removes
    //the Monitor lock & allows other thread to execute the program
    //it will be in that wait state untill some one calls notifyAll() method

    public synchronized void consumeItem()
    {
        System.out.println("Inside the Consume Item in shared Resource: "+ Thread.currentThread().getName());

        if (!isItemAvailable)
        {
            try {
                System.out.println("as item is not available waiting of that: " + Thread.currentThread().getName());
                wait(); //it will wait , untill some one calls notifyAll. it removes all the monitor locks
            }
            catch(Exception e)
            {
                //some exception handling
            }
        }
        System.out.println("as item is  available & Consumed  " + Thread.currentThread().getName());
        isItemAvailable = false;
    }


}
