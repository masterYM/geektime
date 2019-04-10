package p_c_patterns.condition_sort;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 用condition 实现顺序打印
 */
public class MyService {
    volatile private int printWho = 1;
    final private ReentrantLock lock = new ReentrantLock();
    final private Condition conditionA = lock.newCondition();
    final private Condition conditionB = lock.newCondition();
    final private Condition conditionC = lock.newCondition();

    public void PrintC(){
        try {
            lock.lock();
            while (printWho != 3){
                conditionC.await();
            }
            System.out.println("Thread C");
            printWho = 1;
            conditionA.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void PrintB(){
        try {
            lock.lock();
            while (printWho != 2){
                conditionB.await();
            }
            System.out.println("Thread B");
            printWho = 3;
            conditionC.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void PrintA(){
        try {
            lock.lock();
            while (printWho != 1){
                conditionA.await();
            }
            System.out.println("Thread A");
            printWho = 2;
            conditionB.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }



}
