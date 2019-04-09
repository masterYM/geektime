package p_c_patterns._1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public void waitA(){
        lock.lock();
        try {
            System.out.println("B");
            condition.await();
            System.out.println("B");
        }catch (InterruptedException e){
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }
    public void waitB(){
        lock.lock();
        try {
            System.out.println("A");
            condition.await();
            System.out.println("A");
        }catch (InterruptedException e){
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public void notify1(){
        lock.lock();
        try{
            System.out.println("开始通知");
            condition.signalAll();
            System.out.println("通知完毕");
        }finally {
            lock.unlock();
        }
    }
}
