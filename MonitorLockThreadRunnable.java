public class MonitorLockThreadRunnable implements Runnable{

    MonitorLockExp monitorLockExp;
    public MonitorLockThreadRunnable(MonitorLockExp monitorLockExp) {
        this.monitorLockExp =monitorLockExp;
    }

    @Override
    public void run() {
        monitorLockExp.task1();
    }
}
