package p_c_patterns._1;

public class ThreadA implements Runnable{
    private MyService myService;

    public ThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.waitA();
    }
}
