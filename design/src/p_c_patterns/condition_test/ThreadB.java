package p_c_patterns.condition_test;

public class ThreadB extends Thread {
    private MyService myService;

    public ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        for(int i = 0;i < 10;i++){
            myService.printB();
        }
    }
}
