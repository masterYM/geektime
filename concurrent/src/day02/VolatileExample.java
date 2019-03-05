package day02;

/**
 * Happens-Before ：前面一个操作的结果对后续操作是可见的
 * Happens-Before 约束了编译器的优化行为，虽然允许编译器优化，但是要求编译器优化后一定遵守Happens-Before 规则
 *
 * Happens-Before 规格：
 *   1、程序的顺序性规则 ： 在一个线程中，按照程序顺序，前面的操作Happens-Before于后续的任意操作。
 *   2、volatile 规则：对一个volatile 变量的写操作，Happens-Before 于后续对这个volatile 变量的读操作
 *   3、如果 A Happens-Before B ，且 B Happens-Before C，那么A Happens-Before C
 */
public class VolatileExample {
    int x = 0;
    volatile boolean v = false;
    public void writer(){
        x = 42;
        v = true;
    }

    public void reader(){
        if(v == true){
            System.out.println(x);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileExample volatileExample = new VolatileExample();
        Thread t1 = new Thread(()->{
            volatileExample.writer();
        });
        Thread t2 = new Thread(()->{
            volatileExample.reader();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
