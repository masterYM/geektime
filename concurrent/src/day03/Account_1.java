package day03;

/**
 * 下面四种条件都发生才会发生死锁
 * 一、互斥，共享资源x和y只能被一个线程占用
 * 二、占有且等待，不释放共享资源
 * 三、不可抢占
 * 4、循环等待
 *
 * 能打破的是 二 三 四
 *
 * 单例导致操作也是串行的吧  作者回复: 是串行，但是允许A转B，C转D
 */

public class Account_1 {
    //actr 应该为单例
    private Allocator actr = Allocator.getInstance();
    private int balance;

    public int getBalance() {
        return balance;
    }

    public Account_1(int balance) {
        this.balance = balance;
    }

    //转账
    void transfer(Account_1 target, int amt){
        //一次性申请转出账户和转入账户，直到成功
        while (!actr.apply(this,target));
        try {
            //锁定转出账户
            synchronized (this){
                try {
                    Thread.sleep(500);//创造死锁条件
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //锁定转入账户
                synchronized (target){
                    if(this.balance > amt){
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        }finally {
            actr.free(this,target);
        }

    }
}
