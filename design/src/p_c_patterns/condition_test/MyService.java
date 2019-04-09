package p_c_patterns.condition_test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现交替打印
 */
public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    public Condition printAwait = lock.newCondition();
    private boolean printA = true;

    public void printB(){
        lock.lock();
        try {
            while (printA){
                printAwait.await();
            }
            System.out.println("B");
            printA = true;
            printAwait.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printA(){
        lock.lock();
        try {
            while (!printA){
                printAwait.await();
            }
            System.out.println("A");
            printA = false;
            printAwait.signal();

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }



}
