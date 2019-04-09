package p_c_patterns._1;

public class ThreadB implements Runnable{
    private MyService myService;

    public ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.waitB();
    }
}
