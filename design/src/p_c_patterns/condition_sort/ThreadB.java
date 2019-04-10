package p_c_patterns.condition_sort;

public class ThreadB extends Thread{

    private MyService myService;

    public ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.PrintB();
    }
}
