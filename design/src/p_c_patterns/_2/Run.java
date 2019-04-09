package p_c_patterns._2;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        ThreadB threadB = new ThreadB(myService);
        Thread thread1 = new Thread(threadA);
        Thread thread2 = new Thread(threadB);
        thread1.start();
        thread2.start();

        Thread.sleep(1000);
        myService.signalA();
        Thread.sleep(2000);
//        myService.signalB();

    }
}
