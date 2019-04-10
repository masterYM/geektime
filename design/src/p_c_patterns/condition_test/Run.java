package p_c_patterns.condition_test;

public class Run {
    public static void main(String[] args) {
        final MyService myService = new MyService();
        ThreadA thread1 = new ThreadA(myService);
        ThreadB thread2 = new ThreadB(myService);
        thread1.start();
        thread2.start();

        final  int a = 10;

    }
}
