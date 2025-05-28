package ProducerConsumerProblem;

import java.util.PriorityQueue;
import java.util.Queue;

public class SharedResourceBuffer {

    Queue<Integer> sharedBuffer;
    int bufferSize;
    SharedResourceBuffer(int bufferSize)
    {
        sharedBuffer = new PriorityQueue<>();
        this.bufferSize = bufferSize;
    }


    //produce data
    public synchronized void produceData(int item)
    {
        System.out.println("Inside produce Data :" + Thread.currentThread().getName());
        try {
            while (sharedBuffer.size() == bufferSize)
            {
                System.out.println("Buffer is Full, Waiting consumer to consume : " + Thread.currentThread().getName());
               wait();
            }
            sharedBuffer.offer(item);
            System.out.println("Produced Data: "  + item +" " + Thread.currentThread().getName());
            //as items were added, it notifies all consumer to consume data
            notify();

        } catch (Exception e) {
            //something
        }

    }

    //consume data
    public synchronized int consumeData() throws InterruptedException {
        //if there is no data , It needs to wait
        System.out.println("Inside consumeData :" + Thread.currentThread().getName());


            while (sharedBuffer.isEmpty())
            {
                System.out.println("Buffer is Empty, waiting Producer to produce data :" + Thread.currentThread().getName());
                wait(); //It removes the monitor lock.
            }
            int item = sharedBuffer.poll();
            System.out.println("consume Data : " + item+ "  " + Thread.currentThread().getName());
            notify();
            //so something
        return item;
    }
}
