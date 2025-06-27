package ExecutorsExp;

import java.util.concurrent.RecursiveTask;

public class ComputeSumTask extends RecursiveTask<Integer> {
    int start, end;
    public ComputeSumTask( int s, int e)
    {
        start = s;
        end = e;
    }

    @Override
    protected Integer compute() {

        if(end - start <= 1)
        {
            return 1;
        }
        else {
            //split the task into two parts
            int mid = (end + start) / 2;

            ComputeSumTask left = new ComputeSumTask(start, mid);
            ComputeSumTask right = new ComputeSumTask(mid + 1, end);
            System.out.println("current Thread : "  + Thread.currentThread().getName() + " end = " + end  +" start = " + start );
            left.fork();
            right.fork();

            int leftRes = left.join();
            int rightRes= right.join();
            return  leftRes + rightRes;

        }
    }
}
