package p_c_patterns.condition_sort;

public class ThreadA extends Thread{

    private MyService myService;

    public ThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.PrintA();
    }
}
