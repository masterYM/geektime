package p_c_patterns._2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();

    public void signalB(){
        lock.lock();
        try {
            System.out.println("begin signalB");
            conditionB.signal();
            System.out.println("end signalB");
        }finally {
            lock.unlock();
        }
    }

    public void signalA(){
        lock.lock();
        try {
            System.out.println("begin signalA");
            conditionA.signal();
            System.out.println("end signalAA");
        }finally {
            lock.unlock();
        }
    }

    public void awaitA(){
        lock.lock();
        try {
            System.out.println("to A");
            conditionA.await();
            System.out.println("end A");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void awaitB(){
        lock.lock();
        try {
            System.out.println("to B");
            conditionB.await();
            System.out.println("end B");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
