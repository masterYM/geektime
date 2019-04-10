package p_c_patterns.condition_sort;

public class ThreadC extends Thread{

    private MyService myService;

    public ThreadC(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.PrintC();
    }
}
