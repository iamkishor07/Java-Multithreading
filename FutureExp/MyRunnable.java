package FutureExp;

import java.util.List;

public class MyRunnable implements Runnable{

    List<Integer> list;
    public MyRunnable(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println("Im Running");
        list.add(100);
    }
}
