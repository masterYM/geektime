package stamped_lock;

import java.util.concurrent.locks.StampedLock;

public class Myservice {
    final StampedLock s1 = new StampedLock();



    public void read(){
        //获取悲观读锁
        long stamp = s1.readLock();
        try {
            System.out.println("开始读");
        }finally {
            s1.unlockRead(stamp);
        }
    }

    public void write(){
        //释放写锁
        long stamp = s1.writeLock();
        try {
            System.out.println("开始写");
        }finally {
            s1.unlockWrite(stamp);
        }
    }
}
