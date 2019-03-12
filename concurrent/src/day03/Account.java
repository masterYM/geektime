package day03;

/**
 * 下面四种条件都发生才会发生死锁
 * 一、互斥，共享资源x和y只能被一个线程占用
 * 二、占有且等待，不释放共享资源
 * 三、不可抢占
 * 4、循环等待
 *
 * 能打破的是 二 三 四
 */

public class Account {
    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    private int balance;
    //转账
    void transfer(Account target,int amt){

        synchronized (this){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (target){
                if(this.balance > amt){
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}
