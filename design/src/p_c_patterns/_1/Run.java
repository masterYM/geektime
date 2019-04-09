package p_c_patterns._1;

/**
 * 通知所有 --错误用法
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        ThreadB threadB = new ThreadB(myService);
        Thread r1 = new Thread(threadA);
        Thread r2 = new Thread(threadB);
        r1.start();
        r2.start();
        Thread.sleep(50);
        myService.notify1();

    }

}
